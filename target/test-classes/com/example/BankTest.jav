package com.example;

import junit.framework.TestCase;

public class BankTest extends TestCase {

    private Bank bank;
    private Client client1;
    private Client client2;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Initialisation de la banque et des clients pour les tests
        bank = Bank.getInstance(); // Obtenir l'instance de la banque
        client1 = new Client("Doe", "John", "123 rue de Paris", "0123456789");
        client2 = new Client("Smith", "Jane", "456 avenue de Lyon", "0987654321");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        bank = null; // Nettoyage de l'instance de la banque
        client1 = null; // Nettoyage du client 1
        client2 = null; // Nettoyage du client 2
    }

    public void testAjouterClient_NouveauClient() {
        // Ajouter un nouveau client
        bank.ajouterClient(client1);
        assertTrue(bank.getClients().contains(client1)); // Vérifie que le client a été ajouté
    }

    public void testAjouterClient_ClientDejaExistant() {
        // Ajouter un client, puis essayer d'ajouter le même client
        bank.ajouterClient(client1);
        bank.ajouterClient(client1); // Tentative d'ajouter à nouveau le même client

        // Vérifie que la taille des clients est toujours 1
        assertEquals(1, bank.getClients().size());
    }

    public void testAjouterClient_ClientDifferent() {
        // Ajouter deux clients différents
        bank.ajouterClient(client1);
        bank.ajouterClient(client2);

        // Vérifie que les deux clients sont dans l'ensemble
        assertTrue(bank.getClients().contains(client1));
        assertTrue(bank.getClients().contains(client2));
        assertEquals(2, bank.getClients().size()); // Vérifie qu'il y a 2 clients
    }
}
