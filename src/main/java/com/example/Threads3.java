package com.example;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Threads3 extends Thread {

    private final Lock lock = new ReentrantLock();
    Client client;

    public Threads3(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        lock.lock();
        for (int i = 1; i <= 1000; i++) {

            client.getCompteStandard().iterator().next().verserArgent(1);

        }
    }
}
