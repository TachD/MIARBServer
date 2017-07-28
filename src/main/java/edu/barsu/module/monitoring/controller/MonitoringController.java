package edu.barsu.module.monitoring.controller;

import edu.barsu.module.Constant;
import edu.barsu.module.crypto.DES;
import edu.barsu.module.database.controller.DBCRUD;
import edu.barsu.module.database.model.packages.structure.DepartamentSet;
import edu.barsu.module.database.model.packages.model.clEmployee;
import edu.barsu.module.network.controller.*;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.security.Key;

public class MonitoringController {
    @FXML
    private TextArea taLog;
    @FXML
    private Label lbDBStatus;
    @FXML
    private Label lServerStatus;
    @FXML
    private ToggleButton tbtnServer;
    @FXML
    private ToggleButton tbtnDB;
    @FXML
    private Label lHost;
    @FXML
    private ImageView ivDB;
    @FXML
    private ImageView ivServer;
    @FXML
    private ImageView ivGenerator;

    private DBCRUD dbControl;

    private volatile boolean activeFlag;

    private DepartamentSet departamentSet;

    @FXML
    private void initialize() {
        try {
            ivDB.setImage(
                    new Image(Constant.Image.DATABASE));
            ivServer.setImage(
                    new Image(Constant.Image.SERVER));
            ivGenerator.setImage(
                    new Image(Constant.Image.SETGEN));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            lHost.setText("Host name: " + InetAddress.getLocalHost().getHostName() +
                    " & Host address: " + InetAddress.getLocalHost().getCanonicalHostName());
        } catch (Exception e) {
            lHost.setText("Host: Unknown");
        }
    }

    @FXML
    private void dbToggle() throws Exception {
        if (tbtnServer.isSelected()) {
            new Alert(Alert.AlertType.INFORMATION,
                    "Перед отсоединением от БД небоходимо выключить сервер").show();
            tbtnDB.setSelected(true);
        } else if (tbtnDB.isSelected())
            if (setDBConnection()) {
                taLog.appendText("Подключение к БД выполнено успешно!\n");
                lbDBStatus.setText("online");
                lbDBStatus.setTextFill(Color.GREEN);
             } else {
                taLog.appendText("БД недоступна. Возможно, не запущена система\n");
                tbtnDB.setSelected(false);
            }
        else {
            dbControl.close();
            taLog.appendText("Отключение от БД выполнено успешно!\n");
            lbDBStatus.setText("offline");
            lbDBStatus.setTextFill(Color.RED);
        }
    }

    @FXML
    private void serverToggle() {
        if (tbtnServer.isSelected())
            if (dbControl == null || dbControl.isAccessDenied()) {
                new Alert(Alert.AlertType.INFORMATION,
                        "Перед запуском серверра необходимо " +
                                "создать соединение с БД!").show();
                tbtnServer.setSelected(false);
            } else {
                new Thread(this::serverStartMethod).start();

                taLog.appendText("Сервер успешно запущен!\n");
                lServerStatus.setText("online");
                lServerStatus.setTextFill(Color.GREEN);
            }
        else {
            activeFlag = false;

            try (IOClient ioClient = new IOClient(
                    new InetSocketAddress(InetAddress.getLocalHost().getCanonicalHostName(), 10001))) {
                ioClient.crateSocket();
                ioClient.connect();
                ioClient.createIOStreams();

                ObjectOutputStream OS = ioClient.getOS();

                OS.writeObject(-1);
            } catch (IOException e) {
                taLog.appendText("Серверное соединение не разорвано!\n");
                new Alert(Alert.AlertType.WARNING, "Ошибка разъединения сервера: " + e.getMessage()).show();
            }

            taLog.appendText("Сервер успешно отключен!\n");
            lServerStatus.setText("offline");
            lServerStatus.setTextFill(Color.RED);
        }
    }

