public class App {
    public static void main(String[] args){
        Mapa mapa = new Mapa();

        mapa.agregarLugar("Entrada");
        mapa.agregarLugar("Alimentos");
        mapa.agregarLugar("Hipopótamos");
        mapa.agregarLugar("Antílopes");
        mapa.agregarLugar("Cebras");
        mapa.agregarLugar("Linces rojos");
        mapa.agregarLugar("Lobos mexicanos");
        mapa.agregarLugar("Ajolotes");
        mapa.agregarLugar("Jaguares");
        mapa.agregarLugar("Ocelotes");
        mapa.agregarLugar("Orangutanes");
        mapa.agregarLugar("Gorilas");
        mapa.agregarLugar("Pandas");
        mapa.agregarLugar("Pandas gigantes");
        mapa.agregarLugar("Tigres");
        mapa.agregarLugar("Osos");
        mapa.agregarLugar("Nutrias");
        mapa.agregarLugar("Conejos");
        mapa.agregarLugar("Pinguinos");
        mapa.agregarLugar("Osos polares");
        mapa.agregarLugar("Paujiles");
        mapa.agregarLugar("Delfines");
        mapa.agregarLugar("Cotorras");
        mapa.agregarLugar("Condor andino");
        mapa.agregarLugar("Argo real");
        mapa.agregarLugar("Orcas asesinas");
        mapa.agregarLugar("Tienda");
        mapa.agregarLugar("Quiosco");

        mapa.crearCamino("Entrada", "Lobos mexicanos", 180);
        mapa.crearCamino("Entrada", "Ajolotes", 200);
        mapa.crearCamino("Lobos mexicanos", "Linces rojos", 30);
        mapa.crearCamino("Linces rojos", "Cebras", 40);
        mapa.crearCamino("Linces rojos", "25", 55);
        mapa.crearCamino("25", "Cebras", 45);
        mapa.crearCamino("Cebras", "Hipopótamos", 130);
        mapa.crearCamino("Hipopótamos", "Antílopes", 60);
        mapa.crearCamino("Antílopes", "27", 35);
        mapa.crearCamino("27", "Pinguinos", 80);
        mapa.crearCamino("27", "Conejos", 50);
        mapa.crearCamino("27", "Alimentos", 30);
        mapa.crearCamino("Pinguinos", "Osos polares", 30);
        mapa.crearCamino("Osos polares", "28", 50);
        mapa.crearCamino("28", "Nutrias", 50);
        mapa.crearCamino("28", "Tigres", 45);
        mapa.crearCamino("28", "Condor andino", 60);
        mapa.crearCamino("Condor andino", "Paujiles", 50);
        mapa.crearCamino("Paujiles", "Cotorras", 30);
        mapa.crearCamino("27", "Pinguinos", 80);
        mapa.crearCamino("Cotorras", "Argo real", 40);
        mapa.crearCamino("Argo real", "Condor andino", 30);
        mapa.crearCamino("Nutrias", "Osos", 30);
        mapa.crearCamino("Osos", "Tigres", 30);
        mapa.crearCamino("Tigres", "Pandas", 40);
        mapa.crearCamino("Pandas", "Conejos", 45);
        mapa.crearCamino("Pandas", "Pandas gigantes", 40);
        mapa.crearCamino("Pandas gigantes", "Ajolotes", 35);
        mapa.crearCamino("Ajolotes", "Alimentos", 20);
        mapa.crearCamino("Ajolotes", "Jaguares", 30);
        mapa.crearCamino("Jaguares", "Orangutanes", 10);
        mapa.crearCamino("Ocelotes", "Jaguares", 10);
        mapa.crearCamino("Ocelotes", "26", 60);
        mapa.crearCamino("Gorilas", "26", 50);

        mapa.leer();
        mapa.imprimir();
        

    }
}
