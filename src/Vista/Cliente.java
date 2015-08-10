package Vista;

import Control.C_Funcion;
import Control.Opciones;
import Control.Visual.PanelDegradado;
import Modelo.C_Jugador;
import Modelo.C_Triqui;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Cliente extends JFrame {

    public PanelDegradado contenido = new PanelDegradado(new Color(0x82f9ba), new Color(0x3ab272));
    public C_Triqui ct = new C_Triqui();
    public Opciones op = new Opciones();
    public C_Funcion cl;

    public Cliente() {
        super("Cliente");
        this.setSize(380, 350);
        this.setResizable(false);
        this.setLocation(500, 150);
        //this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("archivos/Imagenes/triqui.png"));
        this.add(contenido);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void mostrarInterfaz() {
        contenido.removeAll();
        cl.refCliente(this);
        ct.setCliente(this);
        ct.colocarJuegoVentana();
        contenido.setVisible(false);
        contenido.setVisible(true);

    }

    public void activar(int n) {
        if (n == 1) {
            C_Jugador j = new C_Jugador();
            j.refCliente(this);
            op.c1.addActionListener(j);
            op.c2.addActionListener(j);
        } else if (n == 2) {
            C_Jugador j1 = new C_Jugador();
            j1.refCliente(this);
            op.c1.addActionListener(j1);
        }
    }

    public void movimiento(String jugada) {
        ct.jugada(jugada);
    }

    public void colocarOpciones() {
        contenido.removeAll();
        op.setBounds(0, 0, getWidth(), getHeight());
        contenido.setVisible(false);
        contenido.setVisible(true);
        contenido.add(op);
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        if (args.length == 0) {
            cliente.cl = new C_Funcion("127.0.0.1");
        } else {
            cliente.cl = new C_Funcion(args[ 0]);
        }
        cliente.mostrarInterfaz();
        cliente.cl.ejecutarCliente();
    }
}
