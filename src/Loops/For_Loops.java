package Loops;

public class For_Loops {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            System.out.println(i);
        }
        System.out.println("Vi kan fint bruke andre navn enn i som vi gjør i neste loop, men i (kort for integer) er standarden. ");
        for (int teller = 0; teller < 10; teller++){
            System.out.println(teller);
        }

        System.out.println("Vi kan fint starte på andre steder enn 0, f.eks. her hvor vi teller fra 1-10 istedet");
        for (int i = 1; i < 11; i++){
            System.out.println(i);
        }
        System.out.println("Vi kan også endre formatet på loopen til å telle nedover, slik vi gjør her");
        for (int i = 10; i > 0; i--){
            System.out.println(i);
        }

        System.out.println("Vi kan også gjøre større hopp. Her øker vi i med 2 per runde, så vi printer kun annenhvert tall");
        for (int i = 0; i < 10; i+=2){
            System.out.println(i);
        }

        System.out.println("Vi kan også legge en for loop inne i en annen for loop. Kutymen da er at loop nr 2 bruker int j (første bokstav etter i)");
        for (int i = 1; i <= 5; ++i) {

            // inner loop to print the numbers
            for (int j = 1; j <= i; ++j) {
                System.out.print(j + " ");
            }
            System.out.println(); //Legger inn et line break etter hver serie med tall
        }
    }
}
