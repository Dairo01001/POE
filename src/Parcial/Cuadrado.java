package Parcial;

/**
 * @author Dairo García Naranjo
 */
public class Cuadrado {

    private int lado;

    public Cuadrado() {
    }

    public Cuadrado(int lado) {
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public int getArea() {
        return lado * lado;
    }

    public int getPerimetro() {
        return lado * 4;
    }

    @Override
    public String toString() {
        return "Cuadrado [" + "Lado: " + lado + ']';
    }
}
