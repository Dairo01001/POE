package Layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 * @author Dairo García Naranjo
 */
public class CardL1 extends JFrame {

    public CardL1() {
        this.initJPanel();
        this.initComponents();
    }

    private void initJPanel() {
        this.setTitle("Card Layout");
        this.setSize(400, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel comBoxPanel = new JPanel();
        String comBoxItem[] = {this.BUTTON, this.TEXTFIELD, this.SLIDER};
        JComboBox cb = new JComboBox(comBoxItem);
        cb.setEditable(false);
        cb.setFont(this.FONT);
        cb.addItemListener((ItemEvent e) -> {
            CardLayout cl = (CardLayout) (this.cartas.getLayout());
            cl.show(cartas, (String)e.getItem());
        });
        comBoxPanel.add(cb);
        this.add(comBoxPanel, BorderLayout.NORTH);

        JPanel carta = new JPanel();
        carta.add(this.jButton("UNO"));
        carta.add(this.jButton("DOS"));
        carta.add(this.jButton("TRES"));
        
        JPanel carta1 = new JPanel();
        carta1.add(this.jTextField("......"));
        carta1.add(this.jTextField("......"));
        
 
        JPanel carta2 = new JPanel();
        carta2.add(this.jSlider());
        
        this.cartas = new JPanel(new CardLayout());
        this.cartas.add(carta, this.BUTTON);
        this.cartas.add(carta1, this.TEXTFIELD);
        this.cartas.add(carta2, this.SLIDER);
        
        this.add(this.cartas, BorderLayout.CENTER);
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

    private final String BUTTON = "JButton";
    private final String TEXTFIELD = "JTextField";
    private final String SLIDER = "JSlider";

    private JPanel cartas;
    
    private final Font FONT = new Font("Courier New", Font.BOLD, 20);

    public static void main(String[] args) {
        CardL1 ventana = new CardL1();
        ventana.setVisible(true);
    }
}
