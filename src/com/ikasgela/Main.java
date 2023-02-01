package com.ikasgela;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class Main {

    public static Map<String, Contacto> contactos = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Ejemplos de prueba BORRAR
        Contacto c_1 = new Contacto("Luis", "Medina", "luism&m@gmail.com");
        Contacto c_2 = new Contacto("Olha", "Zahorna", "olhita@gmail.com");
        Contacto c_3 = new Contacto("Nicolas", "Perez", "nicope@gmail.com");

        contactos.put("5789", c_1);
        contactos.put("1234", c_2);
        contactos.put("7412", c_3);
        boolean running = true;
        do {

            System.out.print("\nCONTACTOS\n" +
                    "---------\n" +
                    "\t0. Salir\n" +
                    "Gestión de contactos\n" +
                    "\t1. Nuevo contacto.\n" +
                    "\t2. Eliminar contacto.\n" +
                    "Búsqueda\n" +
                    "\t3. Buscar contacto por número de teléfono.\n" +
                    "\t4. Buscar contacto por nombre.\n" +
                    "Listados\n" +
                    "\t5. Listado de todos los contactos, tal como se han añadido.\n" +
                    "\t6. Listado de todos los contactos, ordenados por número de teléfono." +
                    "\nOpcion: ");
            try {
                int opcion = Integer.parseInt(br.readLine());

                switch (opcion) {
                    case 0:
                        System.out.println("Saliendo");
                        running = false;
                        break;
                    case 1:
                        CrearNuevoContacto(br);
                        break;
                    case 2:
                        EliminarContacto(br);
                        break;
                    case 3:
                        MostrarContacto_Num(br);
                        break;
                    case 4:
                        MostrarContacto_Nom(br);
                        break;
                    case 5:
                        System.out.printf("%-20s | %-25s | %-25s | %-25s |\n\n", "TELEFONO", "NOMBRE", "APELLIDOS", "EMAIL");
                        contactos.forEach((telefono, contacto) ->
                                System.out.print(String.format("%-20s ", telefono) + contacto));
                        break;
                    case 6:
                        Map<String, Contacto> order_Key = new TreeMap<>(contactos);
                        System.out.printf("%-20s | %-25s | %-25s | %-25s |\n\n", "TELEFONO", "NOMBRE", "APELLIDOS", "EMAIL");
                        order_Key.forEach((telefono, contacto) ->
                                System.out.print(String.format("%-20s ", telefono) + contacto));

                        break;

                    default:
                        System.out.println("Opcion Invalida, Intente Nuevamente\n");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR:Entrada invalida");
            }

        } while (running);


    }

    private static void MostrarContacto_Nom(BufferedReader br) throws IOException {
        if (contactos.size() > 0) {
            System.out.print("Ingrese el nombre del contacto: ");
            String nom_Search = br.readLine();

            boolean found = false;
            for (Map.Entry<String, Contacto> entry : contactos.entrySet()) {
                String telefono = entry.getKey();
                Contacto contacto = entry.getValue();
                if (contacto.getNombre().equals(nom_Search)) {
                    System.out.println(telefono + ":\n " + contacto);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Contacto no encontrado.\n");
            }

        } else {
            System.out.print("Sin Contactos Añadidos aun.\n");
        }
    }

    private static void MostrarContacto_Num(BufferedReader br) throws IOException {
        if (contactos.size() > 0) {
            System.out.print("Indique el numero de telefono: ");
            String num_Search = br.readLine();
            if (contactos.containsKey(num_Search)) {
                System.out.printf("%-20s | %-25s | %-25s | %-25s |\n\n", "TELEFONO", "NOMBRE", "APELLIDOS", "EMAIL");
                System.out.print(String.format("%-20s ", num_Search) + contactos.get(num_Search));
            } else {
                System.out.println("Número no encontrado\n");
            }
        } else {
            System.out.print("Sin Contactos Añadidos aun.\n");
        }
    }

    private static void EliminarContacto(BufferedReader br) throws IOException {
        if (contactos.size() > 0) {
            System.out.print("Indique el número de contacto que desea eliminar: ");
            String num_Eliminar = br.readLine();
            if (contactos.containsKey(num_Eliminar)) {
                System.out.println(num_Eliminar + " ha sido eliminado.\n");
                contactos.remove(num_Eliminar);
            } else {
                System.out.println("Contacto no encontrado.\n");
            }
        } else {
            System.out.print("Sin Contactos Añadidos aun.\n");
        }
    }

    private static void CrearNuevoContacto(BufferedReader br) throws IOException {
        System.out.print("Indique el numero de telefono: ");
        try {
            int num_init = Integer.parseInt(br.readLine());
            String num_Crear = String.valueOf(num_init);

            if (contactos.containsKey(num_Crear)) {
                System.out.print("Numero indicado ya esta registrado\n");
            } else {
                System.out.print("Indique el nombre del contacto: ");
                String nombre_Crear = br.readLine();
                System.out.print("Indique el apellido del contacto: ");
                String apellido_Crear = br.readLine();
                System.out.print("Indique el email del contacto: ");
                String email_Crear = br.readLine();

                Contacto contacto_Crear = new Contacto(nombre_Crear, apellido_Crear, email_Crear);

                contactos.put(num_Crear, contacto_Crear);
                System.out.println("Contacto Creado Exitosamente.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Numero ingresado no es valido\n");
        }
    }
}
