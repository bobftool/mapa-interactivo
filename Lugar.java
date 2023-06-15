import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class Lugar extends AppController{
    public int numero;
    private String nombre;
    private int coordenadaX;
    private int coordenadaY;

    private AnchorPane grafico = new AnchorPane();

    public EventHandler eventHandler = new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent arg0){
            actualizar(Lugar.this);
            grafico.setStyle("-fx-background-color: #000000; -fx-border-color: #000000;");
        }
    };



    public Lugar(int numero, String nombre, int coordenadaX, int coordenadaY) {
        this.numero = numero;
        this.nombre = nombre;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;

        inicializarGrafico(coordenadaX, coordenadaY);
    }

    private void inicializarGrafico(int coordenadaX, int coordenadaY){
        grafico.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #000000;");
        grafico.setPrefSize(20, 20);
        grafico.setLayoutX(coordenadaX);
        grafico.setLayoutY(coordenadaY);
        grafico.getChildren().add(new Text(String.valueOf(numero)));

        grafico.onMouseClickedProperty().set(eventHandler);
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
