package Control;

import Vista.Servidor;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class S_Funcion {

    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private ServerSocket servidor;
    private Socket conexion;
    private int contador = 1;
    public Servidor ser = null;

    public void refServidor(Servidor ref) {
        ser = ref;
    }

    public S_Funcion() {
    }

    public void ejecutarServidor() {
        try {

            servidor = new ServerSocket(12345, 100);
            while (true) {
                try {
                    esperarConexion();
                    obtenerInf();
                    procesarConexion();
                } catch (EOFException ex) {
                    JOptionPane.showMessageDialog(null, "El servidor terminó la conexión", "Resultado", JOptionPane.PLAIN_MESSAGE);
                } finally {
                    cerrarConexion();
                    ++contador;
                }
            }
        } catch (IOException excepcionES) {
            excepcionES.printStackTrace();
        }
    }

    private void esperarConexion() throws IOException {
        mostrarMensaje("Esperando una conexión\n");
        conexion = servidor.accept();
        mostrarMensaje("Conexión " + contador + " recibida de: " + conexion.getInetAddress().getHostName());
    }

    private void obtenerInf() throws IOException {
        salida = new ObjectOutputStream(conexion.getOutputStream());
        salida.flush();
        entrada = new ObjectInputStream(conexion.getInputStream());
        mostrarMensaje("\nConexion Exitosa\n");
    }

    private void procesarConexion() throws IOException {
        String mensaje = "Conexión exitosa";
        enviarDatos(mensaje);
        do { // procesar los mensajes enviados por el cliente
            try {
                mensaje = (String) entrada.readObject();
                if (mensaje.length() == 1) {
                    System.out.println("hola");
                } else if (mensaje.length() == 3) {
                    ser.movimiento(mensaje);
                } else if (Integer.parseInt(mensaje) < 0) {
                    ser.st.setOponente(Integer.parseInt(mensaje) * (-1));
                    ser.st.elegirFicha(2, (Integer.parseInt(mensaje) * (-1)));
                }
            } catch (ClassNotFoundException excepcionClaseNoEncontrada) {
                mostrarMensaje("\nSe recibió un tipo de objeto desconocido");
            }
        } while (!mensaje.equals("CLIENTE>>> TERMINAR"));
    }

    private void cerrarConexion() {
        mostrarMensaje("\nConexión finalizada\n");
        try {
            salida.close();
            entrada.close();
            conexion.close();
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
                    ser.op.removeAll();
                    ser.op.selecionarImagen();
                    ser.colocarOpciones();
                    ser.activar(2);
                } else {
                    ser.op.removeAll();
                    ser.op.aviso.setText(mensajeAMostrar);
                    ser.op.aviso();
                    ser.colocarOpciones();
                }
            }
        });
    }
}
