package pw.pio;


import java.util.HashSet;
import java.util.Set;

public class Pracownik extends Osoba {
    private int id;
    private Set<Etat> etaty = new HashSet<>();

    public Pracownik(String imie, String nazwisko, int id) {
        super(imie, nazwisko);
        this.id = id;
    }

    public double policzWynagrodzenie()
    {
        double wynagrodzenie = 0;
        for (Etat etat : etaty) {
            wynagrodzenie += etat.getWynagrodzenie();
        }

        return wynagrodzenie;
    }

    /**
     * <strong>Metoda, której nie ma w diagramie</strong>
     * @param etat etat do dodanai pracownikowi
     */
    public void dodajEtat(Etat etat) {
        etaty.add(etat);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Etat> getEtaty() {
        return etaty;
    }

    public void setEtaty(Set<Etat> etaty) {
        this.etaty = etaty;
    }
}
