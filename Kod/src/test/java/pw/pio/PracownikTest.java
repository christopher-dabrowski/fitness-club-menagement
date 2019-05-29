package pw.pio;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class PracownikTest {

    @Test

    public void dodajEtat(){

        Pracownik p = new Pracownik("Pan", "Paweł");
        Etat e1 = new Etat("Recepcjonista", 30, 3000, new Date(), new Date());
        Etat e2 = new Etat("Trener", 10, 2000, new Date(), new Date());

        p.dodajEtat(e1);
        p.dodajEtat(e2);

        assertTrue(p.listaEtatow().contains(e1));
        assertTrue(p.listaEtatow().contains(e2));
    }


    @Test

    public void usunEtat(){

        Pracownik p = new Pracownik("Pan", "Paweł");
        Etat e1 = new Etat("Recepcjonista", 30, 3000, new Date(), new Date());


        p.dodajEtat(e1);
        assertTrue(p.listaEtatow().contains(e1));
        p.usunEtat(e1);

        assertFalse(p.listaEtatow().contains(e1));
    }

    
    @Test
    public void policzWynagrodzeniePowinnoBycRowneSumieWynagrodzenZEtatow() {
        //Given
        Pracownik p = new Pracownik("Adam", "Twaróg");
        double[] wynagrodzenia = {2000, 4500, 321.53};

        //When
        for (int i = 0; i < wynagrodzenia.length; i++) {
            double w = wynagrodzenia[i];
            Etat e = new Etat("Etat" + i, 20, w, new Date(), new Date());
            e.setWynagrodzenie(w);

            p.dodajEtat(e);
        }

        //Then expected
        double suma = DoubleStream.of(wynagrodzenia).sum();

        assertEquals(suma, p.policzWynagrodzenie(), 0.0001);
    }
}
