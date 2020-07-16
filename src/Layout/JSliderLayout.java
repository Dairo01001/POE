package Layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Dairo Garcia
 */
public class JSliderLayout extends JFrame implements ChangeListener {

    public JSliderLayout() {
        this.initJFrame();
        this.initComponets();
    }

    private void initJFrame() {
        this.setTitle("JSlider - Layout");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponets() {
        this.initJPanelSlider();
        this.JPanelCenter = new JPanel();
        this.JPanelCenter.setBackground(new Color(this.red.getValue(), this.green.getValue(), this.blue.getValue()));
        this.add(this.JPanelCenter, BorderLayout.CENTER);
    }

    private void initJPanelSlider() {
        this.red = this.initJSlider();
        this.green = this.initJSlider();
        this.blue = this.initJSlider();

        this.jPanelJSlider = new JPanel();
        this.jPanelJSlider.setBackground(Color.BLACK);
        this.jPanelJSlider.setLayout(new GridLayout(3, 1));

        this.jPanelJSlider.add(this.red);
        this.jPanelJSlider.add(this.green);
        this.jPanelJSlider.add(this.blue);
        this.add(this.jPanelJSlider, BorderLayout.NORTH);
    }

    private JSlider initJSlider() {
        JSlider jSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        jSlider.setMajorTickSpacing(50);
        jSlider.setMinorTickSpacing(5);
        jSlider.setPaintTicks(true);
        jSlider.setPaintLabels(true);
        jSlider.addChangeListener(this);
        jSlider.setFont(this.font);
        return jSlider;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.JPanelCenter.setBackground(new Color(this.red.getValue(), this.green.getValue(), this.blue.getValue()));
    }

    private JSlider red, green, blue;
    private JPanel jPanelJSlider, JPanelCenter;
    private final Font font = new Font("Courier New", Font.BOLD, 20);

    public static void main(String[] args) {
        JSliderLayout ventana = new JSliderLayout();
        ventana.setVisible(true);
    }
}
