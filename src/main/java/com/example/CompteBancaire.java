package com.example;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CompteBancaire implements iGestionDesComptes {

    private final Lock lock = new ReentrantLock();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    protected double solde;

    public CompteBancaire(float soldeInitial) {
        this.solde = soldeInitial;
    }

    public double getSolde() {
        return solde;
    }

    public double calculerSoldeApresUnAn() {
        return solde;
    }

    @Override
    public String toString() {
        return "Compte Bancaire avec un solde de: " + solde + " EUR";
    }

    @Override
    public double soldeApresXAnnée(int annee) {
        return solde;
    }

    @Override
    public boolean soleestpositif() {
        return solde >= 0;
    }

    @Override
    public <T extends Number> void verserArgent(T argent) {
        try {
            rwl.writeLock().lock();
            solde = solde + argent.floatValue();
        } finally {
            rwl.writeLock().unlock();
        }

    }

    //Avec ReentranlLock
    /*
    @Override
    public <T extends Number> void retirerargent(T montant) throws MonException {
        try {
            lock.lock();
            if (montant.doubleValue() > 0 && montant.doubleValue() <= solde) {
                solde -= montant.doubleValue();
                System.out.println("Montant retiré: " + montant + " EUR. Nouveau solde: " + solde + " EUR.");
            } else {
                throw new MonException("pas possible de retire de l'argent solde > 0");
            }
        } finally {
            lock.unlock();
        }

    }
     */
    //Avec ReentrantReadWriteLock
    @Override
    public <T extends Number> void retirerargent(T montant) throws MonException {
        try {
            rwl.writeLock().lock();
            if (montant.doubleValue() > 0 && montant.doubleValue() <= solde) {
                solde -= montant.doubleValue();
                rwl.readLock().lock();
                try {
                    System.out.println("Montant retiré: " + montant + " EUR. Nouveau solde: " + solde + " EUR.");
                } finally {
                    rwl.readLock().unlock();
                }

            } else {
                throw new MonException("pas possible de retire de l'argent solde > 0");
            }
        } finally {
            rwl.writeLock().unlock();
        }

    }
}
