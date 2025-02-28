import java.time.LocalDateTime;
import java.util.Scanner;

public class Codelab_1{
    public static void main(String[] args) {
        //Memanggil Scanner
        Scanner scan = new Scanner(System.in);

        //Meminta Input User untuk Variabel Nama
        System.out.print("Masukkan Nama: ");
        String nama = scan.nextLine();

        //Meminta Input User untuk Variabel Jenis Kelamin
        System.out.print("Masukkan Jenis Kelamin (L/P): ");
        char kelamin = scan.next().charAt(0);
        String jenis_kelamin="NULL";

        //Memproses Input pilihan Jenis Kelamin
        switch (kelamin){
            case 'L':
            case 'l':
                jenis_kelamin = "Laki-laki";
                break;
            case 'P':
            case 'p':
                jenis_kelamin = "Perempuan";
                break;
            default: jenis_kelamin = "Non Binary";}

        //Meminta Input Tahun Lahir
        System.out.print("Masukkan Tahun Lahir: ");
        int lahir = scan.nextInt();

        //Menghitung Umur dengan menggunakan Local Date Time (Base from BIOS)
        int umur = LocalDateTime.now().getYear() - lahir;

        //Menampilkan seluruh hasil input dan perhitungan umur
        System.out.println("\nData Diri");
        System.out.printf("Nama          : %s\n", nama);
        System.out.printf("Jenis Kelamin : %s\n", jenis_kelamin);
        System.out.printf("Umur          : %d\n", umur);

        //Memulangkan scanner
        scan.close();
    }
}