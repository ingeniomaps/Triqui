package Modelo;

import Vista.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class C_Jugador implements ActionListener {

    private Cliente cl = null;

    public void refCliente(Cliente ref) {
        cl = ref;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (cl != null) {
            if ("Si".equals(ae.getActionCommand())) {
                cl.ct.setTurno(2);
                cl.cl.enviarDatos("" + 2);
            } else if ("No".equals(ae.getActionCommand())) {
                cl.ct.setTurno(1);
                cl.cl.enviarDatos("" + 1);
            } else if ("Aceptar".equals(ae.getActionCommand())) {
                for (int i = 0; i < cl.op.ni; i++) {
                    if (cl.op.imagenes[i].isSelected()  && (i+1)!=cl.ct.getOponente()) {
                        cl.op.removeAll();
                        cl.op.elegir();
                        cl.activar(1);
                        cl.colocarOpciones();
                        cl.cl.enviarDatos(((-1) * (i + 1)) + "");
                        cl.ct.elegirFicha(1, (i + 1));
                        i = cl.op.ni;
                    }else if((i+1)==cl.ct.getOponente()){
                        JOptionPane.showMessageDialog(cl.op, "Su Contrincante ya eligio esta figura\nElija otra figura");
                    }
                }
            }
        }
    }
}
