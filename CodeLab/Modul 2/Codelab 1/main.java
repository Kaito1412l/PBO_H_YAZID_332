public class main {
    public static void main(String[] args) {
        //Memanggil Class Hewan
        hewan hewan1 = new hewan();
        hewan hewan2 = new hewan();

        //Menyatakan Isi Dari Info Hewan
        hewan1.nama = "Kucing";
        hewan1.jenis = "Mamalia";
        hewan1.suara = "Nyann~~";

        hewan2.nama = "Anjing";
        hewan2.jenis = "Mamalia";
        hewan2.suara = "Woof-Woof!!";

        //Memanggil Info Hewan
        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();}}