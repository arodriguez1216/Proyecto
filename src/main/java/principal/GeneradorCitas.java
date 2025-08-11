/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class GeneradorCitas {

    private ArrayList<Cita> agenda;
    private Scanner scanner;

    public GeneradorCitas() {
        agenda  = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // 1. Generar cita con cédula, nombre, descripción, fecha y costo
    public void generarCita() {
        System.out.print("Número de cédula: ");
        int cedula = Integer.parseInt(scanner.nextLine());

        System.out.print("Nombre del paciente: ");
        String nombrePaciente = scanner.nextLine();

        System.out.print("Descripción de la cita: ");
        String descripcion = scanner.nextLine();

        // Lectura y validación de fecha (DD/MM/AAAA)
        LocalDate fecha = null;
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (fecha == null) {
            System.out.print("Fecha de la cita (DD/MM/AAAA): ");
            String textoFecha = scanner.nextLine();
            try {
                fecha = LocalDate.parse(textoFecha, formatoFecha);
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Use DD/MM/AAAA.");
            }
        }

        // Lectura y validación de costo
        double costo = -1;
        while (costo < 0) {
            System.out.print("Costo de la cita en colones ");
            if (scanner.hasNextDouble()) {
                costo = scanner.nextDouble();
                if (costo < 0) {
                    System.out.println("El costo no puede ser negativo.");
                }
            } else {
                System.out.println("Valor inválido. Ingrese un número decimal.");
            }
            scanner.nextLine(); // limpia buffer
        }

        // Crear y almacenar la nueva cita
        Cita nueva = new Cita(cedula, nombrePaciente, descripcion, fecha, costo);
        agenda.add(nueva);
        System.out.println("Cita generada correctamente:");
        System.out.println(nueva);
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
        agenda.removeIf(c -> c.getCedula() == id);
        System.out.println("Cita eliminada si existía.");
    }

    // 4. Buscar cita específica
    public void buscarCita() {
        System.out.print("Numero de cedula: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Cita c : agenda) {
            if (c.getCedula() == id) {
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
            if (c.getCedula() == id) {
                c.setFactura(factura);
                System.out.println("Factura asociada correctamente.");
                return;
            }
        }
        System.out.println("Cita no encontrada para asociar factura.");
    }
    
}
