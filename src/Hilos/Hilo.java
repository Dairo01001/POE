package Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 * @author Dairo García Naranjo
 */
public class Hilo extends Thread {

    private final int velocidad;
    private final boolean retroceso;
    private final JButton jb;

    public Hilo(int velocidad, boolean retroceso, JButton jb) {
        this.velocidad = velocidad;
        this.retroceso = retroceso;
        this.jb = jb;
    }

    public void update() {
        if (this.retroceso) {
            this.jb.setText((Integer.parseInt(this.jb.getText()) - 1) + "");
        } else {
            this.jb.setText((Integer.parseInt(this.jb.getText()) + 1) + "");
        }
    }

    @Override
    public void run() {

        try {
            sleep(this.velocidad);
            this.update();
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
