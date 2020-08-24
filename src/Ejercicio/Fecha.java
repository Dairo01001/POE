package Ejercicio;

import static java.lang.Thread.sleep;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 * @author Dairo Garcia Naranjo
 */
public class Fecha implements Runnable {

    private final JButton fecha;

    public Fecha(JButton fecha) {
        this.fecha = fecha;
    }

    @Override
    public void run() {
        
        for (;;) {
            try {
                sleep(100);
                this.fecha.setText(new Date().toString());
            } catch (InterruptedException ex) {
                Logger.getLogger(Fecha.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
