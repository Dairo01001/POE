package Layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Dairo Garcia
 */
public class FlowLayoutEjemplo extends JFrame {

    public FlowLayoutEjemplo() {
        this.initJFrame();
        this.initComponets();
    }

    private void initJFrame() {
        this.setTitle("FlowLayout - BorderLayout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.DARK_GRAY);
    }

    private void initComponets() {
        this.initJP1();
        this.pack();
    }
    
    private void initJP2(){
        
    }
    
    private void initJP1() {
        this.jPanel = new JPanel(new BorderLayout());
        this.jPanel.add(this.initJButton("NORTH", Color.RED), BorderLayout.NORTH);
        this.jPanel.add(this.initJButton("CENTER", Color.BLUE), BorderLayout.CENTER);
        this.jPanel.add(this.initJButton("EAST", Color.GREEN), BorderLayout.EAST);
        this.jPanel.add(this.initJButton("WEST", Color.YELLOW), BorderLayout.WEST);
        this.jPanel.add(this.initJButton("SOUTH", Color.PINK), BorderLayout.SOUTH);
        this.add(this.jPanel, BorderLayout.SOUTH);
    }

    private JButton initJButton(String nombre, Color color) {
        JButton jBtn = new JButton(nombre);
        jBtn.setBackground(color);
        jBtn.setFont(this.font);
        return jBtn;
    }

    private JPanel jPanel;

    private final Font font = new Font("Courier New", Font.BOLD, 20);

    public static void main(String[] args) {
        FlowLayoutEjemplo ventana = new FlowLayoutEjemplo();
        ventana.setVisible(true);
    }
}
