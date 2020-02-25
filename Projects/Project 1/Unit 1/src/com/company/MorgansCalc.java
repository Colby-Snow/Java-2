package com.company;

import java.util.Scanner;

public class MorgansCalc {

    String[][] Employees = new String[10][2];
    Double[][] PayCheckAmt = new Double[4][3];
    String fName,lName;
    int menuOperation;
    Scanner userInput = new Scanner(System.in);

    public void mainMenu(){
        System.out.println("Please one of the following option numbers.");
        System.out.print("Option 1: Enter Employee Data\n\rOption 2: Display All Employees\n\r" +
                "Option 3: Display Single Employee\n\rOption 4: Exit\n\r");
        menuOperation = userInput.nextInt();
        switch(menuOperation) {
            case 1:
                System.out.println("Option 1 selected");
                break;
            case 2:
                System.out.println("Option 2 selected");
                break;
            case 3:
                System.out.println("Option 3 selected");
                break;
            case 4:
                System.out.println("Option 4 selected");
                break;
        }
    }

    public String[][] SearchOption(String fName, String lName){
        Employees[2][1] = "Hello";
        return Employees;
    }
}
