package Ueb03;

import java.util.Scanner;

public class Dialog {

    public static int leseEingabe(){
        
        Scanner input = new Scanner(System.in);
        System.out.print("Wähle Funktion: ");
        int geleseneEingabe = input.nextInt();
        return geleseneEingabe;

    }

    public void start(){
        final int TEILERSUMME = 1;
        final int ISBN = 2;
        final int BEENDEN = 0;
        int eingabe;


        System.out.println("Berechne Teilersumme:   " + TEILERSUMME +
                         "   Berechne Prüfziffer:   " + ISBN +
                         "   Beenden   " + BEENDEN);

        while((eingabe = leseEingabe()) != BEENDEN){
            if(eingabe == TEILERSUMME){
                MathFunctions.berechneTeilersummeDialog();
            } else if(eingabe == ISBN){
                MathFunctions.berechnePrüfzifferDialog();
            } else if(eingabe == BEENDEN){
                return;
            } else if(eingabe > 2){
                throw new IllegalStateException("Funktion nicht vorhanden");
            }
        }
    }
    
    /**
     * 
     * In Main wird die Nutzer Eingabe mit den vorhandenen Funktionen verglichen
     * @param args
     */
    public static void main(String[] args) {
        
        

        
}
