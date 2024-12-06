package com.example;

import java.util.Set;

// j'utilise HASHSET 
//HASHset permet de hasher tout le tableau et vient remplacer les nom par des hash 
//la fonction permet de comparer toute sle scolones pour eviter d'avoir des doublons 
public class Main {

    public static void main(String[] args) {
        // Création d'une banque
        Bank maBanque = Bank.getInstance();

        // Création d'un client standard
        Client client1 = new Client("Dupont", "Jean", "123 Rue de Paris", "0123456789");
        maBanque.ajouterClient(client1);
        System.out.println(client1);
        System.out.println("Client PRO ? " + client1.estPro());

        // Ouverture d'un compte standard pour le client standard
        CompteBancaire compteStandard = new CompteBancaire(1000);
        client1.ouvrirCompteStandard(compteStandard);
        System.out.println(compteStandard);
        System.out.println("Solde après un an: " + compteStandard.calculerSoldeApresUnAn() + " EUR");

        // Ouverture d'un compte épargne pour le client standard
        CompteEpargne compteEpargne = new CompteEpargne(2000, 0.03); // 3% d'intérêt
        client1.ouvrirCompteEpargne(compteEpargne);
        System.out.println(compteEpargne);
        compteEpargne.appliquerInteret();
        System.out.println("Solde après un an: " + compteEpargne.calculerSoldeApresUnAn() + " EUR");
        System.out.println("Solde après 10 ans: " + compteEpargne.soldeApresXAnnée(10) + " EUR");

        // Création d'un client PRO
        ClientPro clientPro1 = new ClientPro("Martin", "Sophie", "456 Avenue de Lyon", "0987654321", "12345678901234");
        maBanque.ajouterClient(clientPro1);
        System.out.println(clientPro1);
        System.out.println("Client PRO ? " + clientPro1.estPro());

        // Ouverture de plusieurs comptes standard pour le client PRO
        CompteBancaire comptePro1 = new CompteBancaire(3000);
        CompteBancaire comptePro2 = new CompteBancaire(4000);
        clientPro1.ouvrirCompteStandard(comptePro1);
        clientPro1.ouvrirCompteStandard(comptePro2);
        System.out.println(comptePro1);
        System.out.println(comptePro2);

        // Ouverture d'un compte épargne pour le client PRO
        CompteEpargne compteEpargnePro = new CompteEpargne(5000, 0.04); // 4% d'intérêt
        clientPro1.ouvrirCompteEpargne(compteEpargnePro);
        System.out.println(compteEpargnePro);
        compteEpargnePro.appliquerInteret();
        System.out.println("Solde après un an: " + compteEpargnePro.calculerSoldeApresUnAn() + " EUR");
        System.out.println("Solde après 10 ans: " + compteEpargnePro.soldeApresXAnnée(10) + " EUR");

        // Affichage de tous les clients de la banque
        System.out.println("\nListe des clients de la banque:");
        Set<Client> clients = maBanque.getClients();

        for (Client client : clients) {
            System.out.println(client);
            client.afficherComptes(); // Afficher les comptes de chaque client
        }

        System.out.println("client 1 :");
        client1.afficherComptes();
        try {
            client1.getCompteStandard().iterator().next().retirerargent(100000000);
        } catch (MonException e) {
            System.out.println("Erreur lors du retrait d'argent : " + e.getMessage());
        }
        Bank maBanque2 = Bank.getInstance();
        System.out.println("------------------------------");
        Client client3 = new Client("test", "Jean", "123 Rue de Paris", "0123456789");
        maBanque2.ajouterClient(client3);
        maBanque2.getClients();

        //threads
        System.out.println("----------------Pour retirer de l'argent--------------");
        Client client5 = new Client("Thread", "Thread", "123 Rue de Paris", "0123456789");
        maBanque.ajouterClient(client5);
        CompteBancaire compteStandard5 = new CompteBancaire(10000);
        client5.ouvrirCompteStandard(compteStandard5);
        client5.afficherComptes();
        Thread threads1 = new Threads1(client5);
        Thread threads2 = new Threads2(client5);
        threads1.start();
        threads2.start();
        try {
            threads1.join();
            threads2.join();

        } catch (Exception e) {
        }
        client5.afficherComptes();

        System.out.println("----------------Pour verser de l'argent--------------");
        Thread threads3 = new Threads3(client5);
        Thread threads4 = new Threads4(client5);
        threads3.start();
        threads4.start();
        try {
            threads3.join();
            threads4.join();

        } catch (Exception e) {
        }
        client5.afficherComptes();

    }
}
