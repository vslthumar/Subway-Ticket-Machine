/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketmachine;

import java.util.Scanner;

/**
 * This class defines view model of the program. It takes input from the user
 * and call the methods from model class to display proper output to the user.
 *
 * @author Vishal Thumar
 */
public class TicketGenerator {

    /**
     *
     * @param args unused
     */
    public static void main(String[] args) {

        //variables and scanner class declaration
        Scanner sc = new Scanner(System.in);
        int i, j;
        boolean a = true, b = false;

        //make objects of model class
        TicketMachine tm = new TicketMachine();
        TicketMachine tm1 = new TicketMachine();
        TicketMachine tm2 = new TicketMachine();

        //setting values of routes and fares using set method of object class
        tm1.setRoute("Downtown", "Uptown");
        tm2.setRoute("Main street", "King street");
        tm1.setFare(3.5, 6.5);
        tm2.setFare(2.5, 5.5);

        //loop for changing machine and exit program
        while (a) {

            //input to choose a machine
            System.out.println("\n.......................................");
            System.out.println("Enetr 1 to select Machine-1:");
            System.out.println("Enter 2 to select Machine-2:");
            System.out.println("Enter 3 to Exit.");
            System.out.println(".......................................\n");
            i = sc.nextInt();

            //process according to different conditions of input
            switch (i) {
                case 1:
                    tm = tm1;
                    b = true;
                    break;
                case 2:
                    tm = tm2;
                    b = true;
                    break;
                case 3:
                    a = false;
                    b = false;
                    break;
                default:
                    System.out.println("\n.......................................");
                    System.out.println("Invalid Input.");
                    System.out.println(".......................................\n");
                    b = false;
                    a = true;
                    break;
            }
            tm.route = tm.getRoute1();

            //loop for adding credit and persons,removing persons, and calculate and display output.
            while (b) {

                a = false;

                //output of ticket info by calling tostring method from object class
                System.out.println("\n.......................................");
                System.out.println(tm.toString());
                System.out.println(".......................................\n");

                //input
                System.out.println("Enter");
                System.out.println("1. Select route " + tm.getRoute1());
                System.out.println("2. Select route " + tm.getRoute2());
                System.out.println("3. Add an Adult");
                System.out.println("4.Remove an Adult");
                System.out.println("5. Add a Child");
                System.out.println("6. Remove a Child.");
                System.out.println("7. Insert a Quater");
                System.out.println("8. Insert a Loonie");
                System.out.println("9. Insert a Toonie");
                System.out.println("10. Print Ticket");
                System.out.println("11. Switch to another machine.");
                System.out.println(".......................................\n");
                j = sc.nextInt();

                //process to set values as per user input and calculates by calling methods from object class
                double fare = tm.getFare();
                double credit = tm.getCredit();
                switch (j) {
                    case 1:
                        tm.route = tm.getRoute1();
                        break;
                    case 2:
                        tm.route = tm.getRoute2();
                        break;
                    case 3:
                        tm.addAdult();
                        break;
                    case 4:
                        if (tm.adults > 0) {
                            tm.removeAdult();
                        }
                        break;
                    case 5:
                        tm.addChild();
                        break;
                    case 6:
                        if (tm.children > 0) {
                            tm.removeChild();
                        }
                        break;
                    case 7:
                        tm.addQuater();
                        break;
                    case 8:
                        tm.addLoonie();
                        break;
                    case 9:
                        tm.addToonie();
                        break;
                    case 10:
                        if (tm.adults > 0 || tm.children > 0) {
                            //output of confirmation or rejection
                            if (credit >= fare) {
                                System.out.println("\n.......................................");
                                System.out.println("You got your ticket.");
                                System.out.println(".......................................\n");
                                tm.quater = 0;
                                tm.loonie = 0;
                                tm.toonie = 0;
                            } else {
                                System.out.println("\n.......................................");
                                System.out.println("No ticket for you.\tYour credit is less than total fare.");
                                System.out.println(".......................................\n");
                            }
                            tm.children = 0;
                            tm.adults = 0;
                        } else {
                            System.out.println("\n.......................................");
                            System.out.println("No ticket for you.\tAdd at least one person.");
                            System.out.println(".......................................\n");
                        }
                        break;
                    case 11:
                        tm.children = 0;
                        tm.adults = 0;
                        tm.quater = 0;
                        tm.loonie = 0;
                        tm.toonie = 0;
                        b = false;
                        a = true;
                        break;

                    default:
                        System.out.println("\n.......................................");
                        System.out.println("Invalid Input.");
                        System.out.println(".......................................\n");
                        break;
                }
            }
        }
    }
}
