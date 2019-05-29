package pw.pio;


import java.util.ArrayList;
import java.util.List;

public class Pracownik extends Osoba {
    private int id;
    private List<Etat> etaty = new ArrayList<>();

    public Pracownik(String imie, String nazwisko) {
        super(imie, nazwisko);
        this.id = BazaPracownikow.getInstance().wygenerujUnikalnyNumerPracownika();
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

    public void usunEtat(Etat etat) {
        etaty.remove(etat);
    }

    public int getId() {
        return id;
    }

    public List<Etat> listaEtatow() {
        return etaty;
    }

    public void setEtaty(List<Etat> etaty) {
        this.etaty = etaty;
    }
}
