package Ejercicio;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * @author Dairo García Naranjo
 */
public class Ventana extends JFrame {

    public Ventana() {
        this.inicializarVentana();
    }

    private void inicializarVentana() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel nort = new JPanel(new GridLayout());
        String s[] = {"1", "2", "3", "5"};
        JList seg = new JList(s);
        seg.setSelectedIndex(0);
        seg.setFont(FONT);
        
        JButton fecha = this.inicializarJButton(new Date().toString());
        Fecha au = new Fecha(fecha);
        Thread h = new Thread(au);
        h.start();
        
        this.add(fecha, BorderLayout.CENTER);
        
        JPanel contadores = new JPanel(new GridLayout());
        contador = this.inicializarJButton("0");
        contadores.add(contador);

        contador2 = this.inicializarJButton("1000");
        contadores.add(contador2);
        

        JPanel controles = new JPanel(new GridLayout());
        start = this.inicializarJButton("START");
        start.addActionListener((ActionEvent e) -> {
            int aux = Integer.parseInt(seg.getSelectedValue().toString()) * 1000;

            h1 = new Hilo(contador, aux, false);
            h2 = new Hilo(contador2, aux, true);

            h1.start();
            h2.start();
            
            seg.setEnabled(false);
            start.setEnabled(false);
            stop.setEnabled(true);
            pauRea.setEnabled(true);
        });
        

        stop = this.inicializarJButton("STOP");
        stop.addActionListener((ActionEvent e) -> {
            
            contador.setText("0");
            contador2.setText("1000");
            
            seg.setEnabled(true);
            stop.setEnabled(false);
            pauRea.setEnabled(false);
            start.setEnabled(true);
            h1.stop();
            h2.stop();  
        });
        stop.setEnabled(false);
        
        pauRea = this.inicializarJButton(" PAUSAR ");
        pauRea.addActionListener((ActionEvent e) -> {
            if (flag) {
                h1.suspend();
                h2.suspend();
                pauRea.setText("REANUDAR");
                
            } else {
                h1.resume();
                h2.resume();
                pauRea.setText(" PAUSAR ");
            }
            flag = !flag;
        });
        pauRea.setEnabled(false);
        
        nort.add(seg);
        nort.add(contador);
        nort.add(contador2);
        
        this.add(nort, BorderLayout.NORTH);
        
        controles.add(start);
        controles.add(pauRea);
        controles.add(stop);
        
        this.add(controles, BorderLayout.SOUTH);
     
        this.pack();
    }

    private JButton inicializarJButton(String nombre) {
        JButton jButton = new JButton(nombre);
        jButton.setFont(this.FONT);
        return jButton;
    }

    private Hilo h1, h2;
    private JButton contador, contador2, start, stop, pauRea;
    private boolean flag = true;
    private final Font FONT = new Font("Courier New", Font.BOLD, 20);

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}
