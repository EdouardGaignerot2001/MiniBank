package com.example;
import java.util.HashSet; // Ajout de l'import pour ArrayList
import java.util.Set; // Ajout de l'import pour List

public class Bank {

    private Set<Client> clients;
    private static Bank instance = null;

    public static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    private Bank() {
        this.clients = new HashSet<>();
    }

    // Ajouter un client (standard ou PRO)
    public void ajouterClient(Client client) {
        if (clients.add(client)) {
            System.out.println("Client ajouté: " + client);
        } else {
            System.out.println("Ce client existe déjà: " + client);
        }
    }

    public Set<Client> getClients() {
        return clients;
    }
}
