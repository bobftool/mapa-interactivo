import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

/**
 * Esta clase crea el menu de la lista de lugares.
 */
public class MenuLista{
    private ScrollPane grafico = new ScrollPane();
    private VBox lista = new VBox();

    /**
     * Inicializa los graficos.
     */
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
}