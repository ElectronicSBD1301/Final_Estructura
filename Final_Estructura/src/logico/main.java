package logico;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Bienvenido al menu:");
            System.out.println("1. Opcion 1");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Seleccione la opción 1");
                    // Aquí puedes poner el código correspondiente a la opción 1
                    break;
                case 2:
                    System.out.println("Seleccionó la opción 2");
                    // Aquí puedes poner el código correspondiente a la opción 2
                    break;
                case 3:
                    System.out.println("Seleccionó la opción 3");
                    // Aquí puedes poner el código correspondiente a la opción 3
                    break;
                case 4:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
