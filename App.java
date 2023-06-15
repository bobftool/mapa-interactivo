import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args){
        Mapa mapa = new Mapa();

        mapa.agregarLugar("Entrada", 0, 0); //0
        mapa.agregarLugar("Alimentos", 10, 10); //1
        mapa.agregarLugar("Hipopótamos", 20, 20); //2
        mapa.agregarLugar("Antílopes", 30, 30); //3
        mapa.agregarLugar("Cebras", 40, 40); //4
        mapa.agregarLugar("Linces rojos", 50, 50); //5
        mapa.agregarLugar("Lobos mexicanos", 60, 60); //6
        mapa.agregarLugar("Ajolotes", 70, 70); //7
        mapa.agregarLugar("Jaguares", 80, 80); //8
        mapa.agregarLugar("Ocelotes", 90, 90); //9
        mapa.agregarLugar("Orangutanes",100, 100); //10
        mapa.agregarLugar("Gorilas", 110, 110); //11
        mapa.agregarLugar("Pandas gigantes", 120, 120); //12
        mapa.agregarLugar("Pandas rojos", 130, 130); //13
        mapa.agregarLugar("Tigres", 140, 140); //14
        mapa.agregarLugar("Osos", 150, 150); //15
        mapa.agregarLugar("Nutrias", 160, 160); //16
        mapa.agregarLugar("Conejos", 170, 170); //17
        mapa.agregarLugar("Pingüinos", 180, 180); //18
        mapa.agregarLugar("Osos polares", 190, 190); //19
        mapa.agregarLugar("Paujiles", 200, 200); //20
        mapa.agregarLugar("Cotorras", 210, 210); //21
        mapa.agregarLugar("Cóndores andinos", 220, 220); //22
        mapa.agregarLugar("Argo real", 230, 230); //23
        mapa.agregarLugar("Orcas asesinas", 240, 240); //24
        mapa.agregarLugar("Tiburones", 250, 250); //25
        mapa.agregarLugar("Delfines", 260, 260); //26
        mapa.agregarLugar("Quiosco", 270, 270); //27

        mapa.crearCamino(0, 6, 160);
        mapa.crearCamino(0, 7, 220);
        mapa.crearCamino(1, 7, 40);
        mapa.crearCamino(1, 26, 80);
        mapa.crearCamino(2, 3, 80);
        mapa.crearCamino(2, 4, 140);
        mapa.crearCamino(3, 26, 30);
        mapa.crearCamino(4, 5, 60);
        mapa.crearCamino(4, 24, 60);
        mapa.crearCamino(5, 24, 60);
        mapa.crearCamino(5, 6, 50);
        mapa.crearCamino(6, 8, 50);
        mapa.crearCamino(7, 12, 60);
        mapa.crearCamino(8, 9, 30);
        mapa.crearCamino(8, 10, 20);
        mapa.crearCamino(9, 25, 110);
        mapa.crearCamino(11, 12, 90);
        mapa.crearCamino(11, 25, 150);
        mapa.crearCamino(12, 13, 50);
        mapa.crearCamino(13, 14, 60);
        mapa.crearCamino(13, 17, 50);
        mapa.crearCamino(14, 15, 30);
        mapa.crearCamino(15, 16, 40);
        mapa.crearCamino(15, 27, 50);
        mapa.crearCamino(16, 17, 20);
        mapa.crearCamino(17, 26, 80);
        mapa.crearCamino(18, 19, 30);
        mapa.crearCamino(18, 26, 70);
        mapa.crearCamino(19, 27, 50);
        mapa.crearCamino(20, 21, 20);
        mapa.crearCamino(20, 22, 30);
        mapa.crearCamino(21, 23, 50);
        mapa.crearCamino(22, 23, 20);
        mapa.crearCamino(22, 27, 80);

        //launch();
        mapa.ir(6);
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));
        Scene scene = new Scene(root, 500, 500);

        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();
    }
}