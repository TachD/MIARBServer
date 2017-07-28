package edu.barsu.module.setgen.controller;

import edu.barsu.module.Constant;
import edu.barsu.module.crypto.DES;
import edu.barsu.module.database.controller.DBCRUD;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.InetAddress;
import java.security.Key;

public class SettingGeneratorController {
    @FXML
    private TextField tfURL;
    @FXML
    private TextField tfLogin;
    @FXML
    private PasswordField tfPass;

    private DES desEncrypt;

    @FXML
    private void initialize() {
        try {
            desEncrypt = new DES();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Объект для шифрования не был создан!").showAndWait();

            ((Stage) tfPass.getScene().getWindow()).close();
        }
    }

    @FXML
    private void genAndSaveKey() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранить ключ");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Ключ шифрования", "*.key"));
        fileChooser.setInitialFileName("activeKey.key");

        File keyFile = fileChooser.showSaveDialog(new Stage());

        if (keyFile == null)
            return;

        Key tempKey;

        try {
            tempKey = desEncrypt.genKey();
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "Ключ не сгенерирован!").show();
            return;
        }

        try (ObjectOutputStream OS = new ObjectOutputStream(new FileOutputStream(keyFile))) {
            OS.writeObject(tempKey);
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "Ключ не сохранен!").show();
            return;
        }

        try (ObjectOutputStream OS = new ObjectOutputStream(new FileOutputStream(Constant.Path.KEY))) {
            OS.writeObject(tempKey);
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "Ключ не сохранен на сервере!").show();
            return;
        }

        new Alert(Alert.AlertType.INFORMATION, "Ключ успешно сохранен!").show();
    }

    @FXML
    private void crypt() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранить");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Конфигурация соединения", "*.cfg"));
        fileChooser.setInitialFileName("connectData.cfg");

        File configFile = fileChooser.showSaveDialog(new Stage());

        if (configFile == null)
            return;

        try (ObjectInputStream OS = new ObjectInputStream(new FileInputStream(Constant.Path.KEY))) {
            desEncrypt.setKey((Key) OS.readObject());
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "Отсутствует ключ!").show();
            return;
        }

        try (ObjectOutputStream OS = new ObjectOutputStream(new FileOutputStream(configFile))) {
            OS.writeObject(desEncrypt.encrypt(InetAddress.getLocalHost().getHostName()));
            OS.writeObject(desEncrypt.encrypt("10001"));
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "Файл конфигурации БД не был сохранен!").show();
            return;
        }

        new Alert(Alert.AlertType.INFORMATION, "Конфигурация успешно зашифрована и сохранена!").show();
    }

    @FXML
    private void genDBSetting() {
        if ("".equals(tfLogin.getText()) | "".equals(tfPass.getText()) | "".equals(tfLogin.getText())) {
            new Alert(Alert.AlertType.WARNING, "Данные введены некорректно!").show();
            return;
        }

        DBCRUD dbControlTest = new DBCRUD(tfURL.getText(), tfLogin.getText(), tfPass.getText());

        if (dbControlTest.isAccessDenied()) {
            new Alert(Alert.AlertType.WARNING, "Введены неправильные данные!").show();
            return;
        }


        try (ObjectInputStream OS = new ObjectInputStream(new FileInputStream(Constant.Path.KEY))) {
            desEncrypt.setKey((Key) OS.readObject());
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "Отсутствует ключ!").show();
            return;
        }

        try (ObjectOutputStream OS = new ObjectOutputStream(new FileOutputStream(Constant.Path.CONFIG))) {
            OS.writeObject(desEncrypt.encrypt(tfURL.getText()));
            OS.writeObject(desEncrypt.encrypt(tfLogin.getText()));
            OS.writeObject(desEncrypt.encrypt(tfPass.getText()));
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING, "Файл конфигурации не был создан!").show();
            return;
        }

        new Alert(Alert.AlertType.INFORMATION, "Конфигурация БД успешно сохранена!").show();
    }
}
