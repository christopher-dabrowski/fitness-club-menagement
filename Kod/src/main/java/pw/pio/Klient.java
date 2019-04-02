package pw.pio;

import java.util.Date;

public class Klient extends Osoba {
    private Date dataRozpoczeciaPakietu;
    private int numerKarnetu;
    private PakietUslug pakietUslug;

    public Klient(String imie, String nazwisko, Date dataRozpoczeciaPakietu, PakietUslug pakietUslug) {
        super(imie, nazwisko);
        this.dataRozpoczeciaPakietu = dataRozpoczeciaPakietu;
        this.numerKarnetu = BazaKlientow.getInstance().wygenerujUnikalnyNumerKlienta();
        this.pakietUslug = pakietUslug;
    }

    public Date getDataRozpoczeciaPakietu() {
        return dataRozpoczeciaPakietu;
    }

    public void setDataRozpoczeciaPakietu(Date dataRozpoczeciaPakietu) {
        this.dataRozpoczeciaPakietu = dataRozpoczeciaPakietu;
    }

    public int getNumerKarnetu() {
        return numerKarnetu;
    }

    public void setNumerKarnetu(int numerKarnetu) {
        this.numerKarnetu = numerKarnetu;
    }

    public PakietUslug getPakietUslug() {
        return pakietUslug;
    }

    public void setPakietUslug(PakietUslug pakietUslug) {
        this.pakietUslug = pakietUslug;
    }
}
