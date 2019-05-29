package pw.pio;

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
}