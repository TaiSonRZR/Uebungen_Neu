/**
 * PatientenWarteschlange
 */
public class Patient {
    private int pnr;
    private String name;
    private final int MINIMUM = 1000;
    private final int MAXIMUM = 10000;

    public Patient(int pnr, String name) {
        if (pnr < MINIMUM || pnr >= MAXIMUM) {
            throw new IllegalStateException("Patientennummer ist nicht 4 stellig");
        }
        this.pnr = pnr;

        if (name == null) {
            throw new IllegalStateException("Name ist null");
        }
        this.name = name;
    }

    public String toString() {
        return pnr + "\t" + name + "\n";
    }

    public String getName() {
        return name;
    }

    public int getPnr() {
        return pnr;
    }

}