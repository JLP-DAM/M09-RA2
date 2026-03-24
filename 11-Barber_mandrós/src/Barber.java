public class Barber extends Thread {
    public Barber(String nom) {
        this.setName(nom);
    }

    @Override
    public void run() {
        Barberia barberia = Barberia.getInstancia();

        while (true) {
            if (barberia.getSalaEspera().size() <= 0) {
                try {
                    System.out.println("Ningú en espera");
                    System.out.println("Barber " + this.getName() + " dormint");

                    synchronized (barberia.getCondBarber()) {
                        barberia.getCondBarber().wait();
                    }

                } catch(Exception exception) {}
            }

            Client client = barberia.seguentClient();

            client.tallarseElCabell();
        }
    }
}