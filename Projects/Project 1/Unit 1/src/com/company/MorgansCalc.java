package com.company;

import java.util.Scanner;

public class MorgansCalc {

    String[][] Employees = new String[10][3];
    Double[] PayCheckAmt = new Double[10];
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
                setEmployees();
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

    public void setEmployees(){
        String employContinue;

        for(int i = 0; i <= 10; i++){
            for (int j = 0; j <= 3; j++){
                boolean validStatus = false;
                switch(j) {
                    case 1:
                        System.out.println("Please enter the first name of employee number "+ i + 1);
                        Employees[i][j] = userInput.next();
                    case 2:
                        System.out.println("Please enter the last name of employee number " + i + 1);
                        Employees[i][j] = userInput.next();
                    case 3:
                        do{
                            System.out.println("Please enter the employee number " + i + 1 +"'s status full time (FT) or part time (PT)");
                            Employees[i][j] = userInput.next();
                            if(Employees[i][j].toUpperCase() == "PT" || Employees[i][j].toUpperCase() == "FT"){
                                validStatus = true;
                            }
                            else{
                                System.out.println("Invalid status please enter either PT for part time or FT for full time.");
                            }
                        }while(!validStatus);
                }
            }
            System.out.println("Please enter employee number " + i + 1 +"'s paycheck amount");
            PayCheckAmt[i] = userInput.nextDouble();
            do{
                System.out.println("Would you like to continue entering employees? (Y or N)");
                employContinue = userInput.next().toUpperCase();
            }while (employContinue != "Y" && employContinue != "N");
            if(employContinue == "N") {
                break;
            }
        }
    }

    public void displayEmployees(){
        for (int i = 0; i<=10; i++){
            
        }
    }
}

