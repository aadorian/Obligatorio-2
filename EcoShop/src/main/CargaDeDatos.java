package main;

import dominio.*;
import interfazDominio.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * CargaDeDatos - Carga datos al sistema que se le atribuya
 * @author matia
 */
public class CargaDeDatos {
    //Atributos
    IEcoShop sistemaEcoShop;

    //Costructor
    public CargaDeDatos(IEcoShop sistemaEcoShop) {
        this.sistemaEcoShop = sistemaEcoShop;
    }

    //Getter & Setter
    public IEcoShop getSistemaEcoShop() {
        return sistemaEcoShop;
    }

    public void setSistemaEcoShop(IEcoShop sistemaEcoShop) {
        this.sistemaEcoShop = sistemaEcoShop;
    }

    //
    //METODOS PUBLICOS
    //
    
    public void cargarSistema() {
        this.cargarDirecciones();
        this.cargarProveedores();
        this.cargarEnvases();
        this.cargarPuntosDeVenta();

        this.cargarManzanaVerde();
        this.cargarManzanaRoja();
        this.cargarBanana();
        this.cargarKiwi();
        this.cargarCastanas();
        this.cargarPistachos();
        this.cargarAlmendras();
        this.cargarNueces();
        this.cargarEsparragos();
        this.cargarZanahoria();
        this.cargarGengibre();
        this.cargarApio();
        
        this.cargarListaFavoritosGlobal();
        this.cargoPreVentasYTickets();
    }

    //
    //METODOS PRIVADOS
    //
    
    private void cargarDirecciones() {
        IDireccion d1 = new Direccion("Uruguay", "Montevideo", "Carrasco", "Costa Rica",
                "Cooper", 2264, 11400);
        IDireccion d2 = new Direccion("Uruguay", "Canelones", "Los Cerrillos",
                "Ruta 36 km 37", "-", 2342, 90001);
        IDireccion d3 = new Direccion("Argentina", "Buenos Aires", "La Paternal",
                "Av. Juan B. Justo", "Av. San Martin", 1727, 1405);
        IDireccion d4 = new Direccion("Estados Unidos", "Florida", "Gainesville",
                "717  Long Street", "-", 7483, 32601);

        sistemaEcoShop.registrarDireccion(d1);
        sistemaEcoShop.registrarDireccion(d2);
        sistemaEcoShop.registrarDireccion(d3);
        sistemaEcoShop.registrarDireccion(d4);
    }

    private void cargarProveedores() {
        IProveedor p1 = new Proveedor("Las Acacias");
        IProveedor p2 = new Proveedor("La Serenísima");
        IProveedor p3 = new Proveedor("Los Nietitos");
        IProveedor p4 = new Proveedor("Granja Narbona");

        sistemaEcoShop.registrarProveedor(p1);
        sistemaEcoShop.registrarProveedor(p2);
        sistemaEcoShop.registrarProveedor(p3);
        sistemaEcoShop.registrarProveedor(p4);
    }

    private void cargarEnvases() {
        IEnvase e1 = new Envase("Bolsa Mediana",
                "interfazGrafica/imagenes/BolsaMediana.png");
        IEnvase e2 = new Envase("Tupper Chico",
                "interfazGrafica/imagenes/TupperChico.png");
        IEnvase e3 = new Envase("Tupper Mediano",
                "interfazGrafica/imagenes/TupperMediano.png");
        IEnvase e4 = new Envase("Bolsa Grande",
                "interfazGrafica/imagenes/BolsaGrande.png");

        sistemaEcoShop.registrarEnvase(e1);
        sistemaEcoShop.registrarEnvase(e2);
        sistemaEcoShop.registrarEnvase(e3);
        sistemaEcoShop.registrarEnvase(e4);
    }

