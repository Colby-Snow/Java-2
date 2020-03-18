package com.company;

public class TestReservation {

    public static void main(String[] args) {
        Reservation[] reservations;

        reservations = new Reservation[4];
        //test default constructor
        reservations[0] = new Reservation();
        printRes(0,reservations);

        //test parameterized constructor
        reservations[1] = new Reservation( 5000,"Test Name", true);
        printRes(1,reservations);

        //test setters
        reservations[1].setResCustName("      ");
        reservations[1].setResNumber(99);

        //test getters
        printRes(1, reservations);

        System.out.println(reservations[1].toString());

        System.out.println(reservations[1].calcFreqFlyerDiscount(250));
    }
    public static void printRes(int i, Reservation[] res){
        System.out.println(res[i].getResNumber());
        System.out.println(res[i].getResCustName());
        System.out.println(res[i].getResFreqFlyer());
    }
}
