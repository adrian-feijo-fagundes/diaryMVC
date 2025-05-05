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
import java.util.ArrayList;
import trabalhoMVC.database.Conect;
import trabalhoMVC.model.EntryDaily;

/**
 *
 * @author MARIAEDUARDACOSTABAT
 */
public class EntryDailyDAO {
    public boolean create(EntryDaily entry) {
        String sql = "INSERT INTO entradas_diario (titulo, texto, data, user_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conect.getConect();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, entry.getTitle());
            stmt.setString(2, entry.getText());
            stmt.setString(3, entry.getDate());
            stmt.setInt(4, entry.getUserId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(EntryDaily entry) {
        String sql = "UPDATE entradas_diario SET titulo = ?, texto = ?, data = ? WHERE id = ?";

        try (Connection conn = Conect.getConect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, entry.getTitle());
            stmt.setString(2, entry.getText());
            stmt.setString(3, entry.getDate());
            stmt.setInt(4, entry.getId());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public boolean delete(int id) {
        String sql = "DELETE FROM entradas_diario WHERE id = ?";

        try (Connection conn = Conect.getConect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public ArrayList<EntryDaily> getByUserId(int userId) {
        ArrayList<EntryDaily> entries = new ArrayList<>();
        String sql = "SELECT * FROM entradas_diario WHERE user_id = ?";

        try (Connection conn = Conect.getConect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EntryDaily entry = new EntryDaily();
                entry.setId(rs.getInt("id"));
                entry.setTitle(rs.getString("titulo"));
                entry.setText(rs.getString("texto"));
                entry.setDate(rs.getString("data"));
                entry.setUserId(rs.getInt("user_id"));
                entries.add(entry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entries;
    }
    
    public boolean deleteByTitle(String title) {
        String sql = "DELETE FROM entradas_diario WHERE titulo = ?";

        try (Connection conn = Conect.getConect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, title);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
