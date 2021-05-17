package sogutucu;
import java.io.*;
import java.util.Scanner;
public class Sogutucu {
    public Sogutucu() {
        String kullaniciAdi;
        String sifre;
        boolean key = false;
        do{
            System.out.println("Lütfen sistemde kayıtlı kullanıcı adı ve şifrenizi giriniz..");
            Scanner reader = new Scanner(System.in);
            System.out.print("Kullanici Adi: ");
            kullaniciAdi = reader.next();
            System.out.print("Sifre: ");
            sifre = reader.next();

            if (VeriTabanıIslemleri.getInstance().KullaniciDogrula(kullaniciAdi, sifre)) {
                AgArayuzu arayuz = new AgArayuzu();
                key = true;
            }
        }while(!key);

    }
}
