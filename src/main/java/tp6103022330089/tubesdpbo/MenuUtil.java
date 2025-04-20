/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6103022330089.tubesdpbo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import static tp6103022330089.tubesdpbo.User.database;

/**
 *
 * @author LEGION
 */
public class MenuUtil {
        private static HashMap<Lowongan, ArrayList<Pelamar>> daftarPelamarLowongan = new HashMap<>();
    
        public static void menuUtama(){
            Scanner scan = new Scanner(System.in);
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
                                    } else if (user instanceof Pelamar) {
                                        MenuUtil.menuPelamar(scan, (Pelamar) user);
                                    } else if (user instanceof PembukaLowongan) {
                                        MenuUtil.menuPenyedia(scan, (PembukaLowongan) user);
                                    }
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
                                System.out.println("Pelamar telah berhasil didaftarkan");
                                database.add(newPelamar);
                                menuUtama();
                            } else if (pilihanRegister == 2) {
                                PembukaLowongan newPenyedia = new PembukaLowongan(email, password, nama, alamat, "Penyedia", noTelepon);
                                newPenyedia.register(nama, email, password, alamat, noTelepon);
                                System.out.println("Penyedia  telah berhasil didaftarkan");
                                database.add(newPenyedia);
                                menuUtama();
                            } else {
                                System.out.println("Pilihan tidak valid, coba lagi.");
                            }
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
    
    public static void menuAdmin(Scanner scan, Admin admin) {
        System.out.println("---- Menu Admin ----");
        System.out.println("1. Tambah Berita");
        System.out.println("2. Hapus Berita");
        System.out.println("3. Tambah Pelatihan");
        System.out.println("4. Hapus Pelatihan");
        System.out.println("5. Hapus User");
        System.out.println("6. User yang terdaftar");
        System.out.print("Pilih menu: ");
        int pilihan = ScannerUtil.scanInt(scan);
        
        while (pilihan < 1 || pilihan > 7) {
        System.out.println("Pilihan tidak valid. Silakan pilih antara 1-5.");
        System.out.print("Pilih menu: ");
    }
        
        switch (pilihan) {
            case 1:
                admin.addNews();
                break;
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
                User.hapusUser(namaUserHapus, emailUserHapus);
                break;
            case 6:
                User.showAllUsers();
                break;
            default:
                break;
        }
        System.out.println("\nApakah Anda ingin melanjutkan?");
        System.out.println("1. Kembali ke Menu Admin");
        System.out.println("2. Keluar");
        System.out.print("Pilih menu: ");

        int lanjut = ScannerUtil.scanInt(scan);
        if (lanjut == 1) {
            menuAdmin(scan, admin); // Memanggil kembali menu Admin
        } else {
            System.out.println("Terima kasih!");
            menuUtama();
        }
    }

    // Menu Pelamar
    public static void menuPelamar(Scanner scan, Pelamar pelamar) {
        System.out.println("---- Menu Pelamar ----");
        System.out.println("1. Melihat Lowongan");
        System.out.println("2. Melamar Lowongan");
        System.out.println("3. Melihat Daftar Pelatihan");
        System.out.println("4. Mendaftar Pelatihan");
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
                Pelatihan.displayPelatihan();
                break;
            case 4:
                System.out.println("Masukkan ID Pelatihan: ");
                String idPelatihan = ScannerUtil.scanString(scan);
                pelamar.mendaftarPelatihan(idPelatihan);
                break;
            default:
                break;
        }
        System.out.println("\nApakah Anda ingin melanjutkan?");
        System.out.println("1. Kembali ke Menu Pelamar");
        System.out.println("2. Keluar");
        System.out.print("Pilih menu: ");

        int lanjut = ScannerUtil.scanInt(scan);
        if (lanjut == 1) {
            menuPelamar(scan, pelamar); // Memanggil kembali menu Admin
        } else {
            System.out.println("Terima kasih!");
            menuUtama();
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
                penyedia.membuatLowongan(   );
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
                break;
        }
        System.out.println("\nApakah Anda ingin melanjutkan?");
        System.out.println("1. Kembali ke Menu Penyedia");
        System.out.println("2. Keluar");
        System.out.print("Pilih menu: ");

        int lanjut = ScannerUtil.scanInt(scan);
        if (lanjut == 1) {
            menuPenyedia(scan, penyedia); // Memanggil kembali menu Admin
        } else {
            System.out.println("Terima kasih!");
            menuUtama();
        }
    }
}

