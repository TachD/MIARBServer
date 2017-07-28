package edu.barsu.module.network.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer implements AutoCloseable {
    private InetSocketAddress sockAddr;

    private ServerSocket servSock;

    private Socket cSock;

    private ObjectInputStream IS;

    private ObjectOutputStream OS;

    public IOServer(InetSocketAddress sockAddr) {
        this.sockAddr = sockAddr;
    }

    public ObjectInputStream getIS() {
        return IS;
    }

    public ObjectOutputStream getOS() {
        return OS;
    }

    public final void createServerSocket() throws IOException {
        servSock = new ServerSocket();

        servSock.bind(sockAddr);
    }

    public final void listen() throws IOException {
        cSock = servSock.accept();
    }

    public final void createIOStreams() throws IOException {
        IS = new ObjectInputStream(cSock.getInputStream());
        OS = new ObjectOutputStream(cSock.getOutputStream());
    }

    public final void closeClientSock() throws IOException {
        IS.close();
        OS.close();
        cSock.close();
    }

    public final void closeServer() throws IOException {
        servSock.close();
    }

    @Override
    public void close() throws Exception {
        closeClientSock();
        closeServer();
    }
}