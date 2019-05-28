package pw.pio;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class BazaKlientowTest {

    @Test
    public void poDodaniuKlientaKlientPowinienBycWBazie() {
        //Given
        BazaKlientow bazaKlientow = BazaKlientow.getInstance();

        //When
        Klient klient = new Klient("Mariusz", "Wysocki", new Date(), null);
        bazaKlientow.dodajKlienta(klient);

        //Then
        assertTrue(bazaKlientow.listaKlientow().containsValue(klient));

        //Cleanup
        bazaKlientow.listaKlientow().remove(klient);
    }
}