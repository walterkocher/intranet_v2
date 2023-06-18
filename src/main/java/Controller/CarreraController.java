package Controller;

import model.Carrera;
import model.data.dao.CarreraDao;
import model.data.DBConnector;
import model.data.DBGenerator;
import org.jooq.DSLContext;

public class CarreraController {

	public static boolean añadirCarrera(String nombreCarrera, String codigoCarrera, int cantSemestres) throws ClassNotFoundException {
		DSLContext query = DBGenerator.conectarBD("Universidad");
		if(!CarreraDao.validarExistenciaCarrera(query,"codigo",codigoCarrera)){
			Carrera carrera = new Carrera(nombreCarrera,codigoCarrera,cantSemestres);
			CarreraDao.agregarCarrera(query,carrera);
			DBConnector.closeConnection();
			return true;
		}
		else{
			return false;
		}
	}
	public static Object[] getCodigoCarreras() throws ClassNotFoundException {
		DSLContext query = DBGenerator.conectarBD("Universidad");
		Object[] carreras = CarreraDao.getCodigoCarreras(query);
		DBConnector.closeConnection();
		return carreras;
	}
	public static Object[] getNombreCarrera() throws ClassNotFoundException {
		DSLContext query = DBGenerator.conectarBD("Universidad");
		Object[] carreras = CarreraDao.getNombreCarreras(query);
		DBConnector.closeConnection();
		return carreras;}

}