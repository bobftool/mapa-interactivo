import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class AppController{
    public static Mapa mapa = new Mapa();

    public void actualizar(Lugar lugar){
        for(int i=0; i<mapa.getGrafico().getChildren().size(); i++){
            mapa.getGrafico().getChildren().get(i).setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #000000;");

            if(i == 0){
                mapa.getGrafico().getChildren().get(i).setStyle("-fx-background-color: #30aee9; -fx-border-color: #000000;");
            }
        }
        
        System.out.println("["+lugar.getNombre()+"]");
        //System.out.println(mapa.getIdLugar(lugar));
        mapa.distancia(lugar);
    }

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @FXML
    private AnchorPane container;

    @FXML
    public void initialize() {
        /*
        System.out.println("pene");
        AnchorPane pane1 = new AnchorPane();
        EventHandler eventHandler = new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0){
                System.out.println("XD");
            }
        };

        pane1.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #000000;");
        pane1.setPrefSize(20, 20);
        pane1.setLayoutX(200);
        pane1.setLayoutY(200);

        pane1.onMouseClickedProperty().set(eventHandler);

        mapa.getChildren().add(pane1);
        */

        mapa.agregarLugar("Entrada", 475, 230); //0
        mapa.agregarLugar("Alimentos", 275, 220); //1
        mapa.agregarLugar("Hipopótamos", 160, 90); //2
        mapa.agregarLugar("Antílopes", 220, 130); //3
        mapa.agregarLugar("Cebras", 280, 110); //4
        mapa.agregarLugar("Linces rojos", 345, 145); //5
        mapa.agregarLugar("Lobos mexicanos", 350, 190); //6
        mapa.agregarLugar("Ajolotes", 310, 235); //7
        mapa.agregarLugar("Jaguares", 355, 250); //8
        mapa.agregarLugar("Ocelotes", 380, 250); //9
        mapa.agregarLugar("Orangutanes",365, 275); //10
        mapa.agregarLugar("Gorilas", 350, 315); //11
        mapa.agregarLugar("Pandas gigantes", 290, 280); //12
        mapa.agregarLugar("Pandas rojos", 240, 295); //13
        mapa.agregarLugar("Tigres", 175, 340); //14
        mapa.agregarLugar("Osos", 160, 300); //15
        mapa.agregarLugar("Nutrias", 185, 265); //16
        mapa.agregarLugar("Conejos", 205, 240); //17
        mapa.agregarLugar("Pingüinos", 165, 195); //18
        mapa.agregarLugar("Osos polares", 130, 200); //19
        mapa.agregarLugar("Paujiles", 30, 290); //20
        mapa.agregarLugar("Cotorras", 15, 315); //21
        mapa.agregarLugar("Cóndores andinos", 60, 330); //22
        mapa.agregarLugar("Argo real", 50, 260); //23
        mapa.agregarLugar("Orcas asesinas", 350, 85); //24
        mapa.agregarLugar("Tiburones", 470, 290); //25
        mapa.agregarLugar("Delfines", 230, 170); //26
        mapa.agregarLugar("Quiosco", 115, 265); //27

        mapa.crearCamino(0, 6);
        mapa.crearCamino(0, 7);
        mapa.crearCamino(1, 7);
        mapa.crearCamino(1, 26);
        mapa.crearCamino(2, 3);
        mapa.crearCamino(2, 4);
        mapa.crearCamino(3, 26);
        mapa.crearCamino(4, 5);
        mapa.crearCamino(4, 24);
        mapa.crearCamino(5, 24);
        mapa.crearCamino(5, 6);
        mapa.crearCamino(6, 8);
        mapa.crearCamino(7, 12);
        mapa.crearCamino(8, 9);
        mapa.crearCamino(8, 10);
        mapa.crearCamino(9, 25);
        mapa.crearCamino(11, 12);
        mapa.crearCamino(11, 25);
        mapa.crearCamino(12, 13);
        mapa.crearCamino(13, 14);
        mapa.crearCamino(13, 17);
        mapa.crearCamino(14, 15);
        mapa.crearCamino(15, 16);
        mapa.crearCamino(15, 27);
        mapa.crearCamino(16, 17);
        mapa.crearCamino(17, 26);
        mapa.crearCamino(18, 19);
        mapa.crearCamino(18, 26);
        mapa.crearCamino(19, 27);
        mapa.crearCamino(20, 21);
        mapa.crearCamino(20, 22);
        mapa.crearCamino(21, 23);
        mapa.crearCamino(22, 23);
        mapa.crearCamino(22, 27);

        container.getChildren().add(mapa.getGrafico());
    }
}
