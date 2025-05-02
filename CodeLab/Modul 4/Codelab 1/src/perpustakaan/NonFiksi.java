//Menyatakan Package
package perpustakaan;

// Menyatakan sebagai subClass dari Buku
public class NonFiksi extends Buku {
    // Menyatakan Atribut dari superClass Buku
    public NonFiksi(String judul, String penulis) {
        super(judul, penulis);}

    // Override dari Method displayInfo() pada superClass Buku
    @Override
    public void displayInfo() {
        System.out.println("Buku Non-Fiksi: " + judul + " oleh " + penulis + " (Bidang: Sejarah & Ilmu Pengetahuan )");}
}