import java.util.Scanner;

public class Pila {
    static int t = 0;          // Tamaño de la pila
    static int opcion = 0;     // Opción del menú
    static int topeA = 0;      // Tope de la Pila A
    static int topeB = 0;      // Tope de la Pila B
    static int topeC = 0;      // Tope de la Pila C
    static Object[] PilaC;     // Pila C para elementos alternados

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el tamaño de la pila: ");
        t = sc.nextInt();
        char[] PilaA = new char[t];  // Pila A para caracteres
        int[] PilaB = new int[t];     // Pila B para enteros
        PilaC = new Object[t * 2];    // Pila C para almacenar letras y enteros alternadamente

        do {
            System.out.println("1- Llenar Pila A\n"
                             + "2- Llenar Pila B\n"
                             + "3- Llenar Pila C\n"
                             + "4- Mostrar\n"
                             + "5- Salir del programa\n");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    llenarPilaA(PilaA);
                    break;

                case 2:
                    llenarPilaB(PilaB);
                    break;

                case 3:
                    llenarPilaC(PilaA, PilaB);
                    break;

                case 4://Sub Menu 
                    System.out.println("a)- Mostrar Pila A\n" 
                                     + "b)- Mostrar Pila B\n"
                                     + "c)- Mostrar Pila C\n");

                    char Opcion = sc.next().charAt(0);  
                    switch (Opcion) {
                        case 'a':
                            mostrarPilaA(PilaA);
                            break;
                        case 'b':
                            mostrarPilaB(PilaB);
                            break;
                        case 'c':
                            mostrarPilaC();
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);

        sc.close();
    }

    // Método para llenar Pila A con letras aleatorias
    public static void llenarPilaA(char[] pila) {
        for (int i = 0; i < pila.length; i++) {
            pila[i] = (char) ('A' + (int)(Math.random() * 26));  // Genera letras aleatorias
        }
        topeA = pila.length;  // Actualizar el tope de la pila
        System.out.println("Pila A llenada automáticamente con letras aleatorias");
    }

    // Método para llenar Pila B con múltiplos de 3
    public static void llenarPilaB(int[] pila) {
        int numero = 3;
        for (int a = 0; a < pila.length; a++) {
            pila[a] = numero;  // Llenar con múltiplos de 3
            numero += 3;
        }
        topeB = pila.length;  // Actualizar el tope de la pila
        System.out.println("Pila B llenada automáticamente con múltiplos de 3");
    }

    // Método para llenar Pila C con elementos alternados de A y B
    public static void llenarPilaC(char[] pilaA, int[] pilaB) {
        topeC = 0;  // Reiniciar el tope de Pila C
        int i = 0;

        // Llenar alternadamente mientras ambas pilas tengan elementos
        while (i < topeA && i < topeB) {
            PilaC[topeC++] = pilaA[i];  // Agregar elemento de Pila A
            PilaC[topeC++] = pilaB[i];  // Agregar elemento de Pila B
            i++;
        }

        // Si hay elementos sobrantes en Pila A
        while (i < topeA) {
            PilaC[topeC++] = pilaA[i++];
        }

        // Si hay elementos sobrantes en Pila B
        while (i < topeB) {
            PilaC[topeC++] = pilaB[i++];
        }

        System.out.println("Pila C llenada automáticamente con elementos alternados de Pila A y B");
    }

    // Método para mostrar Pila A
    public static void mostrarPilaA(char[] pila) {
        if (topeA > 0) {
            System.out.println("Elementos en la Pila A:");
            for (int i = 0; i < topeA; i++) {
                System.out.println(pila[i]);
            }
        } else {
            System.out.println("La Pila A está vacía");
        }
    }

    // Método para mostrar Pila B
    public static void mostrarPilaB(int[] pila) {
        if (topeB > 0) {
            System.out.println("Elementos en la Pila B:");
            for (int i = 0; i < topeB; i++) {
                System.out.println(pila[i]);
            }
        } else {
            System.out.println("La Pila B está vacía");
        }
    }

    // Método para mostrar Pila C
    public static void mostrarPilaC() {
        if (topeC > 0) {
            System.out.println("Elementos en la Pila C:");
            for (int i = 0; i < topeC; i++) {
                System.out.println(PilaC[i]);
            }
        } else {
            System.out.println("La Pila C está vacía");
        }
    }
}





