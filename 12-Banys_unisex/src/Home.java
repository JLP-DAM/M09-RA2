import java.util.Random;

public class Home extends Thread {
    private BanyUnisex lavabo;

    public Home(String nom, BanyUnisex lavabo) {
        this.setName(nom);
        this.lavabo = lavabo;
    }

    public void utilitzaLavabo() {
        Random random = new Random();

        try {
            Thread.sleep(random.nextLong(1000, 2000));
        } catch(Exception exception) {}
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " vol entrar al bany");

        lavabo.entraHome();
        utilitzaLavabo();
        lavabo.surtHome();
    }
}
