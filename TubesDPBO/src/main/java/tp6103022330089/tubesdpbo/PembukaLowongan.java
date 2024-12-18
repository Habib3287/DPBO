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

public class PembukaLowongan extends User {
    private ArrayList<Lowongan> daftarLowongan;
    private ArrayList<Pelamar> daftarPelamar;

    public PembukaLowongan(String nama, String email, String password, String alamat, String role, String noTelepon) {
        super(nama, email, password, alamat, role, noTelepon);
        this.daftarLowongan = new ArrayList<>();
    }
    
    public PembukaLowongan(String nama) {
        super(nama);
    }

    public void membuatLowongan(String idLowongan, String judul, 
            String deskripsi) {
        Lowongan newLowongan = new Lowongan(idLowongan, judul, deskripsi);
        daftarLowongan.add(newLowongan);
        System.out.println("Lowongan berhasil dibuat dengan judul: " + judul);
    }

        public void daftarPelamar() {
            System.out.println("Daftar Pelamar untuk Lowongan:");
            if (daftarPelamar.isEmpty()) {
                System.out.println("Tidak ada pelamar untuk lowongan ini.");
            } else {
                for (Pelamar pelamar : daftarPelamar) {
                    System.out.println("- " + pelamar.getNama() );
                }
            }
        }
        
        public void menolakPelamar(Pelamar pelamar) {
            if (pelamar != null) {
                System.out.println("Pelamar " + pelamar.getNama() + " ditolak.");
            } else {
                System.out.println("Pelamar tidak ditemukan.");
            }
        }

    @Override
    public boolean login(String email, String password) {
            for (User user : User.getDatabase()) {
            if (user instanceof PembukaLowongan){
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    System.out.println("Login berhasil sebagai penyedia untuk email : " + email);
                    return true;
                }
            }
        }
        System.out.println("Login gagal. Email atau password salah.");
        return false;
    }

    @Override
    public void register(String nama, String email, String password, String alamat, String noTelepon) {
        PembukaLowongan pembuka = new PembukaLowongan(nama,email,password, alamat, "pembuka",noTelepon);

        User.getDatabase().add(pembuka);

        System.out.println("Register berhasil! Akun Perusahaan " + nama + " telah ditambahkan ke database.");
    }
}
