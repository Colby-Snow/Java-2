package com.company;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        int[][] rents = new int[4][3];
        LoadArrays(rents);
        // floor and bedrooms must be in modules.
        // Module for rent display
        // array must be a file
        int maxFloors = rents.length - 1;
        int maxBedrooms = rents[0].length -1;
        int floor = setFloor(maxFloors);
        int bedrooms = setBedrooms(maxBedrooms);

        getRent(bedrooms, floor, rents);

    }
    private static int setFloor(int maxFloors){
        String entry;
        int floor;
        entry = JOptionPane.showInputDialog(null,
        "Enter a floor number 0 -" + maxFloors + ":");
        try{
            floor = Integer.parseInt(entry);
            if(floor < 0 || floor > maxFloors){
                JOptionPane.showMessageDialog(null, "Invalid input floors set to zero");
                floor = 0;
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid input defaulted zero");
            floor = 0;
        }
        return floor;
        }
    private static int setBedrooms(int maxBedrooms){
        String entry;
        entry = JOptionPane.showInputDialog(null,
                "Enter number of bedrooms ");
        int bedrooms;
        try{
            bedrooms = Integer.parseInt(entry);
            if(bedrooms < 0 || bedrooms > maxBedrooms){
                JOptionPane.showMessageDialog(null, "Invalid input set bedrooms to zero" );
                bedrooms = 0;
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid input defaulted zero");
            bedrooms = 0;
        }
        return bedrooms;
    }

    private static void getRent(int bedrooms, int floor, int rents[][]) {
        JOptionPane.showMessageDialog(null,
                "The rent for a " + bedrooms +
                        " bedroom apartment on floor " + floor +
                        " is $" + rents[floor][bedrooms]);
    }
    private static void LoadArrays(int[][] rent) {
        String record;      //holds record read from input file
        String[] fields;    //holds the fields split out from the record
        Scanner rentScanner;
        boolean eof = false;
        File file = new File("rent_data.dat");

        try{
            rentScanner = new Scanner(file);
            int row = 0;    //set row index to zero
            //file exists, but make sure its not empty
            if(rentScanner.hasNext()){
                //Loop thru file
                //read a record, split it into fields, use fields to build the arrays
                while(!eof){
                    record = rentScanner.nextLine();
                    fields = record.split(", ");
                    rent[row][0] = Integer.parseInt(fields[0]);
                    rent[row][1] = Integer.parseInt(fields[1]);
                    rent[row][2] = Integer.parseInt(fields[2]);
                    row++;
                    if(!rentScanner.hasNext()){   //check for eof and set switch
                        eof = true;
                    }
                }
                JOptionPane.showMessageDialog(null, "Rent file loaded ok");
            }
            else{
                JOptionPane.showMessageDialog(null, "Rent file not found, program aborting");
                System.exit(1);
            }
        }
        catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Rent file not found, program aborting.");
            System.exit(1);
        }
    }
}

