package Objects_fileWriter_Scanner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Vi oppretter en klasse for billetter med private variabler
class Ticket {
    private static int numberOfTickets;
    private String passengerName;
    private String departure;
    private String destination;
    private int timeToDeparture;

    //Med tilhørende konstruktør
    public Ticket(String passengerName, String departure, String destination, int timeToDeparture) {
        this.passengerName = passengerName;
        this.departure = departure;
        this.destination = destination;
        this.timeToDeparture = timeToDeparture;
    }

    //Vi lager getters og setters for alle private variabler
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

    //Lager en metode som henter ut ticketInfo. Merk at den er String, så vi må returnere en String til slutt.
    public String ticketInfo() {
        String output = "\nThe passenger is named " + passengerName + ".\n";
        output += "They are travelling to " + destination + ".\n";
        output += "They leave in " + timeToDeparture + " minutes. ";
        if (timeToDeparture < 0) {
            output += "They're not gonna make it. \n";
        } else if (timeToDeparture < 60) {
            output += "Time is running short. \n";
        } else {
            output += "They should be fine. \n";
        }
        return output;
    }

    //Vi lager også en toString-metode, som bruker metoden ticketInfo over
    @Override
    public String toString() {
        return ticketInfo();
    }
}

//AirlineTicket arver fra (extender) Ticket, så den vil ha tilgang til alle attributtene og metodene i Ticket.
class AirlineTicket extends Ticket {
    String planeNr; //Vi legger til en ny variabel som kun er tilgjengelig for AirlineTicket

    //Constructor-metode her, som lar oss legge inn verdiene samtidig som vi oppretter billettene. Se linje #114
    public AirlineTicket(String passengerName, String departure, String destination, int timeToDeparture, String planeNr) {
        super(passengerName, departure, destination, timeToDeparture); //Her bruker vi superklassen sin constructor for de første tre verdiene
        this.planeNr = planeNr; //Og tar også inn planeNr, som kun brukes i AirlineTicket
    }

    //Lager en metode som henter ut ticketInfo. Merk at den er String, så vi må returnere en String til slutt.
    //Metoden bruker superklassen sin ticketInfo-metode (super.ticketInfo), og legger til en ny linje nederst.
    @Override
    public String ticketInfo() {
        String output = super.ticketInfo();
        output += "Their plane is " + planeNr + ". They need to get going";
        return output;
    }

    //Vi lager også en toString-metode, som bruker metoden ticketInfo over
    @Override
    public String toString() {
        return ticketInfo();
    }
}


public class Main {
    public static void main(String[] args) {
        //Vi oppretter en fil ved navn tickets.txt, den finner vi i rotmappen til prosjektet
        try{

        //Merk at Java krever at all bruk av FileWriter må pakkes inn i en try-catch siden den vil kaste feilmeldinger hvis den ikke finner filen.
            FileWriter writer = new FileWriter("tickets.txt"); //Oppretter en writer som skriver til tickets.txt

            //Vi oppretter noen Tickets
            Ticket ticket1 = new Ticket("Eivind", "Oslo", "Norilsk, Siberia", 10);
            Ticket ticket2 = new Ticket("Tor", "Oslo", "Grand Canaria", -525600);

            //Vi oppretter også en AirlineTicket, merk at denne skal også ha inn planeNr-variabel
            AirlineTicket ticket3 = new AirlineTicket("Sonja", "Oslo", "Florenze", 100, "sas 476");

            //Vi gjør et kall på ticket.ticketInfo() og sender resultatet til writer.write, slik at informasjonen blir lagret i tickets.txt
            writer.write(ticket1.ticketInfo());
            writer.write(ticket2.ticketInfo());
            writer.write(ticket3.ticketInfo());

            //Deretter lukker vi writer. Hvis vi ikke gjør dette kan vi få følgeproblemer, close alltid writer når den er ferdig.
            writer.close();


            //Vi oppretter en marker som forteller Java hvor tickets.txt ligger
            File tickets = new File("tickets.txt");

            //Vi oppretter en scanner som henter informasjon fra tickets.txt (merk at den tar inn File tickets)
            Scanner scanner = new Scanner(tickets);

            //Vi bruker scanneren til å gå gjennom hver linje i tickets.txt, og printer ut verdiene
            while (scanner.hasNextLine()) {
                String ticket = scanner.nextLine();
                System.out.println(ticket);
            }


            //Til slutt har vi en catch som håndterer eventuelle problemer FileWriter can skape
        } catch (IOException e) {
            System.out.println("Fil ikke funnet, hjelp?");
        }
    }
}