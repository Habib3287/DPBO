/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6103022330089.tubesdpbo;

/**
 *
 * @author LEGION
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PembukaLowongan extends User {
private ArrayList<Pelamar> daftarPelamar;
private ArrayList<Lowongan> lowonganYangDibuat;
private  HashMap<Lowongan, ArrayList<Pelamar>> daftarPelamarLowongan = new HashMap<>();

    public PembukaLowongan(String nama, String email, String password, String alamat, String role, String noTelepon) {
        super(nama, email, password, alamat, role, noTelepon);
        this.lowonganYangDibuat = new ArrayList<>();
    }

    @Override
    public void register(String nama, String email, String password, String alamat, String noTelepon) {
        while (!ScannerUtil.isValidEmail(email)) {
            System.out.println("Email tidak valid. Silakan masukkan email yang benar:");
            email = scan.nextLine();
        }
        PembukaLowongan penyediaBaru = new PembukaLowongan(nama, email, password, alamat, "Penyedia", noTelepon);
        User.database.add(penyediaBaru);
    }

    // Penyedia dapat membuat lowongan pekerjaan
    public void membuatLowongan() {
        System.out.print("Masukkan ID Lowongan: ");
        String idLowongan = ScannerUtil.scanString(scan);
        System.out.print("Masukkan Judul Lowongan: ");
        String judul = ScannerUtil.scanString(scan);
        System.out.print("Masukkan Deskripsi Lowongan: ");
        String deskripsi = ScannerUtil.scanString(scan);
        Lowongan lowongan = new Lowongan(idLowongan, judul, deskripsi);
        lowonganYangDibuat.add(lowongan);
        daftarPelamarLowongan.put(lowongan, new ArrayList<>());
        System.out.println("Lowongan pekerjaan dengan ID " + idLowongan + " telah dibuat.");
    }

    public void melihatDaftarPelamar(HashMap<Lowongan, ArrayList<Pelamar>> daftarPelamarLowongan) {
        System.out.println("Daftar Lowongan yang Tersedia:");
        
        if (daftarPelamarLowongan.isEmpty()) {
            System.out.println("Belum ada lowongan yang tersedia.");
            return;
        }

        // Menampilkan semua lowongan
        int index = 1;
        for (Lowongan lowongan : daftarPelamarLowongan.keySet()) {
            System.out.println(index + ". " + lowongan.getPosisi() + " di " + lowongan.getPerusahaan());
            index++;
        }

        System.out.print("Pilih nomor lowongan untuk melihat daftar pelamar: ");
        int pilihan = ScannerUtil.scanInt(new Scanner(System.in));

        // Validasi input
        if (pilihan < 1 || pilihan > daftarPelamarLowongan.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        // Mendapatkan lowongan yang dipilih
        Lowongan lowonganDipilih = (Lowongan) daftarPelamarLowongan.keySet().toArray()[pilihan - 1];
        ArrayList<Pelamar> pelamarLowongan = daftarPelamarLowongan.get(lowonganDipilih);

        // Menampilkan daftar pelamar untuk lowongan tersebut
        System.out.println("Daftar Pelamar untuk Lowongan: " + lowonganDipilih.getPosisi() + " di " + lowonganDipilih.getPerusahaan());
        if (pelamarLowongan.isEmpty()) {
            System.out.println("Tidak ada pelamar untuk lowongan ini.");
        } else {
            for (Pelamar pelamar : pelamarLowongan) {
                System.out.println("- " + pelamar.getNama());
            }
        }
    }

    // Penyedia dapat menolak pelamars
    public void menolakPelamar(Pelamar pelamar) {   
        if (pelamar != null) {
            for (Pelamar p : daftarPelamar) {
                if (p.getEmail().equals(pelamar.getEmail())) {
                    daftarPelamar.remove(p);
                    System.out.println("Pelamar " + pelamar.getNama() + " ditolak.");
                    break;
                }
            }
        } else {
            System.out.println("Pelamar tidak ditemukan.");
        }
    }

    // Penyedia dapat melihat daftar lowongan pekerjaan
    public void showLowongan() {
        if (lowonganYangDibuat.isEmpty()) {
            System.out.println("Tidak ada lowongan tersedia.");
        } else {
            System.out.println("Daftar Lowongan Kerja:");
            for (Lowongan lowongan : lowonganYangDibuat) {
                System.out.println("ID: " + lowongan.getId() + ", Posisi: " + lowongan.getPosisi() +
                        ", Perusahaan: " + lowongan.getPerusahaan());
            }
        }
    }
}