    private void cargarPuntosDeVenta() {
        IPuntoDeVenta p1 = new PuntoDeVenta(1, "interfazGrafica/imagenes/localEcoShop1.jpg");
        IPuntoDeVenta p2 = new PuntoDeVenta(2, "interfazGrafica/imagenes/localEcoShop2.jpg");
        IPuntoDeVenta p3 = new PuntoDeVenta(3, "interfazGrafica/imagenes/localEcoShop3.jpg");
        IPuntoDeVenta p4 = new PuntoDeVenta(4, "interfazGrafica/imagenes/localEcoShop4.jpg");

        sistemaEcoShop.registrarPuntoDeVenta(p1);
        sistemaEcoShop.registrarPuntoDeVenta(p2);
        sistemaEcoShop.registrarPuntoDeVenta(p3);
        sistemaEcoShop.registrarPuntoDeVenta(p4);
    }

    private void cargarListaFavoritosGlobal(){
        IArticulo fav1 = sistemaEcoShop.obtenerArticuloPorNombre("Zanahoria");
        IArticulo fav2 = sistemaEcoShop.obtenerArticuloPorNombre("Kiwi");
        IArticulo fav3 = sistemaEcoShop.obtenerArticuloPorNombre("Manzana Roja");
        IArticulo fav4 = sistemaEcoShop.obtenerArticuloPorNombre("Gengibre");
        
        sistemaEcoShop.agregarArticuloAFavoritosGlobal(fav1);
        sistemaEcoShop.agregarArticuloAFavoritosGlobal(fav2);
        sistemaEcoShop.agregarArticuloAFavoritosGlobal(fav3);
        sistemaEcoShop.agregarArticuloAFavoritosGlobal(fav4);
    }
    
