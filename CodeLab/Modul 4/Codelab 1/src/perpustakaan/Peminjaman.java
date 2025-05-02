// Menyatakan Package
package perpustakaan;

//Menyatakan interface
public interface Peminjaman {
    // Menyatakan Method yang akan diimplementasikan oleh Class lain
    void pinjamBuku(String judul, int durasi);
    void kembalikanBuku(String judul);
}