    @FXML
    private void openGenerator() {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/SettingGeneratorView.fxml"));
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "Ошибка загрузки окна: " + e.getMessage()).show();
            return;
        }

        Stage genStage = new Stage();
        genStage.setTitle("Генератор конфигурации");
        genStage.setScene(new Scene(root));

        genStage.show();
    }

    // 0 - auth, 1 - addNew, 2 - read, 3 - edit, 4 - del, 5 - get departamentSet
    private synchronized void serverStartMethod() {
        try {
            departamentSet = dbControl.readStructure();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try (IOServer ioServer = new IOServer(
                new InetSocketAddress("0.0.0.0", 10001))) {
            ioServer.createServerSocket();

            activeFlag = true;

            while (true) {
                if (!activeFlag)
                    break;

                ioServer.listen();
                ioServer.createIOStreams();

                ObjectInputStream IS = ioServer.getIS();
                ObjectOutputStream OS = ioServer.getOS();
                int serviceCode = (int) IS.readObject();

                Runnable threadTask;
                switch (serviceCode) {
                    case 0:
                        threadTask = () -> {
                            try {
                                auth(IS, OS);
                            } catch (Exception e) {
                                e.printStackTrace();
                                taLog.appendText("Ошибка аутентификаии пользователя!\n");
                            }
                        };
                        break;
                    case 1:
                        threadTask = () -> {
                            try {
                                addNew(IS);
                            } catch (Exception e) {
                                e.printStackTrace();
                                taLog.appendText("Ошибка добавления данных!\n");
                            }
                        };
                        break;
                    case 2:
                        threadTask = () -> {
                            try {
                                read(OS);
                            } catch (Exception e) {
                                e.printStackTrace();
                                taLog.appendText("Ошибка чтения данных!\n");
                            }
                        };
                        break;
                    case 3:
                        threadTask = () -> {
                            try {
                                edit(IS);
                            } catch (Exception e) {
                                e.printStackTrace();
                                taLog.appendText("Ошибка редактирования данных!\n");
                            }
                        };
                        break;
                    case 4:
                        threadTask = () -> {
                            try {
                                del(IS);
                            } catch (Exception e) {
                                e.printStackTrace();
                                taLog.appendText("Ошибка удаления данных!\n");
                            }
                        };
                        break;
                    case 5:
                        threadTask = () -> {
                            try {
                                OS.writeObject(departamentSet);
                            } catch (Exception e) {
                                e.printStackTrace();
                                taLog.appendText("Ошибка отправки структуры министрества!\n");
                            }
                        };
                        break;
                    default:
                        continue;
                }

                Platform.runLater(threadTask);
            }
        } catch (Exception e) {
            taLog.appendText("Ошибка прослушивающего метода!\n");
            serverToggle();
        }
    }

    private void auth(ObjectInputStream IS, ObjectOutputStream OS)
            throws Exception {
        Key clientKey = (Key) IS.readObject();

        String login = String.valueOf(IS.readObject());
        String pass = String.valueOf(IS.readObject());

        OS.writeObject((clientKey.equals(DES.getKeyFromFile(Constant.Path.KEY))) && !dbControl.auth(login, pass));
    }

    private void read(ObjectOutputStream OS)
            throws Exception {
        OS.writeObject(dbControl.read());
    }

    private void addNew(ObjectInputStream IS)
            throws Exception {
        dbControl.addNew((clEmployee) IS.readObject());
    }

    private void edit(ObjectInputStream IS)
            throws Exception {
        dbControl.edit((clEmployee) IS.readObject());
    }

    private void del(ObjectInputStream IS)
            throws Exception {
        dbControl.del((clEmployee) IS.readObject());
    }

    private boolean setDBConnection() {
        String url, login, pass;

        try (ObjectInputStream IS = new ObjectInputStream(
                new FileInputStream(Constant.Path.CONFIG))) {
            DES des = new DES();
            des.setKey(DES.getKeyFromFile(Constant.Path.KEY));

            byte[] bytes = (byte[]) IS.readObject();
            url = des.decrypt(bytes, bytes.length);

            bytes = (byte[]) IS.readObject();
            login = des.decrypt(bytes, bytes.length);

            bytes = (byte[]) IS.readObject();
            pass = des.decrypt(bytes, bytes.length);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Файл конфигурации БД отсутствует или некорректен. " +
                    "Возможно, устарела конфигурация БД. Создайте новый в разделе 'Генератор'").show();
            return false;
        }

        dbControl = new DBCRUD(url, login, pass);

        return !dbControl.isAccessDenied();
    }
}