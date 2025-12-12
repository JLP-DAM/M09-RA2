public class PrincipalEstricte {
    public static void main(String[] args) throws Exception {
        Fil pepe = new Fil("Pepe", Thread.MAX_PRIORITY, true);
        Fil juan = new Fil("Juan", Thread.MAX_PRIORITY, true);

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }
}