package Ejercicio;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

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

        JSlider js = this.initJSlider();
        js.addChangeListener((ChangeEvent e) -> {
            if (start.isEnabled()) {
                this.auxX = js.getValue() * 1000;
            } else {
                this.auxX = js.getValue() * 1000;
                h1.setVelocidad(auxX);
                h2.setVelocidad(auxX);
            }
        });

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

            h1 = new Hilo(contador, auxX, false);
            h2 = new Hilo(contador2, auxX, true);

            h1.start();
            h2.start();

            start.setEnabled(false);
            stop.setEnabled(true);
            pauRea.setEnabled(true);
        });

        stop = this.inicializarJButton("STOP");
        stop.addActionListener((ActionEvent e) -> {

            contador.setText("0");
            contador2.setText("1000");

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

        nort.add(js);
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

    private JSlider initJSlider() {
        JSlider jSlider = new JSlider(JSlider.HORIZONTAL, 1, 5, 1);
        jSlider.setMajorTickSpacing(1);
        jSlider.setPaintTicks(true);
        jSlider.setPaintLabels(true);
        jSlider.setFont(FONT);
        return jSlider;
    }

    private Hilo h1, h2;
    private JButton contador, contador2, start, stop, pauRea;
    private int auxX = 0;
    private boolean flag = true;
    private final Font FONT = new Font("Courier New", Font.BOLD, 20);

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}
