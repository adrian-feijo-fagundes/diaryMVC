/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoMVC.controller;

import java.util.Date;
import java.util.List;
import trabalhoMVC.dao.EntryDailyDAO;
import trabalhoMVC.model.EntryDaily;

/**
 *
 * @author MARIAEDUARDACOSTABAT
 */
public class EntryDailyController {
    private static EntryDailyDAO dao = new EntryDailyDAO();

    public static boolean addEntry(String usuario, String texto) {
        EntryDaily entry = new EntryDaily();
        entry.setUser(usuario);
        entry.setText(texto);
        //entry.setDate(new Date()); // data atual
        return dao.saveEntry(entry);
    }

    public static boolean upDateTextEntry(int id, String novoTexto) {
        dao.upDateEntry(id, novoTexto);
        return true;
    }

    public static boolean removeEntry(int id) {
        dao.deleteEntry(id);
        return true;
    }

    //public static List<EntryDaily> listEntryUser(String usuario) {
    //    return dao.listEntryDaily(usuario);
    //}
}
