package Controller;

import model.Carrera;
import model.Estudiante;
import model.data.dao.CarreraDao;
import model.data.DBConnector;
import model.data.DBGenerator;
import model.data.dao.EstudianteDao;
import org.jooq.DSLContext;

public class EstudianteController {

	public static boolean registrarEstudiante(String nombre, String apellido, String rut, String matricula, String codigo) throws ClassNotFoundException {
		DSLContext query = DBGenerator.conectarBD("Universidad");
		if(!EstudianteDao.validarExistenciaEstudiante(query,"rut",rut)){
			Carrera carrera = CarreraDao.buscarCarrera(query,codigo);
			Estudiante estudiante= new Estudiante(rut,nombre,apellido,matricula,carrera);
			EstudianteDao.agregarEstudiante(query,estudiante);
			DBConnector.closeConnection();
			return true;
		}
		else{
			DBConnector.closeConnection();
			return false;
		}
	}
	public static String[][] mostrarEstudiantesPorCarrera(String nombreCarrera) throws ClassNotFoundException {
		DSLContext query = DBGenerator.conectarBD("Universidad");
		String[][] datosEstudiantes= EstudianteDao.obtenerEstudiantesCursoCodigo(query,nombreCarrera);
		DBConnector.closeConnection();
		return datosEstudiantes;
	}
	public static String[][] mostrarEstudiantesPorNombre(String nombreCarrera, String nombre) throws ClassNotFoundException {
		DSLContext query = DBGenerator.conectarBD("Universidad");
		String[][] datosEstudiantes = EstudianteDao.obtenerEstudiantesCursoNombre(query,nombre,nombreCarrera);
		DBConnector.closeConnection();
		return datosEstudiantes;
	}
}

