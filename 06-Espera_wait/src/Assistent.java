import java.util.Random;

public class Assistent extends Thread {
    Esdeveniment esdeveniment = null;

    Random random = new Random();

    public Assistent(String nom, Esdeveniment esdeveniment) {
        this.setName(nom);

        this.esdeveniment = esdeveniment;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextLong(0, 1001));
            } catch (Exception exception) {}

            if (random.nextLong(0, 101) <= 30) {
                esdeveniment.ferReserva(this);
            } else {
                esdeveniment.cancelaReserva(this);
            }
        }
    }
}