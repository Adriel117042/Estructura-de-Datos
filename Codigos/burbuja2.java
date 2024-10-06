import java.util.Scanner;

public class burbuja2 {
    static int letras = 10;
    static int opcion = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("El tamaño de la palabra es 10:");
        char[] palabra = new char[letras];
        do {
            System.out.println("1- Generar Palabra\n"
                            + "2- Ordenar por el método Bubble Sort\n"
                            + "3- Mostrar la Palabra\n"
                            + "4- Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    palabra(palabra);
                    break;
                case 2:
                   bubbleSort(palabra);
                    break;
                case 3:
                    mostrarPalabra(palabra);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 4);
        sc.close();
    }
    public static void palabra(char[] Vector ) {
        boolean[] usadas = new boolean[26]; 
        int Temporal = 0; 
        while (Temporal < Vector.length) {
            char letra = (char) ('a' + (int) (Math.random() * 26));
            if (!usadas[letra - 'a']) {
                Vector[Temporal] = letra;           
                usadas[letra - 'a'] = true;       
                Temporal++;                      
            }
        }
        System.out.println("Palabra Generada");
    }
    public static void mostrarPalabra(char[] Vector ) {
        if (Vector .length > 0) {
            System.out.println("Elementos de la Palabra");
            for (int i = 0; i < Vector .length; i++) {
                System.out.print(Vector[i]);
            }
            System.out.println();
        } else {
            System.out.println("La palabra está vacía.");
        }
    }
    public static void bubbleSort(char[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    System.out.println("Palabra ordenada.");
    }
}

