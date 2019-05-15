package pw.pio;

import lombok.ToString;

@ToString
public class PakietUslug {
    private int czasTrwania;  // w miesiach
    private boolean darmoweZajecia;
    private double kosztMiesieczny;
    private String nazwa;

    PakietUslug(String nazwa, int czasTrwania, double kosztMiesieczny, boolean darmoweZajecia){
        this.nazwa = nazwa;
        this.czasTrwania = czasTrwania;
        this.kosztMiesieczny = kosztMiesieczny;
        this.darmoweZajecia = darmoweZajecia;
        
    }
    
    public int getCzasTrwania() {
        return czasTrwania;
    }

    public boolean getDarmoweZajecia() {
        return darmoweZajecia;
    }

    public double getKosztMiesieczny() {
        return kosztMiesieczny;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setCzasTrwania(int czasTrwania) {
        this.czasTrwania = czasTrwania;
    }

    public void setDarmoweZajecia(boolean darmoweZajecia) {
        this.darmoweZajecia = darmoweZajecia;
    }

    public void setKosztMiesieczny(double kosztMiesieczny) {
        this.kosztMiesieczny = kosztMiesieczny;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
