import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


/**
 * La clase lugar controla la informacion de las personas, las atracciones y maneja los graficos que le indican al usuario la cantidad de personas que hay en cada atraccion.
 */
public class Lugar{
    public String directorio = System.getProperty("user.dir");
    
    public int numero;
    private String nombre;
    private int coordenadaX;
    private int coordenadaY;
    private String descripcion;
    private int cantidadPersonas;

    private AnchorPane grafico = new AnchorPane();
    private Image imagen;

    private AnchorPane graficoLista = new AnchorPane();
    private Text textCantidadPersonas = new Text();


    /**
     * Inicialista la parte grafica y logica.
     * @param numero
     * @param nombre
     * @param coordenadaX
     * @param coordenadaY
     * 
     */
    public Lugar(int numero, String nombre, int coordenadaX, int coordenadaY) {
        this.numero = numero;
        this.nombre = nombre;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;

        graficoInicializar(coordenadaX, coordenadaY);
        graficoListaInicializar();
    }

    /**
     * Inicializa el grafico y lo coloca en sus cordenadas dentro del grafico.
     * @param coordenadaX
     * @param coordenadaY
     */
    private void graficoInicializar(int coordenadaX, int coordenadaY){
        grafico.setStyle("-fx-background-radius: 25px; -fx-border-radius: 25px; -fx-background-color: #FFFFFF; -fx-border-color: #FFFFFF; -fx-border-width: 3;");
        grafico.setPrefSize(20, 20);
        grafico.setLayoutX(coordenadaX-10);
        grafico.setLayoutY(coordenadaY-10);
        grafico.getChildren().add(new Text(String.valueOf(numero)));
    }

    /**
     * Cambia el color del grafico con el codigo HEX que recibe.
     * @param color
     */
    public void graficoCambiarColor(String color){
        grafico.setStyle("-fx-background-radius: 25px; -fx-border-radius: 25px; -fx-background-color: "+color+"; -fx-border-color: #FFFFFF; -fx-border-width: 3;");
    }


    /**
     *  Inicializa el grafico de la lista.
     */
    public void graficoListaInicializar(){
        Text numero = new Text();
        Text nombre = new Text();
        ImageView imagen = new ImageView(new Image(directorio+"\\Resources\\user.png"));

        numero.setText(String.valueOf(this.numero));
        nombre.setText(this.nombre);
        textCantidadPersonas.setText(String.valueOf(this.cantidadPersonas));

        graficoLista.setPrefSize(200, 20);
        graficoLista.setStyle("-fx-background-radius: 0px 25px 25px 0px; -fx-background-color: #999999;");
        textCantidadPersonas.setStyle("-fx-alignment: right_center;");
        imagen.setFitHeight(15);
        imagen.setFitWidth(15);
        numero.setLayoutX(7);
        numero.setLayoutY(14);
        nombre.setLayoutX(27);
        nombre.setLayoutY(14);
        textCantidadPersonas.setLayoutX(170);
        textCantidadPersonas.setLayoutY(14);
        imagen.setLayoutX(150);
        imagen.setLayoutY(3);

        graficoLista.getChildren().add(imagen);
        graficoLista.getChildren().add(numero);
        graficoLista.getChildren().add(nombre);
        graficoLista.getChildren().add(textCantidadPersonas);
    }

    /**
     * Cambia el color del grafico de la lista con el codigo HEX que recibe.
     * @param color
     */
    public void graficoListaCambiarColor(String color){
        graficoLista.setStyle("-fx-background-radius: 0px 25px 25px 0px; -fx-background-color: "+color+";");
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(String path) {
        this.imagen = new Image(path);
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
        textCantidadPersonas.setText(String.valueOf(this.cantidadPersonas));
    }

    public AnchorPane getGraficoLista() {
        return graficoLista;
    }

    public void setGraficoLista(AnchorPane graficoLista) {
        this.graficoLista = graficoLista;
    }
}
