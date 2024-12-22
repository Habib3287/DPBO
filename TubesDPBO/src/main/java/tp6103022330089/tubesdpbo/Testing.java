/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp6103022330089.tubesdpbo;

/**
 *
 * @author LEGION
 */ 
public class Testing {

    public static void main(String[] args) {
        // Membuat objek Scanner
        // Menambahkan beberapa data dummy untuk pengujian
        Admin admin = new Admin("A", "AB", "1", "Alamat Admin", "Admin", "08123456789");
        Pelamar pelamar = new Pelamar("B", "BC", "2", "Alamat Pelamar", "Pelamar", "08198765432");
        PembukaLowongan penyedia = new PembukaLowongan("C", "CD", "3", "Alamat Penyedia", "Penyedia", "08111223344");
        
        // Menambahkan pengguna ke database
        User.addUser(admin);
        User.addUser(penyedia);
        User.addUser(pelamar);
        
        MenuUtil.menuUtama();
    }
}
