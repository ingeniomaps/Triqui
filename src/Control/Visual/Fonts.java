package Control.Visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;

public class Fonts {

    public JLabel Arial(String nombre, Color c) {
        JLabel l = new JLabel(nombre);
        l.setForeground(c);
        l.setFont(new Font("Arial", Font.BOLD, 14));
        return l;
    }

    public JLabel brooklyn(String nombre, int tam, Color c) {
        JLabel l = new JLabel(nombre);
        try {
            File fuente = new File("archivos/Fonts/brooklyn.ttf");
            Font ttfBase = Font.createFont(Font.TRUETYPE_FONT, fuente);
            Font ttfReal = ttfBase.deriveFont(Font.PLAIN, tam);
            l.setForeground(c);
            l.setFont(ttfReal);
        } catch (FontFormatException ex) {
            System.out.println("Error: " + ex);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        return l;
    }

    public JLabel SignPaintersGothicShaded(String nombre, int tam, Color c) {
        JLabel l = new JLabel(nombre);
        try {
            File fuente = new File("archivos/Fonts/SignPaintersGothicShaded.ttf");
            Font ttfBase = Font.createFont(Font.TRUETYPE_FONT, fuente);
            Font ttfReal = ttfBase.deriveFont(Font.PLAIN, tam);
            l.setForeground(c);
            l.setFont(ttfReal);
        } catch (FontFormatException ex) {
            System.out.println("Error: " + ex);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        return l;
    }

    public JLabel belta_Light(String nombre, int tam, Color c) {
        JLabel l = new JLabel(nombre);
        try {
            File fuente = new File("archivos/Fonts/belta_light.ttf");
            Font ttfBase = Font.createFont(Font.TRUETYPE_FONT, fuente);
            Font ttfReal = ttfBase.deriveFont(Font.PLAIN, tam);
            l.setForeground(c);
            l.setFont(ttfReal);
        } catch (FontFormatException ex) {
            System.out.println("Error: " + ex);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        return l;
    }

    public JLabel sin_of_the_innocent(String nombre, int tam, Color c) {
        JLabel l = new JLabel(nombre);
        try {
            File fuente = new File("archivos/Fonts/sin_of_the_innocent.ttf");
            Font ttfBase = Font.createFont(Font.TRUETYPE_FONT, fuente);
            Font ttfReal = ttfBase.deriveFont(Font.PLAIN, tam);
            l.setForeground(c);
            l.setFont(ttfReal);
        } catch (FontFormatException ex) {
            System.out.println("Error: " + ex);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        return l;
    }

    public JLabel Bebedera(String nombre, int tam, Color c) {
        JLabel l = new JLabel(nombre);
        try {
            File fuente = new File("archivos/Fonts/Bebedera.ttf");
            Font ttfBase = Font.createFont(Font.TRUETYPE_FONT, fuente);
            Font ttfReal = ttfBase.deriveFont(Font.PLAIN, tam);
            l.setForeground(c);
            l.setFont(ttfReal);
        } catch (FontFormatException ex) {
            System.out.println("Error: " + ex);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        return l;
    }

    public JLabel karloff(String nombre, int tam, Color c) {
        JLabel l = new JLabel(nombre);
        try {
            File fuente = new File("archivos/Fonts/karloff.ttf");
            Font ttfBase = Font.createFont(Font.TRUETYPE_FONT, fuente);
            Font ttfReal = ttfBase.deriveFont(Font.PLAIN, tam);
            l.setForeground(c);
            l.setFont(ttfReal);
        } catch (FontFormatException ex) {
            System.out.println("Error: " + ex);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        return l;
    }

    public Font elige(String nombre, int tam) {
        Font ttfReal = null;
        try {
            File fuente = new File("archivos/Fonts/" + nombre + ".ttf");
            Font ttfBase = Font.createFont(Font.TRUETYPE_FONT, fuente);
            ttfReal = ttfBase.deriveFont(Font.PLAIN, tam);
        } catch (FontFormatException ex) {
            System.out.println("Error: " + ex);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        return ttfReal;
    }
}
