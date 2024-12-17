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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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

                    
                    if (roles == 1){
                        PembukaLowongan penyediaLogin = new PembukaLowongan("", emailLogin, passwordLogin, "", "penyedia", "");
                        penyediaLogin.login(emailLogin, passwordLogin);
                    }else if (roles == 2){
                        Pelamar pelamarLogin = new Pelamar("", emailLogin, passwordLogin, "", "pelamar", "");
                        pelamarLogin.login(emailLogin, passwordLogin);
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