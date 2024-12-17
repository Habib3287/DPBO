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

public class Chat {
    private ArrayList<Pesan> daftarPesan;

    public Chat() {
        this.daftarPesan = new ArrayList<>();
    }
    
    public void kirimPesan(Pesan pesan) {
        daftarPesan.add(pesan);
        System.out.println("Pesan berhasil dikirim: " + pesan);
    }
    
    public boolean hapusPesan(String idPesan) {
        for (Pesan pesan : daftarPesan) {
            if (pesan.getIdChat().equals(idPesan)) {
                daftarPesan.remove(pesan);
                return true; // Pesan berhasil dihapus
            }
        }
        System.out.println("Pesan dengan ID: " + idPesan 
                + " tidak ditemukan.");
        return false; // Pesan tidak ditemukan
    }
    
    public void tampilkanPesan() {
        if (daftarPesan.isEmpty()) {
            System.out.println("Tidak ada pesan.");
            return;
        }
        System.out.println("Daftar Pesan:");
        for (Pesan pesan : daftarPesan) {
            System.out.println(pesan);
        }
    }
}
