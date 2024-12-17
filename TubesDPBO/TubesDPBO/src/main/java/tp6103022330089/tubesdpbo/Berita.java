/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6103022330089.tubesdpbo;

/**
 *
 * @author LEGION
 */
public class Berita {
    private String idBerita;
    private String judul;
    private String content;

    // Constructor
    public Berita(String idBerita, String judul, String content) {
        this.idBerita = idBerita;
        this.judul = judul;
        this.content = content;
    }

    // Getter and Setter
    public String getIdBerita() {return idBerita;}

    public void setIdBerita(String idBerita) {
        this.idBerita = idBerita;
    }

    public String getJudul() {return judul;}

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getContent() {return content;}

    public void setContent(String content) {
        this.content = content;
    }
}
