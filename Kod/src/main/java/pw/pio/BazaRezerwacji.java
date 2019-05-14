package pw.pio;

import java.util.*;

public class BazaRezerwacji {

    private Map<Integer, Rezerwacja> rezerwacje = new HashMap<>();
    private BazaRezerwacji(){}
    private static BazaRezerwacji instance;

    public static BazaRezerwacji getInstance(){

        if(instance==null)
            instance = new BazaRezerwacji();

        return instance;

    }

    public int wygenerujUnikalnyNumerRezerwacji() {
        Optional<Integer> max = rezerwacje.keySet().stream().max(Integer::compareTo);
        if (!max.isPresent())
            return 0;

        if (max.get() == Integer.MAX_VALUE)
            throw new RuntimeException("Maksymalny indeks dla pracownika zostal osiagniety");

        return max.get()+1;
    }

    public void dodajRezerwacje(Rezerwacja r){
        int id = r.getIdRezerwacji();
        if(!rezerwacje.containsKey(id)) {
            rezerwacje.put(id, r);
        }
        else throw new RuntimeException("Baza zawiera juz taka rezerwacje.");

        }


    public void usunRezerwacje(int id){
        if(rezerwacje.containsKey(id)) {
            rezerwacje.remove(id);
        }
        else throw new RuntimeException("Nie ma takiej rezerwacji w bazie.");
    }
    public List<Rezerwacja> wyszukajRezerwacje(int numerKarnetu){
        List<Rezerwacja> rezerwacjeKlienta = new ArrayList<>();
        for (Rezerwacja r : rezerwacje.values()) {
            if (r.getNumerKartyKlienta() == numerKarnetu)
                rezerwacjeKlienta.add(r);
        }
        return rezerwacjeKlienta;
    }

    public Map<Integer, Rezerwacja> listaRezerwacji(){

        return rezerwacje;
    }




}




