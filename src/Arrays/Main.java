package Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myArray = new int[10]; //Arrays er en datastruktur for å holde styr på variabler. Dette er et int-array som har plass til 10 elementer
        int[] instantArray = {1,2,3,4,5}; //Arrays kan også fylles når de opprettes, slik dette gjør. Merk at det da vil kun ha plasser til verdiene det får nå.
        char[] charArray = new char[10]; //Arrays kan holde alle datatyper, dette holder chars (bokstaver)
        String[] stringArray = {"hei", "på", "deg"}; //Også objekter som Strings.

        //Det er veldig vanlig å bruke loops til å legge verdier inn i arrays. Innholdet her vil være tallene 1-10
        for (int i = 0; i < myArray.length; i++){
            myArray[i] = i;
        }

        //Det er også vanlig å bruke loops for å hente verdiene ut igjen
        for (int i = 0; i < myArray.length; i++){
            System.out.println(myArray[i]);
        }
    }
}
