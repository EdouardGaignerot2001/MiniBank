package com.example;
public class CompteEpargne extends CompteBancaire {
    private double tauxInteret;

    public CompteEpargne(float  soldeInitial, double tauxInteret) {
        super(soldeInitial);
        this.tauxInteret = tauxInteret;
    }

    public void appliquerInteret() {
        double interets = solde * tauxInteret;
        solde += interets;
        System.out.println("Intérêts appliqués: " + interets + " EUR. Nouveau solde: " + solde + " EUR.");
    }

    
   
    @Override
    public double calculerSoldeApresUnAn() {
        return solde * (1 + tauxInteret); 
    }
     @Override
    public double soldeApresXAnnée(int annee) {
        
        return solde *  Math.pow(1 + tauxInteret, annee);
    }

    @Override
    public String toString() {
        return "Compte Épargne avec un solde de: " + solde + " EUR et un taux d'intérêt de: " + (tauxInteret * 100) + "%";
    }

}
