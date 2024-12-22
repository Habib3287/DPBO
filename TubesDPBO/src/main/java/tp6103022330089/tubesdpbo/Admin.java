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

public class Admin extends User implements News {
    private ArrayList<Berita> daftarBerita = new ArrayList<>();
    private ArrayList<Pelatihan> daftarPelatihan = new ArrayList<>();
    private ArrayList<User> daftarUser = new ArrayList<>();

    public Admin(String nama, String email, String password, String alamat, String role, String noTelepon) {
        super(nama, email, password, alamat, role, noTelepon);
    }

    @Override
    public void register(String nama, String email, String password, String alamat, String noTelepon) {
        System.out.println("Admin tidak perlu melakukan registrasi.");
    }

    @Override
    public void addNews() {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan ID berita: ");
        String id = ScannerUtil.scanString(input);  
        System.out.println("Masukkan judul berita: ");
        String judul = ScannerUtil.scanString(input);   
        System.out.println("Masukkan konten berita: ");
        String konten = ScannerUtil.scanString(input);
        Berita beritaBaru = new Berita(id, judul, konten);
        daftarBerita.add(beritaBaru);
        System.out.println("Berita dengan judul " + beritaBaru.getJudul() + " telah ditambahkan.");
    }

    @Override
    public void deleteNews(String id) {
        for (Berita berita : daftarBerita) {
            if (berita.getId().equals(id)) {
                daftarBerita.remove(berita);
                System.out.println("Berita dengan ID " + id +
                        " berhasil dihapus.");
                return;
            }
        }
        System.out.println("Berita dengan ID " + id +
                " tidak ditemukan.");
    }
    
    @Override
    public  void displayNews() {
        if (daftarBerita.isEmpty()) {
            System.out.println("Tidak ada berita terbaru.");
        } else {
            System.out.println("---- Berita Terbaru ----");
            for (Berita berita : daftarBerita) {
                System.out.println("ID: " + berita.getId() +
                                   " | Judul: " + berita.getJudul() +
                                   "\nKonten: " + berita.getKonten() + "\n");
            }
        }
    }

    // Admin dapat menambah pelatihan
    public void tambahPelatihan() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukkan Judul Pelatihan: ");
        String judulPelatihan = ScannerUtil.scanString(scan);
        System.out.println("Masukkan Pemateri: ");
        String pemateri = ScannerUtil.scanString(scan);
        System.out.println("Masukkan Deskripsi Pelatihan: ");
        String deskripsiPelatihan = ScannerUtil.scanString(scan);
        for (Pelatihan pelatihan : daftarPelatihan) {
            if (!pelatihan.getJudul().equals(judulPelatihan)){
                Pelatihan pelatihanBaru = new Pelatihan(judulPelatihan, pemateri, deskripsiPelatihan);
                daftarPelatihan.add(pelatihanBaru);
                System.out.println("Pelatihan berhasil ditambahkan: " + judulPelatihan);
            }else{
                System.out.println("Pelatihan dengan judul " + judulPelatihan + " sudah ada.");
            }
        }
    }

    // Admin dapat menghapus pelatihan
    public void hapusPelatihan(String judul) {
        for (Pelatihan pelatihan : daftarPelatihan) {
            if (pelatihan.getJudul().equals(judul)) {
                daftarPelatihan.remove(pelatihan);
                System.out.println("Pelatihan " + judul +
                        " berhasil dihapus.");
                return;
            }
        }
        System.out.println("Pelatihan " + judul +
                " tidak ditemukan.");
    }

    // Admin dapat menghapus pengguna
    public void hapusUser(String email, String nama) {
        boolean userDihapus = false;

        // Mencari user di daftar
        for (int i = 0; i < daftarUser.size(); i++) {
            User user = daftarUser.get(i);
            if (user.getNama().equalsIgnoreCase(nama) && user.getEmail().equalsIgnoreCase(email)) {
                daftarUser.remove(i); // Menghapus user dari daftar
                userDihapus = true;
                System.out.println("User dengan nama " + nama + " dan email " + email + " telah dihapus.");
                break;
            }
        }

        // Jika tidak ditemukan user
        if (!userDihapus) {
            System.out.println("User dengan nama " + nama + " dan email " + email + " tidak ditemukan.");
        }
    }

    // Fungsi untuk menampilkan semua pengguna (untuk memverifikasi penghapusan)
    public void tampilkanDaftarUser() {
        if (daftarUser.isEmpty()) {
            System.out.println("Tidak ada pengguna dalam daftar.");
        } else {
            System.out.println("Daftar Pengguna:");
            for (User user : daftarUser) {
                System.out.println(user);
            }
        }
    }
}
