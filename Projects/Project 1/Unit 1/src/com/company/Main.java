package com.company;

public class Main {
    String[][] Employees = new String[10][2];
    Double[][] PayCheckAmt = new Double[4][3];
    String fName,lName;

    public static void main(String[] args) {
        mainMenu();
    }
    public void mainMenu(){
        System.out.print("Option 1: Enter Employee Data");
        System.out.print("Option 2: Display All Employees");
        System.out.print("Option 3: Display Single Employee");
        System.out.print("Option 4: Exit");
    }
    public String[][] SearchOption(String fName, String lName){
        Employees[2][1] = "Hello";
        return Employees;
    }
}
