/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6103022330089.tubesdpbo;

import java.util.Date;

/**
 *
 * @author LEGION
 */
public class Pelatihan {
    private String judulPelatihan;
    private String pemateri;
    private String deskripsiPelatihan;
    private Date tanggalPelatihan;

    public Pelatihan(String judulPelatihan, String pemateri, String deskripsiPelatihan, Date tanggalPelatihan) {
        this.judulPelatihan = judulPelatihan;
        this.pemateri = pemateri;
        this.deskripsiPelatihan = deskripsiPelatihan;
        this.tanggalPelatihan = tanggalPelatihan;
    }



    public String getjudulPelatihan() {
        return judulPelatihan;
    }

    public String getPemateri() {
        return pemateri;
    }

    public String getDeskripsiPelatihan() {
        return deskripsiPelatihan;
    }

    public Date getTanggalPelatihan() {
        return tanggalPelatihan;
    }

    public void setJudulPelatihan(String judulPelatihan) {
        this.judulPelatihan = judulPelatihan;
    }

    public void setPemateri(String pemateri) {
        this.pemateri = pemateri;
    }

    public void setDeskripsiPelatihan(String deskripsiPelatihan) {
        this.deskripsiPelatihan = deskripsiPelatihan;
    }

    public void setTanggalPelatihan(Date tanggalPelatihan) {
        this.tanggalPelatihan = tanggalPelatihan;
    }
    
    
    
}
