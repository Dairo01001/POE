package Layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Dairo Garcia
 */
public class JSliderLayout2 extends JFrame implements ChangeListener, ItemListener, ActionListener {

    public JSliderLayout2() {
        this.initJFrame();
        this.initComponets();
    }

    private void initJFrame() {
        this.setTitle("JSlider 2 - Layout");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponets() {
        this.initJPanelSlider();
        this.initJPanelPanel();
        this.initJPanelOpcions();
        this.initJPanelBotton();
    }

    private void initJPanelSlider() {
        this.jPanelSlider = new JPanel();
        this.jPanelSlider.setLayout(new GridLayout());

        this.red = this.initJSlider();
        this.green = this.initJSlider();
        this.blue = this.initJSlider();

        this.add(this.jPanelSlider, BorderLayout.EAST);
    }

    private JSlider initJSlider() {
        JSlider jSlider = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        jSlider.setMajorTickSpacing(50);
        jSlider.setMinorTickSpacing(5);
        jSlider.setPaintTicks(true);
        jSlider.setPaintLabels(true);
        jSlider.addChangeListener(this);
        jSlider.setFont(this.font);
        this.jPanelSlider.add(jSlider);
        return jSlider;
    }

    private void initJPanelPanel() {
        this.jPanelPanel = new JPanel();
        this.jPanelPanel.setLayout(new GridLayout());

        this.jPanel = initJPanel();
        this.jPanel2 = initJPanel();
        this.jPanel3 = initJPanel();

        this.add(this.jPanelPanel, BorderLayout.CENTER);
    }

    private JPanel initJPanel() {
        JPanel jP = new JPanel();
        jP.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.jPanelPanel.add(jP);
        return jP;
    }

    private void initJPanelOpcions() {
        this.jRadioB = new ButtonGroup();
        this.jPanelOpcions = new JPanel();

        this.jRadioButton = this.initJRadioButton("Panel N°1");
        this.jRadioButton2 = this.initJRadioButton("Panel N°2");
        this.jRadioButton3 = this.initJRadioButton("Panel N°3");

        this.add(this.jPanelOpcions, BorderLayout.NORTH);
    }

    private JRadioButton initJRadioButton(String nombre) {
        JRadioButton jRadio = new JRadioButton(nombre);
        jRadio.setFont(this.font);
        this.jRadioB.add(jRadio);
        this.jPanelOpcions.add(jRadio);
        jRadio.addItemListener(this);
        return jRadio;
    }

    private void initJPanelBotton() {
        this.jPanelBotton = new JPanel();
        this.limpiar = new JButton("Limpiar");
        this.limpiar.addActionListener(this);
        this.limpiar.setFont(this.font);
        this.jPanelBotton.add(this.limpiar);
        this.add(this.jPanelBotton, BorderLayout.SOUTH);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.pintarPanel();
    }

    private void pintarPanel() {
        if (this.jRadioButton.isSelected()) {
            this.jPanel.setBackground(new Color(this.red.getValue(), this.green.getValue(), this.blue.getValue()));
        } else if (this.jRadioButton2.isSelected()) {
            this.jPanel2.setBackground(new Color(this.red.getValue(), this.green.getValue(), this.blue.getValue()));
        } else if (this.jRadioButton3.isSelected()) {
            this.jPanel3.setBackground(new Color(this.red.getValue(), this.green.getValue(), this.blue.getValue()));
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        this.pintarPanel();
    }

    private JSlider red, green, blue;
    private JPanel jPanelSlider, jPanel, jPanel2, jPanel3, jPanelPanel, jPanelBotton, jPanelOpcions;
    private JRadioButton jRadioButton, jRadioButton2, jRadioButton3;
    private JButton limpiar;
    private ButtonGroup jRadioB;
    private final Font font = new Font("Courier New", Font.BOLD, 20);

    public static void main(String[] args) {
        JSliderLayout2 ventana = new JSliderLayout2();
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.jRadioB.clearSelection();
        this.red.setValue(0);
        this.green.setValue(0);
        this.blue.setValue(0);
        this.jPanel.setBackground(null);
        this.jPanel2.setBackground(null);
        this.jPanel3.setBackground(null);
    }
}
