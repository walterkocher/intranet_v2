package view;
import javax.swing.*;
import java.awt.event.*;
public class VentanaBienvenida extends Ventana {

    private JLabel textoMenu;
    private JButton botonRegistrarCarrera;
    private JButton botonSalida;
    private JButton botonRegistrarEstudiante;
    private JButton botonBuscarEstudiante;

    public VentanaBienvenida() {
        super("Menu Intranet", 500, 520);
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonRegistrarCarrera();
        generarBotonRegistrarEstudiante();
        generarBotonBuscarEstudiante();
        generarBotonSalir();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "Intranet 2.0";
        super.generarJLabelEncabezado(this.textoMenu, textoBienvenida, 20, 30, 500, 30);
    }

    private void generarBotonRegistrarCarrera() {
        String textoBoton = "Registrar Carrera";
        this.botonRegistrarCarrera = super.generarBoton(textoBoton, 150, 100, 175, 40);
        this.add(this.botonRegistrarCarrera);
        this.botonRegistrarCarrera.addActionListener(this);
    }

    private void generarBotonSalir() {
        String textoBoton = "Salir";
        this.botonSalida = super.generarBoton(textoBoton, 150, 420, 175, 40);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }

    private void generarBotonRegistrarEstudiante() {
        String textoBoton = "Registrar Estudiante";
        this.botonRegistrarEstudiante = super.generarBoton(textoBoton, 150, 180, 175, 40);
        this.add(this.botonRegistrarEstudiante);
        this.botonRegistrarEstudiante.addActionListener(this);
    }
    private void generarBotonBuscarEstudiante(){
        String textoBoton = "Buscar estudiante";
        this.botonBuscarEstudiante=super.generarBoton(textoBoton, 150, 260, 175, 40);
        this.add(this.botonBuscarEstudiante);
        this.botonBuscarEstudiante.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrarCarrera) {
            VentanaRegistroCarrera ventanaRegistroCarrera = new VentanaRegistroCarrera();
            //Cierra la ventana actual
            this.dispose();
        }
        if(e.getSource() == this.botonRegistrarEstudiante){
            try {
                VentanaRegistroEstudiante ventanaRegistroEstudiante = new VentanaRegistroEstudiante();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }
        if(e.getSource() == this.botonBuscarEstudiante){
            try {
                VentanaBusquedaEstudiante ventanaBusquedaEstudiante = new VentanaBusquedaEstudiante();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            this.dispose();
        }

        if(e.getSource() == this.botonSalida){
            this.dispose();
            System.exit(0);
        }

    }
}

