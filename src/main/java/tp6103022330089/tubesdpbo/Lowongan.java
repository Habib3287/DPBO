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
        
public class Lowongan {

    private String id;
    private String posisi;
    private String perusahaan;
    private ArrayList<Pelamar> pelamarList;
    private static ArrayList<Lowongan> daftarLowongan = new ArrayList<>();

    // Constructor
    public Lowongan(String id, String posisi, String perusahaan) {
        this.id = id;
        this.posisi = posisi;
        this.perusahaan = perusahaan;
        this.pelamarList = new ArrayList<>();
    }

    // Getters dan Setters
    public String getId() { return id; }
    public String getPosisi() { return posisi; }
    public String getPerusahaan() { return perusahaan; }
    public ArrayList<Pelamar> getPelamarList() { return pelamarList; }

    // Melamar lowongan
    public void melamar(Pelamar pelamar) {
        pelamarList.add(pelamar);
    }

    public void showLowongan() {
        if (daftarLowongan.isEmpty()) {
            System.out.println("Tidak ada lowongan tersedia.");
        } else {
            System.out.println("Daftar Lowongan Kerja:");
            for (Lowongan lowongan : daftarLowongan) {
                System.out.println("ID: " + lowongan.getId() + ", Posisi: " + lowongan.getPosisi() +
                        ", Perusahaan: " + lowongan.getPerusahaan());
            }
        }
    }


    // Daftar lowongan yang tersedia
    public static ArrayList<Lowongan> getDaftarLowongan() {
        return daftarLowongan;
    }
}