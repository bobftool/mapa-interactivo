import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MenuLista{
    private ScrollPane grafico = new ScrollPane();
    private VBox lista = new VBox();

    public MenuLista(){
        lista.setStyle("-fx-spacing: 10px; -fx-background-color: #999999;");
        grafico.setStyle("-fx-background-color:transparent;");

        grafico.setPrefWidth(270);
        grafico.setMaxHeight(500);

        grafico.setContent(lista);
    }

    public ScrollPane getGrafico() {
        return grafico;
    }

    public void setGrafico(ScrollPane grafico) {
        this.grafico = grafico;
    }

    public VBox getLista() {
        return lista;
    }

    public void setLista(VBox lista) {
        this.lista = lista;
    }

    public AnchorPane crearElemento(Lugar lugar){
        AnchorPane elemento = new AnchorPane();
        Text id = new Text();
        Text nombre = new Text();
        Text cantidadPersonas = new Text();

        id.setText(String.valueOf(lugar.getNumero()));
        nombre.setText(lugar.getNombre());
        cantidadPersonas.setText(String.valueOf(lugar.getCantidadPersonas()));

        elemento.setPrefSize(200, 20);
        elemento.setStyle("-fx-background-radius: 25px; -fx-background-color: #FFFFFF;");
        id.setLayoutX(7);
        id.setLayoutY(14);
        nombre.setLayoutX(27);
        nombre.setLayoutY(14);
        cantidadPersonas.setLayoutX(170);
        cantidadPersonas.setLayoutY(14);

        elemento.getChildren().add(id);
        elemento.getChildren().add(nombre);
        elemento.getChildren().add(cantidadPersonas);

        return elemento;
    }

    /*
    public void insertarFila(Lugar[] lugares){
        for(int i=0; i<lugares.length; i++){
            AnchorPane contenedor = new AnchorPane();
            Text lugar = new Text();
            Text personas = new Text();

            contenedor.setPrefSize(250, 50);
            contenedor.setLeftAnchor(lugar, 5.0);
            contenedor.setTopAnchor(lugar, 10.0);
            //lugar.setLayoutX(10);
            //lugar.setLayoutY(10);

            contenedor.setStyle("-fx-background-radius: 25px; -fx-background-color: #999999;");
            lista.setStyle("-fx-spacing: 10px;");
            
            contenedor.getChildren().add(lugar);
            contenedor.getChildren().add(personas);

            lugar.setText(lugares[i].getNombre());
            personas.setText(String.valueOf(lugares[i].getCantidadPersonas()));



            lista.getChildren().add(contenedor);
        }
    }
    */
}