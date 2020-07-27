package Layout;

import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Dairo García Naranjo
 */

public class BoxL extends JFrame {
    
    public BoxL() {
        this.initJFrame();
        this.initComponents();
    }
    
    private void initJFrame() {
        this.setTitle("Box Layout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel jP = new JPanel();
        jP.setLayout(new BoxLayout(jP, BoxLayout.X_AXIS));
         
        jP.add(this.jButton("UNO"));
        jP.add(this.jButton("DOS"));
        jP.add(this.jButton("TRES"));
        jP.add(this.jButton("CUATRO"));
        
        this.add(jP);
        this.pack();
    }
    
    private JButton jButton(String nombre){
        JButton jb = new JButton(nombre);
        jb.setFont(this.FONT);
        return jb; 
    }
    
    private final Font FONT = new Font("Courier New", Font.BOLD, 20);
    
    public static void main(String[] args) {
        BoxL ventana = new BoxL();
        ventana.setVisible(true);
    }
}
