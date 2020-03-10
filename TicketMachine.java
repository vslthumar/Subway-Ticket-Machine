/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketmachine;

/**
 * This class define model of the program,which is used to track internal state
 * of the program. This class set and get variables using set and get
 * methods,also calculates values and display output through tostring method.
 *
 * @author Vishal Thumar
 */
public class TicketMachine {

    //variable declaration
    String route1 = "", route2 = "", route;
    double childFare = 0, adultFare = 0;
    int children = 0, adults = 0;
    double quater = 0;
    int loonie = 0, toonie = 0;

    //set and get routes
    void setRoute(String newRoute1, String newRoute2) {
        route1 = newRoute1;
        route2 = newRoute2;
    }

    String getRoute1() {
        return route1;
    }

    String getRoute2() {
        return route2;
    }

    //set values for child and adult fares, and calculates total fare
    void setFare(double newChildFare, double newAdultFare) {
        childFare = newChildFare;
        adultFare = newAdultFare;
    }

    double getFare() {
        return (childFare * children) + (adultFare * adults);
    }

    //these methods add or remove a child or an adult
    public void addAdult() {
        adults++;
    }

    public void removeAdult() {
        adults--;
    }

    public void addChild() {
        children++;
    }

    public void removeChild() {
        children--;
    }

    //add credit in quarter,loonie or toonie
    public void addQuater() {
        quater++;
    }

    public void addLoonie() {
        loonie++;
    }

    public void addToonie() {
        toonie++;
    }

    //calculate total fare
    double getCredit() {
        return (quater * 0.25) + loonie + (toonie * 2);
    }

    //set the output of all info about the ticket
    @Override
    public String toString() {
        return "Selected route: " + route
                + "\t Child fare: " + childFare + "\t Adult fare: " + adultFare
                + "\n Total number of Children: " + children + " \t Total number of Adults: " + adults
                + "\n Total fare: " + getFare() + "\t Credit :" + getCredit();

    }
}
