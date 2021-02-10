import java.util.Scanner;

public class Dialog {
    static Scanner input = new Scanner(System.in);

    public static int leseFunktionsAuswahl() {
        System.out.print("Wähle eine Funktion: ");
        int funktionsAuswahl = input.nextInt();
        return funktionsAuswahl;
    }   

    public static long leseZahl() {
        System.out.print("positive Zahl eingeben: ");
        long zahl = input.nextLong();
        return zahl;
    }


    public static void start() {

        final int TEILERSUMME = 1;
        final int CHECKISBN = 2;
        final int NULLSTELLEN = 3;
        final int SUMMEPOTENZEN = 4;
        long zahl = 0;
        int eingabe;


                        
        while((eingabe = leseFunktionsAuswahl()) != 0){
            System.out.println("Berechne Teilersumme:   " + TEILERSUMME +
                           "   ISBN Prüfziffer   " + CHECKISBN +
                           "   Nullstellen   " + NULLSTELLEN +
                           "   Summe von Potenzen   " + SUMMEPOTENZEN);
            try{
                if(eingabe == TEILERSUMME){
                    zahl = berechneTeilersumme();
                } else if(eingabe == CHECKISBN) {
                    MathFunctions.berechneChecksummeIsbn();
                }
            }        
        }
        
    }

}
