//Menyatakan Sebagai SubClass Dari KarakterUmum
public class pahlawan extends karakterUmum {
    //Menyatakan Atribut Dari SuperClass
    public pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);}

    //Override Atau Lanjutan Dari Serang Di SuperClass
    @Override
    public void serang(karakterUmum target) {
        //Menyatakan Siapan Yang Menyerang Dan Diserang
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan Snake bite!");
        //Mengurangi Kesehatan Target Setelah Diserang
        target.setKesehatan(target.getKesehatan() - 20);
        //Menyatakan Sisa Kesehatan Setelah Dikurangi
        System.out.println(target.getNama() + " sekarang memiliki Kesehatan: " + target.getKesehatan());}}