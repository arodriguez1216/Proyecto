/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author AXEL R
 */
public class GeneradorCitas {


    private ArrayList<Cita> agenda;
    private Scanner scanner;

    // Constructor1
    public GeneradorCitas() {
        agenda = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // 1. Generar cita
    public void generarCita() {
        System.out.print("Numero de Cedula : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Descripción de la cita: ");
        String desc = scanner.nextLine();
        agenda.add(new Cita(id, desc));
        System.out.println("Cita generada correctamente.");
    }

    // 2. Ver citas programadas
    public void verCitas() {
        if (agenda.isEmpty()) {
            System.out.println("No hay citas programadas.");
            return;
        }
        System.out.println("Citas programadas:");
        for (Cita c : agenda) {
            System.out.println(c);
        }
    }

    // 3. Eliminar cita
    public void eliminarCita() {
        System.out.print("Numero de Cedula para eliminar cita: ");
        int id = Integer.parseInt(scanner.nextLine());
        agenda.removeIf(c -> c.getId() == id);
        System.out.println("Cita eliminada si existía.");
    }

    // 4. Buscar cita específica
    public void buscarCita() {
        System.out.print("Numero de cedula: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Cita c : agenda) {
            if (c.getId() == id) {
                System.out.println("Cita encontrada: " + c);
                return;
            }
        }
        System.out.println("No se encontró ninguna cita con ese numero de cedula.");
    }

    // 5. Asociar factura
    public void asociarFactura() {
        System.out.print("Numero de cedula para facturar: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Número de factura: ");
        String factura = scanner.nextLine();
        for (Cita c : agenda) {
            if (c.getId() == id) {
                c.setFactura(factura);
                System.out.println("Factura asociada correctamente.");
                return;
            }
        }
        System.out.println("Cita no encontrada para asociar factura.");
    }
    
}
