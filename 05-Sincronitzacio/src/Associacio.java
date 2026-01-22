public class Associacio {
    static int numSocis = 1000;
    Soci[] socis = new Soci[numSocis];

    long inici = 0;

    public Associacio() {
        for (int index = 0; index < numSocis; index++) {
            socis[index] = new Soci();
        }
    }

    public void iniciaCompteTempsSocis() {
        inici = System.currentTimeMillis();

        for (int index = 0; index < numSocis; index++) {
            socis[index].start();
        }
    }

    public void esperaPeriodeSocis() {
        for (int index = 0; index < numSocis; index++) {
            try {
                socis[index].join();
            } catch(Exception exception) {}
        }
    }

    public void mostraBalancComptes() {
        System.out.println(String.format("Saldo a la compta: %s\nS'ha tardat: %s ms", socis[0].getCompte().getSaldo(), System.currentTimeMillis() - inici));
    }

    public static void main(String[] args) {
        Associacio associacio = new Associacio();

        associacio.iniciaCompteTempsSocis();
        associacio.esperaPeriodeSocis();
        associacio.mostraBalancComptes();
    }
}