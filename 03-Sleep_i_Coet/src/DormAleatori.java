public class DormAleatori extends Thread {

    long instantCreat;
    
    public DormAleatori(String nom) {
        super(nom);

        instantCreat = System.currentTimeMillis();
    }

    @Override
    public void run() {
        for (int index = 0; index < 10; index++) {
            long tempsADormir = (long) (Math.random() * 1000);

            System.out.println(
                String.format("%s(%s) a dormir %sms total %sms", this.getName(), index, tempsADormir, System.currentTimeMillis() - instantCreat)
            );            

            try {
                Thread.sleep(tempsADormir);
            } catch(Exception exception) {}
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("-- Fi de main -------------");
    }
}
