package sogutucu;

public class Main {

    public static void main(String[] args) {
        Kullanici1 k1 = new Kullanici1();
        Kullanici2 k2 = new Kullanici2();

        Publisher p = new Publisher();

        p.attach(k1);
        p.attach(k2);

        Sogutucu basla = new Sogutucu();
    }

}
