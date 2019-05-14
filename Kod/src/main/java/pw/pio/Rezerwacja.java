package pw.pio;

import java.util.Date;

public class Rezerwacja {

    private int idRezerwacji;
    private Date data;
    private int idZajec;
    private int numerKartyKlienta;

    public Rezerwacja(Date data, int idZajec, int numerKartyKlienta){

        this.idRezerwacji = BazaRezerwacji.getInstance().wygenerujUnikalnyNumerRezerwacji();
        this.data = data;
        this.idZajec = idZajec;
        this.numerKartyKlienta = numerKartyKlienta;

    }

    public int getIdRezerwacji() { return idRezerwacji; }

    public Date getData() {
        return data;
    }

    public int getIdZajec() {
        return idZajec;
    }

    public int getNumerKartyKlienta() {
        return numerKartyKlienta;
    }

    public void setData(Date data) { this.data = data; }

    public void setIdZajec(int idZajec) { this.idZajec = idZajec; }

    public void setNumerKartyKlienta(int numerKartyKlienta) { this.numerKartyKlienta = numerKartyKlienta; }
}
