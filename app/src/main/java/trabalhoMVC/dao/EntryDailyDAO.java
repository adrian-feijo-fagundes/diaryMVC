/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoMVC.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import trabalhoMVC.database.Conect;
import trabalhoMVC.model.EntryDaily;

/**
 *
 * @author MARIAEDUARDACOSTABAT
 */
public class EntryDailyDAO {

    public ArrayList<EntryDaily> listEntry(String user) {
        ArrayList<EntryDaily> list = new ArrayList<>();
        String sql = "SELECT id, texto, data FROM entradas_diario WHERE usuario = ? ORDER BY data DESC";

        try (Connection conn = Conect.getConect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EntryDaily entry = new EntryDaily();
                entry.setId(rs.getInt("id"));
                entry.setText(rs.getString("texto"));
                entry.setDate(rs.getString("data"));
                entry.setUser(user);
                list.add(entry);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void deleteEntry(int id) {
        String sql = "DELETE FROM entradas_diario WHERE id = ?";

        try (Connection conn = Conect.getConect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void upDateEntry(int id, String novoTexto) {
        String sql = "UPDATE entradas_diario SET texto = ? WHERE id = ?";

        try (Connection conn = Conect.getConect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoTexto);
            stmt.setInt(2, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean saveEntry(EntryDaily entry) {
        String sql = "INSERT INTO entradas_diario (usuario, texto, data) VALUES (?, ?, ?)";

        try (Connection conn = Conect.getConect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entry.getUser());
            stmt.setString(2, entry.getText());
            //stmt.setTimestamp(3, new Timestamp(entry.getDate().getTime()));

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
