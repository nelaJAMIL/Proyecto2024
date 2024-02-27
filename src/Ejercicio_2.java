import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitud
            System.out.print("Ingrese el primer num: ");
            int num1 = obtenerNumeroPositivo(scanner);

            System.out.print("Ingrese el segundo num: ");
            int num2 = obtenerNumeroPositivo(scanner);


            int mcd = calcularMCD(num1, num2);
            System.out.println(mcd);

        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar números enteros positivos.");
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por cero.");
        }
    }

    // Función recursiva
    private static int calcularMCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calcularMCD(b, a % b);
        }
    }

    // excepcion
    private static int obtenerNumeroPositivo(Scanner scanner) {
        int num = scanner.nextInt();

        if (num <= 0) {
            throw new InputMismatchException();
        }

        return num;
    }
}
