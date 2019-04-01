package pw.pio;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class PracownikTest {

    @Test
    public void policzWynagrodzenie() {
        //Given
        Pracownik p = new Pracownik("Adam", "Twaróg", 1);
        double[] wynagrodzenia = {2000, 4500, 321.53};

        //When
        for (double w : wynagrodzenia) {
            Etat e = new Etat();
            e.setWynagrodzenie(w);

            p.dodajEtat(e);
        }

        //Then expected
        double suma = DoubleStream.of(wynagrodzenia).sum();

        assertEquals(suma, p.policzWynagrodzenie(), 0);
    }
}