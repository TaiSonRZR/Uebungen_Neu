
/**
 * @author Simon Pilger
 * 
 */
public class PatientenWarteschlange {
    private Patient[] pw;

    /**
     * Hier wird die Größe der Wartschlange definiert
     * 
     * @param groesse ist die größe der Warteschlange
     */
    public PatientenWarteschlange(int groesse) {
        if (groesse > 10) {
            throw new IllegalStateException("Warteschlanger ist größer als 10");
        }
        pw = new Patient[groesse];
    }

    /**
     * Hier wird ein neuer Patient hinzugefügt Wird ein Patient hinzugefügt obwohl
     * die Schlange voll ist, wird eine Exception geworfen (Beispiel Patient Oliver Kahn)
     * 
     * @param pnr  Ist die Patientennummer
     * @param name ist der Name des Patienten
     * 
     *             Existiert ein Patient mit der gleichen Nummer wird dies nicht
     *             geprüft und führt nicht zum Fehler, da nicht gefordert Auch wenn
     *             die Patientennummer schon unter einem anderen Namen besteht, wird
     *             dies ebenfalls nicht geprüft
     */
    public void neuerPatient(int pnr, String name) {
        if (schlangeVoll() == true) {
            throw new IllegalStateException("Schlange voll");
        }
        for (int i = 0; i < pw.length; i++) {
            if (pw[i] == null) {
                pw[i] = new Patient(pnr, name);
                return;
            }
        }
    }

    /**
     * Hier kann ein Patient entfernt werden Wenn die Patientennummer nicht
     * existiert wird ein String returned in dem steht "Patient nicht gefunden"
     * 
     * @param pnr Patientennummer
     * @return return ist ein String in dem der entfernte Patient drin steht
     */
    public String entfernePatient(int pnr) {
        String s = "Patient gelöscht: ";
        for (int i = 0; i < pw.length; i++) {
            if (pw[i] != null && pw[i].getPnr() == pnr) {
                Patient p = pw[i];
                s += p.getPnr() + "\t" + p.getName();
                for (int j = i + 1; j < pw.length; j++) {
                    pw[j - 1] = pw[j];
                }
                pw[pw.length - 1] = null;
                return s;
            }
            // if (pw[i] != null && pw[i].getPnr() == pnr && getLaengeSchlange() != 0) {
            // // pw[i] = null;
            // pw[i] = pw[getLaengeSchlange()];
            // if(pw[i] == null){
            // throw new IllegalStateException("Ungültiger Wert für pw[i]");
            // }
            // s += pw[i].getPnr() + "\t" + pw[i].getName();
            // pw[getLaengeSchlange()] = null;
            // //return "Patient gelöscht: " + pw[i].getPnr() + "\t" + pw[i].getName();
            // //return "Patient gelöscht: ";
            // return s;
            // }
        }
        return "Patient nicht gefunden";
    }

    /**
     * Löscht den ersten Patient in der Warteschlange gibt ihn als return zurück und
     * füllt die Lücke mit den nächsten Patienten
     * 
     * @return
     */
    public Patient derNaechsteBitte() {
        if (pw[0] == null) {
            throw new IllegalStateException("Kein Patient vorhanden");
        }
        Patient p = pw[0];
        for (int i = 1; i < pw.length; i++) {
            pw[i - 1] = pw[i];
        }
        pw[pw.length - 1] = null;
        return p;
        // String s = "Nächster Patient: ";
        // if (pw[0] == null) {
        // return "Kein Patient in der Warteschlange";
        // }
        // s += pw[0].getPnr() + "\t" + pw[0].getName();
        // return s;

    }

    /**
     * Hier wird die Warteschlange auf einen freien Platz überprüft
     * 
     * @return
     */
    public Boolean schlangeVoll() {
        for (int i = 0; i < pw.length; i++) {
            if (pw[i] == null) {
                return false;
            }
        }
        return true;
    }

    public int getLaengeSchlange() {
        for (int i = 0; i < pw.length; i++) {
            if (pw[i] == null) {
                return i - 1;
            }
        }
        return -1;
    }

    public String toString() {
        String s = "Wartliste\n";
        s += "\tPnr\tName\n";
        // if (pw[0] != null) {
        // s += pw[0].getPnr() + "\t" + pw[0].getName();
        // }
        for (int i = 0; i < pw.length; i++) {
            if (pw[i] != null) {
                s += i + "\t" + pw[i].getPnr() + "\t" + pw[i].getName() + "\n";
                // } else {
                // s += i + "\t" + "Warteliste Position " + i + " ist null\n";
            }
        }
        return s;
        // return ("Warteliste\nPnr\tName\n");
    }

    public static void main(String[] args) {
        PatientenWarteschlange pw = new PatientenWarteschlange(10);

        pw.neuerPatient(4711, "Löw, Jogi"); // Neuen Patient anfügen
        pw.neuerPatient(1234, "Kroos, Toni");
        pw.neuerPatient(1111, "Neuer, Manuel");
        pw.neuerPatient(4567, "Ballack, Michael");
        pw.neuerPatient(3245, "Pilger, Simon");
        pw.neuerPatient(3377, "Lahm, Phillip");
        pw.neuerPatient(2853, "Haaland, Erling");
        pw.neuerPatient(7357, "Lewandowski, Robert");
        pw.neuerPatient(9897, "Doan, Rizo");
        pw.neuerPatient(4409, "Kempf, Marc Oliver");
        // pw.neuerPatient(8695, "Kahn, Oliver"); // Patient zum testen der vollen Warteschlange
        System.out.println(pw); // Warteschlange ausgeben
        System.out.println(pw.entfernePatient(1111)); // Patient entfernen
        Patient naechster = pw.derNaechsteBitte(); // nächsten Patient herausholen
        System.out.println("Nächster Patient: " + naechster.toString());
        System.out.println(pw);
    }
}
