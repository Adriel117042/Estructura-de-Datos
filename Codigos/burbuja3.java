import java.util.Scanner;

public class burbuja3 {
    static int letras = 26;
    static int opcion = 0;
    static int tope = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("El tamaño de la Vector es 26:");
        char[] Vector = new char[letras];
        do {
            System.out.println("1- Generar Vector\n"
                             + "2- Ordenar por el método Bubble Sort\n"
                             + "3- Mostrar\n"
                             + "4- Eliminar un elemento\n"
                             + "5- Desordenar\n"
                             + "6- Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    Vector(Vector);
                    break;
                case 2:
                   bubbleSort(Vector);
                    break;
                case 3:
                    mostrarPalabra(Vector);
                    break;
                case 4:
                    eliminar(Vector);
                    break;
                case 5:
                    Desordenar(Vector);;
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 7);
        sc.close();
    }
    public static void Vector(char[] Vector ) {
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
                System.out.print(Vector[i] + "  ");
            }
            System.out.println();
        } else {
            System.out.println("La Vector está vacía.");
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
    public static void eliminar(char[] arr) {
        for (int i =0; i<arr.length-1; i++){
            arr[i]=arr[i+1];
        }
        tope--;
    }
    public static void Desordenar(char[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int randomIndex = (int) (Math.random() * (i + 1)); 
            char temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp; 
        }
        System.out.println("Palabra desordenada.");
    }
    
}


