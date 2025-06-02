package persistence;

import domain.Adresa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdresaDAO {

    public List<Adresa> getToateAdresele() throws SQLException {
        List<Adresa> lista = new ArrayList<>();
        String sql = "SELECT * FROM Adresa";
        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            lista.add(new Adresa(
                    rs.getInt("id"),
                    rs.getString("strada"),
                    rs.getString("oras")
            ));
        }

        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }
    public void adaugaAdresa(Adresa adresa) throws SQLException {
        String sql = "INSERT INTO Adresa (strada, oras) VALUES (?, ?)";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, adresa.getStrada());
        stmt.setString(2, adresa.getOras());
        stmt.executeUpdate();
        stmt.close();
        conn.commit();
        conn.close();
    }

}
