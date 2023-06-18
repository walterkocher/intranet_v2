package model;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String rut;
	private String nMatricula;
	private Carrera carrera;

	public Estudiante(String rut, String nombre, String apellido, String nMatricula, Carrera carrera) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.nMatricula = nMatricula;
		this.carrera = carrera;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNMatricula() {
		return this.nMatricula;
	}

	public void setNMatricula(String nMatricula) {
		this.nMatricula = nMatricula;
	}

}