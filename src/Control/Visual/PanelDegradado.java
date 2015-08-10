package Control.Visual;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.GroupLayout;
import javax.swing.JPanel;

public class PanelDegradado extends JPanel {

    private Color colorSuperior;
    private Color colorInferior;

    public PanelDegradado(Color s, Color i) {
        super();
        initComponents();
        setOpaque(false);
        colorSuperior = s;
        colorInferior = i;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(new GradientPaint(0.0f, 0.0f, getColorPrimario().darker(),
                0.0f, getHeight(), getColorSecundario().darker()));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setStroke(new BasicStroke(4f));
        super.paintComponent(g);
    }

    //Con estas especificaciones podemos hacer que todo lo que agregemos quede
    //en una posicion especifica
    private void initComponents() {
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE));
    }

    public Color getColorPrimario() {
        return colorSuperior;
    }

    public void setColorPrimario(Color colorPrimario) {
        this.colorSuperior = colorPrimario;
    }

    public Color getColorSecundario() {
        return colorInferior;
    }

    public void setColorSecundario(Color colorSecundario) {
        this.colorInferior = colorSecundario;
    }
}