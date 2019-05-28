package pw.pio;
import org.junit.Test;

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
}
