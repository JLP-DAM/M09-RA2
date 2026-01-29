public class Organitzador {
    public static void main(String[] args) {
        Esdeveniment esdeveniment = new Esdeveniment(5);

        for (int index = 0; index < 10; index++) {
            Assistent assistent = new Assistent("Assistent-" + index, esdeveniment);

            assistent.start();
        }
    }
}
