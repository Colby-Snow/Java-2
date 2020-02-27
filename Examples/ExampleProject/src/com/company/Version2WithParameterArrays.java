package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Version2WithParameterArrays {


    public static void main(String[] args) {
        String[][] rankings;        //define a 2-dim array reference
        int rows = 5 ;
        int columns = 2;
        rankings = new String[rows][columns]; //allocates space for reference
        int[][] points = new int[5][2];

        Scanner userInput = new Scanner(System.in);
        String iName;
        boolean isFound = false;
        int i;

        init(rankings,points);

        iName = JOptionPane.showInputDialog("What is the player's name?");

        for (i = 0; i < rankings.length; i++) {
            if (iName.trim().toUpperCase().equals(rankings[i][0].toUpperCase())) {
                isFound = true;
                break;
            }
        }
        if (isFound) {
            JOptionPane.showMessageDialog(null,"Player " + rankings[i][0] +
                    " has reached " + rankings[i][1] + " status.\n" +
                    "Quests: " + points[i][0] + "\nAG Points :" + points[i][1]);
        } else {
            JOptionPane.showMessageDialog(null,"Player " + iName + " not found.");
        }
    }

    private static void init(String[][] Pete, int[][] RePete ) {
        //build arrays from player stats input file
        LoadArrays(Pete, RePete);
        //other tasks
        //Pete[0][0] = "Czar";
    }

    private static void LoadArrays(String[][] rankings ,int[][] points) {
        String record;      //holds record read from input file
        String[] fields;    //holds the fields split out from the record
        Scanner playerScanner;
        boolean eof = false;
        File file = new File("player_stats.dat");

        try{
            playerScanner = new Scanner(file);
            int row = 0;    //set row index to zero
            //file exists, but make sure its not empty
            if(playerScanner.hasNext()){
                //Loop thru file
                //read a record, split it into fields, use fields to build the arrays
                while(!eof){
                    record = playerScanner.nextLine();
                    fields = record.split(",");
                    rankings[row][0] = fields[0];
                    rankings[row][1] = fields[1];
                    points[row][0] = Integer.parseInt(fields[2]);
                    points[row][1] = Integer.parseInt(fields[3]);
                    row++;
                    if(!playerScanner.hasNext()){   //check for eof and set switch
                        eof = true;
                    }
                }
                JOptionPane.showMessageDialog(null, "Player stat file loaded ok");
            }
            else{
                JOptionPane.showMessageDialog(null, "Player stat file empty, program aborting");
                System.exit(1);
            }
        }
        catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Player stat file not found, program aborting.");
            System.exit(1);
        }
    }
}
