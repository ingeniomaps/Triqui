package Control.Visual;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ButtonModel;
import javax.swing.JButton;

public class BotonCircular extends JButton {

    private Color color1, color2, color3;
    private Fonts f = new Fonts();

    public BotonCircular(String nombre) {
        super(nombre);
        this.setColor1(new Color(0x80b1ee));
        this.setColor2(new Color(0x096eeb));
        this.setColor3(new Color(0x959595));
        setOpaque(false);
        setContentAreaFilled(false);
        setFont(f.elige("sin_of_the_innocent", 15));
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setBorderPainted(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Color c1, c2, c3;
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        ButtonModel m = getModel();

        if (m.isArmed()) {
            c2 = getColor1().darker();
            c1 = getColor2().darker();
            c3 = getColor3().darker();
        } else {
            c1 = getColor1();
            c2 = getColor2();
            c3 = getColor3().darker();
        }
        if (m.isRollover()) {
            c3 = getColor3().brighter();
        }
        if (m.isPressed()) {
            c3 = getColor3().darker();
        }

        g2.setPaint(new GradientPaint(0.0f, 0.0f, c1, 0.0f, getHeight(), c2));
        g2.fillOval(1, 1, getWidth() - 4, getHeight() - 4);
        g2.setStroke(new BasicStroke(2f));
        g2.setPaint(new GradientPaint(0.0f, 0.0f, c3, 0.0f, getHeight(), c3));
        g2.drawRoundRect(1, 1, getWidth() - 4, getHeight() - 4, getWidth(), getHeight());

        super.paintComponent(g);
    }

    public Color getColor1() {
        return color1;
    }

    private void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    private void setColor2(Color color2) {
        this.color2 = color2;
    }

    public Color getColor3() {
        return color3;
    }

    private void setColor3(Color color3) {
        this.color3 = color3;
    }
}