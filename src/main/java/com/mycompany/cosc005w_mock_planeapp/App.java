/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cosc005w_mock_planeapp;

import java.util.Scanner;

/**
 * // Before you start, complete the following information: NAME: SURNAME:
 * STUDENT ID: SESSION (Day + time):
 */
public class App {

    // Global variables
    private static int[][] planeSeats = null;
    private static int[] pricePerRow = null;
    private static Payment[] payments = new Payment[100];  //A new array of objects type payment.
    private static int paymentCount = 0;

    
    public static void main(String[] args) {
        System.out.println("Welcome to Flying Java!");
        initialiseRows();
        runMenu();
    }

    public static void initialiseRows() {
        planeSeats = new int[4][]; // total rows - multidimensional array
        planeSeats[0] = new int[16]; // row 1 - initialised at 0 all available
        planeSeats[1] = new int[22]; // row 2 - initialised at 0 all available
        planeSeats[2] = new int[22]; // row 2 - initialised at 0 all available
        planeSeats[3] = new int[16]; // row 2 - initialised at 0 all available
        pricePerRow = new int[4];
        pricePerRow[0] = 50;
        pricePerRow[1] = 80;
        pricePerRow[2] = 80;
        pricePerRow[3] = 50;
    }

    public static void runMenu() {
        int option;
        boolean cont = true;

        while (cont) {
            option = getOption();
            switch (option) {
                case 0:
                    cont = false;
                    break;
                case 1:
                    buyTicket();
                    break;
                case 2:
                    showSeatingArea();
                    break;
                default:
                    System.out.println("Option not available. Please select a valid option: ");
            }
        }
    }

    private static int getOption() {

        Scanner input = new Scanner(System.in);
        boolean valid = false;
        int option = -1;
        do {
            System.out.println();
            System.out.println("+---------------------------------------------+");
            System.out.println("|                MAIN MENU                    |");
            System.out.println("+---------------------------------------------+");
            System.out.println("|  1) Buy a plane ticket                      |");
            System.out.println("|  2) Show seating area and available seats   |");
            System.out.println("|  0) Quit                                    |");
            System.out.println("+---------------------------------------------+");
            System.out.print("Please select an option: ");
            try {
                option = input.nextInt();
                valid = true;
            } catch (Exception e) {
                System.out.println("This option not valid.");
            }
        } while (!valid);
        return option;

    }

    private static void buyTicket() {
        Scanner input = new Scanner(System.in);
        int row;

        while (true) {
            System.out.print("Enter row number: ");
            row = input.nextInt() - 1;
            if (row < 0 || row > 3) {
                System.out.println("Please enter a row number between 1 and 4");
                continue;
            } else {
                break;
            }

        }

        System.out.print("Enter seat number: ");
        int seat = input.nextInt() - 1;

        // Check if the seat is available or not
        if (planeSeats[row][seat] == 0) {
            planeSeats[row][seat] = 1;
            System.out.println("Purchase successful.");
            showSeatingArea();
        } else {
            System.out.println("This seat is already taken.");
        }
        
        //Store payment
        int paymentAmount = pricePerRow[row];
        input.nextLine();
        System.out.print("Enter your email address: ");
        String email = input.nextLine();
        
        Payment p1 = new Payment(email, paymentAmount);
        
        if(paymentCount < payments.length) {
            payments[paymentCount] = p1;
            paymentCount ++;
        } else {
            System.out.println("Payment Storage is full!");
        }
        
        System.out.println("Purchase Successful. ");
        p1.printPayment(); 
        
        System.out.println("Payments Array:");  //Testing to see if its printing the objects into the payments array
        for (int i = 0; i < paymentCount; i++) {  //Testing to see if its printing the objects into the payments array
            payments[i].printPayment();
        }
 

    }
  

    private static void showSeatingArea() {

        int rows = planeSeats.length;
        char aisle = '|';

        System.out.println("=".repeat(76));
        System.out.println("                              PLANE SEATING MAP ");
        System.out.println("=".repeat(76));

        for (int row = 0; row < rows; row++) {
            System.out.print("Row " + (row + 1) + "(£" + pricePerRow[row] + ")  ");
            int seatsPerRow = planeSeats[row].length;
            for (int seat = 0; seat < seatsPerRow; seat++) {
                if (seat == 9) { // Create aisles
                    System.out.print(" " + aisle + " ");
                }
                if (planeSeats[row][seat] == 0) { //available
                    System.out.print("[O]");
                } else { // not available
                    System.out.print("[X]");
                }
            }
            System.out.println();
        }
        System.out.println("=".repeat(76));
        System.out.println("LEGEND: [O] = Seat available, [X] = Seat not available, | = Aisle");
        System.out.println("=".repeat(76));
        System.out.println();

    }
}
