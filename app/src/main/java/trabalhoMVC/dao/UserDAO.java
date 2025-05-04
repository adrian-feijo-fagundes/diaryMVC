/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoMVC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
import trabalhoMVC.database.Conect;
import trabalhoMVC.model.User;

/**
 *
 * @author MARIAEDUARDACOSTABAT
 */
public class UserDAO {
    public boolean registerUser(User user) {
        String sql = "INSERT INTO usuarios (usuario, senha) VALUES (?, ?)";
        String senhaHash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        try (Connection conn = Conect.getConect(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, senhaHash);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace (); //Mostra o erro no console
            return false;
        }
    }
    public boolean updatePassword(String email, String novaSenha) {
        String sql = "UPDATE usuarios SET senha = ? WHERE usuario = ?";
        String senhaHash = BCrypt.hashpw(novaSenha, BCrypt.gensalt());

        try (Connection conn = Conect.getConect(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, senhaHash);
            stmt.setString(2, email);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean validateLogin(User user) {
        String sql = "SELECT senha FROM usuarios WHERE usuario = ?";

        try (Connection conn = Conect.getConect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String senhaHash = rs.getString("senha");
                return BCrypt.checkpw(user.getPassword(), senhaHash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}