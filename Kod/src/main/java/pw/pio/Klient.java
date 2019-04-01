package pw.pio;

import java.util.Date;

public class Klient extends Osoba {
    private Date dataRozpoczeciaPakietu;
    private int numerKarnetu;
    //TODO: Referencja na pakiet


    public Klient(String imie, String nazwisko, Date dataRozpoczeciaPakietu, int numerKarnetu) {
        super(imie, nazwisko);
        this.dataRozpoczeciaPakietu = dataRozpoczeciaPakietu;
        this.numerKarnetu = numerKarnetu;
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
}
