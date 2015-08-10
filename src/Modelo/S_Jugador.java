package Modelo;

import Vista.Servidor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class S_Jugador implements ActionListener {

    private Servidor ser = null;

    public void refServidor(Servidor ref) {
        ser = ref;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ser != null) {
            if ("Si".equals(ae.getActionCommand())) {
                ser.st.setTurno(1);
                ser.sf.enviarDatos("" + 1);
                ser.mostrarInterfaz();
            } else if ("No".equals(ae.getActionCommand())) {
                ser.st.setTurno(2);
                ser.sf.enviarDatos("" + 2);
                ser.mostrarInterfaz();
            } else if ("Aceptar".equals(ae.getActionCommand())) {
                for (int i = 0; i < ser.op.ni; i++) {
                    if (ser.op.imagenes[i].isSelected() && (i + 1) != ser.st.getOponente()) {
                        ser.op.removeAll();
                        ser.op.elegir();
                        ser.activar(1);
                        ser.colocarOpciones();
                        ser.sf.enviarDatos(((-1) * (i + 1)) + "");
                        ser.st.elegirFicha(1, (i + 1));
                        i = ser.op.ni;
                    } else if ((i + 1) == ser.st.getOponente()) {
                        JOptionPane.showMessageDialog(ser.op, "Su Contrincante ya eligio esta figura\nElija otra figura");
                    }
                }
            }
        }
    }
}
