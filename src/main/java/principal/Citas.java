/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package principal;



import java.util.Scanner;

public class Citas {

    public static void main(String[] args) {

        GeneradorCitas citas = new GeneradorCitas();
        Scanner op = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú de gestión de citas:");
            System.out.println("1. Generar nueva cita");
            System.out.println("2. Ver citas programadas");
            System.out.println("3. Eliminar cita");
            System.out.println("4. Buscar cita específica");
            System.out.println("5. Asociar factura a cita");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = op.nextInt();
            op.nextLine(); 

            switch (opcion) {
                case 1:
                    citas.generarCita();
                    break;
                case 2:
                    citas.verCitas();
                    break;
                case 3:
                    citas.eliminarCita();
                    break;
                case 4:
                    citas.buscarCita();
                    break;
                case 5:
                    citas.asociarFactura();
                    break;
                case 6:
                    System.out.println("Gracias por usar el sistema de citas.");
                    break;
                default:
                    System.out.println("¡Opción inválida! Intente nuevamente.");
            }
        } while (opcion != 6);
    }
}