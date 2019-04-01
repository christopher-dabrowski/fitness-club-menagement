package pw.pio;


import java.util.HashSet;
import java.util.Set;

public class Pracownik extends Osoba {
    private int id;

    public Pracownik(String imie, String nazwisko, int id) {
        super(imie, nazwisko);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
