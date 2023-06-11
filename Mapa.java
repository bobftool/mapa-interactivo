import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Mapa {
    private final int infinito = Integer.MAX_VALUE;

    private List<Lugar> lugares = new ArrayList<>();
    private int[][] caminos;

    private int idUbicacionActual = 0;



    public void agregarLugar(String nombre){
        lugares.add(new Lugar(nombre));
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

        if(caminosCopia != null){
            for(int i=0; i<lugares.size(); i++){
                for(int o=0; o<lugares.size(); o++){
                    if(caminos[i][o] != infinito){
                        caminos[i][o] = caminosCopia[i][o];
                    }
                }
            }
        }
    }



    public void crearCamino(String lugarA, String lugarB, int distancia){
        int idLugarA = buscaridLugar(lugarA);
        int idLugarB = buscaridLugar(lugarB);

        if(idLugarA >= 0 && idLugarB >= 0){
            caminos[idLugarA][idLugarB] = distancia;
            caminos[idLugarB][idLugarA] = distancia;
        }else{
            System.out.println("No se pudo crear el camino entre "+lugarA+" y "+lugarB+".");
        }
    }



    public void crearCamino(int idLugarA, int idLugarB, int distancia){
        idLugarA-=1;
        idLugarB-=1;

        if(idLugarA >= 0 && idLugarB >= 0 && idLugarA < lugares.size() && idLugarB < lugares.size()){
            caminos[idLugarA][idLugarB] = distancia;
            caminos[idLugarB][idLugarA] = distancia;
        }else{
            System.out.println("No se pudo crear el camino entre "+idLugarA+" y "+idLugarB+".");
        }
    }



    public Lugar buscarLugar(String nombre){
        Lugar lugar = null;

        for(int i=0; i<lugares.size(); i++){
            if(lugares.get(i).getNombre().equals(nombre)){
                lugar = lugares.get(i);
                break;
            }
        }

        return lugar;
    }



    public int buscaridLugar(String nombre){
        return lugares.indexOf(buscarLugar(nombre));
    }



    public void ir(String destino){
        int idDestino = buscaridLugar(destino);
        int[] ruta = rutaHacia(idDestino);

        for(int i=0; i<ruta.length; i++){
            System.out.print("["+lugares.get(ruta[i]).getNombre()+"] -> ");
        }

        System.out.println();
        System.out.println("Distancia: "+distanciaHacia(idDestino));

        idUbicacionActual = idDestino;
    }



    private int[] rutasDesdeUbicacionActual(){
        int[] distancias = new int[lugares.size()];
        int[] rutas = new int[lugares.size()];

        for (int i=0; i<distancias.length; i++) {
            distancias[i] = infinito;
            rutas[i] = -1;
        }
        distancias[idUbicacionActual] = 0;

        boolean[] visitados = new boolean[lugares.size()];
        PriorityQueue<Integer> pendientes = new PriorityQueue<>();
        pendientes.offer(idUbicacionActual);

        while(!pendientes.isEmpty()){
            int idActual = pendientes.poll();

            if(visitados[idActual]){
                continue;
            }

            visitados[idActual] = true;

            for(int i=0; i<lugares.size(); i++){
                if(caminos[idActual][i] != infinito && !visitados[i]){
                    int distancia = distancias[idActual] + caminos[idActual][i];

                    if(distancia < distancias[i]) {
                        distancias[i] = distancia;
                        rutas[i] = idActual;
                    }

                    pendientes.offer(i);
                }
            }
        }

        return rutas;
    }

    private int[] rutaHacia(int idDestino){
        int[] rutasDesdeUbicacionActual = rutasDesdeUbicacionActual();
        int[] rutaInversa = new int[lugares.size()];

        int longitudRuta = 0;
        int idActual = idDestino;

        while(idActual != -1){
            rutaInversa[longitudRuta++] = idActual;
            idActual = rutasDesdeUbicacionActual[idActual];
        }

        int[] ruta = new int[longitudRuta];

        for(int i=longitudRuta-1; i>=0; i--){
            ruta[(longitudRuta-1)-i] = rutaInversa[i];
        }

        return ruta;
    }



    private int distanciaHacia(int idDestino){
        int distancia = 0;

        int[] rutasDesdeUbicacionActual = rutasDesdeUbicacionActual();
        int[] rutaInversa = new int[lugares.size()];

        int longitudRuta = 0;
        int idActual = idDestino;

        while(idActual != -1){
            rutaInversa[longitudRuta++] = idActual;
            idActual = rutasDesdeUbicacionActual[idActual];
        }

        for(int i=longitudRuta-2; i>=0; i--){
            distancia += caminos[idUbicacionActual][rutaInversa[i]];
        }

        return distancia;
    }



    public void imprimir(){
        Queue<Integer> pendientes = new ArrayDeque<>();
        List<Integer> impresos = new ArrayList<>();

        pendientes.add(0);
        
        while(!pendientes.isEmpty()){
            int indice = pendientes.poll();

            System.out.print("["+lugares.get(indice).getNombre()+"] -> ");
            impresos.add(indice);

            for(int i=0; i<lugares.size(); i++){
                if(caminos[indice][i] != infinito && !impresos.contains(i)){
                    pendientes.add(i);
                }
            }
        }
    }



    public void leer(){
        for(int i=0; i<lugares.size(); i++){
            for(int o=0; o<lugares.size(); o++){
                if(caminos[i][o] != infinito){
                    System.out.print("["+caminos[i][o]+"]");
                }else{
                    System.out.print("[in]");
                }
            }
            System.out.println();
        }
    }
}
