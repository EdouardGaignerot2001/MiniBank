
package com.example;
import java.util.ArrayList;
import java.util.List;

public class ClientPro extends Client {
    private final String siret;
    private List<CompteBancaire> compteStandard; // Liste des comptes standards
    private CompteEpargne compteEpargne; // Un seul compte d’épargne

    public ClientPro(String nom, String prenom, String adresse, String telephone, String siret) {
        super(nom, prenom, adresse, telephone);
        this.siret = siret;
        this.compteStandard = new ArrayList<>(); // Initialiser la liste des comptes standards
    }

    public String getSiret() {
        return siret;
    }

    @Override
    public boolean estPro() {
        return true;
    }

    @Override
    public void  ouvrirCompteStandard(CompteBancaire compte) {
        compteStandard.add(compte);
        System.out.println("Compte standard ouvert pour " + getNom() + " " + getPrenom());
        
    }

    @Override
    public boolean ouvrirCompteEpargne(CompteEpargne compte) {
        if (this.compteEpargne == null) {
            this.compteEpargne = compte;
            System.out.println("Compte d’épargne ouvert pour " + getNom() + " " + getPrenom());
            return true;
        } else {
            System.out.println("Ce client a déjà un compte d’épargne.");
            return false;
        }
    }

    @Override
    public void afficherComptes() {
        System.out.println("Comptes de " + getNom() + " " + getPrenom() + ":");
        if (!compteStandard.isEmpty()) {
            for (CompteBancaire compte : compteStandard) {
                System.out.println(compte);
            }
        } else {
            System.out.println("Aucun compte standard.");
        }
        if (compteEpargne != null) {
            System.out.println(compteEpargne);
        } else {
            System.out.println("Aucun compte d’épargne.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", SIRET: " + siret;
    }

    public List<CompteBancaire> getComptesStandard() {
        return compteStandard;
    }

    public void setComptesStandard(List<CompteBancaire> comptesStandard) {
        this.compteStandard = comptesStandard;
    }
}
