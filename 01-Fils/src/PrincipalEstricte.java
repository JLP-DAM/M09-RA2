public class PrincipalEstricte {
    public static void main(String[] args) {
        Fil pepe = new Fil("Pepe", Thread.MAX_PRIORITY);
        Fil juan = new Fil("Juan", Thread.MIN_PRIORITY);

        pepe.thread.start();
        juan.thread.start();

        while (pepe.thread.isAlive() && juan.thread.isAlive()) {
            
        }

        System.out.println("Acaba thread main");
    }
}