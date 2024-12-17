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
import java.util.Date;

public class PembukaLowongan extends User {
    private String idPembuka;
    private ArrayList<Lowongan> dLowongan;

    public PembukaLowongan(String nama, String email, String password, String alamat, String role, String noTelepon, String idPembuka) {
        super(nama, email, password, alamat, role, noTelepon);
        this.idPembuka = idPembuka;
        this.dLowongan = new ArrayList<>();
    }
    
    

    public String getIdPembuka() {return idPembuka;}

    public void setIdPembuka(String idPembuka) {
        this.idPembuka = idPembuka;
    }
    
    public void melakukan() {
        System.out.println("Pembuka lowongan sedang melakukan aktivitas.");
    }

    public void membuatLowongan(String idLowongan, String judul, 
            String deskripsi) {
        Date tanggalBuat = new Date();
        Lowongan newLowongan = new Lowongan(idLowongan, judul, deskripsi,
                tanggalBuat);
        dLowongan.add(newLowongan);
        System.out.println("Lowongan berhasil dibuat dengan judul: " + judul);
    }

        public void daftarPelamar(ArrayList<Pelamar> dPelamar) {
            System.out.println("Daftar Pelamar untuk Lowongan:");
            if (dPelamar.isEmpty()) {
                System.out.println("Tidak ada pelamar untuk lowongan ini.");
            } else {
                for (Pelamar pelamar : dPelamar) {
                    System.out.println("- " + pelamar.getNama() );
                }
            }
        }
        
        public void menerimaPelamar(Pelamar pelamar) {
            if (pelamar != null) {
                System.out.println("Pelamar " + pelamar.getNama() + " diterima.");
            } else {
                System.out.println("Pelamar tidak ditemukan.");
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
        PembukaLowongan pembuka = new PembukaLowongan(nama,email,password, alamat, "pembuka",noTelepon, idPembuka);

        User.getDatabase().add(pembuka);

        System.out.println("Register berhasil! Akun Perusahaan " + nama + " telah ditambahkan ke database.");
    }
}
