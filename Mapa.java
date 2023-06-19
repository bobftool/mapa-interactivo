import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;

/*
 * Esta clase controla la parte logica y grafica del mapa principal, el cual muestra al usuario
 * todas las atracciones a las que tiene acceso.
 */

public class Mapa{

    private final int infinito = Integer.MAX_VALUE;
    private List<Lugar> lugares = new ArrayList<Lugar>();
    private int[][] caminos;
    private int idUbicacion;
    private int idSeleccionado;

    private HBox grafico = new HBox();
    private AnchorPane graficoMapa = new AnchorPane();
    private AnchorPane graficoFondo = new AnchorPane();
    private AnchorPane graficoRutas = new AnchorPane();
    private AnchorPane graficoLugares = new AnchorPane();

    private MenuLugar menuLugar = new MenuLugar();
    private MenuLista menuLista = new MenuLista();

    /**
     * Constructor, el usuario inicia en el primer lugar agregado al mapa.
     */
    public Mapa(){
        idUbicacion = 0;
        idSeleccionado = 0;
    }

    /**
     * 
     * @return Gráfico que contiene el mapa y los menús.
     */
    public HBox getGrafico() {
        return grafico;
    }

    public void setGrafico(HBox grafico) {
        this.grafico = grafico;
    }

    /**
     * Construye el gráfico del mapa capa a capa.
     */
    public void graficoInicializar(){
        graficoMapa.setPrefSize(500, 500);
        graficoMapa.setStyle("-fx-background-color: #4ca848;");
        graficoMapa.getChildren().add(graficoFondo);
        graficoMapa.getChildren().add(graficoRutas);
        graficoMapa.getChildren().add(graficoLugares);

        grafico.getChildren().add(graficoMapa);
        grafico.getChildren().add(menuLugar.getGrafico());
        grafico.getChildren().add(menuLista.getGrafico());

        graficoLimpiar();
        graficoActualizarMapa();
        graficoActualizarMenuLugar();
        graficoActualizarMenuLista();
    }

    /**
     * Actualiza el gráfico de cada lugar del mapa.
     */
    public void graficoActualizarMapa(){
        graficoLugares.getChildren().clear();

        for(int i=0; i<lugares.size(); i++){
            graficoLugares.getChildren().add(lugares.get(i).getGrafico());
        }
    }

