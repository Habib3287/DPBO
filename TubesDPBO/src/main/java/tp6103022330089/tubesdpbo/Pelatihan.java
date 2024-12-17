/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6103022330089.tubesdpbo;


/**
 *
 * @author LEGION
 */
public class Pelatihan {
    private String judulPelatihan;
    private String pemateri;
    private String deskripsiPelatihan;

    public Pelatihan(String judulPelatihan, String pemateri, String deskripsiPelatihan) {
        this.judulPelatihan = judulPelatihan;
        this.pemateri = pemateri;
        this.deskripsiPelatihan = deskripsiPelatihan;
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

    public void setJudulPelatihan(String judulPelatihan) {
        this.judulPelatihan = judulPelatihan;
    }

    public void setPemateri(String pemateri) {
        this.pemateri = pemateri;
    }

    public void setDeskripsiPelatihan(String deskripsiPelatihan) {
        this.deskripsiPelatihan = deskripsiPelatihan;
    }    
}
