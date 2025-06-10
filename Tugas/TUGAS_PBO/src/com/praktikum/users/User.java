package com.praktikum.users;

public abstract  class User {
    //Menyatakan Atribut yang bersifat Private
    String kUser;
    String kPass;

    //Constructor untuk menginisialisasi nama dan nim
    public User(String nama, String nim) {
        this.kUser = nama;
        this.kPass = nim;}

    //Getter dan Setter untuk nama
    public String getNama() {
        return kUser;}
    public void setNama(String nama) {
        this.kUser = nama;}

    //Getter dan Setter untuk nim
    public String getNim() {
        return kPass;}
    public void setNim(String nim) {
        this.kPass = nim;}

    //Method ini akan di-override oleh subClass
    public abstract boolean login(String input1, String input2);

    //Method untuk menampilkan informasi pengguna
    public abstract void displayInfo();

    public abstract void displayMenuApp();

    public abstract void displayAppMenu() ;
}