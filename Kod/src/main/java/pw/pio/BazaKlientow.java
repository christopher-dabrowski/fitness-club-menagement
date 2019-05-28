package pw.pio;

import java.util.*;


public class BazaKlientow {
    private static BazaKlientow instance;

    public Map<Integer, Klient> getKlienci() {
        return klienci;
    }

    public void setKlienci(Map<Integer, Klient> klienci) {
        this.klienci = klienci;
    }

    private Map<Integer, Klient> klienci = new HashMap<>();

    private BazaKlientow() {}

    public static BazaKlientow getInstance() {
        if (instance == null)
            instance = new BazaKlientow();

        return instance;
    }

    public void dodajKlienta(Klient k){

        int id = k.getNumerKarnetu();

        if(!klienci.containsKey(id)) {
            klienci.put(id, k);
        }
        else throw new RuntimeException("Klient znajduje sie juz w bazie.");
    }

    public void usunKlienta(int numerKarnetu){
        if(klienci.containsKey(numerKarnetu)) {
            klienci.remove(numerKarnetu);
        }
        else throw new RuntimeException("W bazie nie ma klienta o podanym numerze karnetu.");
    }
    public Klient wyszukajKlienta(int numerKarnetu){
        return klienci.get(numerKarnetu);
    }

    public Map<Integer, Klient> listaKlientow(){

        return klienci;
    }

    public int wygenerujUnikalnyNumerKlienta() {
        Optional<Integer> max = klienci.keySet().stream().max(Integer::compareTo);
        if (!max.isPresent())
            return 0;

        if (max.get() == Integer.MAX_VALUE)
            throw new RuntimeException("Maksymalny indeks dla klienta zostal osiagniety");

        return max.get()+1;
    }



}
