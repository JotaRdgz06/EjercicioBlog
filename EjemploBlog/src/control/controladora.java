package control;

import java.util.Map;
import java.util.TreeMap;

import Logica.Blog;

public class controladora {
	private Map<Integer, Blog> blogs;
	
	public controladora() {
	    blogs = new TreeMap<Integer, Blog>();
	}
	public void crearBlog(String nombre, String descripcion) {
		Blog b = new Blog(nombre, descripcion);
		blogs.put(b.getCodigo(), b);
	}
	public void borrarBlog(int codigoBlog) throws Exception{
		if (!blogs.containsKey(codigoBlog)) {
			throw new Exception("El codigo de blog no es valido");
		}
		blogs.remove(codigoBlog);
	}
	public Map<Integer, String> obtenerBlogs() {
		Map<Integer, String> resultado = new TreeMap<Integer, String>();
		for (Blog b : blogs.values()) {
			resultado.put(b.getCodigo(), b.getNombre());
		}
		return resultado;
	}
	public void crearPublicacion(int codigoBlog, String titulo, String texto, String nombre) throws Exception {
		if (!blogs.containsKey(codigoBlog)) {
			throw new Exception("El codigo de blog no es valido");
		}
		Blog b = blogs.get(codigoBlog);
		b.crearPublicacion(titulo, texto, nombre);
	}
	public Map<Integer, String> obtenerPublicaciones(int codigoBlog) throws Exception{
		if (!blogs.containsKey(codigoBlog)) {
			throw new Exception("Codigo invalido");
		}
		Blog b = blogs.get(codigoBlog);
        return b.obtenerTitulosPublicaciones();
	}
	public String obtenerPublicacion(int codigoBlog, int codigoPublicacion) throws Exception {
		if (!blogs.containsKey(codigoBlog)) {
			throw new Exception("Codigo invalido");
		}
		Blog b = blogs.get(codigoBlog);
        return b.obtenerPublicacion(codigoPublicacion);
	}
	public void agregarComentario(int codigoBlog, int codigoPublicacion, String email, String ip, String texto) throws Exception {
		if (!blogs.containsKey(codigoBlog)) {
			throw new Exception("Codigo invalido");
		}
		Blog b = blogs.get(codigoBlog);
        b.agregarComentario(codigoPublicacion, email, ip, texto);
	}
	public void borrarComentario(int codigoBlog, int codigoPublicacion, int posicion) throws Exception {
		if (!blogs.containsKey(codigoBlog)) {
			throw new Exception("Codigo invalido");
		}
		Blog b = blogs.get(codigoBlog);
        b.borrarComentario(codigoPublicacion, posicion);
	}
}
