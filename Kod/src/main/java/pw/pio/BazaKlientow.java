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
        String url = "jdbc:sqlite:C://sqlite/db/Test1.db";
        String sql = "CREATE TABLE IF NOT EXISTS bazaKlientow (\n"
                + "	numerKarnetu integer PRIMARY KEY,\n"
                + "	dataRozpoczeciaPakietu date NULL,\n"
                + "	pakietUslug text NOT NULL,\n"
                + "	imie text NOT NULL,\n"
                + "	nazwisko text NOT NULL\n"
                + ");";
        String insert= "INSERT INTO bazaKlientow(numerKarnetu,dataRozpoczeciaPakietu, pakietUslug,imie, nazwisko) VALUES(?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // tworzy nowa tabele jezeli nie ma jej w bazie
            stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(insert)){
            pstmt.setInt(1, klient.getNumerKarnetu());
            pstmt.setDate(2,new java.sql.Date(klient.getDataRozpoczeciaPakietu().getTime()));
            pstmt.setString(3, klient.getPakietUslug().getNazwa());
            pstmt.setString(4,klient.getImie() );
            pstmt.setString(5, klient.getNazwisko());
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }



    }
    

}
