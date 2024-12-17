/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tp6103022330089.tubesdpbo;

/**
 *
 * @author LEGION
 */
public interface News {
    void tambahBerita(String idBerita, String judul, String content);
    void hapusBerita(String idBerita);
    void tampilkanBerita();
}
