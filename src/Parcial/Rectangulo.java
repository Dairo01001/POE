package Parcial;

/**
 * @author Dairo García Naranjo
 */
public class Rectangulo {

    private int alto;
    private int ancho;

    public Rectangulo() {
    }

    public Rectangulo(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getArea() {
        return alto * ancho;
    }

    public int getPerimetro() {
        return (alto * 2) + (ancho * 2);
    }

    @Override
    public String toString() {
        return "Rectangulo [" + "Alto: " + alto + ", Ancho: " + ancho + ']';
    }
}
