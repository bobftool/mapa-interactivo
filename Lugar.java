import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class Lugar{
    public int numero;
    private String nombre;
    private int coordenadaX;
    private int coordenadaY;

    private AnchorPane grafico = new AnchorPane();


    public Lugar(int numero, String nombre, int coordenadaX, int coordenadaY) {
        this.numero = numero;
        this.nombre = nombre;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;

        graficoInicializar(coordenadaX, coordenadaY);
    }

    private void graficoInicializar(int coordenadaX, int coordenadaY){
        grafico.setStyle("-fx-background-radius: 25px; -fx-border-radius: 25px; -fx-background-color: #FFFFFF; -fx-border-color: #FFFFFF; -fx-border-width: 3;");
        grafico.setPrefSize(20, 20);
        grafico.setLayoutX(coordenadaX-10);
        grafico.setLayoutY(coordenadaY-10);
        grafico.getChildren().add(new Text(String.valueOf(numero)));
    }

    public void graficoCambiarColor(String color){
        grafico.setStyle("-fx-background-radius: 25px; -fx-border-radius: 25px; -fx-background-color: "+color+"; -fx-border-color: #FFFFFF; -fx-border-width: 3;");
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public AnchorPane getGrafico() {
        return grafico;
    }

    public void setGrafico(AnchorPane grafico) {
        this.grafico = grafico;
    }
}
