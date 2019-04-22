package pw.pio;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class BazaKlientow {
    private static BazaKlientow instance;

    private Set<Klient> klienci = new HashSet<>();

    private BazaKlientow() {}

    public static BazaKlientow getInstance() {
        if (instance == null)
            instance = new BazaKlientow();

        return instance;
    }

    public int wygenerujUnikalnyNumerKlienta() {
        Optional<Integer> max = klienci.stream().map(k -> k.getNumerKarnetu()).max(Integer::compareTo);

        if (!max.isPresent())
            return 0;

        if (max.get() == Integer.MAX_VALUE)
            throw new RuntimeException("Maksymalny indeks dla klienta zostal osiagniety");

        return max.get()+1;
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
