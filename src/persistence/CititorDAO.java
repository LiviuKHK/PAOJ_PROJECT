package persistence;

import domain.Cititor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CititorDAO {

    public void adaugaCititor(Cititor cititor) throws SQLException {
        String sql = "INSERT INTO Cititor (nume, adresa_id) VALUES (?, ?)";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cititor.getNume());
        stmt.setInt(2, cititor.getAdresaId());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<Cititor> getTotiCititorii() throws SQLException {
        List<Cititor> cititori = new ArrayList<>();
        String sql = "SELECT * FROM Cititor";
        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            cititori.add(new Cititor(
                    rs.getInt("id"),
                    rs.getString("nume"),
                    rs.getInt("adresa_id")
            ));
        }
        rs.close();
        stmt.close();
        return cititori;
    }

    public void updateCititor(Cititor cititor) throws SQLException {
        String sql = "UPDATE Cititor SET nume = ?, adresa_id = ? WHERE id = ?";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cititor.getNume());
        stmt.setInt(2, cititor.getAdresaId());
        stmt.setInt(3, cititor.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public void deleteCititor(int id) throws SQLException {
        String sql = "DELETE FROM Cititor WHERE id = ?";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
    }
}
