import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Compi{

    // Expresiones regulares para cada tipo de token
    private static final String PATRON_IDENTIFICADOR = "[a-zA-Z_][a-zA-Z0-9_]*";
    private static final String PATRON_PALABRAS_RESERVADAS = "\\b(if|else|while)\\b";
    private static final String PATRON_OPERADORES_ARITMETICOS = "[+\\-*/]";
    private static final String PATRON_OPERADORES_COMPARACION = "<=|>=|<|>|==|!=";
    private static final String PATRON_LITERALES_ENTEROS = "\\d+";

    public static void analizarCodigo(String codigo) {
        // Patrones compilados para mejorar el rendimiento
        Pattern patronIdentificador = Pattern.compile(PATRON_IDENTIFICADOR);
        Pattern patronPalabrasReservadas = Pattern.compile(PATRON_PALABRAS_RESERVADAS);
        Pattern patronOperadoresAritmeticos = Pattern.compile(PATRON_OPERADORES_ARITMETICOS);
        Pattern patronOperadoresComparacion = Pattern.compile(PATRON_OPERADORES_COMPARACION);
        Pattern patronLiteralesEnteros = Pattern.compile(PATRON_LITERALES_ENTEROS);

        // Matcher para encontrar coincidencias
        Matcher matcher;

        // Dividir el código en líneas
        String[] lineas = codigo.split("\n");

        // Analizar cada línea
        for (int i = 0; i < lineas.length; i++) {
            String linea = lineas[i];
            int posicion = 0;

            // Utilizar el matcher para encontrar coincidencias en la línea
            while (posicion < linea.length()) {
                matcher = patronIdentificador.matcher(linea.substring(posicion));
                if (matcher.find()) {
                    // Token: Identificador
                    System.out.println("Identificador: " + matcher.group());
                    posicion += matcher.end();
                    continue;
                }

                matcher = patronPalabrasReservadas.matcher(linea.substring(posicion));
                if (matcher.find()) {
                    // Token: Palabra reservada
                    System.out.println("Palabra reservada: " + matcher.group());
                    posicion += matcher.end();
                    continue;
                }

                matcher = patronOperadoresAritmeticos.matcher(linea.substring(posicion));
                if (matcher.find()) {
                    // Token: Operador aritmético
                    System.out.println("Operador aritmético: " + matcher.group());
                    posicion += matcher.end();
                    continue;
                }

                matcher = patronOperadoresComparacion.matcher(linea.substring(posicion));
                if (matcher.find()) {
                    // Token: Operador de comparación
                    System.out.println("Operador de comparación: " + matcher.group());
                    posicion += matcher.end();
                    continue;
                }

                matcher = patronLiteralesEnteros.matcher(linea.substring(posicion));
                if (matcher.find()) {
                    // Token: Literal entero
                    System.out.println("Literal entero: " + matcher.group());
                    posicion += matcher.end();
                    continue;
                }

                // Manejar errores léxicos
                System.out.println("Error léxico en la línea " + (i + 1) + ", posición " + (posicion + 1));
                posicion++; // Avanzar para evitar bucle infinito en caso de error
            }
        }
    }

    public static void main(String[] args) {
        String codigoFuente = "if (x < 10) { y = y + 5; } else { y = y - 2; }";
        analizarCodigo(codigoFuente);
    }
}

