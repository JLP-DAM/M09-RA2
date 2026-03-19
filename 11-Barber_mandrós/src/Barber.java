import java.util.Random;

public class Barber extends Thread {
    public Barber(String nom) {
        this.setName(nom);
    }

    @Override
    public void run() {
        Barberia barberia = Barberia.getInstancia();

        Random random = new Random();

        while (true) {
            if (barberia.getSalaEspera().size() <= 0) {
                try {
                    System.out.println("Ningú en espera");
                    System.out.println("Barber " + this.getName());
                    wait();
                } catch(Exception exception) {}
            }

            Client client = barberia.seguentClient();

            if (client == null) {continue;}

            synchronized(this) {
                try {
                    this.sleep(900 + random.nextLong(0, 100));
                } catch(Exception exception) {}
            }
        }
    }
}