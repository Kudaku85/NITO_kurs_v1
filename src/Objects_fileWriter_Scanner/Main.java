package Objects_fileWriter_Scanner;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class Ticket{
    private String passengerName;
    private String departure;
    private String destination;
    private int timeToDeparture;
    private static int numberOfTickets;

    public Ticket(String passengerName, String departure, String destination, int timeToDeparture) {
        this.passengerName = passengerName;
        this.departure = departure;
        this.destination = destination;
        this.timeToDeparture = timeToDeparture;
    }

    public String ticketInfo(){
        String output = "\nThe passenger is named " + passengerName + ".\n";
        output += "They are travelling to " + destination + ".\n";
        output += "They leave in " + timeToDeparture + " minutes. ";
        if (timeToDeparture < 0){
            output += "They're not gonna make it. \n";
        }
        else if (timeToDeparture < 60){
            output += "Time is running short. \n";
        }
        else {
            output += "They should be fine. \n";
        }
        return output;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTimeToDeparture() {
        return timeToDeparture;
    }

    public void setTimeToDeparture(int timeToDeparture) {
        this.timeToDeparture = timeToDeparture;
    }

    public static int getNumberOfTickets() {
        return numberOfTickets;
    }

    public static void setNumberOfTickets(int numberOfTickets) {
        Ticket.numberOfTickets = numberOfTickets;
    }
}

class AirlineTicket extends Ticket{
    String planeNr;
    public AirlineTicket(String passengerName, String departure, String destination, int timeToDeparture, String planeNr) {
        super(passengerName, departure, destination, timeToDeparture);
        this.planeNr = planeNr;
    }

    @Override
    public String ticketInfo() {
        String output = super.ticketInfo();
        output += "Their plane is " +planeNr +". They need to get going";
        return output;
    }
}


public class Main {
    public static void main(String[] args){
        File tickets = new File("tickets.txt");
        try {
            FileWriter writer = new FileWriter("tickets.txt");

        Ticket ticket1 = new Ticket("Eivind", "Oslo", "Norilsk, Siberia", 10);
        Ticket ticket2 = new Ticket("Tor", "Oslo", "Grand Canaria", -525600);
        AirlineTicket ticket3 = new AirlineTicket("Sonja", "Oslo", "Florenze", 100, "sas 476");
        writer.write(ticket1.ticketInfo());
        writer.write(ticket2.ticketInfo());
        writer.write(ticket3.ticketInfo());
        writer.close();
        Scanner input = new Scanner(tickets);

        while (input.hasNextLine()) {
            String ticket = input.nextLine();
            System.out.println(ticket);
        }
    }
        catch (Exception e){
            System.out.println("Her gikk noe skikkelig galt");
        }
    }
}