/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6103022330089.tubesdpbo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LEGION
 */

public class Pelamar extends User {

    public Pelamar(String nama, String email, String password, String alamat, String role, String noTelepon) {
        super(nama, email, password, alamat, role, noTelepon);
    }
    
    public Pelamar(String nama) {
        super(nama);
    }

    @Override
    public boolean login(String email, String password) {
        for (User user : User.getDatabase()) {
            if( user instanceof Pelamar){
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    System.out.println("Login berhasil untuk email: " + email);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void register(String nama, String email, String password, String alamat, String noTelepon) {
        Pelamar pelamarBaru = new Pelamar(nama, email, password, alamat, "pelamar", noTelepon);

        User.getDatabase().add(pelamarBaru);

        System.out.println("Register berhasil! User " + nama + " telah ditambahkan ke database.");
    }
    public void mendaftarpelatihan(String emailPelamar){
        for (User user : User.getDatabase()) {
            if( user instanceof Pelamar){
                if (user.getEmail().equals(emailPelamar)) {
                    System.out.println("Pelamar ditemukan: " + emailPelamar);
                    DaftarPelatihan.showPelatihan();
                    System.out.println("Masukkan ID Pelatihan yang ingin Anda daftar: ");
                    Scanner scan = new Scanner(System.in);
                    String idPelatihanPilihan =  scan.nextLine();
                    
                    for ( Pelatihan pelatihan : DaftarPelatihan.getDaftarPelatihan() ) {
                        if (pelatihan.getIdPelatihan().equals(idPelatihanPilihan)){
                            System.out.println("Anda berhasil mendaftar ke pelatihan: " + pelatihan.getjudulPelatihan());
                            return;
                        }
                    }
                    System.out.println("Pelatihan dengan ID tersebut tidak ditemukan.");
                    return;
                }
            }           
            System.out.println("Pelamar tidak ditemukan di database."); 
        }
    }
}

    
