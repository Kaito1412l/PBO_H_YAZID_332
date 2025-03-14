import java.util.Scanner;

public class rekeningBank {
    String nomorRekening;
    String namaPemilik;
    double saldoRekening;
    Scanner inputJumlah = new Scanner(System.in);

    void tampilkanInfo(){
        System.out.printf("\nNomor Rekening : %s\n", nomorRekening);
        System.out.printf("Nama Pemilik   : %s\n", namaPemilik);
        System.out.printf("Saldo          : %.0f\n", saldoRekening);
    }

    void setorUang(){
        System.out.printf("\n%s Menyetor. \nMasukkan Jumlah: ", namaPemilik);
        double setor = inputJumlah.nextDouble();
        saldoRekening = saldoRekening + setor;
        System.out.printf("(Berhasil) \nSaldo Saat ini: %.0f\n", saldoRekening);}

    void tarikUang() {
        System.out.printf("\n%s Menarik. \nMasukkan Jumlah: ", namaPemilik);
        double tarik = inputJumlah.nextDouble();
        if (tarik <= saldoRekening)
           {saldoRekening = saldoRekening - tarik;
            System.out.printf("(Berhasil) \nSaldo Saat ini: %.0f\n", saldoRekening);}
        else {System.out.printf("(Gagal, Saldo tidak cukup) \nSaldo Saat Ini: %.0f\n", saldoRekening);}
    }
}
