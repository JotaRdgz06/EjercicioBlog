package Interfaz;

import control.controladora;
import java.util.Scanner;

public class interfazBlog {

	private static controladora controladora;
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		controladora = new controladora();
		
		int opcion = 0;
		while (opcion != 4) {
            menuPrincipal();

            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    System.out.println("Chau :>");
                    break;
                default:
                    System.out.println("Ingreser un número entre 1 y 4: ");
            }
        }
		
	}
	
	public void crearBlog() throws Exception{
		try {
			System.out.println("Ingrese el titulo: ");
			String titulo = scanner.next();
			System.out.println("Ingrese el texto: ");
			String texto = scanner.next();
			System.out.println("Ingrese el nombre del autor: ");
			String nombreCreador = scanner.next();
			controladora.crearBlog(nombreCreador, nombreCreador);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
	public static void menuPrincipal() {
		String menu = "Administración de blogs";
		menu += "\n \n1. Crear blog nuevo";
		menu += "\n2. Trabajar con blog";
		menu += "\n3. Borrar Blog";
		menu += "\n4. Salir";
		System.out.println(menu);
	}
}