    /**
     * Actualiza el menú del lugar a la última ubicación seleccionada.
     */
    public void graficoActualizarMenuLugar(){
        menuLugar.setImagen(getLugar(idSeleccionado).getImagen());
        menuLugar.setTitulo(getLugar(idSeleccionado).getNombre());
        menuLugar.setDescripcion(getLugar(idSeleccionado).getDescripcion());

        /**
         * Asigna un EventHandler al botón de acción del menú.
         */
        menuLugar.getBoton().setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0){
                ir(idSeleccionado);
                graficoLimpiar();
                graficoActualizarMapa();
                graficoActualizarMenuLugar();
                graficoActualizarMenuLista();
            }
        });
    }

    /**
     * Actualiza el gráfico de cada elemento de la lista.
     */
    public void graficoActualizarMenuLista(){
        int[] idLugares = ordenarIdLugares();

        menuLista.getLista().getChildren().clear();

        for(int i=0; i<lugares.size(); i++){
            menuLista.getLista().getChildren().add(lugares.get(idLugares[i]).getGraficoLista());
        }
    }


    /**
     * Regresa a su estado original todas los gráficos del mapa.
     */
    public void graficoLimpiar(){
        graficoRutas.getChildren().clear();

        for(int i=0; i<lugares.size(); i++){
            lugares.get(i).graficoCambiarColor("#FFFFFF");
            lugares.get(i).graficoListaCambiarColor("#999999");
        }

        lugares.get(idUbicacion).graficoCambiarColor("#30aee9");
        lugares.get(idUbicacion).graficoListaCambiarColor("#FFFFFF");
    }

    /**
     * 
     * @param nombre
     * @return Primer objeto de la lista de lugares que coincida con el nombre
     */
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


    /**
     * Actualiza la ubicación del mapa a la última seleccionada
     * @param idActual
     */
    public void actualizarUbicacion(int idActual){
        lugares.get(idUbicacion).graficoCambiarColor("#FFFFFF");
        lugares.get(idUbicacion).graficoListaCambiarColor("#FFFFFF");

        idUbicacion = idActual;
        idSeleccionado = idActual;
    }

    /**
     * Crea un objeto Lugar y su grafico, lo agrega a la lista lugares.
     * @param nombre
     * @param coordenadaX
     * @param coordenadaY
     */
    public void agregarLugar(String nombre, int coordenadaX, int coordenadaY){
        lugares.add(new Lugar(lugares.size()+1, nombre, coordenadaX, coordenadaY));
        
        int idActual = lugares.size()-1;

        /*
         * Esta funcion asigna al boton del menu funcionalidad dependiendo del lugar 
         * 
         */
        lugares.get(idActual).getGrafico().setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0){
                graficoLimpiar();
                ruta(idActual);
                lugares.get(idActual).graficoCambiarColor("#ff143f");
                lugares.get(idUbicacion).graficoListaCambiarColor("#999999");
                lugares.get(idActual).graficoListaCambiarColor("#FFFFFF");
                graficoActualizarMapa();

                idSeleccionado = idActual;
                graficoActualizarMenuLugar();
            }
        });

        lugares.get(idActual).getGraficoLista().setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0){
                graficoLimpiar();
                ruta(idActual);
                lugares.get(idActual).graficoCambiarColor("#ff143f");
                lugares.get(idUbicacion).graficoListaCambiarColor("#999999");
                lugares.get(idActual).graficoListaCambiarColor("#FFFFFF");
                graficoActualizarMapa();

                idSeleccionado = idActual;
                graficoActualizarMenuLugar();
            }
        });

        if(lugares.size() == 1){
            actualizarUbicacion(0);
        }

        actualizarCaminos();
    }

    /*
     * aumenta el tamaño de la matriz de adyasencia cada vez que se agrega un nuevo lugar a la lsiata 
     * de lugares.
     */
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

    /**
     * 
     * @param idLugarA
     * @param idLugarB
     * crea una conexion entre dos lugares de la lista. Apartir de las coordenadas X y Y 
     * de cada lugar obtiene la distancia con el uso de teorema de pitagoras y se la asigna a la 
     * matriz de adyacencia.
     * En el grafico del mapa crea a una linea que conecta a ambos lugares.
     */
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



    /*
     * Llama a la funcion de cambiar ubicacion.
     */
    public void ir(int idDestino){
        List<Integer> ruta = rutas()[idDestino];

        for(int i=0; i<ruta.size(); i++){
        }

        actualizarUbicacion(idDestino);
    }

    /**
     * Obtiene la ruta al lugaar de destino y suma las distancias de cada lugar recorrido.
     * @param idDestino
     */
    public void distancia(int idDestino){
        List<Integer> ruta = rutas()[idDestino];
        int idActual = idUbicacion;
        int distancia = 0;

        for(int i=1; i<ruta.size(); i++){
            System.out.println(caminos[idActual][ruta.get(i)]);
            distancia += caminos[idActual][ruta.get(i)];
            idActual = ruta.get(i);
        }
    }

    /**
     * Genera graficamente las lineas del recorrido hacia el destino.i
     * @param idDestino
     */
    public void ruta(int idDestino){
        List<Integer> ruta = rutas()[idDestino];

        for(int i=1; i<ruta.size(); i++){
            lugares.get(ruta.get(i)).graficoCambiarColor("#999999");

            Line linea = new Line(getLugar(ruta.get(i-1)).getCoordenadaX(), getLugar(ruta.get(i-1)).getCoordenadaY(), getLugar(ruta.get(i)).getCoordenadaX(), getLugar(ruta.get(i)).getCoordenadaY());

            linea.setStyle("-fx-stroke-width: 10; -fx-stroke: #999999;");

            graficoRutas.getChildren().add(linea);
        }
    }


    /**
     * Genera un arreglo de id de lugares ordenados de menor a mayor cantidad de personas.
     * @return
     */
    public int[] ordenarIdLugares(){
        int maximo = 0;

        for(int i=0; i<lugares.size(); i++){
            if(lugares.get(i).getCantidadPersonas()>maximo){
                maximo = lugares.get(i).getCantidadPersonas();
            }
        }

        int cantidadNumeros[] = new int[maximo+1];

        for(int i=0; i<lugares.size(); i++){
            cantidadNumeros[lugares.get(i).getCantidadPersonas()]++;
        }

        for(int i=1; i<cantidadNumeros.length; i++){
            cantidadNumeros[i]+=cantidadNumeros[i-1];
        }

        int numerosDesordenados[] = new int[lugares.size()];
        int lugaresOrdenados[] = new int[lugares.size()]; 

        for(int i=0; i<lugares.size(); i++){
            numerosDesordenados[i] = i;
        }

        for(int i=0; i<lugares.size(); i++){
            lugaresOrdenados[cantidadNumeros[lugares.get(numerosDesordenados[i]).getCantidadPersonas()]-1] = numerosDesordenados[i];
            cantidadNumeros[lugares.get(numerosDesordenados[i]).getCantidadPersonas()]--;
        }
        
        return lugaresOrdenados;
    }


    /**
     * Utilizamos el algoritmo Dijkstra para obtener el camiono mas corto de una atraccion a otra. 
     * @return
     */
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
