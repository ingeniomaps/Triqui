package Modelo;

import Vista.Cliente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class C_Triqui implements MouseListener {

    public Cuadro juego;
    public JLabel[][] fichas;
    public ImageIcon[][] imagenes;
    private int ancho = 100, largo = 80, turno = 0, oponente = 0;
    private int[][] jugada;
    public ImageIcon[] ficha = new ImageIcon[4];
    private Cliente cl = null;

    public void setCliente(Cliente ref) {
        this.cl = ref;
    }

    public C_Triqui() {
        juego = new Cuadro();
        fichas = new JLabel[3][3];
        imagenes = new ImageIcon[2][3];
        jugada = new int[3][3];
        imagenes();
        cargarFichas();
    }

    private void imagenes() {
        for (int i = 0; i < 3; i++) {
            imagenes[0][i] = new ImageIcon("archivos/Imagenes/" + (i + 1) + ".png");
            imagenes[1][i] = new ImageIcon(imagenes[0][i].getImage().getScaledInstance(ancho, largo, Image.SCALE_DEFAULT));
        }
    }

    private void cargarFichas() {
        int x = 10, y = 10;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fichas[i][j] = new JLabel();
                fichas[i][j].setBounds(x, y, ancho, largo);
                fichas[i][j].addMouseListener(this);
                jugada[i][j] = 0;
                juego.add(fichas[i][j]);
                x += ancho + 10;
            }
            x = 10;
            y += largo + 10;
        }
    }

    public void jugada(String pos) {
        String[] posicion = pos.split(",");
        int i = Integer.parseInt(posicion[0]);
        int j = Integer.parseInt(posicion[1]);
        fichas[i][j].setIcon(ficha[3]);
        jugada[i][j] = 1;
        setTurno(2);
    }

    public void limpiar() {
        juego.removeAll();
        cargarFichas();
        juego.setVisible(false);
        juego.setVisible(true);
        juego.repaint();
    }

    public void elegirFicha(int j, int n) {
        if (j == 1) {
            ficha[0] = new ImageIcon("archivos/Imagenes/" + (n) + ".png");
            ficha[1] = new ImageIcon(ficha[0].getImage().getScaledInstance(ancho, largo, Image.SCALE_DEFAULT));
        } else {
            ficha[2] = new ImageIcon("archivos/Imagenes/" + (n) + ".png");
            ficha[3] = new ImageIcon(ficha[2].getImage().getScaledInstance(ancho, largo, Image.SCALE_DEFAULT));
        }
    }

    public void comprobar(String mensaje) {
        int n = Integer.parseInt(mensaje);
        if (n != 0) {
            if (n == 2) {
                JOptionPane.showMessageDialog(juego, "Ganaste");
            } else if (n == 1) {
                JOptionPane.showMessageDialog(juego, "Perdiste");
            } else if (n == 3) {
                JOptionPane.showMessageDialog(juego, "Empate");
            }
            limpiar();
        }
    }

    public void colocarJuegoVentana() {
        juego.setBackground(Color.BLUE);
        juego.setBorder(BorderFactory.createEmptyBorder(20, 12, 15, 13));
        juego.setBounds(10, 20, 350, 280);
        this.cl.contenido.add(juego, BorderLayout.CENTER);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (getTurno() == 2) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (me.getSource() == fichas[i][j] && jugada[i][j] == 0) {
                        fichas[i][j].setIcon(ficha[1]);
                        jugada[i][j] = 2;
                        cl.cl.enviarDatos(i + "," + j);
                        setTurno(1);
                        i = 3;
                        j = 3;
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (me.getSource() == fichas[i][j] && jugada[i][j] == 0) {
                    //fichas[i][j].setIcon(imagenes[1][0]);
                    fichas[i][j].setCursor(new Cursor(Cursor.HAND_CURSOR));
                    i = 3;
                    j = 3;
                } else if (jugada[i][j] != 0) {
                    fichas[i][j].setCursor(null);
                }

            }
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        /*  for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
         if (me.getSource() == fichas[i][j] && jugada[i][j] == 0) {
         fichas[i][j].setIcon(null);
         i = 3; j=3;
         }
         }
         }*/
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getOponente() {
        return oponente;
    }

    public void setOponente(int oponente) {
        this.oponente = oponente;
    }
    
}
