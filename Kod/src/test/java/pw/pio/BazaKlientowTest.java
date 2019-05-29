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
        bazaKlientow.listaKlientow().remove(klient.getNumerKarnetu());
    }

    @Test
    public void poUsunieciuKlientaKlientaNiePowinnoBycWBazie() {
        //Given
        BazaKlientow bazaKlientow = BazaKlientow.getInstance();
        Klient klient = new Klient("Mariusz", "Wysocki", new Date(), null);
        bazaKlientow.dodajKlienta(klient);

        //When
        if(bazaKlientow.listaKlientow().containsValue(klient)) {
            bazaKlientow.usunKlienta(klient.getNumerKarnetu());
            //Then
            assertFalse(bazaKlientow.listaKlientow().containsValue(klient));
        }else
            fail("Wystąpił problem z dodaniem klienta do bazy");
    }
}