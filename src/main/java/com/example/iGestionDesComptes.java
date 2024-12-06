package com.example;
public interface iGestionDesComptes{

    public double  soldeApresXAnnée (int annee);

    public  boolean  soleestpositif ();

    public  <T extends Number> void   verserArgent(T argent);

    public <T extends Number> void  retirerargent(T argent) throws MonException;
    
}