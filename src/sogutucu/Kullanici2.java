package sogutucu;

public class Kullanici2 implements IObserver{
    @Override
    public void update(String mesaj) {
        System.out.println("2 nolu kullanicimiz " + mesaj);
    }
}
