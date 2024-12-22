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

    public static void main(String[] args) {
        // Membuat objek Scanner
        Scanner scan = new Scanner(System.in);

        // Menambahkan beberapa data dummy untuk pengujian
        Admin admin = new Admin("A", "AB", "1", "Alamat Admin", "Admin", "08123456789");
        Pelamar pelamar = new Pelamar("B", "BC", "2", "Alamat Pelamar", "Pelamar", "08198765432");
        PembukaLowongan penyedia = new PembukaLowongan("C", "CD", "3", "Alamat Penyedia", "Penyedia", "08111223344");
        
        // Menambahkan pengguna ke database
        User.addUser(admin);
        User.addUser(penyedia);
        User.addUser(pelamar);
        
        boolean isRunning = true;
        boolean isLoggedIn = false;
        User currentUser = null;

        OUTER:
        while (isRunning) {
            if (!isLoggedIn){
            System.out.println("---- Menu Utama ----");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int pilihanMenu = ScannerUtil.scanInt(scan);
            switch (pilihanMenu) {
                case 1:
                    {
                        System.out.print("Masukkan email: ");
                        String email = ScannerUtil.scanString(scan);
                        System.out.print("Masukkan password: ");
                        String password = ScannerUtil.scanString(scan);
                        boolean berhasilLogin = false;
                        for (User user : User.getDatabase()) {
                            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                                berhasilLogin = true;
                                isLoggedIn = true;
                                currentUser = user;
                                System.out.println("Login berhasil, selamat datang " + user.getNama());
                                if (user instanceof Admin) {
                                    MenuUtil.menuAdmin(scan, (Admin) user);
                                    break;
                                } else if (user instanceof Pelamar) {
                                    MenuUtil.menuPelamar(scan, (Pelamar) user);
                                    break;
                                } else if (user instanceof PembukaLowongan) {
                                    MenuUtil.menuPenyedia(scan, (PembukaLowongan) user);
                                    break;
                                }
                                break;
                            }
                        }       if (!berhasilLogin) {
                            System.out.println("Login gagal, email atau password salah.");
                        }       break;
                    }
                case 2:
                    {
                        // Proses registrasi
                        System.out.println("1. Register sebagai Pelamar");
                        System.out.println("2. Register sebagai Pembuka Lowongan");
                        System.out.print("Pilih role yang ingin didaftarkan: ");
                        int pilihanRegister = ScannerUtil.scanInt(scan);
                        System.out.print("Masukkan nama: ");
                        String nama = ScannerUtil.scanString(scan);
                        System.out.print("Masukkan email: ");
                        String email = ScannerUtil.scanString(scan);
                        System.out.print("Masukkan password: ");
                        String password = ScannerUtil.scanString(scan);
                        System.out.print("Masukkan alamat: ");
                        String alamat = ScannerUtil.scanString(scan);
                        System.out.print("Masukkan nomor telepon: ");
                        String noTelepon = ScannerUtil.scanString(scan);
                        if (pilihanRegister == 1) {
                            Pelamar newPelamar = new Pelamar(email, password, nama, alamat, "Pelamar", noTelepon);
                            newPelamar.register(nama, email, password, alamat, noTelepon);
                        } else if (pilihanRegister == 2) {
                            PembukaLowongan newPenyedia = new PembukaLowongan(email, password, nama, alamat, "Penyedia", noTelepon);
                            newPenyedia.register(nama, email, password, alamat, noTelepon);
                        } else {
                            System.out.println("Pilihan tidak valid, coba lagi.");
                        }       // Menutup scanner setelah selesai
                        scan.close();   break;
                    }
                case 3:
                    System.out.println("Terima kasih! Keluar dari program.");
                    break OUTER;
                default:
                    break;
            }
        }
        }
    }
}
