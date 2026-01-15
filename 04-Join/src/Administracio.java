public class Administracio {
    int num_poblacio_activa = 50;

    Treballador[] treballadors = new Treballador[num_poblacio_activa];

    public Administracio() {
        for (int index = 0; index < num_poblacio_activa; index++) {
            treballadors[index] = new Treballador(25000, 20, 65, "Ciutadà-" + index);
        }
    }

    public static void main(String[] args) throws Exception {
        Administracio administracio = new Administracio();

        System.out.println("HI");

        for (int index = 0; index < administracio.treballadors.length; index++) {
            Treballador treballador = administracio.treballadors[index];

            treballador.start();
            treballador.join();

            System.out.println(String.format("%s -> edat: %s / total: %.2f", treballador.getName(), treballador.getEdat(), treballador.getCobrat()));
        }
    }
}
