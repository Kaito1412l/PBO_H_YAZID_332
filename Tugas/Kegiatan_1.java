import java.util.Scanner;

public class Kegiatan_1 {
    public static void main(String[] args) {
        //Menyatakan Variabel Final/CONST Untuk Username dan Password
        final String kuadmin = "admin332";
        final String kpadmin = "password332";
        final String kusiswa = "Nur Muhammad Yazid Salim";
        final String kpsiswa = "202410370110332";

        //Memanggil Scanner
        Scanner scan = new Scanner(System.in);

        //Menampilkan Tampilan Awal atau Pilihan Program Login
        String user, pass;
        System.out.println("==========Program Dimulai==========");
        System.out.println("Pilih Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");

        //Meminta Input Pilihan Login
        System.out.print("Masukkan Pilihan: ");
        int pilihan = scan.nextInt();
        //Membersihkan Buffer Input pada Scanner
        scan.nextLine();

        //Memproses Input Pilihan
        switch (pilihan){
            case 1:
                //Memproses Pilihan Login Admin
                System.out.print("Masukkan Username: ");
                user = scan.nextLine();
                System.out.print("Masukkan Password: ");
                pass = scan.nextLine();
                //Melakukan Proses Validasi/Pengecekan Username dan Password
                if ((kuadmin.equals(user)) && (kpadmin.equals(pass)))
                   {System.out.println("\nLogin Admin Berhasil");}
                else
                   {System.out.println("\nLogin Gagal! Username atau Password Salah");}
                break;
            case 2:
                //Memproses Pilihan Login Mahasiswa
                System.out.print("Masukkan Nama: ");
                user = scan.nextLine();
                System.out.print("Masukkan NIM: ");
                pass = scan.nextLine();
                //Melakukan Proses Validasi/Pengecekan Username dan Password
                if ((kusiswa.equals(user)) && (kpsiswa.equals(pass)))
                   {//Menampilkan Data Login Mahasiswa
                    System.out.println("\nLogin Mahasiswa Berhasil");
                    System.out.println("Nama: " + kusiswa);
                    System.out.println("NIM: " + kpsiswa);}
                else
                   {System.out.println("\nLogin Gagal! Nama atau NIM Salah");}
                break;
        default:
            //Menyatakan Input Tidak ada Di Dalam Pilihan
            System.out.println("\nPilihan tidak valid"); break;}

        //Memulangkan Scanner
        scan.close();
        }
    }
