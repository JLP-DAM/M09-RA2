public class Compte {
    private static final Compte INSTANCIA = new Compte();
    
    private float saldo = 0f;

    private Compte() {}

    public static Compte getInstancia() {
        return INSTANCIA;
    }

    public synchronized float getSaldo() {
        return saldo;
    }

    public synchronized void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}