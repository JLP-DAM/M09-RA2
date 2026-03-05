import java.util.Random;

public class Filosof extends Thread {
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;

    private int index;

    private long iniciGana = System.currentTimeMillis() / 1000;
    private long fiGana = System.currentTimeMillis() / 1000;
    private long gana = iniciGana - fiGana;

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
        forquillaEsquerra.agafa(this);
    }

    private void agafarForquillaDreta() {        
        forquillaDreta.agafa(this);
    }

    private void agafarForquilles() {
        agafarForquillaEsquerra();
        agafarForquillaDreta();
    }

    private void deixarForquilles() {
        print("deixa les forquilles");

        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
    }

    public void menjar() {
        while (true) {

            agafarForquilles();

            print(String.format("té forquilles esq(%s) i dreta(%s)", forquillaEsquerra.getIndex(), forquillaDreta.getIndex()));
            print("menja amb gana " + calcularGana());

            espera(random.nextLong(1500, 2000));

            deixarForquilles();

            resetGana();

            print("ha acabat de menjar");
        }
    }

    public long calcularGana() {
        fiGana = (System.currentTimeMillis() / 1000);
        
        gana = fiGana - iniciGana;

        return gana;
    }

    public void resetGana() {
        iniciGana = System.currentTimeMillis() / 1000;
        fiGana = System.currentTimeMillis() / 1000;
        gana = iniciGana - fiGana;
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


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
