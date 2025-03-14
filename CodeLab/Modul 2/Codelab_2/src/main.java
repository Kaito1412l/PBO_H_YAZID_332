public class main {
    public static void main(String[] args) {
        rekeningBank rekening1 = new rekeningBank();
        rekeningBank rekening2 = new rekeningBank();

        rekening1.nomorRekening = "202410370110332";
        rekening1.namaPemilik = "Nur Muhammad Yazid Salim";
        rekening1.saldoRekening = 1000000;

        rekening2.nomorRekening = "202410370110358";
        rekening2.namaPemilik = "Reyhan Aditya Prasetyo";
        rekening2.saldoRekening = 1000000;

        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        rekening1.setorUang();
        rekening2.setorUang();

        rekening1.tarikUang();
        rekening2.tarikUang();

        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}
