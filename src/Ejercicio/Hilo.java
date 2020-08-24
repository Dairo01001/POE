package Ejercicio;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 * @author Dairo García Naranjo
 */
public class Hilo extends Thread {

    private final JButton cont;
    private final int velocidad;
    private final boolean retroceso;

    public Hilo(JButton cont, int velocidad, boolean retroceso) {
        this.cont = cont;
        this.velocidad = velocidad;
        this.retroceso = retroceso;
    }

    private void update() {
        if (this.retroceso) {
            this.cont.setText((Integer.parseInt(this.cont.getText()) - 1) + "");
        } else {
            this.cont.setText((Integer.parseInt(this.cont.getText()) + 1) + "");
        }
    }

    @Override
    public void run() {
        try {
            for (;;) {
                sleep(this.velocidad);
                this.update();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
