public class Fil {
    Thread thread;

    public Fil(String nom, int prioritat) {
        thread = new Thread(nom) {
            public void run() {
                for (int index = 1; index <= 1000; index++) {
                    System.out.println(String.format("%s %s", nom, index));
                }

                System.out.println(String.format("Acaba el fil %s", nom));
            }
        };

        thread.setPriority(prioritat);
    }
}
