public class PrincipalsIguals {
    public static void main(String[] args) {
        Fil pepe = new Fil("Pepe", Thread.MAX_PRIORITY);
        Fil juan = new Fil("Juan", Thread.MAX_PRIORITY);

        pepe.thread.start();

        juan.thread.start();

        System.out.println("Acaba thread main");
    }
}
