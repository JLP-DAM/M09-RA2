import java.util.List;
import java.util.ArrayList;

public class Esdeveniment {
    List<Assistent> assistents = new ArrayList<Assistent>();

    int placesMaximes = 10;
    int placesDisponibles = 10;

    public Esdeveniment(int placesMaximes) {
        this.placesMaximes = placesMaximes;
        this.placesDisponibles = placesMaximes;
    }

    public synchronized void ferReserva(Assistent assistent) {
        while (placesDisponibles <= 0) {
            try {
                wait();
            } catch (Exception exception) {
            }
        }

        placesDisponibles = placesDisponibles - 1;
        assistents.add(assistent);
        System.out.println(
                String.format("%s ha fet una reserva. Places disponibles: %s", assistent.getName(), placesDisponibles));

        notify();
    }

    public synchronized void cancelaReserva(Assistent assistent) {
        int assistentIndex = assistents.indexOf(assistent);

        if (assistentIndex == -1) {
            System.out.println(String.format("%s no ha pogut cancel·lar una reserva inexistent. Places disponibles: %s",
                    assistent.getName(), placesDisponibles));

            return;
        }

        placesDisponibles = placesDisponibles + 1;
        assistents.remove(assistentIndex);
        System.out.println(String.format("%s ha cancel·lat una reserva. Places disponibles: %s", assistent.getName(),
                placesDisponibles));

        notify();
    }
}
