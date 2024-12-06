package com.example;
public class MonException extends Exception {
    
    public MonException(String message) {
        super(message); 
        System.out.println("pas possible de retire de l'argent solde > 0");
    }
}
