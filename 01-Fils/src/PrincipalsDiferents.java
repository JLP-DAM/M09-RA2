public class PrincipalsDiferents {
    public static void main(String[] args) {
        Fil pepe = new Fil("Pepe", Thread.MAX_PRIORITY);
        Fil juan = new Fil("Juan", Thread.MIN_PRIORITY);

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }
}