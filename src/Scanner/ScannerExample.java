package Scanner;

import java.util.Scanner;

//takk til Tom & Per for lånet av denne koden
public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv inn et tall:");
        int i = scanner.nextInt();
        scanner.nextLine(); // Lese inn (svelge) linjeskiftet
        System.out.println("Tallet:"+i);
        System.out.println("Skriv inn en tekst:");
        String s = scanner.nextLine();
        System.out.println("Teksten:"+s);
    }
}
