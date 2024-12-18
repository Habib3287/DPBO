 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6103022330089.tubesdpbo;

/**
 *
 * @author LEGION
 */
        
public class Lowongan {
    private String idLowongan;
    private String judul;
    private String deskripsi;

    public Lowongan(String idLowongan, String judul, String deskripsi) {
        this.idLowongan = idLowongan;
        this.judul = judul;
        this.deskripsi = deskripsi;
    }

    public String getIdLowongan() {return idLowongan;}

    public String getJudul() {return judul;}

    public String getDeskripsi() {return deskripsi;}

    public void setIdLowongan(String idLowongan) {
        this.idLowongan = idLowongan;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
