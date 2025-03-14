import java.util.Scanner;

public class rekeningBank {
    //Menyatakan Atribut
    String nomorRekening;
    String namaPemilik;
    double saldoRekening;
    Scanner scan = new Scanner(System.in);

    void infoPilihan() {
        //Menampilkan Output Pilihan
        System.out.println("\n=====Pilihan=====");
        System.out.println("1. Tampilkan Info");
        System.out.println("2. Setor Uang");
        System.out.println("3. Tarik Uang");
        System.out.println("4. Keluar");
        System.out.print("Masukkan Pilihan: ");}

    void tampilkanInfo(){
        //Menampilkan Output Info Rekening
        System.out.printf("\nNomor Rekening : %s\n", nomorRekening);
        System.out.printf("Nama Pemilik   : %s\n", namaPemilik);
        System.out.printf("Saldo          : %.0f\n", saldoRekening);}

    void setorUang(){
        //Memproses Setor Uang
        System.out.printf("\n%s Menyetor. \nMasukkan Jumlah: ", namaPemilik);
        double setor = scan.nextDouble();
        saldoRekening = saldoRekening + setor;
        //Menyatakan Keberhasilan Proses
        System.out.printf("(Berhasil) \nSaldo Saat ini: %.0f\n", saldoRekening);}

    void tarikUang() {
        //Memproses Tarik Uang
        System.out.printf("\n%s Menarik. \nMasukkan Jumlah: ", namaPemilik);
        double tarik = scan.nextDouble();
        if (tarik <= saldoRekening)
           {saldoRekening = saldoRekening - tarik;
            //Menyatakan Keberhasilan Proses
            System.out.printf("(Berhasil) \nSaldo Saat ini: %.0f\n", saldoRekening);}
        else {System.out.printf("(Gagal, Saldo tidak cukup) \nSaldo Saat Ini: %.0f\n", saldoRekening);}}}