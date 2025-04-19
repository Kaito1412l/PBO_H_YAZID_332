import java.util.Scanner;

//Menyatakan sebagai SubClass dari User
public class Admin extends User {
    //Menyatakan variabel Final/CONST untuk Username dan Password
    private final String kuAdmin = "admin332";
    private final String kpAdmin = "password332";
    private Scanner inputAdmin = new Scanner(System.in);

    //Menyatakan Atribut dari superClass
    public Admin(String kUser, String kPass) {
        super(kUser, kPass);}

    //Override atau lanjutan dari Login di SuperClass
    @Override
    public boolean login() {
        System.out.printf("\nMemulai proses Login Admin\n");
        System.out.print("Masukkan Username: ");
        String aUser  = inputAdmin.nextLine();
        System.out.print("Masukkan Password: ");
        String aPass = inputAdmin.nextLine();

        //Melakukan proses pengecekan input User dan Pass
        if (kuAdmin.equals(aUser ) && kpAdmin.equals(aPass))
        {System.out.println("\nLogin Admin Berhasil.");
            return true;}
        else
        {System.out.println("\nLogin Gagal! Username atau Password Salah.");
            return false;}
    }

    //Override dari method displayInfo()
    @Override
    public void displayInfo() {
        if (login())
        {super.displayInfo();}
    }
}