package pw.pio;

import lombok.val;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class BazaRezerwacjiTest {

    @Test
    public void poDodaniuNowejRezerwacjiUnikalnyNumerPowinienSieZmienic() {
        //Given
        final int staryNumer = BazaRezerwacji.getInstance().wygenerujUnikalnyNumerRezerwacji();

        //When
        Rezerwacja rezerwacja = new Rezerwacja(new Date(), 0, 0);
        BazaRezerwacji.getInstance().dodajRezerwacje(rezerwacja);

        //Then
        final int nowyNumer = BazaRezerwacji.getInstance().wygenerujUnikalnyNumerRezerwacji();

        assertNotEquals(staryNumer, nowyNumer);

        //Cleanup
        BazaRezerwacji.getInstance().listaRezerwacji().remove(rezerwacja.getIdRezerwacji());
    }

    @Test
    public void getInstanceReturnsInstance() {
        assertNotNull(BazaRezerwacji.getInstance());
    }

    @Test
    public void getInstanceReturnsSameObject() {
        //Given
        val baza = BazaRezerwacji.getInstance();

        //When
        val druga = BazaRezerwacji.getInstance();

        //Then
        assertEquals(druga, baza);
    }

    @Test
    public void poDodaniuRezerwacjiPowinnaBycWBazie() {
        //Given
        val rezerwacja = new Rezerwacja(new Date(), 0, 0);
        val idRezerwacji = rezerwacja.getIdRezerwacji();
        val bazaRezerwacji = BazaRezerwacji.getInstance();

        //When
        bazaRezerwacji.dodajRezerwacje(rezerwacja);

        //Then
        assertTrue(bazaRezerwacji.listaRezerwacji().containsValue(rezerwacja));

        //Cleanup
        bazaRezerwacji.listaRezerwacji().remove(idRezerwacji, rezerwacja);
    }

    @Test
    public void usunRezerwacje() {
    }
}