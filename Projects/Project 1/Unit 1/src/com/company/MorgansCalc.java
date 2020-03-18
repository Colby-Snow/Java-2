package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorgansCalc {
    static private String[][] Employees = new String[10][3];
    static private double[] PayCheckAmt = new double[10];
    static private double[][] bonusRates = new double[4][2];
    static private int menuOperation;
    static private String inputOperationString;
    static private Scanner userInput = new Scanner(System.in);
    static private int employeeAmt;

    public static void mainMenu(){
        boolean checkPoint = true;
        LoadArrays(bonusRates);
        do {
            System.out.println("Please enter one of the following option numbers.");
            System.out.print("Option 1: Enter Employee Data\n\rOption 2: Display All Employees\n\r" +
                    "Option 3: Display Single Employee\n\rOption 4: Exit\n\r");
            try {
                inputOperationString = userInput.next();
                menuOperation = Integer.parseInt(inputOperationString);
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input please try again");
                menuOperation = 0;
            }

                switch (menuOperation) {
                    case 1:
                        System.out.println("Option 1 selected: Enter Employee Data. . .");
                        setEmployees();
                        break;
                    case 2:
                        System.out.println("Option 2 selected: Display All Employees. . .");
                        displayAllEmployees();
                        break;
                    case 3:
                        System.out.println("Option 3 selected: Display Single Employee. . .");
                        displaySingleEmployee();
                        break;
                    case 4:
                        System.out.println("Option 4 selected: Ending Program. . .");
                        checkPoint = false;
                        break;
                    default:
                        System.out.println("Invalid Option Selected");
                }
        }while(checkPoint);
    }

    public static void setEmployees(){
        String employContinue;
        employeeAmt = 0;
        for(int i = 0; i < 10; i++){
            employeeAmt++;
            boolean validStatus = false;
            System.out.println("Please enter the first name of employee number "+ i + 1);
            Employees[i][0] = userInput.next();
            System.out.println("Please enter the last name of employee number " + i + 1);
            Employees[i][1] = userInput.next();
            do{
                System.out.println("Please enter the employee number " + i + 1 +"'s status full time (FT) or part time (PT)");
                Employees[i][2] = userInput.next();
                if(Employees[i][2].toUpperCase().equals("PT") || Employees[i][2].toUpperCase().equals("FT")){
                    validStatus = true;
                }
                else{
                    System.out.println("Invalid status please enter either PT for part time or FT for full time.");
                }
            }while(!validStatus);
            do{
                try{
                    System.out.println("Please enter employee number " + i + 1 + "'s paycheck amount must be between 0.01 and 9999.99");
                    inputOperationString = userInput.next();
                    PayCheckAmt[i] = Double.parseDouble(inputOperationString);
                    if(PayCheckAmt[i] >= .01 && PayCheckAmt[i] <= 9999.99){
                        validStatus = true;
                    }
                    else {
                        System.out.println("Invalid input pay check amount must be between 0.01 and 9999.99");
                    }
                }
                catch(NumberFormatException e){
                    System.out.println("Invalid input must be numeric");
                    validStatus = false;
                }
            }while(!validStatus);
            do{
                System.out.println("Would you like to continue entering employees? (Y or N)");
                employContinue = userInput.next().toUpperCase();
            }while (!employContinue.equals("Y") && !employContinue.equals("N"));
            if(employContinue.equals("N")) {
                break;
            }
        }
    }

    public static void displayAllEmployees() {
        String empStatus = "";
        double totBonus = 0;
        if(valEmployees()){
            System.out.printf("%-45s %-22s %-22s %-22s\n", "Employee Name", "Employee Status", "Paycheck Amount", "Employee Bonus");
            for (int i = 0; i < employeeAmt; i++) {
                    displayEmployeeColumns(i);
                    totBonus += bonusCalc(PayCheckAmt[i], Employees[i][2]);
            }
            System.out.printf("%92s%22.2f\n", "Total Bonus Paid: ", totBonus);
        }
    }

    public static void displaySingleEmployee(){
        String firstName;
        String lastName;
        boolean userFound = false;
        if(valEmployees()){
            System.out.println("Please enter the employee's first name");
            firstName = userInput.next();
            System.out.println("Please enter the employee's last name");
            lastName = userInput.next();
            for (int i = 0; i < employeeAmt; i++) {
                if(firstName.toUpperCase().equals(Employees[i][0].toUpperCase()) && lastName.toUpperCase().equals(Employees[i][1].toUpperCase())){
                    displayEmployeeVertical(i);
                    userFound = true;
                    break;
                }
            }

            if(!userFound){
                System.out.println("Employee not found please try again");
            }
        }
    }

    public static void displayEmployeeColumns(int employeePosition){
            String empStatus = "";
            double bonus;
            if(Employees[employeePosition][2].toUpperCase().equals("PT")){
                empStatus = "Part Time";
            }
            else if(Employees[employeePosition][2].toUpperCase().equals("FT")){
                empStatus = "Full Time";
            }

            bonus = bonusCalc(PayCheckAmt[employeePosition], Employees[employeePosition][2]);
            // formats all variables into column based string
            System.out.printf("%-45s %-22s %,22.2f %22.2f\n",Employees[employeePosition][1]+ ", " + Employees[employeePosition][0], empStatus, PayCheckAmt[employeePosition], bonus);
        }

    public static void displayEmployeeVertical(int employeePosition){
        String empStatus = "";
        double bonus;
        if(Employees[employeePosition][2].toUpperCase().equals("PT")){
            empStatus = "Part Time";
        }
        else if(Employees[employeePosition][2].toUpperCase().equals("FT")){
            empStatus = "Full Time";
        }

        bonus = bonusCalc(PayCheckAmt[employeePosition], Employees[employeePosition][2]);
        // formats all variables into column based string
        System.out.println("Employee Name: " + Employees[employeePosition][0] + ", " + Employees[employeePosition][1]);
        System.out.println("Employee Status: " + empStatus);
        System.out.println("Paycheck Amount: " + PayCheckAmt[employeePosition]);
        System.out.printf("%-14s%4.2f\n","Bonus Amount: ", bonus);
    }

    private static boolean valEmployees(){
            if(employeeAmt == 0){
                System.out.println("No employees to display returning...");
                return false;
            }
            else{
                return true;
            }
        }

    private static void LoadArrays(double[][] bonus) {
            String record;      //holds record read from input file
            String[] fields;    //holds the fields split out from the record
            Scanner arrayScanner;
            boolean eof = false;
            File file = new File("Bonus.dat");

            try{
                arrayScanner = new Scanner(file);
                int row = 0;    //set row index to zero
                //file exists, but make sure its not empty
                if(arrayScanner.hasNext()){
                    //Loop thru file
                    //read a record, split it into fields, use fields to build the arrays
                    while(!eof){
                        record = arrayScanner.nextLine();
                        fields = record.split(", ");
                        bonus[row][0] = Double.parseDouble(fields[0]);
                        bonus[row][1] = Double.parseDouble(fields[1]);
                        row++;
                        if(!arrayScanner.hasNext()){   //check for eof and set switch
                            eof = true;
                        }
                    }
                }
                else{
                    System.out.println("Bonus file not found, program aborting");
                    System.exit(1);
                }
            }
            catch(FileNotFoundException e){
                System.out.println("Bonus file not found, program aborting.");
                System.exit(1);
            }
        }

    private static double bonusCalc(double payCheck, String status){
        //Finds and returns the bonus an employee earned.
            double bonusTotal = 0;
            int row,column;
            if(payCheck >= 0.01 && payCheck < 100){
                row = 0;
            }
            else if (payCheck >= 100.01 && payCheck < 300){
                row = 1;
            }
            else if (payCheck >= 300.01 && payCheck < 500){
                row = 2;
            }
            else{
                row = 3;
            }
            if(status.toUpperCase().equals("FT")){
                column = 1;
            }
            else {
                column = 0;
            }
            bonusTotal = bonusRates[row][column] * payCheck;
            return bonusTotal;
        }

}

