package persistence;

import domain.Imprumut;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ImprumutDAO {

    public void adaugaImprumut(Imprumut imprumut) throws SQLException {
        String sql = "INSERT INTO Imprumut (carte_id, cititor_id, data_imprumut) VALUES (?, ?, ?)";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, imprumut.getCarteId());
        stmt.setInt(2, imprumut.getCititorId());
        stmt.setDate(3, Date.valueOf(imprumut.getDataImprumut()));
        stmt.executeUpdate();
        stmt.close();
        conn.commit();
        conn.close();
    }

    public List<Imprumut> getToateImprumuturile() throws SQLException {
        List<Imprumut> imprumuturi = new ArrayList<>();
        String sql = "SELECT * FROM Imprumut";
        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            imprumuturi.add(new Imprumut(
                    rs.getInt("id"),
                    rs.getInt("carte_id"),
                    rs.getInt("cititor_id"),
                    rs.getDate("data_imprumut").toLocalDate()
            ));
        }

        rs.close();
        stmt.close();
        conn.close();
        return imprumuturi;
    }
}
