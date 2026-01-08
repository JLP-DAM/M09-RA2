public class Motor extends Thread {

    int potencia;
    
    public Motor(String nom) {
        super(nom);
    }

    @Override
    public void run() {
        Thread.yield();
    }

    public void setPotencia(int potencia) {

        System.out.println(this.getState() + ", " + currentThread());

        int canvi = (this.potencia == potencia ? 0 : this.potencia > potencia ? -1 : 1);

        System.out.println(
            String.format("%s: %s Objectiu: %s Actual: %s", this.getName(), canvi == 0 ? "FerRes" : canvi == 1 ? "Incre." : "Decre.", potencia, this.potencia + canvi)
        );

        long tempsADormir = 1000 + ((long) (Math.random() * 1000));
        
        try {
            Thread.sleep(tempsADormir);
        } catch(Exception exception) {}

        this.potencia = potencia;
    }
}