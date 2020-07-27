package Layout;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 * @author Dairo García Naranjo
 */
public class CardL extends JFrame {

    public CardL() {
        this.initJFrame();
        this.initComponents();
    }

    private void initJFrame() {
        this.setTitle("Card Layout");
        this.setSize(400, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        JTabbedPane tP = new JTabbedPane();
        tP.setFont(this.FONT);
        
        this.carta = new JPanel();
        this.carta.add(this.jButton("UNO"));
        this.carta.add(this.jButton("DOS"));
        this.carta.add(this.jButton("TRES"));

        this.carta1 = new JPanel();
        this.carta1.add(this.jTextField("......"));
        this.carta1.add(this.jTextField("......"));

        this.carta2 = new JPanel();
        this.carta2.add(this.jSlider());

        tP.addTab("Button", this.carta);
        tP.addTab("Text Field", this.carta1);
        tP.addTab("Slider", this.carta2);

        this.add(tP, BorderLayout.CENTER);
    }

    private JTextField jTextField(String texto) {
        JTextField jtf = new JTextField(texto);
        jtf.setFont(this.FONT);
        return jtf;
    }

    private JButton jButton(String nombre) {
        JButton jb = new JButton(nombre);
        jb.setFont(this.FONT);
        return jb;
    }

    private JSlider jSlider() {
        JSlider js = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        js.setMajorTickSpacing(5);
        js.setMinorTickSpacing(1);
        js.setPaintTicks(true);
        js.setPaintLabels(true);
        js.setFont(this.FONT);
        return js;
    }

    private JPanel carta, carta1, carta2;
    private final Font FONT = new Font("Courier New", Font.BOLD, 20);

    public static void main(String[] args) {
        CardL ventana = new CardL();
        ventana.setVisible(true);
    }
}
