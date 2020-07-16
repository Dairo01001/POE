package Layout;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Dairo Garcia
 */
public class FrutasLayout extends JFrame implements ActionListener {

    public FrutasLayout() {
        this.initJFrame();
        this.initComponets();
    }

    private void initJFrame() {
        this.setTitle("Frutas - Layout");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponets() {
        this.initJPanelFrutas();
        this.initJTextArea();
    }

    private void initJPanelFrutas() {
        String[] frutas = {"Pera", "Manzana", "Melon", "Sandia", "Uva", "Mora"};
        this.jPanelFrutas = new JPanel(new GridLayout(frutas.length, 1));
        this.jRadioButtonFrutas = new JRadioButton[frutas.length];
        ButtonGroup buttonGroupFrutas = new ButtonGroup();
        int i = 0;
        for (JRadioButton jRb : this.jRadioButtonFrutas) {
            jRb = new JRadioButton(frutas[i++]);
            jRb.addActionListener(this);
            jRb.setFont(this.font);
            buttonGroupFrutas.add(jRb);
            this.jPanelFrutas.add(jRb);
        }
        this.add(this.jPanelFrutas, BorderLayout.WEST);
    }

    private void initJTextArea() {
        this.jTextAreaFrutas = new JTextArea();
        this.jTextAreaFrutas.setEditable(false);
        this.jTextAreaFrutas.setFont(this.font);
        JScrollPane scrollPane = new JScrollPane(this.jTextAreaFrutas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    private JRadioButton jRadioButtonFrutas[];
    private JTextArea jTextAreaFrutas;
    private JPanel jPanelFrutas;
    private final Font font = new Font("Courier New", Font.BOLD, 20);

    public static void main(String[] args) {
        FrutasLayout ventana = new FrutasLayout();
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.jTextAreaFrutas.append(e.getActionCommand() + '\n');
    }
}
