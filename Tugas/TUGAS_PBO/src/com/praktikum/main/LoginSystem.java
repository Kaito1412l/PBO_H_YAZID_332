package com.praktikum.main;

import com.praktikum.model.*;
import com.praktikum.users.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItem = new ArrayList<>();

    // Tambahkan user awal
    static {
        userList.add(new Admin("Admin", "0000"));
        userList.add(new Mahasiswa("Nur Muhamamd Yazid Salim", "202410370110332"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        User user = null;
        do {
            System.out.println("\n=== SISTEM LOGIN ===");
            System.out.println("1. Login Admin");
            System.out.println("2. Login Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // buang newline
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); // clear input
                pilihan = -1;
            }

            switch (pilihan) {
                case 1:
                    user = loginUser("Admin", scanner);
                    if (user != null) user.displayAppMenu();
                    break;
                case 2:
                    user = loginUser("Mahasiswa", scanner);
                    if (user != null) user.displayAppMenu();
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 3);

        scanner.close();
    }

    public static User loginUser(String role, Scanner scanner) {
        int sisaKesempatan = 3;
        while (sisaKesempatan > 0) {
            System.out.print(role.equals("Admin") ? "Masukkan Username: " : "Masukkan Nama: ");
            String input1 = scanner.nextLine();
            System.out.print(role.equals("Admin") ? "Masukkan Password: " : "Masukkan NIM: ");
            String input2 = scanner.nextLine();

            for (User u : userList) {
                if ((role.equals("Admin") && u instanceof Admin) ||
                        (role.equals("Mahasiswa") && u instanceof Mahasiswa)) {
                    if (u.login(input1, input2)) {
                        u.displayInfo();
                        return u;
                    }
                }
            }

            sisaKesempatan--;
            System.out.println("Login gagal! Coba lagi. Kesempatan tersisa: " + sisaKesempatan);
        }

        System.out.println("Gagal login 3 kali. Silakan coba lagi nanti!");
        return null;
    }

    public static User loginUser(String role, String username, String password) {
        for (User u : userList) {
            if ((role.equals("Admin") && u instanceof Admin) ||
                    (role.equals("Mahasiswa") && u instanceof Mahasiswa)) {
                if (u.login(username, password)) {
                    u.displayInfo();
                    return u;
                }
            }
        }
        return null;
    }
}
