package com.example;
import junit.framework.TestCase;

public class ClientTest extends TestCase {

    private Client client;
    private CompteBancaire compteStandard;
    private CompteEpargne compteEpargne;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        client = new Client("Doe", "John", "123 rue de Paris", "0123456789");
        compteStandard = new CompteBancaire(1000); // Exemple de compte standard
        compteEpargne = new CompteEpargne(5000.0f, 0.02); // Utilise float pour 5000 et un double pour le taux d'intérêt

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        client = null;
        compteStandard = null;
        compteEpargne = null;
    }

    public void testGetNom() {
        assertEquals("Doe", client.getNom());
    }

    public void testSetNom() {
        client.setNom("Smith");
        assertEquals("Smith", client.getNom());
    }

    public void testGetPrenom() {
        assertEquals("John", client.getPrenom());
    }

    public void testSetPrenom() {
        client.setPrenom("Jane");
        assertEquals("Jane", client.getPrenom());
    }

    public void testGetAdresse() {
        assertEquals("123 rue de Paris", client.getAdresse());
    }

    public void testSetAdresse() {
        client.setAdresse("456 avenue de Lyon");
        assertEquals("456 avenue de Lyon", client.getAdresse());
    }

    public void testGetTelephone() {
        assertEquals("0123456789", client.getTelephone());
    }

    public void testSetTelephone() {
        client.setTelephone("9876543210");
        assertEquals("9876543210", client.getTelephone());
    }

    public void testEstPro() {
        assertFalse(client.estPro());  // Vérifie que le client n'est pas un professionnel
    }

    public void testOuvrirCompteStandard() {
        client.ouvrirCompteStandard(compteStandard);
        assertTrue(client.getCompteStandard().contains(compteStandard));

        // Essayer d'ajouter un deuxième compte standard
        CompteBancaire autreCompteStandard = new CompteBancaire(2000);
        client.ouvrirCompteStandard(autreCompteStandard);
        assertEquals(1, client.getCompteStandard().size());  // Toujours 1 compte standard
    }

    public void testOuvrirCompteEpargne() {
        assertTrue(client.ouvrirCompteEpargne(compteEpargne));  // Doit pouvoir ouvrir un compte d'épargne

        // Essayer d'ajouter un deuxième compte d'épargne
        CompteEpargne autreCompteEpargne = new CompteEpargne(3000.0f, 0.02);
        assertFalse(client.ouvrirCompteEpargne(autreCompteEpargne)); // Ne doit pas pouvoir ouvrir
    }

    public void testAfficherComptes() {
        client.ouvrirCompteStandard(compteStandard);
        client.ouvrirCompteEpargne(compteEpargne);
        client.afficherComptes();
        // Pas d'assertions ici, car cela dépend du système de sortie
    }

    public void testToString() {
        String expected = "Client: Doe John, Adresse: 123 rue de Paris, Téléphone: 0123456789";
        assertEquals(expected, client.toString());
    }
}
