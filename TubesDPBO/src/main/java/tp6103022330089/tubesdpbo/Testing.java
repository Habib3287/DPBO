/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp6103022330089.tubesdpbo;

import java.util.Scanner;

/**
 *
 * @author LEGION
 */ 
public class Testing {

    /**
     */
    
        public  static void menuLoginPel(){
            System.out.println("----Menu Pelamar----");
            System.out.println("1. Melihat lowongan kerja");
            System.out.println("2. Membuat cv");
            System.out.println("3. Melihat daftar pelatihan");
        }
        
        public static void menuLoginAdm(){
            System.out.println("----Menu Admin----");
            System.out.println("1. Tambah Berita");
            System.out.println("2. Menghapus Berita");
            System.out.println("3. Tambah Pelatihan");
            System.out.println("4. Hapus Pelatihan");
            System.out.println("5. Hapus User");
        }
        
        public static void menuLoginPen(){
            System.out.println("----Menu Pembuka Lowongan----");
            System.out.println("1. Membuat Lowongan");
            System.out.println("2. Menolak Pelamar");
        }
        
    public static void main(String[] args) {
        
        Admin admin = new Admin("a","b","c", "d", "Admin", "f");
        User.getDatabase().add(admin);
        
        DaftarPelatihan DP = new DaftarPelatihan("");
        Scanner scan = new Scanner(System.in);
        int pilihan;
        
        
        // Loop utama program
        while (true) {
            // Menampilkan menu
            System.out.println("Pilih Role: ");
            System.out.println("1. Penyedia Kerja");
            System.out.println("2. Pencari Kerja");
            System.out.println("3. Admin");
            int roles = scan.nextInt();   
            if (roles > 3){
                System.out.println("Tidak ada roles yang dipilih");
            }else if (roles == 3){
                System.out.println("1. Login");
                System.out.println("2. Keluar");
                System.out.print("Pilih menu: ");
            }else if (roles == 1 || roles == 2){
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu: ");
            }else{
                break;
            }

            // Membaca pilihan pengguna
            if (scan.hasNextInt()) {
                pilihan = scan.nextInt();
                scan.nextLine(); // Membersihkan buffer
            } else {
                System.out.println("Input tidak valid. Masukkan angka.");
                scan.nextLine(); // Membersihkan buffer
                continue;
            }

            // Menangani pilihan menu
            switch (pilihan) {
                case 1 -> {
                    System.out.print("Masukkan email: ");
                    String emailLogin = scan.nextLine();
                    System.out.print("Masukkan password: ");
                    String passwordLogin = scan.nextLine();

                    
                switch (roles) {
                    case 1:
                    PembukaLowongan penyedia = new PembukaLowongan("", emailLogin, passwordLogin, "", "penyedia", "");
                    penyedia.login(emailLogin, passwordLogin);
                    menuLoginPen();
                    int pilLogPen;
                    pilLogPen = scan.nextInt();
                    scan.nextLine(); // Membersihkan buffer setelah nextInt

                    switch (pilLogPen) {
                        case 1 -> {
                            System.out.println("Masukkan ID Lowongan");
                            String idLowongan = scan.nextLine();
                            System.out.println("Masukkan Judul Lowongan");
                            String judul = scan.nextLine();
                            System.out.println("Masukkan Deskripsi Lowongan");
                            String deskripsi = scan.nextLine();
                            penyedia.membuatLowongan(idLowongan, judul, deskripsi);
                        }
                        case 2 -> {
                            System.out.println("Masukkan Nama Pelamar");
                            String namaPelamar = scan.nextLine();

                            // Cari pelamar yang cocok di database
                            boolean pelamarDitemukan = false;

                            for (User user : User.getDatabase()) {
                                if (user instanceof Pelamar) {
                                    Pelamar pelamar = (Pelamar) user; // Casting User menjadi Pelamar
                                    if (pelamar.getNama().equalsIgnoreCase(namaPelamar)) {
                                        penyedia.menolakPelamar(pelamar); // Menolak pelamar yang sesuai
                                        pelamarDitemukan = true;
                                        System.out.println("Pelamar " + namaPelamar + " telah ditolak.");
                                        break;
                                    }
                                }
                            }

                                if (!pelamarDitemukan) {
                                    System.out.println("Pelamar dengan nama " + namaPelamar + " tidak ditemukan.");
                                }
                            }
                        }
                        break;
                    case 2:
                        Pelamar pelamar = new Pelamar("", emailLogin, passwordLogin, "", "pelamar", "");
                        pelamar.login(emailLogin, passwordLogin);
                        menuLoginPel();
                        int pilLogPel;
                        pilLogPel = scan.nextInt();
                        switch(pilLogPel){
                            case 1 -> {

                            }
                            case 2 ->{
                                
                            }
                            case 3 ->{
                                DP.showPelatihan();
                                String email = pelamar.getEmail();
                                pelamar.mendaftarpelatihan(email);
                            }
                        }
                    case 3:
                         
                        if(admin.login(emailLogin, passwordLogin)){
                            menuLoginAdm();
                            int pilLogAdm;
                            pilLogAdm = scan.nextInt();
                            switch(pilLogAdm){
                                case 1 -> {
                                    System.out.println("Masukkan ID Berita");
                                    String idBerita = scan.nextLine();
                                    System.out.println("Masukkan Judul");
                                    String judul = scan.nextLine();
                                    System.out.println("Masukkan Konten");
                                    String content = scan.nextLine();
                                    admin.tambahBerita(idBerita,judul,content);
                                }
                                case 2 ->{
                                    System.out.println("Masukkan ID Berita");
                                    String idBerita = scan.nextLine();
                                    admin.hapusBerita(idBerita);
                                }
                                case 3 ->{
                                    System.out.println("Masukkan Judul Pelatihan");
                                    String judulPelatihan = scan.nextLine();
                                    System.out.println("Masukkan Pemateri");
                                    String pemateri = scan.nextLine();
                                    System.out.println("Masukkan Deskripsi Pelatihan");
                                    String deskripsiPelatihan = scan.nextLine();
                                    admin.tambahPelatihan(judulPelatihan, pemateri, deskripsiPelatihan);
                                }
                                case 4 ->{
                                    System.out.println("Masukkan Judul Pelatihan");
                                    String judulPelatihan = scan.nextLine();
                                    admin.hapusPelatihan(judulPelatihan);
                                }
                                case 5 ->{
                                    for (User user : User.getDatabase()) {
                                        if (user instanceof Pelamar || user instanceof PembukaLowongan){
                                            admin.hapusUser(user.getNama(), user.getEmail());
                                        }
                                    }
                                    
                                }
                            }
                        }else{
                            System.out.println("Login gagal. Email atau password salah.");
                        }
   
                    default:
                        break;
                }
                }
                case 2 -> {
                    System.out.println("Masukkan nama: ");
                    String nama = scan.nextLine();
                    System.out.println("Masukkan email: ");
                    String email = scan.nextLine();
                    System.out.println("Masukkan password: ");
                    String password = scan.nextLine();
                    System.out.println("Masukkan alamat: ");
                    String alamat = scan.nextLine();
                    System.out.println("Masukkan nomor telepon: ");
                    String noTelepon = scan.nextLine();
                    
                    if (roles == 1){
                        PembukaLowongan penyediaBaru = new PembukaLowongan(nama, email, password, alamat, "penyedia", noTelepon);
                        penyediaBaru.register(nama, email, password, alamat, noTelepon);
                    }else if(roles == 2){
                        Pelamar pelamarBaru = new Pelamar(nama, email, password, alamat, "pelamar", noTelepon);
                        pelamarBaru.register(nama, email, password, alamat, noTelepon);
                    }
                }
                case 3 -> {
                    for (User user : User.getDatabase()) {
                        System.out.println("- Nama: " + user.getNama() + ", Email: " + user.getEmail() + ", Role: " + user.getRole());
                    }
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}
