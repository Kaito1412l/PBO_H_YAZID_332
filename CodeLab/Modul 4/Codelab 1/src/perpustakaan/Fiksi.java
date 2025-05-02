//Menyatakan Package
package perpustakaan;

// Menyatakan sebagai subClass dari Buku
public class Fiksi extends Buku {
    // Menyatakan Atribut dari superClass Buku
    public Fiksi(String judul, String penulis) {
        super(judul, penulis);}

    // Override dari Method displayInfo() pada superClass Buku
    @Override
    public void displayInfo() {
        System.out.println("Buku Fiksi: " + judul + " oleh " + penulis + " (Genre: Dongeng)");}
}