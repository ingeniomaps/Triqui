package Control.Visual;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

public class ToggleBoton extends JToggleButton {

    private ImageIcon imagen, escala;
    private Color b;

    public ToggleBoton(String nombre) {
        this.setB(new Color(0x959595));
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imagen = new ImageIcon(getClass().getResource(nombre));
        escala = new ImageIcon(imagen.getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT));
        this.setIcon(escala);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Color borde;
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        ButtonModel m = getModel();

        if (m.isSelected()) {
            borde = getB().darker();
            g2.setStroke(new BasicStroke(4f));
            g2.setPaint(new GradientPaint(0.0f, 0.0f, borde, 0.0f, getHeight(), borde));
            g2.drawRoundRect(1, 1, getWidth() - 4, getHeight() - 4, 40, 40);
        }

        super.paintComponent(g);
    }

    public Color getB() {
        return b;
    }

    public void setB(Color b) {
        this.b = b;
    }
}
