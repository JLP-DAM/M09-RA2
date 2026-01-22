import java.util.Random;

public class Soci extends Thread {
    private Compte compte = Compte.getInstancia();

    float aportacio = 10f;
    int esperaMax = 100;
    Random random = new Random();
    int maxAnys = 10;

    public Soci() {}

    public Compte getCompte() {
        return compte;
    }

    @Override
    public void run() {
        for (int any = 1; any <= maxAnys; any++) {
            for (int mes = 1; mes <= 12; mes++) {

                try {
                    Thread.sleep(random.nextLong(1, esperaMax));
                } catch(Exception exception) {}

                compte.setSaldo(compte.getSaldo() + (((mes - 1) % 2 == 0) ? 10f : 10f));
            }
        }
    }
}
