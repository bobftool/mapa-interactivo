import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MenuLugar{
    private VBox grafico = new VBox();
    private VBox informacion = new VBox();
    private HBox botones = new HBox();

    private ImageView imagen = new ImageView();
    private Text titulo = new Text();
    private Text descripcion = new Text();
    private AnchorPane boton = new AnchorPane();
    private Text textoBoton = new Text();

    public MenuLugar(){
        informacion.getChildren().add(titulo);
        informacion.getChildren().add(descripcion);

        boton.getChildren().add(textoBoton);
        botones.getChildren().add(boton);

        grafico.getChildren().add(imagen);
        grafico.getChildren().add(informacion);
        grafico.getChildren().add(botones);

        textoBoton.setStyle("-fx-alignment: center;");
        boton.setPrefSize(72, 27);
        boton.setStyle("-fx-background-radius: 25px; -fx-background-color: #30aee9;");

        grafico.setStyle("-fx-background-color: #FFFFFF;");
        botones.setStyle("-fx-alignment: bottom_center;");
        informacion.setStyle("-fx-alignment: top_center; -fx-padding: 10px 10px 30px 10px; -fx-spacing: 10px;");
        titulo.setStyle("-fx-fill: black; -fx-font-size: 20px; -fx-font-weight: bold;");
        descripcion.setStyle("-fx-fill: black; -fx-font-size: 15px; -fx-alignment: left_top;");
        descripcion.setWrappingWidth(230);
        textoBoton.setStyle("-fx-fill: white; -fx-font-weight: bold;");
        textoBoton.setLayoutX(31);
        textoBoton.setLayoutY(18);

        imagen.setFitHeight(150);
        imagen.setFitWidth(250);
        titulo.setText("pene");
        textoBoton.setText("IR");
    }

    public VBox getGrafico() {
        return grafico;
    }

    public void setGrafico(VBox grafico) {
        this.grafico = grafico;
    }

    public Text getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo.setText(titulo);
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen.setImage(imagen);
    }

    public Text getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.setText(descripcion);
    }

    public AnchorPane getBoton() {
        return boton;
    }

    public void setBoton(AnchorPane boton) {
        this.boton = boton;
    }

    public Text getTextoBoton() {
        return textoBoton;
    }

    public void setTextoBoton(String textoBoton) {
        this.textoBoton.setText(textoBoton);
    }
}