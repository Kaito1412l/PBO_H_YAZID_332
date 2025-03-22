public class karakterUmum {
    //Menyatakan Atribut Yang Bersifat Private
    private String nama;
    private int kesehatan;

    public karakterUmum(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;}

    //Method Setter & Getter Untuk Atribut Nama
    public void setNama(String nama) {
        this.nama = nama;}
    public String getNama() {
        return nama;}

    //Method Setter & Getter Untuk Atribut Kesehatan
    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;}
    public int getKesehatan() {
        return kesehatan;}

    // Method ini akan di-override oleh subclass
    public void serang(karakterUmum target) {}}