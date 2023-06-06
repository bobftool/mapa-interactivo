import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.sound.midi.Soundbank;
import javax.sound.sampled.SourceDataLine;

public class Mapa {
    private final int infinito = Integer.MAX_VALUE;

    private List<Lugar> lugares = new ArrayList<>();
    private int[][] caminos;



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
        int idLugarA = -1;
        int idLugarB = -1;

        for(int i=0; i<lugares.size(); i++){
            if(idLugarA < 0 || idLugarB < 0){
                if(lugares.get(i).getNombre().equals(lugarA)){
                    idLugarA = i;
                }
    
                if(lugares.get(i).getNombre().equals(lugarB)){
                    idLugarB = i;
                }
            }else{
                break;
            }
        }

        if(idLugarA >= 0 && idLugarB >= 0){
            caminos[idLugarA][idLugarB] = distancia;
            caminos[idLugarB][idLugarA] = distancia;
        }else{
            System.out.println("No se pudo crear el camino entre "+lugarA+" y "+lugarB+".");
        }
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
