import java.util.Random;

public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;

    private int index;

    private int gana;

    private Random random = new Random();

    public Filosof(String nom, int index) {
        this.setName(nom);
        this.index = index;
    }

    private void print(String missatge) {
        System.out.println("Filòsof: " + this.getName() + " " + missatge);
    }

    private void espera(long temps) {
        try {
            Thread.sleep(temps);
        } catch (Exception exception) {
        }
    }

    private void agafarForquillaEsquerra() {
        if (forquillaEsquerra.getPropietari() != -1) {
            espera(random.nextLong(500, 1000));

            return;
        }

        forquillaEsquerra.agafa(this);

        print("agafa la forquilla esquerra " + forquillaEsquerra.getIndex());
    }

    private void agafarForquillaDreta() {
        if (forquillaEsquerra.getPropietari() != -1) {
            deixarForquilles();

            print("deixa la forquilla esquerra(" + forquillaEsquerra.getIndex() + ") i espera (dreta ocupada)");

            espera(random.nextLong(500, 1000));
            return;
        }
        
        forquillaDreta.agafa(this);

        print("agafa la forquilla dreta " + forquillaDreta.getIndex());
    }

    private void agafarForquilles() {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }

    private void deixarForquilles() {
        if (forquillaDreta.getPropietari() == index) {
            forquillaEsquerra.setPropietari(-1);
        }
        
        if (forquillaDreta.getPropietari() == index) {
            forquillaDreta.setPropietari(-1);
        }
    }

    public void menjar() {
        while (true) {

            agafarForquilles();

            print("menja");

            espera(random.nextLong(1500, 2000));

            deixarForquilles();

            print("ha acabat de menjar");
        }
    }

    public void pensar() {
        print("pensant");

        espera(random.nextLong(1000, 2000));
    }

    @Override
    public void run() {
        while (true) {
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


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
