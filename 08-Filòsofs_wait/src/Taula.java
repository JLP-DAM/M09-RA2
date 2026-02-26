public class Taula {
    private Filosof[] comensals;
    private Forquilla[] forquilles;

    public Taula(int quantitat) {
        this.comensals = new Filosof[quantitat];
        this.forquilles = new Forquilla[quantitat];

        for (int index = 0; index < quantitat; index++) {
            comensals[index] = new Filosof("fil" + index, index);
            forquilles[index] = new Forquilla(index);
        }

        for (int index = 0; index < quantitat; index++) {
            Filosof comensal = comensals[index];

            comensal.setForquillaEsquerra(forquilles[index]);
            comensal.setForquillaDreta(forquilles[(index + 1) % quantitat]);
        }
    }

    public void showTaula() {
        for (int index = 0; index < comensals.length; index++) {
            Filosof comensal = comensals[index];

            System.out.println(String.format("Comensal:%s esq:%s dret:%s", comensal.getName(), comensal.getForquillaEsquerra().getIndex(), comensal.getForquillaDreta().getIndex()));
        }
    }

    public void cridarATaula() {
         for (int index = 0; index < comensals.length; index++) {
            comensals[index].start();
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);

        taula.showTaula();
        System.out.println("----------------");
        taula.cridarATaula();
    }
}
