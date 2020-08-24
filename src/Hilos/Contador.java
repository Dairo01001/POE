package Hilos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Dairo García Naranjo
 */
public class Contador extends JFrame {

    public Contador() {
        this.inicializarVentana();
        this.inicialiazarComponentes();
    }

    private void inicializarVentana() {
        this.setTitle("Contador");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void inicialiazarComponentes() {
        JPanel panelContadores = new JPanel(new GridLayout());

        this.contador1 = this.inicializarJButton("0");
        panelContadores.add(this.contador1);

        this.contador2 = this.inicializarJButton("1000");
        panelContadores.add(this.contador2);

        this.add(panelContadores, BorderLayout.CENTER);

        JPanel auxPanel = new JPanel(new GridLayout());

        this.start = this.inicializarJButton("START");
        this.start.addActionListener((ActionEvent e) -> {

            this.hilo1 = new Hilo(2, false, this.contador1);
            this.hilo2 = new Hilo(2, true, this.contador2);
            hilo1.start();
            hilo2.start();

            this.pauRea.setEnabled(true);
            this.stop.setEnabled(true);
            this.start.setEnabled(false);
        });

        this.stop = this.inicializarJButton("STOP");
        this.stop.addActionListener((ActionEvent e) -> {

            hilo1.stop();
            hilo2.stop();

            this.contador1.setText("0");
            this.contador2.setText("1000");
            this.start.setEnabled(true);
            this.pauRea.setEnabled(false);
            this.stop.setEnabled(false);
        });
        this.stop.setEnabled(false);

        this.pauRea = this.inicializarJButton("PAUSAR");
        this.pauRea.addActionListener((ActionEvent e) -> {
            if (this.bandera) {
                this.hilo1.suspend();
                this.hilo1.suspend();

                this.pauRea.setText("REANUDAR");
                this.bandera = !this.bandera;
            } else {
                this.hilo1.resume();
                this.hilo2.resume();

                this.pauRea.setText("PAUSAR");
                this.bandera = !this.bandera;
            }
        });
        this.setEnabled(false);

        auxPanel.add(this.start);
        auxPanel.add(this.pauRea);
        auxPanel.add(this.stop);

        this.add(auxPanel, BorderLayout.SOUTH);

        this.pack();
    }

    private JButton inicializarJButton(String nombre) {
        JButton jb = new JButton(nombre);
        jb.setFont(this.FONT);
        return jb;
    }

    private final Font FONT = new Font("Courier New", Font.BOLD, 20);
    private JButton start, stop, contador1, contador2, pauRea;
    private Hilo hilo1, hilo2;
    private boolean bandera = true;

    public static void main(String[] args) {
        Contador cont = new Contador();
        cont.setVisible(true);
    }
}
