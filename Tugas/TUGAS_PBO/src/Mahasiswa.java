import java.util.Scanner;

//Menyatakan sebagai SubClass dari User
public class Mahasiswa extends User {
    //Menyatakan variabel Final/CONST untuk Username dan Password
    private final String kuSiswa = "Nur Muhammad Yazid Salim";
    private final String kpSiswa = "202410370110332";
    private Scanner inputMahasiswa = new Scanner(System.in);

    //Menyatakan Atribut dari superClass
    public Mahasiswa(String kUser, String kPass) {
        super(kUser, kPass);}

    //Override atau lanjutan dari Login di SuperClass
    @Override
    public boolean login() {
        System.out.printf("\nMemulai proses Login Mahasiswa\n");
        System.out.print("Masukkan Nama: ");
        String mUser  = inputMahasiswa.nextLine();
        System.out.print("Masukkan NIM: ");
        String mPass = inputMahasiswa.nextLine();

        //Melakukan proses pengecekan input User dan Pass
        if (this.kuSiswa.equals(mUser ) && this.kpSiswa.equals(mPass))
        {System.out.println("\nLogin Mahasiswa Berhasil.");
            return true;}
        else
        {System.out.println("\nLogin Gagal! Nama atau NIM Salah.");
            return false;}
    }

    //Override dari method displayInfo()
    @Override
    public void displayInfo() {
        if (login())
        {super.displayInfo();}
    }
}