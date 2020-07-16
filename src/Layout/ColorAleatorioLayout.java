package Layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * @author Dairo Garcia
 */
public class ColorAleatorioLayout extends JFrame implements ActionListener {
    
    public ColorAleatorioLayout() {
        this.initJFrame();
        this.initComponets();
    }
    
    private void initJFrame() {
        this.setTitle("Layout - Color");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    private void initComponets() {
        this.initJPanelButtons();
        
        this.jPanelColor = new JPanel();
        this.jPanelColor.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.add(this.jPanelColor, BorderLayout.CENTER);
        
        this.initJPanelLetreros();
    }
    
    private void initJPanelButtons() {
        this.jPanelButtons = new JPanel();
        
        this.color = initJButton("Color Aletorio");
        this.salir = initJButton("Salir");
        
        this.add(this.jPanelButtons, BorderLayout.NORTH);
    }
    
    private JButton initJButton(String nombre) {
        JButton jB = new JButton(nombre);
        jB.setFont(this.font);
        jB.addActionListener(this);
        this.jPanelButtons.add(jB);
        return jB;
    }
    
    private void initJPanelLetreros() {
        this.jPanelLetreros = new JPanel();
        this.red = initJLabel("Red:");
        this.red.setForeground(Color.RED);
        this.green = initJLabel("Green:");
        this.green.setForeground(Color.GREEN);
        this.blue = initJLabel("Blue:");
        this.blue.setForeground(Color.BLUE);
        
        this.add(this.jPanelLetreros, BorderLayout.SOUTH);
    }
    
    private JLabel initJLabel(String nombre) {
        JLabel jL = new JLabel(nombre);
        jL.setFont(this.font);
        this.jPanelLetreros.add(jL);
        return jL;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.salir)) {
            System.exit(0);
        } else if (e.getSource().equals(this.color)) {
            int r = saturacion();
            int g = saturacion();
            int b = saturacion();
            this.jPanelColor.setBackground(new Color(r, g, b));
            this.red.setText("Red: " + r);
            this.green.setText("Green: " + g);
            this.blue.setText("Blue: " + b);
        }
    }
    
    private int saturacion() {
        return (int) (Math.random() * 256);
    }
    
    private JPanel jPanelButtons, jPanelColor, jPanelLetreros;
    private JButton color, salir;
    private JLabel red, green, blue;
    private final Font font = new Font("Courier New", Font.BOLD, 20);
    
    public static void main(String[] args) {
        ColorAleatorioLayout ventana = new ColorAleatorioLayout();
        ventana.setVisible(true);
    }
}
