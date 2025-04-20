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
public class Pelatihan {

    private String judul;
    private String pemateri;
    private String deskripsi;
    private static ArrayList<Pelatihan> daftarPelatihan = new ArrayList<>();

    public Pelatihan(String judul, String pemateri, String deskripsi) {
        this.judul = judul;
        this.pemateri = pemateri;
        this.deskripsi = deskripsi;
    }

    public String getJudul() {
        return judul;
    }

    public String getPemateri() {
        return pemateri;
    }

    public String getDeskripsi() {
        return deskripsi;
    }


    public  ArrayList<Pelamar> daftarPelamar() {
        return new ArrayList<>();
    }



    public void daftarPelamar(Pelamar pelamar) {
        ArrayList<Pelamar> daftarPelamar = new ArrayList<>();
        daftarPelamar.add(pelamar);
    }

    public static void displayPelatihan() {
        if (daftarPelatihan.isEmpty()) {
            System.out.println("Tidak ada pelatihan yang tersedia.");
        } else {
            System.out.println("---- Daftar Pelatihan ----");
            for (Pelatihan pelatihan : daftarPelatihan) {
                System.out.println("Judul: " + pelatihan.getJudul() +
                                   " | Pemateri: " + pelatihan.getPemateri() +
                                   " | Deskripsi: " + pelatihan.getDeskripsi());
            }
        }
    }
}

