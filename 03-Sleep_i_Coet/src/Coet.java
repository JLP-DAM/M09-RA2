import java.util.Scanner;

public class Coet extends Thread {
    Motor[] motors = new Motor[4];
    
    public Coet() {
        for (int index = 0; index < 4; index++) {
            motors[index] = new Motor("Motor " + index);
            motors[index].start();
        }
    }

    public void passaAPotencia(int potencia) {
        if (potencia < 0 || potencia > 10) {
            System.out.println("Potencia invalida, la potencia introduida ha d'estar entre el 0 i el 10 (inclosos)");

            return;
        }

        System.out.println("Passant a potència: " + potencia);

        boolean potenciaArribada = false;

        while (!potenciaArribada) {
            potenciaArribada = true;

            for (int index = 0; index < motors.length; index++) {
                Motor motor = motors[index];

                int canvi = (motor.potencia == potencia ? 0 : motor.potencia > potencia ? -1 : 1);

                motor.setPotencia(motor.potencia + canvi);

                potenciaArribada = potenciaArribada && ((motor.potencia + canvi) == potencia);
            }
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int potencia = Integer.parseInt(scanner.nextLine());

            coet.passaAPotencia(potencia);

            if (potencia == 0) {break;}
        }

        scanner.close();
    }
}