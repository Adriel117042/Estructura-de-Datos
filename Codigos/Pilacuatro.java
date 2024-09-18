import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Pilacuatro {
    static int tope = 0;  // índice del tope de la pila
    static int t = 26;    // tamaño de la pila ajustado a 26 (número de letras minúsculas)
    static int opt = 0;   // opción del menú

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Ya sabemos que el tamaño es 26
        System.out.println("El tamaño de la pila es 26");

        char[] pila = new char[t];  // Arreglo de caracteres

        do {
            // Mostrar el menú de opciones
            System.out.println("2- Mostrar\n"
                             + "3- Eliminar\n"
                             + "4- Llenar automáticamente\n"
                             + "5- Salir\n");
            opt = sc.nextInt();

            switch(opt) {
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

                case 4: // Llenar automáticamente sin repetir letras
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

        sc.close();
    }

    public static void llenar(char[] pila) {
        List<Character> letras = new ArrayList<>();
        
        // Añadir todas las letras minúsculas del alfabeto
        for (char c = 'a'; c <= 'z'; c++) {
            letras.add(c);
        }

        // Barajar las letras aleatoriamente
        Collections.shuffle(letras);

        // Llenar la pila con las letras minúsculas
        for (int i = 0; i < t; i++) {
            pila[i] = letras.get(i);
        }
        tope = t;  // Actualizar el tope de la pila
    }
}



