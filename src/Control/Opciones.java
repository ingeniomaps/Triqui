package Control;

import Control.Visual.Fonts;
import Control.Visual.BotonCircular;
import Control.Visual.PanelDegradado;
import Control.Visual.ToggleBoton;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;

public class Opciones extends PanelDegradado {

    private Fonts f = new Fonts();
    public JLabel aviso;
    public ToggleBoton imagenes[];
    public int ni = 5;
    public BotonCircular c1, c2;

    public Opciones() {
        super(new Color(0x82f9ba), new Color(0x3ab272));
        aviso = f.Bebedera("Esperando Conexion...", 30, new Color(0xc2f1ff));
    }

    public void elegir() {

        JLabel aux = f.sin_of_the_innocent("Conexion Exitosa", 14, new Color(0x55dc8e));
        JLabel aux1 = f.Bebedera("Desea Mover Primero", 30, new Color(0xc2f1ff));
        c1 = new BotonCircular("Si");
        c2 = new BotonCircular("No");

        c1.setBounds(50, 100, 120, 120);
        c2.setBounds(200, 100, 120, 120);
        aux.setBounds(220, 290, 150, 25);
        aux1.setBounds(50, 50, 300, 25);

        this.add(c1);
        this.add(c2);
        this.add(aux);
        this.add(aux1);

    }

    public void selecionarImagen() {
        JLabel aux = f.Bebedera("Selecione la figura", 30, new Color(0xc2f1ff));
        JLabel aux1 = f.Bebedera("con la que desea jugar", 30, new Color(0xc2f1ff));
        c1 = new BotonCircular("Aceptar");


        c1.setBounds(235, 240, 120, 70);
        aux.setBounds(60, 15, 300, 35);
        aux1.setBounds(35, 50, 350, 35);

        int x = 5, y = 95, cont = 0;
        imagenes = new ToggleBoton[ni];
        ButtonGroup grupo = new ButtonGroup();

        for (int i = 0; i < ni; i++) {
            imagenes[i] = new ToggleBoton("../../Imagenes/" + (i + 1) + ".png");
            imagenes[i].setBounds(x, y, 70, 70);
            grupo.add(imagenes[i]);
            this.add(imagenes[i]);
            x += 72;
            cont++;
            if (cont == 5) {
                x = 5;
                y += 72;
                cont = 0;
            }
        }

        this.add(c1);
        this.add(aux);
        this.add(aux1);
    }

    public void aviso() {
        aviso.setBounds(20, 120, 350, 35);
        this.add(aviso);
    }
}
