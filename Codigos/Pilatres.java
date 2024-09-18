import java.util.Scanner;

public class Pilatres {
    static int tope = 0;  // índice del tope de la pila
    static int t = 0;     // tamaño de la pila
    static int opt = 0;   // opción del menú
    static int tamaño = 27; // Tamaño de la pila porque es el abecedario

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Tamaño de la pila:");
            t = sc.nextInt();

            char[] pila = new char[t];  // Arreglo de caracteres

            do {
                System.out.println("1- Agregar\n"
                                 + "2- Mostrar\n"
                                 + "3- Eliminar\n"
                                 + "4- Llenar automáticamente\n"
                                 + "5- Salir\n");
                opt = sc.nextInt();

                switch(opt) {
                    case 1: // Agregar letra a la pila
                        if (tope < t) {
                            System.out.println("Agrega una letra:");
                            char letra = sc.next().charAt(0);
                            if (Character.isLetter(letra)) {  // Verifica que sea una letra
                                pila[tope] = letra;
                                tope++;
                            } else {
                                System.out.println("Error: Solo se permiten letras");
                            }
                        } else {
                            System.out.println("Error: Pila llena");
                        }
                        break;

                    case 2: // Mostrar la pila como una sola palabra
                        if (tope > 0) {
                            System.out.print("Elementos en la pila: ");
                            for (int i = 0; i < tope; i++) {
                                System.out.print(pila[i]);  // Imprime sin salto de línea
                            }
                            System.out.println();  // Agrega salto de línea al final
                        } else {
                            System.out.println("La pila está vacía");
                        }
                        break;

                    case 3: // Eliminar el último elemento
                        if (tope > 0) {
                            tope--;
                            System.out.println("Elemento eliminado");
                        } else {
                            System.out.println("Error: Pila vacía");
                        }
                        break;

                    case 4: // Llenar automáticamente con el patrón especificado
                        llenar(pila);
                        break;

                    case 5: // Salir
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } while(opt != 5);
        }
    }

    public static void llenar(char[] pila) {
        String caracteresEspeciales = "!@+-?/*";
        int numeros[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Llenar la pila en el orden especificado: 1 mayúscula, 2 minúsculas, 2 caracteres especiales, y números
        if (tope < pila.length) {
            // Mayúscula
            char letraMayuscula = (char) ('A' + (int)(Math.random() * 26));
            pila[tope++] = letraMayuscula;
        }
        
        if (tope < pila.length) {
            // Dos minúsculas
            for (int i = 0; i < 2 && tope < pila.length; i++) {
                char letraMinuscula = (char) ('a' + (int)(Math.random() * 26));
                pila[tope++] = letraMinuscula;
            }
        }

        if (tope < pila.length) {
            // Dos caracteres especiales
            for (int i = 0; i < 2 && tope < pila.length; i++) {
                char caracterEspecial = caracteresEspeciales.charAt((int)(Math.random() * caracteresEspeciales.length()));
                pila[tope++] = caracterEspecial;
            }
        }

        if (tope < pila.length) {
            // Números restantes
            while (tope < pila.length) {
                char numero = (char) ('0' + (int)(Math.random() * 10));
                pila[tope++] = numero;
            }
        }

        System.out.println("Pila llenada automáticamente con el patrón.");
    }
}
