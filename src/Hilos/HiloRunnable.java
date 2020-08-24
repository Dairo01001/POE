package Hilos;

/**
 * @author Dairo García Naranjo
 */
public class HiloRunnable implements Runnable {
    
    private final String nombre;

    public HiloRunnable(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(this.nombre + i);
        }
    }
    
    public static void main(String[] args) {
        HiloRunnable r1 = new HiloRunnable("Uno");
        Thread h1 = new Thread(r1);
        
        HiloRunnable r2 = new HiloRunnable("Dos");
        Thread h2 = new Thread(r2);
        
        h1.start();
        h2.start();
    }
}
