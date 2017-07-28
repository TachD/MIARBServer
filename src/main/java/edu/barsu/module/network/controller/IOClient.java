package edu.barsu.module.network.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class IOClient implements AutoCloseable {
    private InetSocketAddress sockAddr;

    private Socket cSock;

    private ObjectInputStream IS;

    private ObjectOutputStream OS;

    public IOClient(InetSocketAddress sockAddr) {
        this.sockAddr = sockAddr;
    }

    public final ObjectInputStream getIS() {
        return IS;
    }

    public final ObjectOutputStream getOS() {
        return OS;
    }

    public final void crateSocket() throws IOException {
        cSock = new Socket();
    }

    public final void connect() throws IOException {
        cSock.connect(sockAddr);
    }

    public final void createIOStreams() throws IOException {
        OS = new ObjectOutputStream(cSock.getOutputStream());
        IS = new ObjectInputStream(cSock.getInputStream());
    }
    @Override
    public final void close() throws IOException {
        IS.close();
        OS.close();
        cSock.close();
    }
}
