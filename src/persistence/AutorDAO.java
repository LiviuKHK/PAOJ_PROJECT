package persistence;

import domain.Autor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {

    public void adaugaAutor(Autor autor) throws SQLException {
        String sql = "INSERT INTO Autor (nume) VALUES (?)";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, autor.getNume());
        stmt.executeUpdate();
        stmt.close();
    }

    public List<Autor> getTotiAutorii() throws SQLException {
        List<Autor> autori = new ArrayList<>();
        String sql = "SELECT * FROM Autor";
        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            autori.add(new Autor(
                    rs.getInt("id"),
                    rs.getString("nume")
            ));
        }

        rs.close();
        stmt.close();
        return autori;
    }

    public boolean existaAutorCuNume(String nume) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Autor WHERE LOWER(nume) = LOWER(?)";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nume);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        boolean exista = rs.getInt(1) > 0;
        rs.close();
        stmt.close();
        return exista;
    }

    public Autor gasesteAutorDupaNume(String nume) throws SQLException {
        String sql = "SELECT * FROM Autor WHERE LOWER(nume) = LOWER(?)";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nume);
        ResultSet rs = stmt.executeQuery();

        Autor autor = null;
        if (rs.next()) {
            autor = new Autor(rs.getInt("id"), rs.getString("nume"));
        }

        rs.close();
        stmt.close();
        return autor;
    }

    public void actualizeazaAutor(Autor autor) throws SQLException {
        String sql = "UPDATE Autor SET nume = ? WHERE id = ?";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, autor.getNume());
        stmt.setInt(2, autor.getId());
        stmt.executeUpdate();
        stmt.close();
        conn.commit();
        conn.close();
    }

    public void stergeAutor(int id) throws SQLException {
        String sql = "DELETE FROM Autor WHERE id = ?";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        conn.commit();
        conn.close();
    }
}
