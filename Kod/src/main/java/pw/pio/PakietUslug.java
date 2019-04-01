package pw.pio;
public class PakietUslug {
    private int czasTrwania;
    private boolean darmoweZajecia;
    private double kosztMiesieczny;
    private String nazwa;

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
