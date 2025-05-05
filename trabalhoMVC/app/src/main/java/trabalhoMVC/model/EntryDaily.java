/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoMVC.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MARIAEDUARDACOSTABAT
 */
public class EntryDaily {
   
    private int id;
    private String title;
    private String text;
    private String date;
    private int userId;

    public EntryDaily() {}

    public EntryDaily(String title, String text, int userId){
        String dataFormatada = createDate();
        this.text = text;
        this.userId = userId;    
        this.title = createTitle(dataFormatada, title);
        this.date = dataFormatada;
    }
    public EntryDaily(String title, String text, String date, int userId) {
        this.title = title;
        this.text = text;
        this.date = date;
        this.userId = userId;
    }

    private String createTitle(String data, String title) {
        return "Dia " + data + " " + title;
    }
    private String createDate() {
        Date data = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data);
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}


