package org.example;

import org.example.repository.ConnectionManager;

public class Main {

    
    public static void run(){
        System.out.println("Runing ... ");
    }

    public static void main(String[] args) {
        ConnectionManager.startDatabase();
        run();

    }
}