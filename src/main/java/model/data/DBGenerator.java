package model.data;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {

    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root","");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create,nombreBD);
        create = actualizarConexion(nombreBD);
        crearTablaCarrera(create);
        crearTablaEstudiante(create);
        relacionarTabla(create,"Estudiante","codigo_carrera","Carrera");
        DBConnector.closeConnection();

    }
    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre,"root","");
        DSLContext create = DSL.using(connection);
        return create;
    }
    //Crea una base de datos en caso de que no exista
    private static void crearBaseDato(DSLContext create, String nombreBD){
        create.createDatabaseIfNotExists(nombreBD).execute();
    }
    //Actualiza la conexion inicial para conectar a la base de datos
    private static DSLContext actualizarConexion(String nombreBD){
        DBConnector.closeConnection();
        Connection connection = DBConnector.connection(nombreBD, "root", "");
        return DSL.using(connection);
    }

    private static void crearTablaCarrera(DSLContext create){
        create.createTableIfNotExists("Carrera")
                .column("nombre_carrera",VARCHAR(100))
                .column("codigo",VARCHAR(50))
                .column("cantidad_semestres",INTEGER)
                .constraint(primaryKey("codigo")).execute();
    }

    private static void crearTablaEstudiante(DSLContext create){
        create.createTableIfNotExists("Estudiante")
                .column("rut",VARCHAR(50))
                .column("nombre",VARCHAR(50))
                .column("apellido",VARCHAR(50))
                .column("matricula",VARCHAR(50))
                .column("codigo_carrera",VARCHAR(50))
                .constraint(primaryKey("rut")).execute();

    }
    private static void relacionarTabla(DSLContext create, String nombreTabla, String claveForanea, String nombreTablaRelacion){
        //create.alterTableIfExists(nombreTabla).add(foreignKey(claveForanea).references(nombreTablaRelacion)).execute();
        create.alterTableIfExists(nombreTabla).alterConstraint(foreignKey(claveForanea).references(nombreTablaRelacion)).enforced();
    }
    private static void agregarColumnaTabla(DSLContext create, String nombreTabla, String columna, DataType tipoColumna){
        create.alterTableIfExists(nombreTabla).addColumn(columna,tipoColumna);
    }

}

