/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6103022330089.tubesdpbo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author LEGION
 */
public class MenuUtil {
    private static HashMap<Lowongan, ArrayList<Pelamar>> daftarPelamarLowongan = new HashMap<>();
    
    public static void menuAdmin(Scanner scan, Admin admin) {
        System.out.println("---- Menu Admin ----");
        System.out.println("1. Tambah Berita");
        System.out.println("2. Hapus Berita");
        System.out.println("3. Tambah Pelatihan");
        System.out.println("4. Hapus Pelatihan");
        System.out.println("5. Hapus User");
        System.out.print("Pilih menu: ");
        int pilihan = ScannerUtil.scanInt(scan);

        switch (pilihan) {
            case 1:
                admin.addNews();
            case 2:
                System.out.println("Masukkan ID Berita yang ingin dihapus: ");
                String idBeritaHapus = ScannerUtil.scanString(scan);
                admin.deleteNews(idBeritaHapus);
                break;
            case 3:
                admin.tambahPelatihan();
                break;
            case 4:
                System.out.println("Masukkan Judul Pelatihan yang ingin dihapus: ");
                String judulPelatihanHapus = ScannerUtil.scanString(scan);
                admin.hapusPelatihan(judulPelatihanHapus);
                break;
            case 5:
                System.out.println("Masukkan nama user yang ingin dihapus: ");
                String namaUserHapus = ScannerUtil.scanString(scan);
                System.out.println("Masukkan email user yang ingin dihapus: ");
                String emailUserHapus = ScannerUtil.scanString(scan);
                admin.hapusUser(namaUserHapus, emailUserHapus);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }

    // Menu Pelamar
    public static void menuPelamar(Scanner scan, Pelamar pelamar) {
        System.out.println("---- Menu Pelamar ----");
        System.out.println("1. Melihat Lowongan");
        System.out.println("2. Melamar Lowongan");
        System.out.println("3. Melihat Daftar Pelatihan");
        System.out.print("Pilih menu: ");
        int pilihan = ScannerUtil.scanInt(scan);

        switch (pilihan) {
            case 1:
            System.out.println("Daftar Lowongan: ");
                Lowongan.getDaftarLowongan();
                break;
            case 2:
                System.out.println("Masukkan email pelamar: ");
                String emailPelamar = ScannerUtil.scanString(scan);
                System.out.println("Masukkan ID Lowongan: ");
                String idLowongan = ScannerUtil.scanString(scan);
                pelamar.melamarLowongan(emailPelamar, idLowongan);
                break;
            case 3:
                Pelatihan.getDaftarPelatihan();
                System.out.println("Masukkan ID Lowongan: ");
                String idPelatihan = ScannerUtil.scanString(scan);
                pelamar.mendaftarPelatihan(idPelatihan);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }

    // Menu Penyedia Lowongan
    public static void menuPenyedia(Scanner scan, PembukaLowongan penyedia) {
        System.out.println("---- Menu Penyedia Lowongan ----");
        System.out.println("1. Membuat Lowongan");
        System.out.println("2. Menolak Pelamar");
        System.out.println("3. Melihat Daftar Pelamar");
        System.out.println("4. Melihat Daftar Lowongan");
        System.out.print("Pilih menu: ");
        int pilihan = ScannerUtil.scanInt(scan);

        switch (pilihan) {
            case 1:
                // Membuat lowongan
                    System.out.print("Masukkan ID Lowongan: ");
                    String idLowongan = ScannerUtil.scanString(scan);
                    System.out.print("Masukkan Judul Lowongan: ");
                    String judul = ScannerUtil.scanString(scan);
                    System.out.print("Masukkan Deskripsi Lowongan: ");
                    String deskripsi = ScannerUtil.scanString(scan);
                    penyedia.membuatLowongan(idLowongan, judul, deskripsi);
                    Lowongan lowonganBaru = new Lowongan(idLowongan, judul, deskripsi);
                    daftarPelamarLowongan.put(lowonganBaru, new ArrayList<>());
                    break;
            case 2:
                System.out.print("Masukkan nama pelamar yang akan ditolak: ");
                String namaPelamar = ScannerUtil.scanString(scan);
                Pelamar pelamarDitolak = null;
                for (ArrayList<Pelamar> daftarPelamar : daftarPelamarLowongan.values()) {
                    for (Pelamar pelamar : daftarPelamar) {
                        if (pelamar.getNama().equalsIgnoreCase(namaPelamar)) {
                            pelamarDitolak = pelamar;
                        }
                    }
                }
                penyedia.menolakPelamar(pelamarDitolak);
                break;
            case 3:
                penyedia.melihatDaftarPelamar(daftarPelamarLowongan);
                break;
            case 4:
                penyedia.showLowongan();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }
}

