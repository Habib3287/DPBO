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
        for (User user : User.getDatabase()) {
            if (user instanceof Pelamar || user instanceof PembukaLowongan){
                if (user.getEmail().equals(email) && user.getNama().equals(nama)){
                    System.out.println("Apakah anda yakin ingin menghapus user " + user.getNama() + " (Y/N)");
                    Scanner confirm = new Scanner(System.in);   
                    ScannerUtil.scanChar(confirm);
                    if( confirm.next().charAt(0) == 'Y' || confirm.next().charAt(0) == 'y'){
                        if (user instanceof Pelamar){
                            Pelamar pelamar = (Pelamar) user;
                            System.out.println("Pelamar " + pelamar.getNama() + " telah dihapus.");
                            User.getDatabase().remove(user);
                            return;
                        }else if (user instanceof PembukaLowongan){
                            PembukaLowongan pembukaLowongan = (PembukaLowongan) user;
                            System.out.println("Penyedia " + pembukaLowongan.getNama() + " telah dihapus.");
                            User.getDatabase().remove(user);
                            return;
                        }
                    }else{
                        System.out.println("User " + nama + " tidak akan dihapus.");
                        return;
                    }
                }
            }else{
                System.out.println("User tidak ditemukan");
            }
        }
    }    
}
