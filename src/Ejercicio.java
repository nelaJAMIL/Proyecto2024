import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0, b = 1, c = 0;

        System.out.print("Ingrese el número  ");
        try {
            int num1 = obtenerNumeroPositivo(scanner);


            System.out.println(":");
            System.out.print(a + " ");

            for (int i = 1; i < num1; i++) {
                System.out.print(b + " ");

                c = a + b;
                a = b;
                b = c;
            }

            System.out.println( a);

        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número entero positivo.");
        } catch (Exception e) {
            System.out.println("Error inesperado.");
        }
    }

    private static int obtenerNumeroPositivo(Scanner scanner) {
        int num = scanner.nextInt();

        if (num <= 0) {
            throw new InputMismatchException();
        }

        return num;
    }
}
