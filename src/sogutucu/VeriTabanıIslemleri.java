package sogutucu;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class VeriTabanıIslemleri {

    private static VeriTabanıIslemleri instance;
    ArrayList<String> kullaniciadlari = new ArrayList<String>();
    ArrayList<String> kullanicisifreleri = new ArrayList<String>();
    ArrayList<String> kullanicinolari = new ArrayList<String>();

    private VeriTabanıIslemleri(){
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5252/sogutucu",
                    "postgres", "56791384812o");
            if (conn != null)
                System.out.println("Veritabanına başarıyla bağlanıldı!");
            else
                System.out.println("Bağlantı başarısız!");


            String sql= "SELECT \"no\", \"ad\", \"sifre\"  FROM \"kullanici\"";


            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sql);

            conn.close();

            String kullaniciNo= null;
            String kullaniciAdi=null;
            String sifre;

            while(results.next())
            {
                /***** Kayda ait alan değerlerini değişkene ata *****/
                kullaniciNo  = results.getString("no");
                kullaniciAdi = results.getString("ad");
                sifre = results.getString("sifre");

                kullanicinolari.add(kullaniciNo);
                kullaniciadlari.add(kullaniciAdi);
                kullanicisifreleri.add(sifre);
            }

            /***** Kaynakları serbest bırak *****/
            results.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static synchronized VeriTabanıIslemleri getInstance(){

        if(instance==null)
            instance = new VeriTabanıIslemleri();

        return instance;

    }

    public ArrayList<String> KullaniciNoDondur(){

        return kullanicinolari;
    }


    public boolean KullaniciDogrula(String kullaniciAdi, String sifre) {
        System.out.println("Kullanıcı sorgulanıyor...");
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println(e);
        }
        //Veritabanındaki veriler ile kullanıcıdan alınan veriler karşılaştırılarak kullanıcı doğrulama işlemi yapılıyor
        for (int i = 0; i < kullaniciadlari.size(); i++) {
            if ((kullaniciadlari.get(i).equals(kullaniciAdi) && kullanicisifreleri.get(i).equals(sifre)) ) {
                System.out.println("Kullanici dogrulandi...\n");
                return true;
            }
        }
        System.out.println("Kullanici dogrulanamadi...\n");
        return false;
    }

}
