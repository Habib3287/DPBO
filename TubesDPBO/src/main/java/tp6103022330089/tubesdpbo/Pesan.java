/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6103022330089.tubesdpbo;

/**
 *
 * @author LEGION
 */

import java.util.Date;


public class Pesan {
    private String idChat;
    private String pengirim;
    private String penerima;
    private String pesan;
    private Date jam;

    public Pesan(String idChat, String pengirim, String penerima, String pesan, Date jam) {
        this.idChat = idChat;
        this.pengirim = pengirim;
        this.penerima = penerima;
        this.pesan = pesan;
        this.jam = jam;
    }

    public String getIdChat() {return idChat;}
    public String getPengirim() {return pengirim;}
    public String getPenerima() {return penerima;}
    public String getPesan() {return pesan;}
    public Date getJam() {return jam;}
    

    public void setIdChat(String idChat) {
        this.idChat = idChat;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public void setPenerima(String penerima) {
        this.penerima = penerima;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public void setJam(Date jam) {
        this.jam = jam;
    }
    
    @Override
    public String toString() {
        return "Room ID: " + idChat + ", Pengirim: " + pengirim + ", Penerima: " 
                + penerima + "\n" + pesan + "\n "+jam;
    }
}
