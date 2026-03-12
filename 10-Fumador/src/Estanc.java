import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc extends Thread {
    List<Tabac> tabacs = new ArrayList<Tabac>();
    List<Llumi> llumis = new ArrayList<Llumi>();
    List<Paper> papers = new ArrayList<Paper>();

    Random random = new Random();

    public Estanc() {}

    public void nouSubministrament() {
        switch(random.nextInt(1, 4)) {
            case 1:
                addTabac();
            case 2:
                addLlumi();
            case 3:
                addPaper();
        }
    }

    public synchronized void addTabac() {
        System.out.println("Afegint Tabac");

        tabacs.add(new Tabac());

        notifyAll();
    }

    public synchronized void addLlumi() {
        System.out.println("Afegint Llumí");

        llumis.add(new Llumi());

        notifyAll();
    }

    public synchronized void addPaper() {
        System.out.println("Afegint Paper");

        papers.add(new Paper());

        notifyAll();
    }

    public synchronized Tabac venTabac() {
        while (tabacs.isEmpty()) {
            try {
                wait();
            } catch (Exception exception) {
            }
        }
        
        Tabac tabac = tabacs.remove(tabacs.size() - 1);

        return tabac;
    }

    public synchronized Llumi venLlumi() {
        while (llumis.isEmpty()) {
            try {
                wait();
            } catch (Exception exception) {
            }
        }
        
        Llumi llumi = llumis.remove(llumis.size() - 1);

        return llumi;
    }

    public synchronized Paper venPaper() {
        while (papers.isEmpty()) {
            try {
                wait();
            } catch (Exception exception) {
            }
        }
        
        Paper paper = papers.remove(papers.size() - 1);

        return paper;
    }

    public void tancarEstanc() {
        System.out.println("Estanc tancat");
        System.exit(0);
    }

    private void espera(long temps) {
        try {
            Thread.sleep(temps);
        } catch (Exception exception) {}
    }

    @Override
    public void run() {
        System.out.println("Estanc obert");

        while (true) {
            espera(random.nextLong(500, 1000));

            nouSubministrament();
        }
    }
}