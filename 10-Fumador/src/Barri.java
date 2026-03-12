public class Barri {
    Estanc estanc;

    Fumador[] fumadors = new Fumador[3];

    public Barri() {
        estanc = new Estanc();

        for (int index = 0; index < fumadors.length; index++) {
            fumadors[index] = new Fumador(estanc, index);
        }
    }

    public static void main(String[] args) {
        Barri barri = new Barri();

        barri.estanc.start();

        for (int index = 0; index < barri.fumadors.length; index++) {
            barri.fumadors[index].start();
        }

        for (int index = 0; index < barri.fumadors.length; index++) {
            try {
                barri.fumadors[index].join();
            } catch(Exception exception) {}
        }

        barri.estanc.tancarEstanc();
    }
}
