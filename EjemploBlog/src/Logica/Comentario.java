package Logica;

import java.time.LocalDateTime;

class Comentario {
	private LocalDateTime fechaCreacion;
	private String email;
	private String ip;
	private String texto;
	
	public Comentario(String email, String ip, String texto) {
		fechaCreacion = LocalDateTime.now();
		this.email = email;
		this.ip = ip;
		this.texto = texto;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public String getEmail() {
		return email;
	}
	public String getIp() {
		return ip;
	}
	public String getTexto() {
		return texto;
	}
	public String toString() {
		String resultado = email + " - " + ip + " - " + fechaCreacion.toString() + "\n";
		resultado += texto + "\n";
		return resultado;
	}
}
