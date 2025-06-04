package com.praktikum.main;

import com.praktikum.model.Item;
import com.praktikum.error.loginExeptions;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

import java.util.ArrayList;
import java.util.Scanner;


public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItem = new ArrayList<>();

    public static void main(String[] args) {
        //Inisialisasi untuk memanggil loginSystem
        LoginSystem program = new LoginSystem();
        program.runProgram();
    }

    public void runProgram() {
        userList.add(new Admin("admin332", "password332"));
        userList.add(new Mahasiswa("Nur Muhammad Yazid Salim", "202410370110332"));

        Scanner scanner = new Scanner(System.in);
        User loggedInUser = null;

        System.out.println("\n=== Sistem Login ===");

        while (loggedInUser == null) {
            System.out.print("Masukkan username/nama: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password/NIM: ");
            String password = scanner.nextLine();

            try {loggedInUser = Login(username, password);
                 if (loggedInUser == null) {throw new loginExeptions("\nUser not found!");}

                 System.out.println("Login berhasil!");
                 loggedInUser.displayInfo(username, password);
                 loggedInUser.displayAppMenu();}
            catch (loginExeptions e)
                {System.out.println("ERROR: " + e.getMessage());
                 System.out.println("Silakan coba lagi.\n");}}
        scanner.close();}

    public static User Login(String userInput, String passInput) {
        for (User u : userList) {
            if (u instanceof Admin admin)
               {if (admin.getNama().equals(userInput) && admin.getNim().equals(passInput)) {
                    return admin;}}
            else if (u instanceof Mahasiswa mhs)
               {if (mhs.getNama().equals(userInput) && mhs.getNim().equals(passInput))
                   {return mhs;}}}
        return null;}
}