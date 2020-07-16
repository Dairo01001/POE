package Layout;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author Dairo Garcia Naranjo
 */
public class ImagenesLayout extends JFrame {

    public ImagenesLayout() {
        this.initJFrame();
        this.initComponets();
    }

    private void initJFrame() {
        this.setTitle("Imagenes - Layout");
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponets() {
        this.img = new Img();
        this.jPanelNombres = new JPanel(new GridLayout(this.img.getNOMBRES().length, 1));
        this.initJRadioButtons();
        this.imagen = new JLabel();
        this.add(this.imagen, BorderLayout.CENTER);
    }

    private void initJRadioButtons() {
        ButtonGroup bTg = new ButtonGroup();
        this.actionListener = (ActionEvent e) -> {
            this.imagen.setIcon(this.img.getIMG().get(e.getActionCommand()));
        };
        for (String nombre : this.img.getNOMBRES()) {
            JRadioButton jRb = new JRadioButton(nombre);
            jRb.setFont(this.font);
            bTg.add(jRb);
            jRb.addActionListener(actionListener);
            this.jPanelNombres.add(jRb);
        }
        this.add(this.jPanelNombres, BorderLayout.WEST);
    }

    private class Img {

        public Img() {
            this.IMG = new HashMap();
            this.Cargar();
        }

        public HashMap<String, ImageIcon> getIMG() {
            return IMG;
        }

        public String[] getNOMBRES() {
            return NOMBRES;
        }

        private void Cargar() {
            for (String nombre : this.NOMBRES) {
                this.IMG.put(nombre, new ImageIcon("src" + this.SEPARADOR + "data" + this.SEPARADOR + nombre + ".png"));
            }
        }

        private final char SEPARADOR = File.separatorChar;
        private final String[] NOMBRES = {"Bills", "Broly", "Cell", "Majin Boo", "Son Goku"};
        private final HashMap<String, ImageIcon> IMG;
    }

    private JPanel jPanelNombres;
    private JLabel imagen;
    private final Font font = new Font("Courier New", Font.BOLD, 20);
    private Img img;
    private ActionListener actionListener;

    public static void main(String[] args) {
        ImagenesLayout ventana = new ImagenesLayout();
        ventana.setVisible(true);
    }
}
