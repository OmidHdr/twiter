package org.example;

import org.example.repository.ConnectionManager;

public class Main {

    public static void run(String str){
        System.out.println("Runing ... ");
        switch (str){
            case "1":
            System.out.println("press 'q' to quit : ");
        }
    }

    public static void main(String[] args) {
        ConnectionManager.startDatabase();
        run();

    }
}