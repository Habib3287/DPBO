/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6103022330089.tubesdpbo;

/**
 *
 * @author LEGION
 */

public class Pelamar extends User {

    public Pelamar(String nama, String email, String password, String alamat, String role, String noTelepon) {
        super(nama, email, password, alamat, role, noTelepon);
    }

    @Override
    public void register(String nama, String email, String password, String alamat, String noTelepon) {
        Pelamar pelamarBaru = new Pelamar(nama, email, password, alamat, "Pelamar", noTelepon);
        User.database.add(pelamarBaru);
    }

    // Pelamar dapat melamar pekerjaan
    public void melamarLowongan(String email, String idLowongan) {
        boolean ditemukan = false;
        for (Lowongan lowongan : Lowongan.getDaftarLowongan()) {
            if (lowongan.getId().equals(idLowongan)) {
                ditemukan = true;
                lowongan.melamar(this);
                System.out.println("Pelamar " + this.getNama() + " telah melamar lowongan " + lowongan.getPosisi());
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Lowongan dengan ID " + idLowongan + " tidak ditemukan.");
        }    }

    // Pelamar dapat mendaftar pelatihan
    public void mendaftarPelatihan(String judulPelatihan) {
        for (Pelatihan pelatihan : Pelatihan.getDaftarPelatihan()) {
            if (pelatihan.getJudul().equals(judulPelatihan)) {
                pelatihan.daftarPelamar(this);
                System.out.println("Pelamar " + this.getNama() + " berhasil mendaftar pelatihan " + pelatihan.getJudul());
                return;
            }
        }
        
        System.out.println("Pelatihan dengan nama " + judulPelatihan + " tidak ditemukan.");
    }

}
