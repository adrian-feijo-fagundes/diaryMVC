/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoMVC.model;

/**
 *
 * @author MARIAEDUARDACOSTABAT
 */
public class EntryDaily {
    private int id;
    private String user;
    private String text;
    private String date;

    
    
    public EntryDaily(int id, String user, String text, String date) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.date = date;
    }

    public EntryDaily() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

  
}
