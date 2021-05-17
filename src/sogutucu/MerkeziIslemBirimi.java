package sogutucu;

public class MerkeziIslemBirimi {
    private boolean acik = false;

    public MerkeziIslemBirimi(){
        Eyleyici eyleyici = new Eyleyici();
    }

    public void EyleyiciCalistir(String durum){
        Eyleyici eyleyici = new Eyleyici();

        System.out.println("Istek eyleyiciye bildiriliyor...");
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println(e);
        }

        if(durum.equals("Ac")){ //Soğutucu zaten açık mı
            eyleyici.SogutucuAc();
            acik = true;
        }
        else { //Soğutucu zaten açık değil
            eyleyici.SogutucuKapat();
            acik = false;
        }

    }

    public boolean SogutucuAcikMi(){
        if (acik) {
            return true;
        }
        else return false;
    }

    public boolean SogutucuKapaliMi(){
        if (acik) {
            return false;
        }
        else return true;
    }


}
