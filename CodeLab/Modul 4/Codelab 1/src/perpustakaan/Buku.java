//Menyatakan Package
package perpustakaan;

public abstract class Buku {
    // Menyatakan atribut yang bertipe Abstract dengan sifat Protected
    protected String judul;
    protected String penulis;

    // Constructor untuk menginisialisasi judul dan penulis
    public Buku(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;}

    // Method Getter judul
    public String getJudul() {
        return judul;}

    // Method ini akan di-override oleh subClass
    public abstract void displayInfo();
}