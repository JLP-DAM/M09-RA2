public class Fil extends Thread {
    boolean estricte = false;

    public Fil(String nom, int prioritat) {
        this.setName(nom);
        this.setPriority(prioritat);
    }

    public Fil(String nom, int prioritat, boolean estricte) {
        this.setName(nom);
        this.setPriority(prioritat);

        this.estricte = estricte;
    }

    @Override
    public void run() {
        for (int index = 1; index <= 1000; index++) {
            System.out.println(String.format("%s %s", this.getName(), index));

            if (estricte) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException excepcio) {
                    excepcio.printStackTrace();
                }
            }
        }

        System.out.println(String.format("Acaba el fil %s", this.getName()));
    }
}
