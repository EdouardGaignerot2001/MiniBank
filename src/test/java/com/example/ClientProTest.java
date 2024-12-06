package com.example;

import junit.framework.TestCase;

public class ClientProTest extends TestCase {

    private ClientPro clientPro;
    private CompteBancaire compteStandard;
    private CompteEpargne compteEpargne;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Initialisation du client professionnel et des comptes pour les tests
        clientPro = new ClientPro("Doe", "John", "123 rue de Paris", "0123456789", "12345678901234");
        compteStandard = new CompteBancaire(1000); // Exemple de compte standard
        compteEpargne = new CompteEpargne(5000.0f, 0.02); // Exemple de compte d'épargne
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        clientPro = null; // Nettoyage de l'instance de ClientPro
        compteStandard = null; // Nettoyage du compte standard
        compteEpargne = null; // Nettoyage du compte d'épargne
    }

    public void testGetSiret() {
        assertEquals("12345678901234", clientPro.getSiret()); // Vérifie le SIRET du client
    }

    public void testEstPro() {
        assertTrue(clientPro.estPro()); // Vérifie que le client est bien un professionnel
    }

    public void testOuvrirCompteStandard() {
        clientPro.ouvrirCompteStandard(compteStandard);
        assertTrue(clientPro.getComptesStandard().contains(compteStandard)); // Vérifie que le compte standard a été ajouté
    }

    public void testOuvrirCompteEpargne() {
        assertTrue(clientPro.ouvrirCompteEpargne(compteEpargne)); // Vérifie que le compte d'épargne a été ouvert
        // Essayer d'ajouter un deuxième compte d'épargne
        CompteEpargne autreCompteEpargne = new CompteEpargne(3000.0f, 0.02);
        assertFalse(clientPro.ouvrirCompteEpargne(autreCompteEpargne)); // Ne doit pas pouvoir ouvrir un deuxième compte d'épargne
    }

    public void testAfficherComptes() {
        clientPro.ouvrirCompteStandard(compteStandard);
        clientPro.ouvrirCompteEpargne(compteEpargne);
        clientPro.afficherComptes(); // Pas d'assertions ici, car cela dépend du système de sortie
    }

    public void testToString() {
        String expected = "Client: Doe John, Adresse: 123 rue de Paris, Téléphone: 0123456789, SIRET: 12345678901234";
        assertEquals(expected, clientPro.toString()); // Vérifie que la méthode toString retourne la bonne valeur
    }
}
