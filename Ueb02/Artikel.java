package Ueb02;

public class Artikel {
    private int artikelNr;
    private String art;
    private int bestand;

    public void bucheAbgang(int menge){
        if(menge >= 0){
            setBestand(bestand -= menge);
        } else {
            throw new IllegalStateException("Menge ist kleiner 0");
        }
    }

    public void bucheZugang(int menge){
        if(menge >= 0){
            setBestand(bestand -= menge);
        } else {
            throw new IllegalStateException("Menge ist kleiner 0");
        }
    }

    public String toString(){
        return "Artikelnummer: " + artikelNr + "Bezeichnung: " + art + "Bestand: " + bestand;
    }

    public int getArtikelNr(){
        return artikelNr;
    }

    public String getBezeichnung(){
        return art;
    }

    public int getBestand(){
        return bestand;
    }
    
    public void setBestand(int BestandNeu){
        if(bestand >= 0){
            bestand = BestandNeu;
        } else {
            throw new IllegalStateException("Bestand ist kleiner 0");
        }
    }

    public Artikel(int artikelNr, String art, int bestand){
        if (artikelNr < 10000 && artikelNr > 999){
            this.artikelNr = artikelNr;
        } else {
            throw new IllegalStateException("Artikelnummer ist nicht vierstellig");
        }
        if (art != null){
            this.art = art;
        } else {
            throw new IllegalStateException("Die Bezeichnung ist null");
        }
        setBestand(bestand);
    }

    public Artikel(int artikelNr, String art){
        this(artikelNr, art, 0);
    }

}
