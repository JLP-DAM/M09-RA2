import java.util.LinkedList;

public class Barberia extends Thread {
    private static Barberia barberia = null;
    
    private LinkedList<Client> salaEspera;

    private Object condBarber;

    private int quantitatCadires;

    private Barberia(int cadires) {
        quantitatCadires = cadires;

        salaEspera = new LinkedList<Client>();

        condBarber = new Object();
    }

    public static Barberia getInstancia() {
        if (barberia == null) {
            barberia = Barberia.getInstancia(3);            
        }

        return barberia;
    }

    public static Barberia getInstancia(int cadires) {
        if (barberia == null) {
            barberia = new Barberia(cadires);
        }

        return barberia;
    }

    public LinkedList<Client> getSalaEspera() {
        return salaEspera;
    }

    public Object getCondBarber() {
        return condBarber;
    }

    public void setCondBarber(Object condBarber) {
        this.condBarber = condBarber;
    }

    public Client seguentClient() {
        if (salaEspera.size() <= 0) {return null;}

        return salaEspera.removeFirst();
    }

    public void entraClient(Client client) {
        if (salaEspera.size() >= quantitatCadires) {
            System.out.println("No queden cadires, client " + client.getNom() + " s'en va.");

            return;
        }

        salaEspera.add(client);
        System.out.println("Client " + client.getNom() + " en espera.");
    }

    public static void main(String[] args) {
        barberia = Barberia.getInstancia(3);

        Barber barber = new Barber("Pepe");

        barber.start();

        for (int index = 1; index <= 20; index++) {
            try {
                Thread.sleep(500);
            } catch (Exception exception) {}
            
            Barberia.getInstancia().entraClient(new Client(index));;    

            synchronized (Barberia.getInstancia().condBarber) {
                Barberia.getInstancia().condBarber.notify();
            }

            if (index == 10) {
                try {
                    Thread.sleep(10000);
                } catch (Exception exception) {}
            }
        }
    }
}
