import java.util.Scanner;

public class Pila {
    static int tope = 0;  // índice del tope de la pila
    static int t = 0;     // tamaño de la pila
    static int opt = 0;   // opción del menú
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Tamaño de la pila:");
            t = sc.nextInt();
            
            char[] pila = new char[t];  // Cambiamos a un arreglo de caracteres
            
            do {
                System.out.println("1- Agregar\n"
                                 + "2- Mostrar\n"
                                 + "3- Eliminar\n"
                                 + "4- Salir\n");
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
                        
                    case 2: // Mostrar la pila
                        if (tope > 0) {
                            System.out.println("Elementos en la pila:");
                            for (int i = tope - 1; i >= 0; i--) {
                                System.out.println(pila[i]);
                            }
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
                        
                    case 4: // Salir
                        System.out.println("Saliendo...");
                        break;
                        
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } while(opt != 4);
        }
    }
}
