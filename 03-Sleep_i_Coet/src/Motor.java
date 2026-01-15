public class Motor extends Thread {

    int potencia = 0;
    int potenciaDesitjada = 0;
    int canvi = -2;

    public Motor(String nom) {
        super(nom);
    }

    @Override
    public void run() {
        while (true) {
            if (canvi != 1 && canvi != -1 && canvi != 0) {
                try {
                    Thread.sleep(1);
                } catch (Exception exception) {
                }

                continue;
            }

            System.out.println(
                    String.format("%s: %s Objectiu: %s Actual: %s", this.getName(),
                            canvi == 0 ? "FerRes" : canvi == 1 ? "Incre." : "Decre.", potenciaDesitjada, this.potencia + canvi));

            long tempsADormir = 1000 + ((long) (Math.random() * 1000));

            try {
                Thread.sleep(tempsADormir);
            } catch (Exception exception) {
            }

            this.potencia = potencia + canvi;

            canvi = -2;
        }
    }

    public void setPotencia(int potencia) {
        canvi = (this.potencia == potencia ? 0 : this.potencia > potencia ? -1 : 1);

        potenciaDesitjada = potencia;
    }
}