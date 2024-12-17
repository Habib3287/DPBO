/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6103022330089.tubesdpbo;

import java.util.ArrayList;

/**
 *
 * @author LEGION
 */
public class DaftarPelatihan {
    private String idDPelatihan;
    private ArrayList<Pelatihan> pelatihanTersedia;

    public DaftarPelatihan(String idDPelatihan) {
        this.idDPelatihan = idDPelatihan;
        this.pelatihanTersedia = new ArrayList<>();
    }
    
    public void showPelatihan(){
        if (pelatihanTersedia.isEmpty()){
            System.out.println("Belum ada pelatihan yang tersedia");
            return;
        }
        
        System.out.println("Daftar Pelatihan: ");
        for (Pelatihan pelatihan : pelatihanTersedia) {
            System.out.println("- " + pelatihan.getjudulPelatihan());
        }
    }
}
