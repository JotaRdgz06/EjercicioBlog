package Logica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Publicacion {
	private static int consecutivo = 1;
	private int codigoPublicacion;
	private String titulo;
	private String texto;
	private String nombreCreador;
	private LocalDateTime fechaPublicacion;
	private List<Comentario> comentarios;
	
	public Publicacion(String titulo, String texto, String nombreCreador) {
		codigoPublicacion = consecutivo++;
		this.titulo = titulo;
		this.texto = texto;
		this.nombreCreador = nombreCreador;
		fechaPublicacion = LocalDateTime.now();
		comentarios = new ArrayList<Comentario>();
	}
	
	public int getCodigoPublicacion() {
		return codigoPublicacion;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getTexto() {
		return texto;
	}

	public String getNombreCreador() {
		return nombreCreador;
	}

	public LocalDateTime getFechaPublicacion() {
		return fechaPublicacion;
	}
	
	public String toString() {
		String resultado = "Publicación número " + codigoPublicacion;
		resultado += "\n" + titulo + "\n";
		resultado += "\nCreador: " + nombreCreador + "\n";
		resultado += "\n" + fechaPublicacion.toString() + "\n";
		resultado += "\n" + texto + "\n";
		resultado += "\ncomentarios: \n";
		if (comentarios.isEmpty()) {
			resultado += "No hay comentarios";
		} else {
			for (Comentario c : comentarios) {
				resultado += c.toString() + "\n";
			}
		}
		return resultado;
	}
	public void agregarComentario(String email, String ip, String texto) {
		Comentario c = new Comentario(email, ip, texto);
		comentarios.add(c);
	}
	public void borrarComentario(int posicion) throws Exception {
		if (posicion < 1 || posicion > comentarios.size()) {
			throw new Exception("Comentario no valido");
		}
		comentarios.remove(posicion - 1);
	}
}
