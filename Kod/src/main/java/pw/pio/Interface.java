package pw.pio;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {

        System.out.println("Wybierz co chcesz zrobic: ");
        System.out.println("1: Dodaj klienta");
        System.out.println("2: Wypisz klientow ");
        System.out.println("q: Wyjdz ");

        Scanner wybor = new Scanner(System.in);

        if(wybor == '1'){
            System.out.println("podaj imie klienta: ");
            Scanner imie = new Scanner(System.in);
            System.out.println("podaj naazwisko klienta: ");
            Scanner nazwisko = new Scanner(System.in);
            System.out.println("Ustawic dzisiejszzaa date jako date rozpoczecia pakietu? [t/n]");
            Scanner odp = new Scanner(System.in);
            if(odp == "t"){
                Calendar data = Calendar.getInstance();   SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            }else{
                System.out.println("Podaj date rozpoczecia pakietu: ");
                Scanner data = new Scanner(System.in);
            }

            Klient nowy = new Klient(imie, nazwisko, data,  );
        }else if(wybor == '2'){


        }else if(wybor == 'q')
    }
}
