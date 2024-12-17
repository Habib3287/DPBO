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

public abstract class User {
    private String nama;
    private String email;
    private String password;
    private String alamat;
    private String role;
    private String noTelepon;
    private static ArrayList<User> database = new ArrayList<>();
    
    public User(String nama, String email, String password, String alamat, String role, String noTelepon) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.alamat = alamat;
        this.role = role;
        this.noTelepon = noTelepon;
    }
    
    public String getNoTelepon() {
        return noTelepon;
    }
    
    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
    
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


    public static ArrayList<User> getDatabase() {
        return database;
    }
    public static void setDatabase(ArrayList<User> database) {
        User.database = database;
    }


    public abstract void login(String email, String password);
    public abstract void register(String nama, String email, String password, String alamat, String noTelepon);
}


