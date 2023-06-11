public class App {
    public static void main(String[] args){
        Mapa mapa = new Mapa();

        mapa.agregarLugar("Entrada"); //1
        mapa.agregarLugar("Alimentos"); //2
        mapa.agregarLugar("Hipopótamos"); //3
        mapa.agregarLugar("Antílopes"); //4
        mapa.agregarLugar("Cebras"); //5
        mapa.agregarLugar("Linces rojos"); //6
        mapa.agregarLugar("Lobos mexicanos"); //7
        mapa.agregarLugar("Ajolotes"); //8
        mapa.agregarLugar("Jaguares"); //9
        mapa.agregarLugar("Ocelotes"); //10
        mapa.agregarLugar("Orangutanes"); //11
        mapa.agregarLugar("Gorilas"); //12
        mapa.agregarLugar("Pandas gigantes"); //13
        mapa.agregarLugar("Pandas rojos"); //14
        mapa.agregarLugar("Tigres"); //15
        mapa.agregarLugar("Osos"); //16
        mapa.agregarLugar("Nutrias"); //17
        mapa.agregarLugar("Conejos"); //18
        mapa.agregarLugar("Pingüinos"); //19
        mapa.agregarLugar("Osos polares"); //20
        mapa.agregarLugar("Paujiles"); //21
        mapa.agregarLugar("Cotorras"); //22
        mapa.agregarLugar("Cóndores andinos"); //23
        mapa.agregarLugar("Argo real"); //24
        mapa.agregarLugar("Orcas asesinas"); //25
        mapa.agregarLugar("Tiburones"); //26
        mapa.agregarLugar("Delfines"); //27
        mapa.agregarLugar("Quiosco"); //28

        mapa.crearCamino(1, 7, 160);
        mapa.crearCamino(1, 8, 220);
        mapa.crearCamino(2, 8, 40);
        mapa.crearCamino(2, 27, 80);
        mapa.crearCamino(3, 4, 80);
        mapa.crearCamino(3, 5, 140);
        mapa.crearCamino(4, 27, 30);
        mapa.crearCamino(5, 6, 60);
        mapa.crearCamino(5, 25, 60);
        mapa.crearCamino(6, 25, 60);
        mapa.crearCamino(6, 7, 50);
        mapa.crearCamino(8, 9, 50);
        mapa.crearCamino(8, 13, 60);
        mapa.crearCamino(9, 10, 30);
        mapa.crearCamino(9, 11, 20);
        mapa.crearCamino(10, 26, 110);
        mapa.crearCamino(12, 13, 90);
        mapa.crearCamino(12, 26, 150);
        mapa.crearCamino(13, 14, 50);
        mapa.crearCamino(14, 15, 60);
        mapa.crearCamino(14, 18, 50);
        mapa.crearCamino(15, 16, 30);
        mapa.crearCamino(16, 17, 40);
        mapa.crearCamino(16, 28, 50);
        mapa.crearCamino(17, 18, 20);
        mapa.crearCamino(18, 27, 80);
        mapa.crearCamino(19, 20, 30);
        mapa.crearCamino(19, 27, 70);
        mapa.crearCamino(20, 28, 50);
        mapa.crearCamino(21, 22, 20);
        mapa.crearCamino(21, 23, 30);
        mapa.crearCamino(22, 24, 50);
        mapa.crearCamino(23, 24, 20);
        mapa.crearCamino(23, 28, 80);

        mapa.ir("Lobos mexicanos");
    }
}
