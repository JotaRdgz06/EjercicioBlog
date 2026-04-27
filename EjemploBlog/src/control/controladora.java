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
			throw new Exception()
		}
		Map<Integer, String> resultado = new TreeMap<Integer, String>();
		for (Blog b : blogs.values()) {
			resultado.put(b.getCodigo(), b.getNombre());
		}
		return resultado;
	}
}
