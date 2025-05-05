/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoMVC.controller;

import trabalhoMVC.dao.UserDAO;
import trabalhoMVC.model.User;

/**
 *
 * @author MARIAEDUARDACOSTABAT
 */
public class UserController {
    private static UserDAO userDAO = new UserDAO();
    
    public static boolean registerUser(String name, String password){
        User user = new User(name, password);//criamos um objeto Usuario com as informações
        //que pegamos nos parâmetros(que por sua vez pegamos dos campos na view)
        //inserimos o usuario no banco, pois o metodo de DAO faz isso
        return userDAO.registerUser(user);
    }
     public static boolean updatePassword(String email, char[] charSenha){
       String novaSenha = new String (charSenha);
       if(email.isEmpty() || novaSenha.isEmpty()){
           return false;
       }
       return userDAO.updatePassword(email, novaSenha);
   }
      public static User validateLogin(String username, char[] charSenha){
       String senha = new String(charSenha).trim();
       User usuario = new User(username, senha);
       Integer id = userDAO.validateLogin(usuario);
        
       if (id != null) usuario.setId(id);
       
       return usuario;
   }
}
