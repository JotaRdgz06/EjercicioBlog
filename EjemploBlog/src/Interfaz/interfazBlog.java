package Interfaz;

import control.controladora;
import java.util.Scanner;
import java.util.Map;

public class interfazBlog {

	private static controladora controladora;
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		controladora = new controladora();
		
		porDefecto();
		
		int opcion = 0;
		while (opcion != 4) {
            menuPrincipal();

            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearBlog();
                    break;
                case 2:
                    trabajarConBlog();
                    break;
                case 3:
                    borrarBlog();
                    break;
                case 4:
                    System.out.println("Chau :>");
                    break;
                default:
                    System.out.println("Ingreser un número entre 1 y 4: ");
            }
        }
		
	}
	
	public static void crearBlog() throws Exception{
        System.out.println("\nCrear blog nuevo");

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción: ");
        String descripcion = scanner.nextLine();

        if (nombre.isEmpty()) {
            throw new Exception("el nombre no puede estar vacio.");
        }
        if (descripcion.isEmpty()) {
        	throw new Exception("la descripcion no puede estar vacia");
        }
        controladora.crearBlog(nombre, descripcion);
	}
	
	public static void menuPrincipal() {
		String menu = "Administración de blogs";
		menu += "\n \n1. Crear blog nuevo";
		menu += "\n2. Trabajar con blog";
		menu += "\n3. Borrar Blog";
		menu += "\n4. Salir";
		System.out.println(menu);
	}
	
	public static void trabajarConBlog() {
		
	}
	
	public static void borrarBlog() throws Exception{
		Map<Integer, String> blogs = controladora.obtenerBlogs();

        if (blogs.isEmpty())
            System.out.println("No hay blogs para borrar.");
        System.out.println("Ingrese el codigo de la publicacion que desea borrar entre 1 y " + blogs.size() + ": ");
        int codigo = scanner.nextInt();
        
        if (codigo < 1 || codigo > blogs.size())
        	throw new Exception("El valor ingresado está fuera de rango");
        try {
            controladora.borrarBlog(codigo);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
	}
	
	public static void porDefecto() {
		try {
		controladora.crearBlog("el nodo centinela le puede ganar a goku?", "debate serio en el que se intenta concluir si el nodo centinela le puede ganar a goku en un 1vs1");
		controladora.crearPublicacion(1, "nadie le gana a goku", "este debate no tiene sentido, ni siquiera el poderosisimo nodo centinela le puede ganar a goku base", "PateaAbuelas3000");
		controladora.agregarComentario(1, 1, "pablitoGamer123@gmail.com", "123.456.7.8", "borra la cuenta");
		controladora.agregarComentario(1, 1, "unRandom@gmail.com", "231.577.1.7", "estimado usuario de esta red social, con el debido respeto me refiero a usted para expresar mi desacuerdo con su opinion, en primer lugar el nodo centinela es completamente indetectable ya que se ignora por completo al no poseer informacion en él, haciendo que ni siquiera el ultra instinto pueda detectarlo, en segunda, si bien pueden estar en una escala de poder muy similar, el poder del nodo centinela se asimila más al de saitama, siendo que entre más fuerte es su rival, más crecerá la diferencia de poder entre ambos, siendo algo exponencial que no tiene limites conocidos, esto se demuestra en la pagina 25 del quinto tomo del manga del nodo centinela, aunque es entendible que no cuente con esta informacion ya que no ha sido animado. Es por esto y por otras razones que considero que su afirmacion es erronea, buenas tardes.");
		
		controladora.crearPublicacion(1, "el sayayin más fuerte de la actualidad vs el nodo más fuerte de la historia", "+'si la lista tiene un nodo centinela al principio y al final me daría algunos problemas'\\r\\n -'perderías?'\\r\\n +'...ganaría'", "CamiloJoestar");
		controladora.agregarComentario(1, 2, "nosequeponer789@gmail.com", "345.745.7.2", "I'm just a holy fool, oh, baby, it's so cruel\r\n" + "But I'm still in love with Judas, baby");
		controladora.agregarComentario(1, 2, "jotarocalvo@gmail.com", "135.479.2.1", "pero el nodo centinela no necesita guionazos para ganar");
		
		controladora.crearBlog("Personaje de ficcion favorito?", "un blog para compartir los personajes favoritos de las personas y conocer a gente con gustos parecidos");
		controladora.crearPublicacion(2, "Makoto Yuki del persona 3", "Me encanta su estilo, sus audifonos, el reproductor que lleva en el pecho, su persona y el juego en general me encanta por su estetica y su característico color azul", "FanDeMakotoYuki#1");
		controladora.agregarComentario(2, 3, "tampocosequeponer@gmail.com", "135.363.1.4", "PERSONAAAAAA");
		controladora.agregarComentario(2, 3, "elpapumisterioso@gmail.com", "124.125.2.6", "creo que prefiero al joker del persona 5 pero la verdad es un muy buen protagonista");
		
		controladora.crearPublicacion(2, "yo creo que el mio es Haru Urara del umamusume", "su personalidad tan feliz y positiva, su espiritu competitivo y la historia de la yegua de la vida real me hacen admirarla, porque a pesar de correr en 113 carreras y no ganar ninguna nunca se rindió y se esforzó por mejorar, por eso la admiro y me motiva a seguir adelante", "MrYeiYei");
		controladora.agregarComentario(2, 4, "XxCarlitosProYTxX", "367.368.1.8", "yo tambien admiro a rice shower y a TM Opera O, porque fueron tan buenos caballos que la gente los odiaba por ganar las carrearas, pero a pesar de eso siempre se convirtieron en leyendas, me gusta mucho sus historias");
		controladora.agregarComentario(2, 4, "Silksong-Sale-Mañana@gmail.com", "234.876.3.6", "haru mi hija we");
		} catch (Exception e) {
			System.out.println("Error:" + e);
        }
	}
}
