package pw.pio;

import java.util.HashSet;
import java.util.Set;

public class BazaKlientow {
    private static BazaKlientow instance;

    private Set<Klient> klienci = new HashSet<>();

    private BazaKlientow() {}

    public static BazaKlientow getInstance() {
        if (instance == null)
            instance = new BazaKlientow();

        return instance;
    }

    public void dodajKlienta(Klient klient) {
        klienci.add(klient);
    }

    public Set<Klient> getKlienci() {
        return klienci;
    }

    public void usun(Klient klient) {
        klienci.remove(klient);
    }

}
