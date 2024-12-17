/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6103022330089.tubesdpbo;

/**
 *
 * @author LEGION
 */
import java.util.Scanner;

public class Pelamar extends User {
    Scanner scan = new Scanner(System.in);

    public Pelamar(String nama, String email, String password, String alamat, String role, String noTelepon) {
        super(nama, email, password, alamat, role, noTelepon);
    }

    @Override
    public void login(String email, String password) {
        for (User user : User.getDatabase()) {
            if( user instanceof Pelamar){
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    System.out.println("Login berhasil untuk email: " + email);
                    return;
                }
            }
        }
        System.out.println("Login gagal. Email atau password salah.");
    }

    @Override
    public void register(String nama, String email, String password, String alamat, String noTelepon) {
        Pelamar pelamarBaru = new Pelamar(nama, email, password, alamat, "pelamar", noTelepon);

        User.getDatabase().add(pelamarBaru);

        System.out.println("Register berhasil! User " + nama + " telah ditambahkan ke database.");
    }
        public void mendaftarpelat(){
        
    }
}

    
