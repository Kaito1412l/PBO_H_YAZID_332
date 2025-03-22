import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //Memanggil Class rekeningBank
        rekeningBank rekening1 = new rekeningBank();
        rekeningBank rekening2 = new rekeningBank();
        rekeningBank infoRekening = new rekeningBank();

        //menyatakan Isi Dari infoRekening
        rekening1.nomorRekening = "202410370110332";
        rekening1.namaPemilik = "Nur Muhammad Yazid Salim";
        rekening1.saldoRekening = 1000000;

        rekening2.nomorRekening = "202410370110358";
        rekening2.namaPemilik = "Reyhan Aditya Prasetyo";
        rekening2.saldoRekening = 1000000;

        //Memanggil Scanner
        Scanner scan = new Scanner(System.in);
        int pilihan;

        //Melakukan Looping program
        do {//Menampilkan Info Pilihan yang tersedia
            infoRekening.infoPilihan();
            //Meminta Input Pilihan dari user
            pilihan = scan.nextInt();

            //Memproses Input Pilihan
            switch (pilihan){
                //Memanggil Info Rekening
                case 1: rekening1.tampilkanInfo();
                        rekening2.tampilkanInfo();
                        break;
                //Memanggil Setor Uang
                case 2: rekening1.setorUang();
                        rekening2.setorUang();
                        break;
                //Memanggil Tarik Uang
                case 3: rekening1.tarikUang();
                        rekening2.tarikUang();
                //Menyatakan Pilihan Keluar Dari Program
                case 4: continue;
                //Menyatakan Input Tidak Sesuai
                default:System.out.println("Input Error!!");
                        break;}}
        while (pilihan != 4);

        //Memulangkan Scanner
        scan.close();}}