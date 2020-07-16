package Parcial;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;

/**
 * @author Dairo García Naranjo
 */
public class Parcial extends JFrame {
    
    public Parcial() {
        this.initJFrame();
        this.initComponents();
    }
    
    private void initJFrame() {
        this.setTitle("Calculos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        this.rect = new Rectangulo();
        this.cua = new Cuadrado();
        
        this.actionListener = (ActionEvent e) -> {
            if (e.getSource().equals(this.cuadrado)) {
                this.jP.setVisible(false);
                this.alto.setEnabled(true);
                this.anchoLabel.setEnabled(false);
                this.ladoLabel.setText("Lado");
                this.jP2.setVisible(true);
            } else if (e.getSource().equals(this.rectangulo)) {
                this.jP.setVisible(false);
                this.ladoLabel.setText("Alto");
                this.anchoLabel.setEnabled(true);
                this.alto.setEnabled(true);
                this.ancho.setEnabled(true);
                this.jP2.setVisible(true);
            }
        };
        
        this.jCheckBox();
        this.jRadioButton();
        this.jTextArea();
        this.opciones();
        this.jSlider();
    }
    
    private void jSlider() {
        this.jP3 = new JPanel(new GridLayout(4, 1));
        
        this.ladoLabel = this.initJLabel("Alto");
        this.jP3.add(this.ladoLabel);
        
        this.alto = new JSlider(JSlider.HORIZONTAL, 0, 20, 0);
        this.alto.setMajorTickSpacing(2);
        this.alto.setMinorTickSpacing(1);
        this.alto.setPaintTicks(true);
        this.alto.setPaintLabels(true);
        this.alto.addChangeListener((ChangeEvent e) -> {
            if (this.cuadrado.isSelected()) {
                this.cua.setLado(this.alto.getValue());
                if (this.area.isSelected()) {
                    this.calculos.append(this.cua.getArea() + "\n");
                } else {
                    this.calculos.append(this.cua.getPerimetro() + "\n");
                }
            } else {
                this.rect.setAlto(this.alto.getValue());
                this.rect.setAncho(this.ancho.getValue());
                if (this.area.isSelected()) {
                    this.calculos.append(this.rect.getArea() + "\n");
                } else {
                    this.calculos.append(this.rect.getPerimetro() + "\n");
                }
            }
        });
        this.alto.setFont(this.font);
        this.alto.setEnabled(false);
        this.jP3.add(this.alto);
        
        this.anchoLabel = this.initJLabel("Ancho");
        this.jP3.add(this.anchoLabel);
        
        this.ancho = new JSlider(JSlider.HORIZONTAL, 0, 20, 0);
        this.ancho.setMajorTickSpacing(2);
        this.ancho.setMinorTickSpacing(1);
        this.ancho.setPaintTicks(true);
        this.ancho.setPaintLabels(true);
        this.ancho.addChangeListener((ChangeEvent e) -> {
            this.rect.setAlto(this.alto.getValue());
            this.rect.setAncho(this.ancho.getValue());
            if (this.area.isSelected()) {
                this.calculos.append(this.rect.getArea() + "\n");
            } else {
                this.calculos.append(this.rect.getPerimetro() + "\n");
            }
        });
        this.ancho.setFont(this.font);
        this.ancho.setEnabled(false);
        this.jP3.add(this.ancho);
        
        this.add(this.jP3, BorderLayout.SOUTH);
    }
    
    private JLabel initJLabel(String nombre) {
        JLabel jL = new JLabel(nombre);
        jL.setFont(this.font);
        return jL;
    }
    
    private void opciones() {
        JPanel jPop = new JPanel();
        this.nuevoCalculo = new JButton("Nuevo Calculo");
        this.nuevoCalculo.setFont(this.font);
        this.nuevoCalculo.addActionListener((ActionEvent e) -> {
            this.jBgCalculo.clearSelection();
            this.alto.setValue(0);
            this.alto.setEnabled(false);
            
            this.ancho.setValue(0);
            this.ancho.setEnabled(false);
            
            this.jP.setVisible(true);
        });
        jPop.add(this.nuevoCalculo);
        
        this.reiniciarSistema = new JButton("Reiniciar");
        this.reiniciarSistema.setFont(this.font);
        this.reiniciarSistema.addActionListener((ActionEvent e) -> {
            this.jBgTipo.clearSelection();
            this.jP2.setVisible(false);
            this.jBgCalculo.clearSelection();
            this.ancho.setEnabled(false);
            this.ancho.setValue(0);
            this.alto.setEnabled(false);
            this.alto.setValue(0);
            this.calculos.setText(null);
            this.jP.setVisible(true);
        });
        jPop.add(this.reiniciarSistema);
        this.add(jPop, BorderLayout.NORTH);
    }
    
    private void jTextArea() {
        this.calculos = new JTextArea();
        this.calculos.setEditable(false);
        this.calculos.setFont(this.font);
        JScrollPane scrollPane = new JScrollPane(this.calculos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane, BorderLayout.CENTER);
    }
    
    private void jCheckBox() {
        this.jBgCalculo = new ButtonGroup();
        this.jP2 = new JPanel(new GridLayout(2, 1));
        this.area = this.initJCheckBox("Area");
        this.jP2.add(this.area);
        this.perimetro = this.initJCheckBox("Perimetro");
        this.jP2.add(this.perimetro);
        this.add(this.jP2, BorderLayout.EAST);
        this.jP2.setVisible(false);
    }
    
    private JCheckBox initJCheckBox(String nombre) {
        JCheckBox jCb = new JCheckBox(nombre);
        jCb.setFont(this.font);
        this.jBgCalculo.add(jCb);
        return jCb;
    }
    
    private void jRadioButton() {
        this.jBgTipo = new ButtonGroup();
        this.jP = new JPanel(new GridLayout(2, 1));
        this.cuadrado = this.initJRadioButton("Cuadrado");
        this.jP.add(this.cuadrado);
        this.rectangulo = this.initJRadioButton("Rectangulo");
        this.jP.add(this.rectangulo);
        this.add(this.jP, BorderLayout.WEST);
    }
    
    private JRadioButton initJRadioButton(String nombre) {
        JRadioButton jRb = new JRadioButton(nombre);
        jRb.setFont(this.font);
        jRb.addActionListener(this.actionListener);
        this.jBgTipo.add(jRb);
        return jRb;
    }
    
    private JPanel jP;
    private ButtonGroup jBgTipo;
    private ActionListener actionListener;
    private JRadioButton cuadrado, rectangulo;
    
    private JPanel jP2;
    private ButtonGroup jBgCalculo;
    private JCheckBox area, perimetro;
    
    private JTextArea calculos;
    private JButton nuevoCalculo, reiniciarSistema;
    
    private JPanel jP3;
    private JLabel ladoLabel, anchoLabel;
    private JSlider ancho, alto;
    
    private Rectangulo rect;
    private Cuadrado cua;
    
    private final Font font = new Font("Courier New", Font.BOLD, 20);
    
    public static void main(String[] args) {
        Parcial ventana = new Parcial();
        ventana.setVisible(true);
    }
}
