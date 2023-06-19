import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/*
 * Autores: 
 * Alan González Morales 
 * Alan Olea Garcia
 * Axel Ivan Rossano Mddina
 * Mario Alexis Anguiano Juarez
 * Jose Julian Cruz Laparra
 * 
 */

 /*
  * Esta clase controla la aplicacion, la parte grafica del sistema.
  */
public class AppController{
    public String directorio = System.getProperty("user.dir");
    public Mapa mapa = new Mapa();
    public Random random = new Random();
    public int cantidad = 100;

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @FXML
    private AnchorPane container;

    /*
     * Esta funcion inicializa la parte grafica y crea los lugares del mapa , los caminos y agrega informacion a cada lugar.
     */
    @FXML
    public void initialize() {
        mapa.agregarLugar("Entrada", 475, 230); //0
        mapa.agregarLugar("Delfines", 275, 220); //1
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
        mapa.agregarLugar("Pavo reales", 50, 260); //23
        mapa.agregarLugar("Jirafas", 350, 85); //24
        mapa.agregarLugar("Tiburones", 470, 290); //25
        mapa.agregarLugar("Alimentos", 230, 170); //26
        mapa.agregarLugar("Quiosco", 115, 265); //27

        mapa.getLugar(0).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(1).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(2).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(3).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(4).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(5).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(6).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(7).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(8).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(9).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(10).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(11).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(12).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(13).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(14).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(15).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(16).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(17).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(18).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(19).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(20).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(21).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(22).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(23).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(24).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(25).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(26).setCantidadPersonas(random.nextInt(cantidad));
        mapa.getLugar(27).setCantidadPersonas(random.nextInt(cantidad));

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

        mapa.getLugar(0).setImagen(directorio+"\\Imagenes\\Entrada.jpg");
        mapa.getLugar(1).setImagen(directorio+"\\Imagenes\\Delfines.jpg");
        mapa.getLugar(2).setImagen(directorio+"\\Imagenes\\Hipopotamos.jpg");
        mapa.getLugar(3).setImagen(directorio+"\\Imagenes\\Antilopes.jpg");
        mapa.getLugar(4).setImagen(directorio+"\\Imagenes\\Cebras.jpg");
        mapa.getLugar(5).setImagen(directorio+"\\Imagenes\\Linces_Rojos.jpg");
        mapa.getLugar(6).setImagen(directorio+"\\Imagenes\\Lobos_Mexicanos.jpg");
        mapa.getLugar(7).setImagen(directorio+"\\Imagenes\\Ajolotes.jpg");
        mapa.getLugar(8).setImagen(directorio+"\\Imagenes\\Jaguares.jpg");
        mapa.getLugar(9).setImagen(directorio+"\\Imagenes\\Ocelotes.jpg");
        mapa.getLugar(10).setImagen(directorio+"\\Imagenes\\Orangutanes.jpg");
        mapa.getLugar(11).setImagen(directorio+"\\Imagenes\\Gorilas.jpg");
        mapa.getLugar(12).setImagen(directorio+"\\Imagenes\\Pandas_Gigantes.jpg");
        mapa.getLugar(13).setImagen(directorio+"\\Imagenes\\Pandas_Rojos.jpg");
        mapa.getLugar(14).setImagen(directorio+"\\Imagenes\\Tigres.jpg");
        mapa.getLugar(15).setImagen(directorio+"\\Imagenes\\Osos.jpg");
        mapa.getLugar(16).setImagen(directorio+"\\Imagenes\\Nutrias.jpg");
        mapa.getLugar(17).setImagen(directorio+"\\Imagenes\\Conejos.jpg");
        mapa.getLugar(18).setImagen(directorio+"\\Imagenes\\Pinguinos.jpg");
        mapa.getLugar(19).setImagen(directorio+"\\Imagenes\\Osos_Polares.jpg");
        mapa.getLugar(20).setImagen(directorio+"\\Imagenes\\Paujiles.jpg");
        mapa.getLugar(21).setImagen(directorio+"\\Imagenes\\Cotorras.jpg");
        mapa.getLugar(22).setImagen(directorio+"\\Imagenes\\Condores_Andinos.jpg");
        mapa.getLugar(23).setImagen(directorio+"\\Imagenes\\Pavo_Reales.jpg");
        mapa.getLugar(24).setImagen(directorio+"\\Imagenes\\Jirafas.jpg");
        mapa.getLugar(25).setImagen(directorio+"\\Imagenes\\Tiburones.jpg");
        mapa.getLugar(26).setImagen(directorio+"\\Imagenes\\Alimentos.jpg");
        mapa.getLugar(27).setImagen(directorio+"\\Imagenes\\Quiosco.jpg");

        mapa.getLugar(0).setDescripcion(
            "¡Bienvenido a la entrada principal del Zoológico de Chapultepec!"
            +"\n"+"\n"+
            "Aquí comienza tu aventura en el maravilloso mundo de la fauna y la naturaleza. Al cruzar nuestras puertas, serás recibido por un ambiente lleno de emoción y descubrimiento."
        );
        mapa.getLugar(1).setDescripcion(
            "En esta zona, podrás disfrutar de emocionantes exhibiciones donde los delfines te deslumbrarán con sus acrobacias y habilidades sorprendentes."
            +"\n"+"\n"+
            "Nuestra amplia piscina brinda a los delfines espacio para nadar, saltar y jugar en un entorno que simula su hábitat natural."
        );
        mapa.getLugar(2).setDescripcion(
            "Aquí podrás maravillarte con la majestuosidad de estos asombrosos animales semiacuáticos."
            +"\n"+"\n"+
            "Nuestra zona está diseñada para ofrecer a los hipopótamos un hábitat espacioso y confortable que se asemeja a su entorno natural."
        );
        mapa.getLugar(3).setDescripcion(
            "Descubre y aprende sobre los fascinantes antílopes que habitan en diversas regiones del mundo en este espacio dedicado a ellos."
            +"\n"+"\n"+
            "El área de antílopes brinda un entorno que se asemeja lo más posible a su hábitat natural."
        );
        mapa.getLugar(4).setDescripcion(
            "Sumérgete en el mundo fascinante de las hermosas y emblemáticas cebras africanas en el área dedicada a ellas del Zoológico."
            +"\n"+"\n"+
            "Observa sus comportamientos naturales, como pastar, correr y socializar en manadas."
        );
        mapa.getLugar(5).setDescripcion(
            "Adéntrate en el mundo misterioso y cautivador de los magníficos linces rojos en su área designada del Zoológico."
            +"\n"+"\n"+
            "Disfruta de un ambiente natural y estimulante que se asemeja al hábitat de estos hermosos depredadores."
        );
        mapa.getLugar(6).setDescripcion(
            "Explora el fascinante mundo de los majestuosos lobos mexicanos, una especie emblemática de la fauna mexicana, en su área exclusiva del Zoológico."
            +"\n"+"\n"+
            "Experimenta un entorno enriquecedor que recrea su hábitat natural."
        );
        mapa.getLugar(7).setDescripcion(
            "Sumérgete en el fascinante mundo de los enigmáticos ajolotes, únicos anfibios mexicanos, en su área dedicada del Zoológico."
            +"\n"+"\n"+
            "Disfruta de un entorno cuidadosamente diseñado que recrea su hábitat acuático y les brinda un ambiente adecuado."
        );
        mapa.getLugar(8).setDescripcion(
            "Adéntrate en el fascinante mundo de los majestuosos jaguares, símbolos de la fuerza y la belleza de la vida silvestre, en su área especial del Zoológico."
            +"\n"+"\n"+
            "Explora un entorno que refleja de cerca el hábitat natural de estos depredadores."
        );
        mapa.getLugar(9).setDescripcion(
            "Descubre el mundo enigmático de los cautivadores ocelotes de América Latina en su área dedicada del Zoológico."
            +"\n"+"\n"+
            "Sumérgete en un entorno cuidadosamente diseñado que refleja su hábitat natural."
        );
        mapa.getLugar(10).setDescripcion(
            "Adéntrate en el fascinante mundo de los inteligentes y carismáticos orangutanes en su área dedicada del Zoológico."
            +"\n"+"\n"+
            "Disfruta de un entorno que imita de cerca su hábitat natural, con amplios espacios arbolados, enredaderas y plataformas elevadas donde pueden trepar, balancearse y explorar como en la selva."
        );
        mapa.getLugar(11).setDescripcion(
            "Explora el fascinante mundo de los imponentes gorilas, considerados uno de los grandes tesoros de la naturaleza, en su área exclusiva del Zoológico."
            +"\n"+"\n"+
            "Sumérgete en un entorno que se asemeja a su hábitat natural en las selvas africanas."
        );
        mapa.getLugar(12).setDescripcion(
            "Sumérgete en el encantador mundo de los adorables y emblemáticos pandas gigantes en su área dedicada del Zoológico."
            +"\n"+"\n"+
            "Descubre un entorno cuidadosamente diseñado que recrea su hábitat natural en las montañas boscosas."
        );
        mapa.getLugar(13).setDescripcion(
            "Explora el encantador mundo de los pequeños y cautivadores pandas rojos nativos de las montañas del Himalaya en su área exclusiva del Zoológico."
            +"\n"+"\n"+
            "Disfruta de un entorno diseñado para recrear su hábitat natural."
        );
        mapa.getLugar(14).setDescripcion(
            "Adéntrate en el fascinante mundo de los majestuosos tigres, conocidos por su belleza y poder, en su área especial del Zoológico."
            +"\n"+"\n"+
            "Explora un entorno que se asemeja a su hábitat natural en las selvas y bosques."
        );
        mapa.getLugar(15).setDescripcion(
            "Explora el fascinante mundo de los grandes y fascinantes osos en su área dedicada del Zoológico."
            +"\n"+"\n"+
            "Sumérgete en un entorno que se asemeja a su hábitat natural."
        );
        mapa.getLugar(16).setDescripcion(
            "Sumérgete en el encantador mundo acuático de las juguetonas y carismáticas nutrias en su área designada del Zoológico."
            +"\n"+"\n"+
            "Disfruta de un entorno que recrea su hábitat natural en los ríos y lagos, con amplias y cristalinas piscinas, áreas rocosas y vegetación acuática donde pueden nadar, jugar y exhibir su comportamiento natural."
        );
        mapa.getLugar(17).setDescripcion(
            "Explora el mundo encantador y tranquilo de los adorables y esponjosos conejos en su área dedicada del Zoológico."
            +"\n"+"\n"+
            "Disfruta de un ambiente acogedor que se asemeja a su hábitat natural."
        );
        mapa.getLugar(18).setDescripcion(
            "Sumérgete en el fascinante mundo de las increíbles aves marinas en el área de pingüinos del Zoológico."
            +"\n"+"\n"+
            "Descubre su estilo de vida único en el hielo y el agua, en un entorno diseñado para recrear su hábitat frío y acuático en las regiones polares."
        );
        mapa.getLugar(19).setDescripcion(
            "Adéntrate en el fascinante mundo de los majestuosos osos polares en su área exclusiva del Zoológico."
            +"\n"+"\n"+
            "Explora un entorno diseñado para recrear el vasto y gélido entorno ártico donde estos magníficos depredadores del Ártico llaman hogar."
        );
        mapa.getLugar(20).setDescripcion(
            "Sumérgete en el fascinante mundo de las coloridas aves tropicales en el área de paujiles del Zoológico."
            +"\n"+"\n"+
            "Descubre su belleza y encanto únicos en un entorno diseñado para recrear el exuberante hábitat de las selvas tropicales donde estas aves se encuentran."
        );
        mapa.getLugar(21).setDescripcion(
            "Adéntrate en el mundo vibrante y bullicioso de las alegres cotorras en su área designada del Zoológico."
            +"\n"+"\n"+
            "Explora un entorno tropical lleno de color y movimiento, similar a los hábitats nativos donde estas aves parlanchinas se encuentran."
        );
        mapa.getLugar(22).setDescripcion(
            "Explora el fascinante mundo de las majestuosas aves rapaces, los cóndores andinos, en su área exclusiva del Zoológico."
            +"\n"+"\n"+
            "Sumérgete en un entorno diseñado para recrear el hábitat montañoso donde estas aves sobrevuelan y descubre su importancia en los ecosistemas de las montañas."
        );
        mapa.getLugar(23).setDescripcion(
            "Sumérgete en el fascinante mundo de las hermosas aves exóticas, los pavos reales, en su área designada del Zoológico."
            +"\n"+"\n"+
            "Admira sus majestuosas exhibiciones de plumaje en un entorno exuberante y colorido, inspirado en sus hábitats naturales."
        );
        mapa.getLugar(24).setDescripcion(
            "Adéntrate en el fascinante mundo de las jirafas y descubre su elegancia y singularidad en su área exclusiva del Zoológico."
            +"\n"+"\n"+
            "Explora un entorno similar a las vastas llanuras africanas, donde estas magníficas criaturas de cuello largo se sienten como en casa."
        );
        mapa.getLugar(25).setDescripcion(
            "Explora el fascinante Área de Tiburones del Acuario y adéntrate en el mundo de estos increíbles depredadores marinos. Descubre su belleza y poderío en el reino submarino."
            +"\n"+"\n"+
            "Sumérgete en un entorno acuático diseñado para reflejar los hábitats marinos donde estos magníficos tiburones habitan, y maravíllate con su presencia."
        );
        mapa.getLugar(26).setDescripcion(
            "Disfruta de la experiencia culinaria en el Área de Alimentos del Zoológico, donde encontrarás una amplia variedad de opciones gastronómicas para satisfacer tus necesidades durante tu visita."
            +"\n"+"\n"+
            "Nuestro objetivo es ofrecerte una experiencia culinaria única y de alta calidad, complementando tu recorrido por el zoológico."
        );
        mapa.getLugar(27).setDescripcion(
            "Visita el Quiosco del Zoológico, un lugar acogedor y conveniente donde podrás satisfacer tus antojos rápidos mientras disfrutas de tu visita."
            +"\n"+"\n"+
            "El Quiosco ofrece una variedad de opciones deliciosas y prácticas que se adaptan a todos los gustos."
        );
        
        mapa.graficoInicializar();
        container.getChildren().add(mapa.getGrafico());
    }
}
