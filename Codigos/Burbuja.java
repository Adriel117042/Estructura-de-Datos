import java.util.Scanner;

public class Burbuja {
    static int letras = 26;
    static int opcion = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("El tamaño del Vector es 26");
        char[] VectorA = new char[letras];

        do {
            System.out.println("1- Generar Vector\n"
                    + "2- Ordenar por el método Bubble Sort\n"
                    + "3- Mostrar el Vector A\n"
                    + "4- Salir");

            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    llenarVector(VectorA);
                    break;

                case 2:
                    bubbleSort(VectorA);
                    break;

                case 3:
                    mostrarVector(VectorA);
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

    public static void llenarVector(char[] Vector ) {
        boolean[] usadas = new boolean[26]; // Array que marca si una letra ya fue usada
        int Temporal = 0; 
    
        while (Temporal < Vector.length) {
            char letra = (char) ('A' + (int) (Math.random() * 26));
    
            // Verificar si la letra ya fue usada
            if (!usadas[letra - 'A']) {
                Vector[Temporal] = letra;           
                usadas[letra - 'A'] = true;       
                Temporal++;                      
            }
        }
        System.out.println("Vector A generado sin repeticiones.");
        }

    public static void mostrarVector(char[] Vector ) {
        if (Vector .length > 0) {
            System.out.println("Elementos del Vector A:");
            for (int i = 0; i < Vector .length; i++) {
                System.out.print(Vector[i]+ "  ");
            }
            System.out.println();
        } else {
            System.out.println("El vector A está vacío.");
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
        System.out.println("Vector A ordenado.");
    }
}
