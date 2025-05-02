//Menyatakan Package
package perpustakaan;

// Mengimplementasikan Interface Peminjaman
public class Anggota implements Peminjaman {
    // Menyatakan Atribut
    private String nama;
    private String idAnggota;

    // Constructor untuk menginisialisasi nama dan idAnggota
    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;}

    // Method Getter nama dan idAnggota
    public String getNama() {
        return nama;}
    public String getIdAnggota() {
        return idAnggota;}

    // Implementasi Method pinjamBuku dari Interface Peminjaman
    @Override
    public void pinjamBuku(String judul, int durasi) {
        System.out.println(nama + " meminjam buku \"" + judul + "\" selama " + durasi + " hari.");}

    // Implementasi Method kembalikanBuku dari Interface Peminjaman
    @Override
    public void kembalikanBuku(String judul) {
        System.out.println(nama + " mengembalikan buku berjudul: " + judul);}
}