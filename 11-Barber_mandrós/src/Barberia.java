import java.util.LinkedList;

public class Barberia {
    private static Barberia barberia = null;
    
    private LinkedList<Client> salaEspera;

    private Barber condBarber;

    private int quantitatCadires;

    private Barberia(int cadires) {
        quantitatCadires = cadires;

        salaEspera = new LinkedList<Client>();
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

    public Barber getCondBarber() {
        return condBarber;
    }

    public void setCondBarber(Barber condBarber) {
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

        System.out.println("Client " + client.getNom() + " en espera.");
    }
}
