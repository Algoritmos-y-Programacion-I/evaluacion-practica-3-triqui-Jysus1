package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private static boolean flag;

    private Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
    }

    public void run(boolean flag) {

        flag = false;

        while (!flag) {

            System.out.println("\n\nBienvenido al menu:\n");
            System.out.println("Opciones:\n" + "1. Imprimir tablero \n" + "2. Jugada de la máquina \n"
                    + "3. Jugada de humano \n" + "4. Verificar ganador \n" + "5. Salir del programa \n");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
                    flag = true;
                    System.exit(0);
                    break;
                default:
                    System.out.print("Por favor ingrese una opcion valida");
                    continue;
            }

        }

    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run(flag);
    }

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La máquina ha realizado su jugada.");
        imprimirTablero();
    }

    private void jugadaHumano() {
    System.out.println("Ingrese la fila (0-2): ");
    int i = reader.nextInt();
    System.out.println("Ingrese la columna (0-2): ");
    int j = reader.nextInt();

    if (cont.jugadaHumano(i, j)) {
        System.out.println("¡Jugada realizada!");
        imprimirTablero();
    } else {
        System.out.println("Movimiento inválido. Intente de nuevo.");
    }
}

    private void validarGanador() {
    String ganador = cont.validarGanador();
    if (ganador == null) {
        System.out.println("No hay un ganador aún.");
    } else if (ganador.equals("X")) {
        System.out.println("¡La máquina ha ganado!");
    } else if (ganador.equals("O")) {
        System.out.println("¡El humano ha ganado!");
    }
}
}