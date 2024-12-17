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

public class Admin extends User implements News {
    private String idAdmin;
    private String hakAkses;
    private ArrayList<Berita> daftarBerita;

    public Admin(String nama, String email, String password, String alamat, String role, String noTelepon, String idAdmin, String hakAkses ) {
        super(nama, email, password, alamat, role, noTelepon);
        this.idAdmin = idAdmin;
        this.hakAkses = hakAkses;
        this.daftarBerita = new ArrayList<>();
    }

    
    public String getIdAdmin() {return idAdmin;}

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getHakAkses() {return hakAkses;}

    public void setHakAkses(String hakAkses) {
        this.hakAkses = hakAkses;
    }

    public void melakukan() {
        System.out.println("Admin sedang melakukan aktivitas.");
    }

    // Implementasi Metode News
    @Override
    public void tambahBerita(String idBerita, String judul, String content) {
        Berita beritaBaru = new Berita(idBerita, judul, content) {
        };
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

        System.out.println("Daftar Berita:");
        for (Berita berita : daftarBerita) {
            System.out.println("- " + berita.getJudul() + " (Konten: " +
                    berita.getContent() + ")");
        }
    }

    @Override
    public void login(String email, String password) {
        for (User user : User.getDatabase()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login berhasil untuk email: " + email);
                return;
            }
        }
        System.out.println("Login gagal. Email atau password salah.");
    }

    @Override
    public void register(String nama, String email, String password, String alamat, String noTelepon) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
