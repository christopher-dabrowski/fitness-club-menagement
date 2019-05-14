package pw.pio;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class BazaPracownikow {

    private static BazaPracownikow instance;
    private Map<Integer, Pracownik> pracownicy = new HashMap<>();

    private BazaPracownikow(){}
    public static BazaPracownikow getInstance() {
        if(instance==null)
            instance = new BazaPracownikow();

        return instance;
    }

    public void dodajPracownika(Pracownik p){

        int id = p.getId();

        if(!pracownicy.containsKey(id)) {
            pracownicy.put(id, p);
        }
        else throw new RuntimeException("Pracownik znajduje sie juz w bazie.");
    }

    public void usunPracownika(int id){
        if(pracownicy.containsKey(id)) {
            pracownicy.remove(id);
        }
        else throw new RuntimeException("W bazie nie ma pracownika o podanym id.");
    }
    public Pracownik wyszukajPracownika(int id){
        return pracownicy.get(id);
    }

    public Map<Integer, Pracownik> listaPracownikow(){

        return pracownicy;
    }

    public int wygenerujUnikalnyNumerPracownika() {
        Optional<Integer> max = pracownicy.keySet().stream().max(Integer::compareTo);
        if (!max.isPresent())
            return 0;

        if (max.get() == Integer.MAX_VALUE)
            throw new RuntimeException("Maksymalny indeks dla pracownika zostal osiagniety");

        return max.get()+1;
    }

}
