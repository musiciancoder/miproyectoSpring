package net.itinajero.app.model;

import java.util.Date;

public class Noticia {
	
	private int id;
	private String titulo;
	private Date fecha;
	private String detalle;
	private String estatus;
	
	public Noticia() {
		System.out.print("Constructor noticia");
		this.fecha = new Date();
		this.estatus="Activa";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		System.out.print("estoy seteando el titulo");
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		System.out.print("estoy seteando el detalle");
		this.detalle = detalle;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		System.out.print("estoy seteando el estatus");
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", detalle=" + detalle + ", estatus="
				+ estatus + "]";
	}
	
	
	

}
