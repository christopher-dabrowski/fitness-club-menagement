package pw.pio;
import java.util.Date;

public class Etat {

    private Date doKiedy;
    private String nazwa;

    private Date odKiedy;
    private int wymiarGodzin;
    private double wynagrodzenie;


    public Date getDoKiedy() {
        return doKiedy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public Date getOdKiedy() {
        return odKiedy;
    }

    public int getWymiarGodzin() {
        return wymiarGodzin;
    }

    public double getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setDoKiedy(Date doKiedy) {
        this.doKiedy = doKiedy;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setOdKiedy(Date odKiedy) {
        this.odKiedy = odKiedy;
    }

    public void setWymiarGodzin(int wymiarGodzin) {
        this.wymiarGodzin = wymiarGodzin;
    }

    public void setWynagrodzenie(double wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }
}
