import java.util.Scanner;

public class admin {
    //Menyatakan Variabel Final/CONST Untuk Username dan Password
    final String kuAdmin = "admin332";
    final String kpAdmin = "password332";
    Scanner inputAdmin =  new Scanner(System.in);

    //Method untuk login admin
    void login() {
        //Memproses Pilihan Login Admin
        System.out.print("Masukkan Username: ");
        String aUser = inputAdmin.nextLine();
        System.out.print("Masukkan Password: ");
        String aPass = inputAdmin.nextLine();

        //Melakukan Proses Validasi/Pengecekan Username dan Password
        if ((kuAdmin.equals(aUser)) && (kpAdmin.equals(aPass)))
        {System.out.println("\nLogin Admin Berhasil.");}
        else
        {System.out.println("\nLogin Gagal! Username atau Password Salah.");}

        //Memulangkan Scanner
        inputAdmin.close();}
}