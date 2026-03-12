import java.util.Random;

public class Fumador extends Thread {
    Estanc estanc;
    int id;
    Tabac tabac;
    Llumi llumi;
    Paper paper;
    int fumades;

    Random random = new Random();

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;

        this.setName(id + "");
    }
    
    private void espera(long temps) {
        try {
            Thread.sleep(temps);
        } catch (Exception exception) {}
    }

    private void print(String missatge) {
        System.out.println("Fumador: " + this.getName() + " " + missatge);
    }

    public void fuma() {
        if (tabac == null || llumi == null || paper == null) {return;}

        tabac = null;
        llumi = null;
        paper = null;

        fumades = fumades + 1;

        print("ha fumat " + fumades + " vegades");

        espera(random.nextLong(500, 1000));
    }

    public void compraTabac() {        
        tabac = estanc.venTabac();

        print("comprant Tabac");
    }

    public void compraLlumi() {
        llumi = estanc.venLlumi();

        print("comprant Llumi");
    }

    public void compraPaper() {
        paper = estanc.venPaper();

        print("comprant Paper");
    }

    @Override
    public void run() {
        while (fumades <= 2) {
            espera(random.nextLong(500, 1000));
            compraTabac();
            espera(random.nextLong(500, 1000));
            compraLlumi();
            espera(random.nextLong(500, 1000));
            compraPaper();
            espera(random.nextLong(500, 1000));
            fuma();
        }
    }
}
