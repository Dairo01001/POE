package Layout;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Dairo García Naranjo
 */
public class GridL extends JFrame {

    public GridL() {
        this.initJFrame();
        this.initComponents();
    }

    private void initJFrame() {
        this.setTitle("Grid Layout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.getContentPane().setLayout(new GridLayout(2, 2));
        this.add(this.jButton("UNO"));
        this.add(this.jButton("DOS"));
        this.add(this.jButton("TRES"));
        this.add(this.jButton("CUATRO"));
        this.pack();
    }

    private JButton jButton(String nombre) {
        JButton jb = new JButton(nombre);
        jb.setFont(FONT);
        return jb;
    }

    private final Font FONT = new Font("Courier New", Font.BOLD, 20);

    public static void main(String[] args) {
        GridL ventana = new GridL();
        ventana.setVisible(true);
    }
}
