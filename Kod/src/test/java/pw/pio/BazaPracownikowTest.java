package pw.pio;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BazaPracownikowTest {

    @Test
    public void dodajPracownika() {
        Map<Integer, Pracownik> pracownicy = new HashMap<>();
        Pracownik p = new Pracownik("Jan", "Nowak");
        int id = p.getId();
            pracownicy.put(id, p);
            BazaPracownikow.getInstance().dodajPracownika(p);
        assertEquals(BazaPracownikow.getInstance().listaPracownikow(),pracownicy);


    }

    @Test
    public void wyszukajPracownika() {
        Pracownik p = new Pracownik("Jan", "Nowak");
        BazaPracownikow.getInstance().dodajPracownika(p);
        assertEquals(BazaPracownikow.getInstance().wyszukajPracownika(p.getId()),p);
    }

    @Test
    public void poDodaniuNowegoPracownikaUnikalnyNumerPowinienSieZmienic() {
        //Given
        final int staryNumer = BazaPracownikow.getInstance().wygenerujUnikalnyNumerPracownika();

        //When
        Pracownik p = new Pracownik("Jan", "Nowak");
        BazaPracownikow.getInstance().dodajPracownika(p);

        //Then
        final int nowyNumer = BazaPracownikow.getInstance().wygenerujUnikalnyNumerPracownika();

        assertNotEquals(staryNumer, nowyNumer);

        //Cleanup
        BazaPracownikow.getInstance().listaPracownikow().remove(p.getId());
    }
}
