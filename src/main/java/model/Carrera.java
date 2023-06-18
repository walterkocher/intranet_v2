package model;

public class Carrera {
	private String nombreCarrera;
	private String codigo;
	private int semestres;

	public Carrera(String nombreCarrera, String codigo, int semestres) {
		this.nombreCarrera = nombreCarrera;
		this.codigo = codigo;
		this.semestres = semestres;
	}

	public String getNombreCarrera() {
		return this.nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getSemestres() {
		return this.semestres;
	}

	public void setSemestres(int semestres) {
		this.semestres = semestres;
	}
}