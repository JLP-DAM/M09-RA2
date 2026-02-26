import java.util.Random;

public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;

    private int gana;

    private Random random = new Random();

    public Filosof(String nom) {
        this.setName(nom);
    }

    private void print(String missatge) {
        System.out.println("Filòsof: " + this.getName() + " " + missatge);
    }

    private void espera(long temps) {
        try {
            Thread.sleep(temps);
        } catch(Exception exception) {}
    }

    public void menjar() {
        while (true) {

            if (forquillaEsquerra.getEnUs()) {
                espera(random.nextLong(500, 1000)); 
                
                continue;
            }

            forquillaEsquerra.setEnUs(true);

            print("agafa la forquilla esquerra " + forquillaEsquerra.getIndex());

            if (forquillaDreta.getEnUs()) {
                forquillaEsquerra.setEnUs(false);

                print("deixa la forquilla esquerra(" + forquillaEsquerra.getIndex() + ") i espera (dreta ocupada)");
                gana++;
                print("gana=" + gana);
                espera(random.nextLong(500, 1000)); 
                continue;
            }

            forquillaDreta.setEnUs(true);
            print("agafa la forquilla dreta " + forquillaDreta.getIndex());
            print("menja");

            espera(random.nextLong(1500, 2000));

            gana = 0;

            forquillaEsquerra.setEnUs(false);
            forquillaDreta.setEnUs(false);

            print("ha acabat de menjar");
        }
    }

    public void pensar() {
        print("pensant");

        espera(random.nextLong(1000, 2000));
    }

    @Override
    public void run() {
        while(true) {
            menjar();
            pensar();
        }
    }

    public Forquilla getForquillaDreta() {
        return forquillaDreta;
    }

    public void setForquillaDreta(Forquilla forquillaDreta) {
        this.forquillaDreta = forquillaDreta;
    }


    public Forquilla getForquillaEsquerra() {
        return forquillaEsquerra;
    }

    public void setForquillaEsquerra(Forquilla forquillaEsquerra) {
        this.forquillaEsquerra = forquillaEsquerra;
    }


    public int getGana() {
        return gana;
    }

    public void setGana(int gana) {
        this.gana = gana;
    }
}
