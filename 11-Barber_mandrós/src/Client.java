import java.util.Random;

public class Client {
    private String nom;

    public Client(int id) {
        this.nom = "Client-" + id;
    }

    public void tallarseElCabell() {
        Random random = new Random();

        System.out.println("Li toca al client " + this.getNom());
        System.out.println("Tallant cabell a " + this.getNom());

        try {
            Thread.sleep(900 + random.nextInt(0, 100));
        } catch (Exception exception) {}
    }

    public String getNom() {
        return this.nom;
    }
}