    private void cargoPreVentasYTickets(){
        //Primera preventa a cargar
        ICarrito c1 = new Carrito();
        IPuntoDeVenta local1 = sistemaEcoShop.obtenerPuntoDeVentaPorNumeroDeLocal(1);
        LocalDateTime diaCompra1 = LocalDateTime.now();
        LocalDate diaRetiro1 = LocalDate.of(2019, 12, 2);
        IPreVenta p1;
        
        c1.agregarArticulo(sistemaEcoShop.obtenerArticuloPorNombre("Kiwi"), 1.0);
        c1.agregarArticulo(sistemaEcoShop.
                obtenerArticuloPorNombre("Zanahoria"), 2.5);
        c1.agregarArticulo(sistemaEcoShop.
                obtenerArticuloPorNombre("Manzana Verde"), 3.0);
        c1.agregarArticulo(sistemaEcoShop.
                obtenerArticuloPorNombre("Manzana Roja"), 0.7);
        
        c1.agregarEnvase(sistemaEcoShop.
                obtenerArticuloPorNombre("Kiwi"), 
                sistemaEcoShop.obtenerEnvasePorNombre("Tupper Mediano"));
        c1.agregarEnvase(sistemaEcoShop.
                obtenerArticuloPorNombre("Zanahoria"), 
                sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Mediana"));
        c1.agregarEnvase(sistemaEcoShop.
                obtenerArticuloPorNombre("Manzana Verde"), 
                sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Grande"));
        c1.agregarEnvase(sistemaEcoShop.
                obtenerArticuloPorNombre("Manzana Roja"), 
                sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Mediana"));
        
        p1 = new PreVenta(c1, local1, diaCompra1, c1.obtenerPrecioTotal(), diaRetiro1);
        
        sistemaEcoShop.registrarPreVenta(p1);
        //Genera el TicketPreVenta
        sistemaEcoShop.generarTicket(p1);
        
        //Segunda preventa a cargar
        ICarrito c2 = new Carrito();
        IPuntoDeVenta local2 = sistemaEcoShop.obtenerPuntoDeVentaPorNumeroDeLocal(3);
        LocalDateTime diaCompra2 = LocalDateTime.now();
        LocalDate diaRetiro2 = LocalDate.of(2019, 11, 25);
        IPreVenta p2;
        
        c2.agregarArticulo(sistemaEcoShop.obtenerArticuloPorNombre("Banana"), 2.0);
        c2.agregarArticulo(sistemaEcoShop.
                obtenerArticuloPorNombre("Gengibre"), 0.3);
        c2.agregarArticulo(sistemaEcoShop.
                obtenerArticuloPorNombre("Nueces"), 0.1);
        c2.agregarArticulo(sistemaEcoShop.
                obtenerArticuloPorNombre("Manzana Roja"), 0.7);
        
        c2.agregarEnvase(sistemaEcoShop.
                obtenerArticuloPorNombre("Banana"), 
                sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Mediana"));
        c2.agregarEnvase(sistemaEcoShop.
                obtenerArticuloPorNombre("Gengibre"), 
                sistemaEcoShop.obtenerEnvasePorNombre("Tupper Mediano"));
        c2.agregarEnvase(sistemaEcoShop.
                obtenerArticuloPorNombre("Nueces"), 
                sistemaEcoShop.obtenerEnvasePorNombre("Tupper Chico"));
        c2.agregarEnvase(sistemaEcoShop.
                obtenerArticuloPorNombre("Manzana Roja"), 
                sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Mediana"));
        
        p2 = new PreVenta(c2, local2, diaCompra2, c2.obtenerPrecioTotal(), diaRetiro2);
        
        sistemaEcoShop.registrarPreVenta(p2);
        //Genera el TicketPreVenta
        sistemaEcoShop.generarTicket(p2);
    }
    
    /**
     * Carga nuevo artículo: Manzana Verde
     */
    private void cargarManzanaVerde() {
        //Variables
        double precioPorKGManzanaVerde = 59;
        String rutaDeImagenManzanaVerde
                = "interfazGrafica/imagenes/manzanaVerde2.jpg";
        String calificadorManzanaVerde = "Fruta";
        int codigoIdentificadorManzanaVerde = 1023;

        //Creo Artículo
        IArticulo manzanaVerde
                = new Articulo("Manzana Verde", rutaDeImagenManzanaVerde,
                        precioPorKGManzanaVerde, calificadorManzanaVerde, 
                        codigoIdentificadorManzanaVerde);

        //Seteo los posibles envases para este artículo
        manzanaVerde.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre
                                  ("Bolsa Mediana"));
        manzanaVerde.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre
                                  ("Bolsa Grande"));

        //Ingreso este nuevo artículo al sistema
        sistemaEcoShop.registrarArticulo(manzanaVerde);
    }

    private void cargarManzanaRoja() {
        //Var
        double precioPorKGManzanaRoja = 66;
        String rutaDeImagenManzanaRoja = "interfazGrafica/imagenes/manzanaRoja.jpg";
        String calificadorManzanaRoja = "Fruta";

        IArticulo manzanaRoja = new Articulo("Manzana Roja", rutaDeImagenManzanaRoja,
                precioPorKGManzanaRoja, calificadorManzanaRoja, 3982);

        manzanaRoja.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Mediana"));
        manzanaRoja.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Grande"));

        sistemaEcoShop.registrarArticulo(manzanaRoja);
    }

    private void cargarBanana() {
        //Var
        double precioPorKGBanana = 109;
        String rutaDeImagenBanana = "interfazGrafica/imagenes/banana.jpg";
        String calificadorBanana = "Fruta";

        IArticulo banana = new Articulo("Banana", rutaDeImagenBanana,
                precioPorKGBanana, calificadorBanana, 2138);

        banana.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Mediana"));
        banana.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Grande"));

        sistemaEcoShop.registrarArticulo(banana);
    }

    private void cargarKiwi() {
        //Var
        double precioPorKGKiwi = 192;
        String rutaDeImagenKiwi = "interfazGrafica/imagenes/kiwi.jpg";
        String calificadorKiwi = "Fruta";

        IArticulo kiwi = new Articulo("Kiwi", rutaDeImagenKiwi,
                precioPorKGKiwi, calificadorKiwi, 8573);

        kiwi.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Mediana"));
        kiwi.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Grande"));
        kiwi.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Tupper Mediano"));

        sistemaEcoShop.registrarArticulo(kiwi);
    }

    private void cargarCastanas() {
        //Var
        double precioPorKGCastanas = 1790;
        String rutaDeImagenCastanas = "interfazGrafica/imagenes/castanas.jpg";
        String calificadorCastanas = "Fruto Seco";

        IArticulo castana = new Articulo("Castañas de Cajú", rutaDeImagenCastanas,
                precioPorKGCastanas, calificadorCastanas, 8765);

        castana.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Mediana"));
        castana.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Grande"));
        castana.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Tupper Chico"));
        castana.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Tupper Mediano"));

        sistemaEcoShop.registrarArticulo(castana);
    }

    private void cargarPistachos() {
        //Var
        double precioPorKGPistachos = 2740;
        String rutaDeImagenPistachos = "interfazGrafica/imagenes/pistachos.jpg";
        String calificadorPistachos = "Fruto Seco";

        IArticulo pistacho = new Articulo("Pistachos", rutaDeImagenPistachos,
                precioPorKGPistachos, calificadorPistachos,
                5599);

        pistacho.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Mediana"));
        pistacho.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Grande"));
        pistacho.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Tupper Chico"));
        pistacho.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Tupper Mediano"));

        sistemaEcoShop.registrarArticulo(pistacho);
    }

    private void cargarAlmendras() {
        //Var
        double precioPorKGAlmendras = 1050;
        String rutaDeImagenAlmendras = "interfazGrafica/imagenes/almendras.jpg";
        String calificadorAlmendras = "Fruto Seco";

        IArticulo almendra = new Articulo("Almendras", rutaDeImagenAlmendras,
                precioPorKGAlmendras, calificadorAlmendras,
                3345);

        almendra.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Mediana"));
        almendra.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Grande"));
        almendra.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Tupper Chico"));
        almendra.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Tupper Mediano"));

        sistemaEcoShop.registrarArticulo(almendra);
    }

    private void cargarNueces() {
        //Var
        double precioPorKGNueces = 1170;
        String rutaDeImagenNueces = "interfazGrafica/imagenes/nueces.jpg";
        String calificadorNueces = "Fruto Seco";

        IArticulo nuez = new Articulo("Nueces", rutaDeImagenNueces,
                precioPorKGNueces, calificadorNueces, 1890);

        nuez.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Mediana"));
        nuez.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Grande"));
        nuez.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Tupper Chico"));
        nuez.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Tupper Mediano"));

        sistemaEcoShop.registrarArticulo(nuez);
    }

    private void cargarEsparragos() {
        //Var
        double precioPorKGEsparragos = 447;
        String rutaDeImagenEsparragos = "interfazGrafica/imagenes/esparragos.jpg";
        String calificadorEsparragos = "Verdura";

        IArticulo esparrago = new Articulo("Esparragos", rutaDeImagenEsparragos,
                precioPorKGEsparragos, calificadorEsparragos, 2019);

        esparrago.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Mediana"));
        esparrago.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Grande"));
        esparrago.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Tupper Mediano"));

        sistemaEcoShop.registrarArticulo(esparrago);
    }

    private void cargarZanahoria() {
        //Var
        double precioPorKGZanahoria = 64;
        String rutaDeImagenZanahoria = "interfazGrafica/imagenes/zanahoria.jpg";
        String calificadorZanahoria = "Verdura";

        IArticulo zanahoria = new Articulo("Zanahoria", rutaDeImagenZanahoria,
                precioPorKGZanahoria, calificadorZanahoria, 4000);

        zanahoria.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Mediana"));
        zanahoria.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Grande"));

        sistemaEcoShop.registrarArticulo(zanahoria);
    }

    private void cargarGengibre() {
        //Var
        double precioPorKGGengibre = 227;
        String rutaDeImagenGengibre = "interfazGrafica/imagenes/gengibre.jpg";
        String calificadorGengibre = "Verdura";

        IArticulo gengibre = new Articulo("Gengibre", rutaDeImagenGengibre,
                precioPorKGGengibre, calificadorGengibre,
                8888);

        gengibre.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Mediana"));
        gengibre.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Grande"));
        gengibre.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Tupper Mediano"));

        sistemaEcoShop.registrarArticulo(gengibre);
    }

    private void cargarApio() {
        //Var
        double precioPorKGApio = 193;
        String rutaDeImagenApio = "interfazGrafica/imagenes/apio.jpg";
        String calificadorApio = "Verdura";

        IArticulo apio = new Articulo("Apio", rutaDeImagenApio,
                precioPorKGApio, calificadorApio, 9999);

        apio.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Mediana"));
        apio.agregarEnvase(sistemaEcoShop.obtenerEnvasePorNombre("Bolsa Grande"));

        sistemaEcoShop.registrarArticulo(apio);
    }

}
