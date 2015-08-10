package Modelo;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.GroupLayout;
import javax.swing.JPanel;

public class Cuadro extends JPanel {

    public Cuadro() {
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.drawLine(115, 0, 115, 300);
        g.drawLine(225, 0, 225, 300);
        g.drawLine(0, 95, 340, 95);
        g.drawLine(0, 185, 340, 185);
        setOpaque(false);
        super.paintComponent(g);
    }

    private void initComponents() {
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE));
    }
}
