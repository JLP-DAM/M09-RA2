import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BanyUnisex {
    private static final int BANY_BUIT = 0;
    private static final int BANY_AMB_HOMES = 1;
    private static final int BANY_AMB_DONES = 2;

    private static final int CAPACITAT_MAX = 3;

    private int estatActual = BANY_BUIT;
    private int ocupants = 0;
    private int capacitat = CAPACITAT_MAX;
    private Semaphore semafor = new Semaphore(CAPACITAT_MAX, true);
    private ReentrantLock lockEstat = new ReentrantLock(true);

    public void entraHome() {
        if (!lockEstat.isHeldByCurrentThread()) {return;}
        if (estatActual != BANY_BUIT && estatActual != BANY_AMB_HOMES) {return;}
        if (ocupants >= capacitat) {return;}

        lockEstat.lock();

        estatActual = BANY_AMB_HOMES;

        ocupants++;

        System.out.println("Home entra al bany. Ocupants: " + ocupants);

        lockEstat.unlock();
    }

    public void entraDona() {
        if (!lockEstat.isHeldByCurrentThread()) {return;}
        if (estatActual != BANY_BUIT && estatActual != BANY_AMB_DONES) {return;}
        if (ocupants >= capacitat) {return;}

        lockEstat.lock();

        estatActual = BANY_AMB_DONES;

        ocupants++;

        System.out.println("Dona entra al bany. Ocupants: " + ocupants);

        lockEstat.unlock();
    }

    public void surtHome() {
        if (!lockEstat.isHeldByCurrentThread()) {return;}
        if (estatActual != BANY_AMB_HOMES) {return;}
        if (ocupants <= 0) {return;}

        lockEstat.lock();

        ocupants--;

        if (ocupants <= 0) {
            estatActual = BANY_BUIT;
        }

        
        System.out.println("Home surt del bany. Ocupants: " + ocupants);

        lockEstat.unlock();
    }

    public void surtDona() {
        if (!lockEstat.isHeldByCurrentThread()) {return;}
        if (estatActual != BANY_AMB_DONES) {return;}
        if (ocupants <= 0) {return;}

        lockEstat.lock();

        ocupants--;

        if (ocupants <= 0) {
            estatActual = BANY_BUIT;
        }
        
        System.out.println("Home surt del bany. Ocupants: " + ocupants);

        lockEstat.unlock();
    }

    public static void main(String[] args) {
        BanyUnisex lavabo = new BanyUnisex();

        for (int index = 0; index < 5; index++) {
            (new Home("Home-" + index, lavabo)).start();
        }

        for (int index = 0; index < 5; index++) {
            (new Dona("Dona-" + index, lavabo)).start();
        }
    }
}