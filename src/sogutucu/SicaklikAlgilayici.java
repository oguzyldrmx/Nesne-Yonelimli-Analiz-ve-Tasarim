package sogutucu;
import java.util.Random;
public class SicaklikAlgilayici implements ISicaklikAlgilayici{
    private int sicaklik;

    public SicaklikAlgilayici(){
        Random rand = new Random();
        sicaklik = rand.nextInt(50);
    }

    public int SicaklikDondur(){
        return sicaklik;
    }
}
