import java.util.Random;

public class Treballador extends Thread {
    private float sou_anual_brut;

    private int edat_inici_treball;
    private int edat_final_treball;
    private int edat_actual;

    private float cobrat;

    private Random rnd;

    public Treballador(float sou_anual_brut, int edat_inici_treball, int edat_final_treball, String nom) {
        this.sou_anual_brut = sou_anual_brut;

        this.edat_inici_treball = edat_inici_treball;
        this.edat_final_treball = edat_final_treball;

        this.edat_actual = 0;

        this.cobrat = 0.0f;

        this.rnd = new Random();

        this.setName(nom);
    }

    @Override
    public void run() {
        edat_actual = edat_inici_treball;

        while (edat_actual < edat_final_treball) {
            for (int index = 1; index <= 12; index++) {
                cobra();
                pagaImpostos();
            }

            edat_actual++;
        }

        try {
            Thread.sleep(rnd.nextInt(1, 2));
        } catch(Exception exception) {}
    }

    public void cobra() {
        cobrat = cobrat + (sou_anual_brut / 12);
    }

    public void pagaImpostos() {
        cobrat = cobrat - ((sou_anual_brut / 12) * 0.24f);
    }


    public int getEdat() {
        return edat_actual;
    }

    public float getCobrat() {
        return cobrat;
    }
}