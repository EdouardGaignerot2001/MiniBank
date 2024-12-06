package com.example;

import junit.framework.TestCase;

public class CompteBancaireTest extends TestCase {

    private CompteBancaire compte;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        compte = new CompteBancaire(1000); // Solde initial de 1000 EUR
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        compte = null; // Nettoyage de l'instance de CompteBancaire
    }

    public void testGetSolde() {
        assertEquals(1000.0, compte.getSolde()); // Vérifie que le solde initial est correct
    }

    public void testVerserArgent() {
        compte.verserArgent(500); // Verse 500 EUR
        assertEquals(1500.0, compte.getSolde()); // Vérifie que le solde est maintenant de 1500 EUR
    }

    public void testRetirerArgent() throws MonException {
        compte.retirerargent(300); // Retire 300 EUR
        assertEquals(700.0, compte.getSolde()); // Vérifie que le solde est maintenant de 700 EUR
    }

    public void testRetirerArgentInsuffisant() {
        try {
            compte.retirerargent(1200); // Essaie de retirer 1200 EUR, ce qui devrait échouer
            fail("Une exception devrait avoir été lancée pour solde insuffisant");
        } catch (MonException e) {
            assertEquals("pas possible de retire de l'argent solde > 0", e.getMessage()); // Vérifie le message d'exception
        }
    }

    public void testSoleestpositif() {
        assertTrue(compte.soleestpositif()); // Vérifie que le solde est positif
        compte.retirerargent(1000); // Retire tout le solde
        assertFalse(compte.soleestpositif()); // Vérifie que le solde n'est plus positif
    }

    public void testCalculerSoldeApresUnAn() {
        double soldeApresUnAn = compte.calculerSoldeApresUnAn();
        assertEquals(1000.0, soldeApresUnAn); // Vérifie que le solde après un an est le même, pour l'instant sans intérêt
    }

    public void testToString() {
        String expected = "Compte Bancaire avec un solde de: 1000.0 EUR";
        assertEquals(expected, compte.toString()); // Vérifie que la méthode toString retourne la bonne valeur
    }
}
