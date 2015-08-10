package Vista;

import Control.Opciones;
import Control.Visual.PanelDegradado;
import Control.S_Funcion;
import Modelo.S_Jugador;
import Modelo.S_Triqui;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Servidor extends JFrame {

    public PanelDegradado contenido = new PanelDegradado(new Color(0x82f9ba), new Color(0x3ab272));
    public Opciones op = new Opciones();
    public S_Triqui st = new S_Triqui();
    public S_Funcion sf = new S_Funcion();

    public Servidor() {
        super("Servidor");

        this.setSize(380, 350);
        this.setResizable(false);
        this.setLocation(20, 150);

        //this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("archivos/Imagenes/triqui.png"));
        this.add(contenido);
        this.mostrarInterfaz();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        sf.ejecutarServidor();
    }

    public void mostrarInterfaz() {
        contenido.removeAll();
        sf.refServidor(this);
        st.refServidor(this);
        st.colocarJuegoVentana();
        contenido.setVisible(false);
        contenido.setVisible(true);
    }

    public void colocarOpciones() {
        contenido.removeAll();
        op.setBounds(0, 0, getWidth(), getHeight());
        contenido.setVisible(false);
        contenido.setVisible(true);
        contenido.add(op);
    }

    public void activar(int n) {
        if (n == 1) {
            S_Jugador j = new S_Jugador();
            j.refServidor(this);
            op.c1.addActionListener(j);
            op.c2.addActionListener(j);
        } else if (n == 2) {
            S_Jugador j1 = new S_Jugador();
            j1.refServidor(this);
            op.c1.addActionListener(j1);
        }
    }

    public void movimiento(String mensaje) {
        st.jugada(mensaje);
    }

    public static void main(String[] args) {
        Servidor servidor = new Servidor();
    }
}
