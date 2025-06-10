package com.praktikum.model;

import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

import java.util.ArrayList;

public class DataStore {
    public static ArrayList<User> userList = new ArrayList<>();

    static {
        userList.add(new Admin("Admin", "0000"));
        userList.add(new Mahasiswa("Nur Muhammad Yazid Salim", "202410370110332"));}

    public static User validateLogin(String role, String kuAdmin, String kpAdmin) {
        for (User user : userList) {
            if ((role.equals("Admin") && user instanceof Admin) || (role.equals("Mahasiswa") && user instanceof Mahasiswa)) {
                if (user.login(kuAdmin, kpAdmin)) {
                    return user;}}}
        return null;}
}