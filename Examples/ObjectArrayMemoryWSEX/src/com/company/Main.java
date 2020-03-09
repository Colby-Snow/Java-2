package com.company;

public class Main {

    public static void main(String[] args) {
        Reservation[] reservations;

        reservations = new Reservation[4];

        reservations[3] = new Reservation(1001,"Mickey Mouse", true);

        reservations[2].setResNumber(2000);

        reservations[1] = new Reservation();

        reservations[4] = new Reservation(1002, "Minnie Mouse", false);

    }
}
