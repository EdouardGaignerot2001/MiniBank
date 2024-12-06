package com.example;
public class Threads2 extends Thread {

    Client client;

    public Threads2(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            try {
                client.getCompteStandard().iterator().next().retirerargent(1);
            } catch (MonException e) {
            }

        }
    }
}
