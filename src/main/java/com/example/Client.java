package com.example;
//import java.util.ArrayList;
//import java.util.List;
import java.util.HashSet; // Importer HashSet
import java.util.Set; // Importer Set


public class Client {

    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private final Set<CompteBancaire> compteStandard; // Liste des comptes standards// Un seul compte standard
    private CompteEpargne compteEpargne;    // Un seul compte d’épargne

    public Client(String nom, String prenom, String adresse, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.compteStandard = new HashSet<>(); // Liste vide au départ
        this.compteEpargne = null;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public boolean estPro() {
        return false;
    }

     public void ouvrirCompteStandard(CompteBancaire compte) {
        if (compteStandard.size() < 1) {
            compteStandard.add(compte);
            System.out.println("Compte standard ajouté pour " + this.nom + " " + this.prenom);
        } else {
            System.out.println("Un client standard ne peut pas avoir plus de 1 comptes standard.");
        }
    }

    public boolean ouvrirCompteEpargne(CompteEpargne compte) {
        if (this.compteEpargne == null) {
            this.compteEpargne = compte;
            System.out.println("Compte d’épargne ouvert pour " + this.nom + " " + this.prenom);
            return true;
        } else {
            System.out.println("Ce client a déjà un compte d’épargne.");
            return false;
        }
    }

    public void afficherComptes() {
        System.out.println("Comptes de " + nom + " " + prenom + ":");
        if (compteStandard != null) {
            System.out.println(compteStandard);
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
        return "Client: " + nom + " " + prenom + ", Adresse: " + adresse + ", Téléphone: " + telephone;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<CompteBancaire> getCompteStandard() {
        return compteStandard;
    }

    
}
