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

public abstract class User {
    protected String nama;
    protected String email;
    protected String password;
    protected String alamat;
    protected String role;
    protected String noTelepon;

    // Database untuk menyimpan semua user
    protected static ArrayList<User> database = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    

    // Constructor untuk User
    public User(String nama, String email, String password, String alamat, String role, String noTelepon) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.alamat = alamat;
        this.role = role;
        this.noTelepon = noTelepon;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public static ArrayList<User> getDatabase() {
        return database;
    }

    // Method untuk login
    public boolean login(String email, String password) {
        // Cek apakah email dan password sesuai dengan data user di database
        for (User user : database) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Abstract method untuk register, setiap subclass perlu mengimplementasikan
    public abstract void register(String nama, String email, String password, String alamat, String noTelepon);


    // Method untuk menampilkan daftar semua pengguna
    public static void showAllUsers() {
        if (database.isEmpty()) {
            System.out.println("Tidak ada pengguna di database.");
        } else {
            for (User user : database) {
                System.out.println("Nama: " + user.getNama() + " Email: " + user.getEmail() + " Role: " + user.getRole());
            }
        }
    }
    
    public static void hapusUser(String nama, String email) {
        boolean userDihapus = false;

        for (int i = 0; i < database.size(); i++) {
            User user = database.get(i);
            if (user.getNama().equalsIgnoreCase(nama) && user.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Apakah anda yakin ingin menghapus user " + user.getNama() + "? (Y/N)");
                char confirm = ScannerUtil.scanChar(scan);
                if (confirm != 'Y') {
                    System.out.println("User tidak jadi dihapus.");
                    return;
                }else{
                database.remove(i);
                userDihapus = true;
                System.out.println("User dengan nama " + nama + " dan email " + email + " telah dihapus.");
                break;
                }
            }
        }

        if (!userDihapus) {
            System.out.println("User dengan nama " + nama + " dan email " + email + " tidak ditemukan.");
        }
    }
    
}
