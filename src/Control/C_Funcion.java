package Control;

import Vista.Cliente;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class C_Funcion {

    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private String mensaje = "";
    private String servidorChat;
    private Socket cliente;
    private Cliente cl = null;

    public void refCliente(Cliente ref) {
        cl = ref;
    }

    public C_Funcion(String host) {
        servidorChat = host;
    }

    public void ejecutarCliente() {
        try {
            conectarAServidor();
            obtenerInf();
            procesarConexion();
        } catch (EOFException excepcionEOF) {
            JOptionPane.showMessageDialog(null, "El cliente terminó la conexión", "Resultado", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException excepcionES) {
            excepcionES.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    private void conectarAServidor() throws IOException {
        mostrarMensaje("Intentando realizar conexión\n");
        cliente = new Socket(InetAddress.getByName(servidorChat), 12345);
        mostrarMensaje("Conectado a: " + cliente.getInetAddress().getHostName());
    }

    private void obtenerInf() throws IOException {
        salida = new ObjectOutputStream(cliente.getOutputStream());
        salida.flush();
        entrada = new ObjectInputStream(cliente.getInputStream());
        mostrarMensaje("\nConexion Exitosa\n");
    }
    
    int n = 0, aux = 0, aux1 = 0;

    private void procesarConexion() throws IOException {
        do {
            try {
                mensaje = (String) entrada.readObject();
                if (mensaje.length() == 1) {
                    if (aux == 0) {
                        cl.contenido.removeAll();
                        cl.mostrarInterfaz();
                        cl.contenido.setVisible(false);
                        cl.contenido.setVisible(true);
                        cl.ct.setTurno(Integer.parseInt(mensaje));
                        aux = 1;
                    } else {
                        cl.ct.comprobar(mensaje);
                    }
                } else if (n == 1 && mensaje.length() == 3) {
                    cl.movimiento(mensaje);
                } else if (n == 1 && Integer.parseInt(mensaje) < 0) {
                    cl.ct.setOponente(Integer.parseInt(mensaje) * (-1));
                    cl.ct.elegirFicha(2, (Integer.parseInt(mensaje) * (-1)));
                }
                n = 1;
            } catch (ClassNotFoundException excepcionClaseNoEncontrada) {
                mostrarMensaje("\nSe recibió un objeto de tipo desconocido");
            }
        } while (!mensaje.equals("SERVIDOR>>> TERMINAR"));
    }

    public void cerrarConexion() {
        try {
            mostrarMensaje("\nCerrando conexión");
            salida.close();
            entrada.close();
            cliente.close();
        } catch (IOException excepcionES) {
            excepcionES.printStackTrace();
        }
    }

    public void enviarDatos(String mensaje) {
        try {
            salida.writeObject(mensaje);
            salida.flush();
        } catch (IOException excepcionES) {
            System.out.println("Error: " + excepcionES);
        }
    }

    private void mostrarMensaje(final String mensajeAMostrar) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if ("\nConexion Exitosa\n".equals(mensajeAMostrar)) {
                    cl.op.removeAll();
                    cl.op.selecionarImagen();
                    cl.colocarOpciones();
                    cl.activar(2);
                } else {
                    cl.op.removeAll();
                    cl.op.aviso.setText(mensajeAMostrar);
                    cl.op.aviso();
                    cl.colocarOpciones();
                }
            }
        });
    }
}
