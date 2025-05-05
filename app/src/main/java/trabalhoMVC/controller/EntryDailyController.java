/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoMVC.controller;

import java.util.ArrayList;
import trabalhoMVC.dao.EntryDailyDAO;
import trabalhoMVC.model.EntryDaily;

/**
 *
 * @author MARIAEDUARDACOSTABAT
 */
public class EntryDailyController {
    private static EntryDailyDAO dao = new EntryDailyDAO();

    public static boolean createEntry(String title,String texto, int userId) {
        EntryDaily entry = new EntryDaily(title, texto, userId);
        return dao.create(entry);
    }

    public static boolean updateTextEntry(EntryDaily entry) {
       
        return dao.update(entry);
    }

    public static boolean removeEntry(int id) {
        return dao.delete(id);
    }
    
    public static ArrayList<EntryDaily> listEntryUser(int userId) {
        return dao.getByUserId(userId);
    }
    
    public static boolean removeEntryByTitle(String title) {
        return dao.deleteByTitle(title);
    }
}
