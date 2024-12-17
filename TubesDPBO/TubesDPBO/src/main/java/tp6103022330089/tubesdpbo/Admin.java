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
import java.util.Scanner;
import java.util.Date;

public class Admin extends User implements News {
    Scanner scan = new Scanner(System.in);
    private String idAdmin;
    private ArrayList<Berita> daftarBerita;
    private ArrayList<Pelatihan> daftarPelatihan;

    public Admin(String nama, String email, String password, String alamat, String role, String noTelepon, String idAdmin, String hakAkses ) {
        super(nama, email, password, alamat, role, noTelepon);
        this.daftarBerita = new ArrayList<>();
    }

    
    public String getIdAdmin() {return idAdmin;}

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void melakukan() {
        System.out.println("Admin sedang melakukan aktivitas.");
    }

    // Implementasi Metode News
    @Override
    public void tambahBerita(String idBerita, String judul, String content) {
        Berita beritaBaru = new Berita(idBerita, judul, content);
        daftarBerita.add(beritaBaru);
        System.out.println("Berita berhasil ditambahkan: " + judul);
    }

    @Override
    public void hapusBerita(String idBerita) {
        for (Berita berita : daftarBerita) {
            if (berita.getIdBerita().equals(idBerita)) {
                daftarBerita.remove(berita);
                System.out.println("Berita dengan ID " + idBerita +
                        " berhasil dihapus.");
                return;
            }
        }
        System.out.println("Berita dengan ID " + idBerita +
                " tidak ditemukan.");
    }

    @Override
    public void tampilkanBerita() {
        if (daftarBerita.isEmpty()) {
            System.out.println("Belum ada berita yang tersedia.");
            return;
        }

        System.out.println("Daftar Berita: ");
        for (Berita berita : daftarBerita) {
            System.out.println("- " + berita.getJudul() + " (Konten: " +
                    berita.getContent() + ")");
        }
    }

    @Override
    public void login(String email, String password) {
        for (User user : User.getDatabase()) {
            if( user instanceof Admin){
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    System.out.println("Login berhasil untuk email: " + email);
                    return;
                }
            }
        }
        System.out.println("Login gagal. Email atau password salah.");
    }

    @Override
    public void register(String nama, String email, String password, String alamat, String noTelepon) {
        System.out.println("Admin tidak perlu register");
    }
    
    public void hapusUser(String nama, String email){
        for (User user : User.getDatabase()) {
            if (user instanceof Pelamar || user instanceof PembukaLowongan){
                if (user.getEmail().equals(email) && user.getNama().equals(nama)){
                    System.out.println("Apakah anda yakin ingin menghapus user " + user.getNama() + " (Y/N)");
                    String perm = scan.nextLine();
                    if (perm.equals('y') || perm.equals('Y')){
                        User.getDatabase().remove(user);
                        System.out.println("User " + user.getNama() + " telah dihapus");
                    }else{
                        System.out.println("Baiklah");
                        return;
                    }
                }
            }
        }
    }
    
    public void tambahPelatihan(String judulPelatihan, String pemateri, String deskripsiPelatihan) {
        Date tanggalPelatihan = new Date();
        Pelatihan pelatihanBaru = new Pelatihan(judulPelatihan, pemateri, deskripsiPelatihan, tanggalPelatihan);
        daftarPelatihan.add(pelatihanBaru);
        System.out.println("Pelatihan berhasil ditambahkan: " + judulPelatihan);
    }

    public void hapusPelatihan(String judul) {
        for (Pelatihan pelatihan : daftarPelatihan) {
            if (pelatihan.getjudulPelatihan().equals(judul)) {
                daftarPelatihan.remove(pelatihan);
                System.out.println("Pelatihan " + judul +
                        " berhasil dihapus.");
                return;
            }
        }
        System.out.println("Pelatihan " + judul +
                " tidak ditemukan.");
    }
}
