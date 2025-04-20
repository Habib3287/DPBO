/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp6103022330089.tubesdpbo;

import java.util.Scanner;

/**
 *
 * @author LEGION
 */
public class ScannerUtil {

    // Membaca input string dari pengguna
    public static String scanString(Scanner scan) {
        return scan.nextLine();
    }

    // Membaca input integer dari pengguna dengan pengecekan
    public static int scanInt(Scanner scan) {
        int input = -1;
        boolean valid = false;
        while (!valid) {
            try {
                input = Integer.parseInt(scan.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, silakan masukkan angka.");
            }
        }
        return input;
    }

    // Membaca input karakter ('Y' / 'N') dari pengguna
    public static char scanChar(Scanner scan) {
        char input = ' ';
        boolean valid = false;
        while (!valid) {
            String userInput = scan.nextLine().toUpperCase();
            if (userInput.equals("Y") || userInput.equals("N")) {
                input = userInput.charAt(0);
                valid = true;
            } else {
                System.out.println("Input tidak valid, masukkan 'Y' atau 'N'.");
            }
        }
        return input;
    }
    public static boolean isValidEmail(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(regex);
    }

}

