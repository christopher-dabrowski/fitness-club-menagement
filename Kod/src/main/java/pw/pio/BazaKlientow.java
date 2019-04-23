package pw.pio;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import java.sql.*;


public class BazaKlientow {
    private static BazaKlientow instance;

    private Set<Klient> klienci = new HashSet<>();

    private BazaKlientow() {}

    public static BazaKlientow getInstance() {
        if (instance == null)
            instance = new BazaKlientow();

        return instance;
    }

    public int wygenerujUnikalnyNumerKlienta() {
        Optional<Integer> max = klienci.stream().map(k -> k.getNumerKarnetu()).max(Integer::compareTo);

        if (!max.isPresent())
            return 0;

        if (max.get() == Integer.MAX_VALUE)
            throw new RuntimeException("Maksymalny indeks dla klienta zostal osiagniety");

        return max.get()+1;
    }

    public void dodajKlienta(Klient klient) {
        klienci.add(klient);
        dodajDoBazySQL(klient);
    }

    public Set<Klient> getKlienci() {
        return klienci;
    }

    public void usun(Klient klient) {
        klienci.remove(klient);
    }
     private void dodajDoBazySQL(Klient klient)
    {
        String url = "jdbc:sqlite:C://sqlite/db/FitnessClub.db";
        String sql = "CREATE TABLE IF NOT EXISTS bazaKlientow (\n"
                + "	numerKarnetu integer PRIMARY KEY,\n"
                + "	dataRozpoczeciaPakietu date NULL,\n"
                + "	pakietUslug text NOT NULL\n"
                + ");";
        String insert= "INSERT INTO bazaKlientow(numerKarnetu,pakietUslug) VALUES(?,?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             Statement stmt = conn.createStatement()) {
            // tworzy nowa tabele jezeli nie ma jej w bazie
            stmt.execute(sql);

                pstmt.setInt(1, klient.getNumerKarnetu());
                pstmt.setString(2, klient.getPakietUslug().getNazwa());
                pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }



    }
    private void polaczZBazaSQL(){
        String url = "jdbc:sqlite:C://sqlite/db/FitnessClub.db";
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
    }
    }

}
