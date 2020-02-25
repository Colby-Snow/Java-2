package com.company;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    static String[][] rankings = {
            {"ivan", "King"},
            {"Gantic", "King"},
            {"Reton8", "King"},
            {"AmyCline", "Queen"},
            {"RYMM", "Prince"}
    };
    static int[][] points ={
            {1115, 39720},
            {1057, 38865},
            {1115, 36935},
            {1022, 30735},
            {1033, 30550}
    };


    public static void main(String[] args) {
         Scanner userInput = new Scanner(System.in);
         String iName;
	    System.out.println("What is the player's name?");
	    iName = userInput.next();
	    boolean isFound = false;
        int i;

	    for(i = 0; i < rankings.length; i++){
	        if(iName.trim().toUpperCase().equals(rankings[i][0].toUpperCase())){
	            isFound = true;
	            break;
            }
        }
        if(isFound){
                System.out.println( "Player " + rankings[i][0] +
                    " has reached " + rankings[i][1] + " status.\n" +
                    "Quests: " + points[i][0] + "\nAG Points :" + points[i][1]);
        }
        else {
            System.out.println("Player " + iName + " not found.");
        }
        }
    }
