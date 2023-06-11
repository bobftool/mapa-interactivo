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
        int caminosidCaminoActualpia[][] = caminos;
        caminos = new int[lugares.size()][lugares.size()];

        for(int i=0; i<lugares.size(); i++){
            for(int o=0; o<lugares.size(); o++){
                caminos[i][o] = infinito;
            }
        }

        if(caminosidCaminoActualpia != null){
            for(int i=0; i<lugares.size(); i++){
                for(int o=0; o<lugares.size(); o++){
                    if(caminos[i][o] != infinito){
                        caminos[i][o] = caminosidCaminoActualpia[i][o];
                    }
                }
            }
        }
    }



    public void crearCamino(String lugarA, String lugarB, int distancias){
        int idLugarA = buscaridLugar(lugarA);
        int idLugarB = buscaridLugar(lugarB);

        if(idLugarA >= 0 && idLugarB >= 0){
            caminos[idLugarA][idLugarB] = distancias;
            caminos[idLugarB][idLugarA] = distancias;
        }else{
            System.out.println("No se pudo crear el camino entre "+lugarA+" y "+lugarB+".");
        }
    }



    public void crearCamino(int idLugarA, int idLugarB, int distancias){
        idLugarA-=1;
        idLugarB-=1;

        if(idLugarA >= 0 && idLugarB >= 0 && idLugarA < lugares.size() && idLugarB < lugares.size()){
            caminos[idLugarA][idLugarB] = distancias;
            caminos[idLugarB][idLugarA] = distancias;
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



    public void dijkStra(){
        List<Integer>[] rutas = new ArrayList[lugares.size()];
        int[] distancias = new int[lugares.size()];
        boolean[] visitados = new boolean[lugares.size()];

        for(int i=0; i<lugares.size(); i++){
            distancias[i] = infinito;
            rutas[i] = new ArrayList<>();
        }

        int idCaminoActual = 0;
        int idLugarActual = idUbicacionActual;

        distancias[idUbicacionActual] = 0;

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
                            rutas[idCaminoActual].set(i, rutas[idLugarActual].get(i));
                        }

                        for(int i=idCaminoActual; i<rutas[idLugarActual].size(); i++){
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

        System.out.println("Iniciar nodo:" + lugares.get(idUbicacionActual).getNombre());
        for(int i=0; i<lugares.size(); i++){
            System.out.print(lugares.get(i).getNombre() + "   " + distancias[i] + "   ");

            for(int o=0; o<rutas[i].size(); o++){
                System.out.print(lugares.get(rutas[i].get(o)).getNombre()+" -> ");
            }
            System.out.println();
        }

    }



    public int obtenerCaminoSiguiente(int idLugarActual, int idCaminoActual) {
        for(int i=idCaminoActual+1; i<lugares.size(); i++){
            System.out.println(idCaminoActual+" "+i);
            if(idLugarActual >= 0 && caminos[idLugarActual][i] != infinito){
                return i;
            }
        }

        return -1;
    }



    public int obtenerLugarSiguiente(int[] distancias, boolean[] visitados) {
        int j = 0;
        double mindis = Double.POSITIVE_INFINITY;
        for (int i = 0; i < distancias.length; i++) {
            if (!visitados[i]) {
                if (distancias[i] < mindis) {
                    mindis = distancias[i];
                    j = i;
                }
            }
        }
        return j;
    }
}
