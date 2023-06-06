public class Lugar {
    private String nombre;
    private int peso;
    private boolean actual;

    public Lugar(String nombre) {
        this.nombre = nombre;
        peso = 0;
        actual = false;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }

}
