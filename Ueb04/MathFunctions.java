package Ueb04;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class MathFunctions {
    static Scanner input = new Scanner(System.in);
    private long zahl;

    

    

    public static long leseIsbn() {
        System.out.print("Neunstellige Zahl: ");
        long isbn = input.nextLong();
        return isbn;
    }

    public static long berechneTeilersumme() {
        long teilersumme = 0;
        long zahl = leseZahl();

        if (zahl >= 0) {
            for (int n = 1; n <= zahl; n++) {

                if (zahl % n == 0) {
                    teilersumme += n;
                }
            }
        } else {
            throw new IllegalStateException("Zahl ist negativ");
        }
        return teilersumme;
    }
    

    public static String berechneChecksummeIsbn(){
        int berechnetePrüfziffer = 0;
        long isbn = leseIsbn();

        if(isbn < 1000000000 && isbn > 999999999){
            for(int n = 1; n <= 9; n++){
                berechnetePrüfziffer += ((isbn / (long) Math.pow(10, n))%10)*n;
            }

            berechnetePrüfziffer = berechnetePrüfziffer % 11;

            if(berechnetePrüfziffer == 10){
                return "x";
            } else {
                return Integer.toString(berechnetePrüfziffer);
            }
        } else {
            throw new IllegalStateException("ISBN ist nicht 9-stellig");
        }

    }

    

}
    



try{
    long teilersumme = berechneTeilersumme();
    System.out.println(teilersumme);
} catch (IllegalStateException e) {
    System.out.println(e);
}