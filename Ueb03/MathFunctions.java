package Ueb03;

import java.util.Scanner;

/**
 * MathFunctions
 */
public class MathFunctions {
    private static Scanner input = new Scanner(System.in);
    
    /**
     * leseeingabeteilersumme liest die Eingabe des Nutzers ein
     * @return zahl
     */

    public static long leseEingabeTeilersumme(){
        long zahl;
        System.out.print("Positive Zahl eingeben: ");
        zahl = input.nextInt();
        return zahl;
    }

    /**
     * berechneteilersumme berechnet die Teilersumme der vom Nutzer eingegebenen Zahl
     */

    public static long berechneTeilersumme(long zahl){        
        long teilersumme = 0;
        if(zahl >= 0){
            for(int n = 1; n <= zahl; n++){

                if(zahl % n == 0){
                    teilersumme += n;
                }
            }
        } else {
            throw new IllegalStateException("Die Eingabe ist negativ");
        }
        return teilersumme;
    }

    /**
     * berechnechecksummeisbn Berechnet die Prüfziffer der vom Nutzer eingegebeneb ISBN     
     * @param isbn
     * @return Die Prüfziffer wird als String ausgegeben
     */

    public static String berechneChecksummeIsbn(long isbn){
        int berechnetePrüfziffer = 0;

        if(isbn < 1000000000 && isbn >= 0){
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

    /**
     * lese isbn liest die nutzereingabe
     * @return
     */

    public static long leseIsbn(){
        long zahl;
        System.out.print("Neunstellige positive Zahl eingeben: ");
        zahl = input.nextInt();
        return zahl;
    }

    /**
     * Im becrechnePrüfzifferDialog wird die eingabe der isbn abgefragt und die prüfziffer ausgegeben
     * 
     */

    public static void berechnePrüfzifferDialog(){
        long eingabe;
        String prüfziffer = null;

        eingabe = leseIsbn();
        
        prüfziffer = berechneChecksummeIsbn(eingabe);

        System.out.println("Prüfziffer: " + prüfziffer);
        

    }

    /**
     * Im berechneteilersummedialog wird ein Dialog zur Eingabe der zu berechnenden Teilersumme abgefragt
     * und die teilersumme ausgegeben
     */

    public static void berechneTeilersummeDialog() {
        long eingabe;
        long teilersumme;

        eingabe = leseEingabeTeilersumme();

        teilersumme = berechneTeilersumme(eingabe);

        System.out.println("Teilersumme: " + teilersumme);
        

    }

    public Isbn(long zahl){
        
    }
    
}