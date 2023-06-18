import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public class Mapa{
    private final int infinito = Integer.MAX_VALUE;
    private List<Lugar> lugares = new ArrayList<Lugar>();
    private int[][] caminos;
    private int idUbicacion;
    private int idSeleccionado;

    private AnchorPane grafico = new AnchorPane();
    private AnchorPane graficoFondo = new AnchorPane();
    private AnchorPane graficoRutas = new AnchorPane();
    private AnchorPane graficoLugares = new AnchorPane();

    public Mapa(){
        idUbicacion = 0;

        graficoInicializar();
    }

    private void graficoInicializar(){
        grafico.setPrefSize(500, 500);
        grafico.setStyle("-fx-background-color: #4ca848;");
        grafico.getChildren().add(graficoFondo);
        grafico.getChildren().add(graficoRutas);
        grafico.getChildren().add(graficoLugares);
    }

    public void graficoActualizar(){
        graficoLugares.getChildren().clear();

        for(int i=0; i<lugares.size(); i++){
            graficoLugares.getChildren().add(lugares.get(i).getGrafico());
        }
    }

    public void graficoLimpiar(){
        graficoRutas.getChildren().clear();

        for(int i=0; i<lugares.size(); i++){
            lugares.get(i).graficoCambiarColor("#FFFFFF");
        }

        lugares.get(idUbicacion).graficoCambiarColor("#30aee9");
    }

    

    public AnchorPane getGrafico() {
        return grafico;
    }

    public void setGrafico(AnchorPane grafico) {
        this.grafico = grafico;
    }

    public Lugar getLugar(String nombre){
        Lugar lugar = null;

        for(int i=0; i<lugares.size(); i++){
            if(lugares.get(i).getNombre().equals(nombre)){
                lugar = lugares.get(i);
                break;
            }
        }

        return lugar;
    }

    public Lugar getLugar(int id){
        return lugares.get(id);
    }

    public int getIdLugar(String nombre){
        return lugares.indexOf(getLugar(nombre));
    }

    public int getIdLugar(Lugar lugar){
        return lugares.indexOf(lugar);
    }



    public void actualizarUbicacion(int idActual){
        lugares.get(idUbicacion).graficoCambiarColor("#000000");

        idUbicacion = idActual;
        
        lugares.get(idUbicacion).graficoCambiarColor("#30aee9");
    }



    public void agregarLugar(String nombre, int coordenadaX, int coordenadaY){
        lugares.add(new Lugar(lugares.size()+1, nombre, coordenadaX, coordenadaY));
        
        int idActual = lugares.size()-1;

        lugares.get(idActual).getGrafico().setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0){
                graficoLimpiar();
                ruta(idActual);
                lugares.get(idActual).graficoCambiarColor("#ff143f");
                graficoActualizar();

                idSeleccionado = idActual;
            }
        });

        if(lugares.size() == 1){
            actualizarUbicacion(0);
        }

        actualizarCaminos();
    }

    private void actualizarCaminos(){
        int caminosCopia[][] = caminos;
        caminos = new int[lugares.size()][lugares.size()];

        for(int i=0; i<lugares.size(); i++){
            for(int o=0; o<lugares.size(); o++){
                caminos[i][o] = infinito;
            }
        }

        if(caminosCopia!= null){
            for(int i=0; i<lugares.size(); i++){
                for(int o=0; o<lugares.size(); o++){
                    if(caminos[i][o] != infinito){
                        caminos[i][o] = caminosCopia[i][o];
                    }
                }
            }
        }
    }



    public void crearCamino(int idLugarA, int idLugarB){
        if(idLugarA >= 0 && idLugarB >= 0 && idLugarA < lugares.size() && idLugarB < lugares.size()){
            int distanciaX = getLugar(idLugarA).getCoordenadaX() - getLugar(idLugarB).getCoordenadaX();
            int distanciaY = getLugar(idLugarA).getCoordenadaY() - getLugar(idLugarB).getCoordenadaY();
            int distancia = (int)Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
            
            caminos[idLugarA][idLugarB] = distancia;
            caminos[idLugarB][idLugarA] = distancia;

            Line linea = new Line(getLugar(idLugarA).getCoordenadaX(), getLugar(idLugarA).getCoordenadaY(), getLugar(idLugarB).getCoordenadaX(), getLugar(idLugarB).getCoordenadaY());

            linea.setStyle("-fx-stroke-width: 15; -fx-stroke: #72c76f;");

            graficoFondo.getChildren().add(linea);
        }else{
            System.out.println("No se pudo crear el camino entre "+idLugarA+" y "+idLugarB+".");
        }
    }



    public void crearCamino(int idLugarA, int idLugarB, int distancia){
        if(idLugarA >= 0 && idLugarB >= 0 && idLugarA < lugares.size() && idLugarB < lugares.size()){
            caminos[idLugarA][idLugarB] = distancia;
            caminos[idLugarB][idLugarA] = distancia;
        }else{
            System.out.println("No se pudo crear el camino entre "+idLugarA+" y "+idLugarB+".");
        }
    }



    public void ir(int idDestino){
        List<Integer> ruta = rutas()[idDestino];

        for(int i=0; i<ruta.size(); i++){
            System.out.print("["+lugares.get(ruta.get(i)).getNombre()+"] -> ");
        }
        System.out.println();

        actualizarUbicacion(idDestino);
    }

    public void distancia(int idDestino){
        List<Integer> ruta = rutas()[idDestino];
        int idActual = idUbicacion;
        int distancia = 0;

        for(int i=1; i<ruta.size(); i++){
            System.out.println(caminos[idActual][ruta.get(i)]);
            distancia += caminos[idActual][ruta.get(i)];
            idActual = ruta.get(i);
        }

        System.out.println(distancia);
    }

    public void ruta(int idDestino){
        List<Integer> ruta = rutas()[idDestino];

        for(int i=1; i<ruta.size(); i++){
            lugares.get(ruta.get(i)).graficoCambiarColor("#999999");

            Line linea = new Line(getLugar(ruta.get(i-1)).getCoordenadaX(), getLugar(ruta.get(i-1)).getCoordenadaY(), getLugar(ruta.get(i)).getCoordenadaX(), getLugar(ruta.get(i)).getCoordenadaY());

            linea.setStyle("-fx-stroke-width: 10; -fx-stroke: #999999;");

            graficoRutas.getChildren().add(linea);
        }
    }



    public List<Integer>[] rutas(){
        List<Integer>[] rutas = new ArrayList[lugares.size()];
        int[] distancias = new int[lugares.size()];
        boolean[] visitados = new boolean[lugares.size()];

        for(int i=0; i<lugares.size(); i++){
            distancias[i] = infinito;
            rutas[i] = new ArrayList<>();
        }

        int idCaminoActual = 0;
        int idLugarActual = idUbicacion;

        distancias[idUbicacion] = 0;

        while(!visitados[idLugarActual]){
            idCaminoActual = obtenerCaminoSiguiente(idLugarActual, idCaminoActual-1);

            if(idCaminoActual >= 0){
                while(idCaminoActual >= 0 && visitados[idCaminoActual]){
                    idCaminoActual = obtenerCaminoSiguiente(idLugarActual, idCaminoActual);
                }
            }

            if(idCaminoActual < 0){
                visitados[idLugarActual] = true;
            }else{
                while(idCaminoActual >= 0 && !visitados[idCaminoActual]){
                    int distanciaCaminoActual = distancias[idLugarActual] + caminos[idLugarActual][idCaminoActual];

                    if(distanciaCaminoActual < distancias[idCaminoActual]) {
                        distancias[idCaminoActual] = distanciaCaminoActual;

                        for(int i=0; i<rutas[idCaminoActual].size(); i++){
                            if(i<rutas[idLugarActual].size()){
                                rutas[idCaminoActual].set(i, rutas[idLugarActual].get(i));
                            }
                        }

                        for(int i=rutas[idCaminoActual].size(); i<rutas[idLugarActual].size(); i++){
                            rutas[idCaminoActual].add(rutas[idLugarActual].get(i));
                        }

                        rutas[idCaminoActual].add(idLugarActual);
                    }

                    visitados[idLugarActual] = true;
                    idCaminoActual = obtenerCaminoSiguiente(idLugarActual, idCaminoActual);

                }
            }

            idCaminoActual = 0;
            idLugarActual = obtenerLugarSiguiente(distancias, visitados);
        }

        for(int i=0; i<lugares.size(); i++){
            rutas[i].add(i);
        }

        return rutas;
    }



    public int obtenerCaminoSiguiente(int idLugarActual, int idCaminoActual) {
        for(int i=idCaminoActual+1; i<lugares.size(); i++){
            if(idLugarActual >= 0 && caminos[idLugarActual][i] != infinito){
                return i;
            }
        }

        return -1;
    }



    public int obtenerLugarSiguiente(int[] distancias, boolean[] visitados) {
        int idLugar = 0;
        int distanciaMinima = infinito;
        for (int i = 0; i < distancias.length; i++) {
            if (!visitados[i]) {
                if (distancias[i] < distanciaMinima) {
                    distanciaMinima = distancias[i];
                    idLugar = i;
                }
            }
        }
        return idLugar;
    }
}
