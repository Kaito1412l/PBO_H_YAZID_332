import java.util.Scanner;

public class loginSystem {
    public static void main(String[] args) {
        //inisialisasi untuk memanggil kegiatan 1
        loginSystem program = new loginSystem();
        program.runProgram();
    }

    public void runProgram() {
        //Memanggil Class Admin Dan Mahasiswa
        admin Admin = new admin();
        mahasiswa Mahasiswa = new mahasiswa();
        //Memanggil Scanner
        Scanner scan = new Scanner(System.in);

        //Menampilkan Tampilan Awal atau Pilihan Program Login
        displayPilihan();

        //Meminta Input Pilihan Login
        System.out.print("Masukkan Pilihan: ");
        int pilihan = scan.nextInt();

        //Memproses Input Pilihan
        switch (pilihan) {
            case 1 -> Admin.login();
            case 2 -> Mahasiswa.login();
            default -> System.out.println("\nPilihan tidak valid");}

        //Memulangkan Scanner
        scan.close();}

    //Method Untuk Pilihan Login
    void displayPilihan(){
        System.out.println("\n==========Program Dimulai==========\n");
        System.out.println("Pilihan Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");}
}
