package persistence;

import domain.Carte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarteDAO {

    public void adaugaCarte(Carte carte) throws SQLException {
        String sql = "INSERT INTO Carte (titlu, an_publicatie, autor_id) VALUES (?, ?, ?)";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, carte.getTitlu());
        stmt.setInt(2, carte.getAnPublicatie());
        stmt.setInt(3, carte.getAutorId());
        stmt.executeUpdate();
        stmt.close();
        conn.commit();
        conn.close();
    }

    public List<Carte> getToateCartile() throws SQLException {
        List<Carte> carti = new ArrayList<>();
        String sql = "SELECT * FROM Carte";
        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            carti.add(new Carte(
                    rs.getInt("id"),
                    rs.getString("titlu"),
                    rs.getInt("an_publicatie"),
                    rs.getInt("autor_id")
            ));
        }

        rs.close();
        stmt.close();
        conn.close();
        return carti;
    }

    public void updateCarte(Carte carte) throws SQLException {
        String sql = "UPDATE Carte SET titlu = ?, an_publicatie = ?, autor_id = ?, disponibila = ? WHERE id = ?";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, carte.getTitlu());
        stmt.setInt(2, carte.getAnPublicatie());
        stmt.setInt(3, carte.getAutorId());
        stmt.setBoolean(4, carte.isDisponibila());
        stmt.setInt(5, carte.getId());
        stmt.executeUpdate();
        stmt.close();
        conn.commit();
        conn.close();
    }

    public boolean deleteCarte(int id) throws SQLException {
        String sql = "DELETE FROM Carte WHERE id = ?";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        int rowsAffected = stmt.executeUpdate();
        stmt.close();
        conn.commit();
        conn.close();
        return rowsAffected > 0;
    }

}
