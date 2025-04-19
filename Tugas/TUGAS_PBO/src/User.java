public class User {
    //Menyatakan Atribut yang bersifat Private
    private String kUser;
    private String kPass;

    //Constructor untuk menginisialisasi nama dan nim
    public User(String nama, String nim) {
        this.kUser = nama;
        this.kPass = nim;}

    //Getter dan Setter untuk nama
    public String getNama() {
        return kUser;}
    public void setNama(String nama) {
        this.kUser = nama;}

    //Getter dan Setter untuk nim
    public String getNim() {
        return kPass;}
    public void setNim(String nim) {
        this.kPass = nim;}

    //Method ini akan di-override oleh subClass
    public boolean login() {
        return false;}

    //Method untuk menampilkan informasi pengguna
    public void displayInfo() {
        System.out.println("Nama: " + kUser);
        System.out.println("NIM: " + kPass);}
}