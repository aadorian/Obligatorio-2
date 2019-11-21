/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dominio.*;
import interfazDominio.*;
import java.util.ArrayList;

/**
 *
 * @author matia
 */
public class CargaDeDatos {

    //Atributos
    IEcoShop sistemaEcoShop;

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
    }

    /**
     *
     */
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

    /**
     *
     */
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
        IEnvase e1 = new Envase("Bolsa Mediana", 20, 13, 30,
                "interfazGrafica/imagenes/BolsaMediana.png");
        IEnvase e2 = new Envase("Tupper Chico", 13, 12, 6,
                "interfazGrafica/imagenes/TupperChico.png");
        IEnvase e3 = new Envase("Tupper Mediano", 18, 11, 11,
                "interfazGrafica/imagenes/TupperMediano.png");
        IEnvase e4 = new Envase("Bolsa Grande", 21, 22, 54,
                "interfazGrafica/imagenes/BolsaGrande.png");

        sistemaEcoShop.registrarEnvase(e1);
        sistemaEcoShop.registrarEnvase(e2);
        sistemaEcoShop.registrarEnvase(e3);
        sistemaEcoShop.registrarEnvase(e4);
    }

    private void cargarPuntosDeVenta() {
        IPuntoDeVenta p1 = new PuntoDeVenta(1);
        IPuntoDeVenta p2 = new PuntoDeVenta(2);
        IPuntoDeVenta p3 = new PuntoDeVenta(3);
        IPuntoDeVenta p4 = new PuntoDeVenta(4);

        sistemaEcoShop.registrarPuntoDeVenta(p1);
        sistemaEcoShop.registrarPuntoDeVenta(p2);
        sistemaEcoShop.registrarPuntoDeVenta(p3);
        sistemaEcoShop.registrarPuntoDeVenta(p4);
    }

    /**
     * Carga nuevo artículo: Manzana Verde
     */
    private void cargarManzanaVerde() {
        //Vaiables
        double densidadDeManzanaVerde = 947;
        double precioPorKGManzanaVerde = 59;
        String rutaDeImagenManzanaVerde
                = "interfazGrafica/imagenes/manzanaVerde2.jpg";
        String calificadorManzanaVerde = "Fruta";

        //Creo Artículo
        IArticulo manzanaVerde
                = new Articulo("Manzana Verde", rutaDeImagenManzanaVerde,
                        precioPorKGManzanaVerde, densidadDeManzanaVerde,
                        calificadorManzanaVerde);

        //Seteo los posibles envases para este artículo
        manzanaVerde.agregarEnvase(obtenerEnvase("Bolsa Mediana"));
        manzanaVerde.agregarEnvase(obtenerEnvase("Bolsa Grande"));

        //Ingreso este nuevo artículo al sistema
        sistemaEcoShop.registrarArticulo(manzanaVerde);
    }

    private void cargarManzanaRoja() {
        double densidadDeManzanaRoja = 947;
        double precioPorKGManzanaRoja = 66;
        String rutaDeImagenManzanaRoja = "interfazGrafica/imagenes/manzanaRoja.jpg";
        String calificadorManzanaRoja = "Fruta";

        IArticulo manzanaRoja = new Articulo("Manzana Roja", rutaDeImagenManzanaRoja,
                precioPorKGManzanaRoja, densidadDeManzanaRoja, calificadorManzanaRoja);

        manzanaRoja.agregarEnvase(obtenerEnvase("Bolsa Mediana"));
        manzanaRoja.agregarEnvase(obtenerEnvase("Bolsa Grande"));

        sistemaEcoShop.registrarArticulo(manzanaRoja);
    }

    private void cargarBanana() {
        double densidadDeBanana = 1382;
        double precioPorKGBanana = 109;
        String rutaDeImagenBanana = "interfazGrafica/imagenes/banana.jpg";
        String calificadorBanana = "Fruta";

        IArticulo banana = new Articulo("Banana", rutaDeImagenBanana,
                precioPorKGBanana, densidadDeBanana, calificadorBanana);

        banana.agregarEnvase(obtenerEnvase("Bolsa Mediana"));
        banana.agregarEnvase(obtenerEnvase("Bolsa Grande"));

        sistemaEcoShop.registrarArticulo(banana);
    }

    private void cargarKiwi() {
        double densidadDeKiwi = 1;
        double precioPorKGKiwi = 1;
        String rutaDeImagenKiwi = "interfazGrafica/imagenes/kiwi.jpg";
        String calificadorKiwi = "Fruta";

        IArticulo kiwi = new Articulo("Kiwi", rutaDeImagenKiwi,
                precioPorKGKiwi, densidadDeKiwi, calificadorKiwi);

        kiwi.agregarEnvase(obtenerEnvase("Bolsa Mediana"));
        kiwi.agregarEnvase(obtenerEnvase("Bolsa Grande"));
        kiwi.agregarEnvase(obtenerEnvase("Tupper Mediano"));

        sistemaEcoShop.registrarArticulo(kiwi);
    }

    private void cargarCastanas() {
        double densidadDeCastanas = 1;
        double precioPorKGCastanas = 1;
        String rutaDeImagenCastanas = "interfazGrafica/imagenes/castanas.jpg";
        String calificadorCastanas = "Fruto Seco";

        IArticulo castana = new Articulo("Castañas de Cajú", rutaDeImagenCastanas,
                precioPorKGCastanas, densidadDeCastanas, calificadorCastanas);

        castana.agregarEnvase(obtenerEnvase("Bolsa Mediana"));
        castana.agregarEnvase(obtenerEnvase("Bolsa Grande"));
        castana.agregarEnvase(obtenerEnvase("Tupper Chico"));
        castana.agregarEnvase(obtenerEnvase("Tupper Mediano"));

        sistemaEcoShop.registrarArticulo(castana);
    }

    private void cargarPistachos() {
        double densidadDePistachos = 1;
        double precioPorKGPistachos = 1;
        String rutaDeImagenPistachos = "interfazGrafica/imagenes/pistachos.jpg";
        String calificadorPistachos = "Fruto Seco";

        IArticulo pistacho = new Articulo("Pistachos", rutaDeImagenPistachos,
                precioPorKGPistachos, densidadDePistachos, calificadorPistachos);

        pistacho.agregarEnvase(obtenerEnvase("Bolsa Mediana"));
        pistacho.agregarEnvase(obtenerEnvase("Bolsa Grande"));
        pistacho.agregarEnvase(obtenerEnvase("Tupper Chico"));
        pistacho.agregarEnvase(obtenerEnvase("Tupper Mediano"));

        sistemaEcoShop.registrarArticulo(pistacho);
    }

    private void cargarAlmendras() {
        double densidadDeAlmendras = 1;
        double precioPorKGAlmendras = 1;
        String rutaDeImagenAlmendras = "interfazGrafica/imagenes/almendras.jpg";
        String calificadorAlmendras = "Fruto Seco";

        IArticulo almendra = new Articulo("Almendras", rutaDeImagenAlmendras,
                precioPorKGAlmendras, densidadDeAlmendras, calificadorAlmendras);

        almendra.agregarEnvase(obtenerEnvase("Bolsa Mediana"));
        almendra.agregarEnvase(obtenerEnvase("Bolsa Grande"));
        almendra.agregarEnvase(obtenerEnvase("Tupper Chico"));
        almendra.agregarEnvase(obtenerEnvase("Tupper Mediano"));

        sistemaEcoShop.registrarArticulo(almendra);
    }

    private void cargarNueces() {
        double densidadDeNueces = 1;
        double precioPorKGNueces = 1;
        String rutaDeImagenNueces = "interfazGrafica/imagenes/nueces.jpg";
        String calificadorNueces = "Fruto Seco";

        IArticulo nuez = new Articulo("Nueces", rutaDeImagenNueces,
                precioPorKGNueces, densidadDeNueces, calificadorNueces);

        nuez.agregarEnvase(obtenerEnvase("Bolsa Mediana"));
        nuez.agregarEnvase(obtenerEnvase("Bolsa Grande"));
        nuez.agregarEnvase(obtenerEnvase("Tupper Chico"));
        nuez.agregarEnvase(obtenerEnvase("Tupper Mediano"));

        sistemaEcoShop.registrarArticulo(nuez);
    }

    private void cargarEsparragos() {
        double densidadDeEsparragos = 1;
        double precioPorKGEsparragos = 1;
        String rutaDeImagenEsparragos = "interfazGrafica/imagenes/esparragos.jpg";
        String calificadorEsparragos = "Verdura";

        IArticulo esparrago = new Articulo("Esparragos", rutaDeImagenEsparragos,
                precioPorKGEsparragos, densidadDeEsparragos, calificadorEsparragos);

        esparrago.agregarEnvase(obtenerEnvase("Bolsa Mediana"));
        esparrago.agregarEnvase(obtenerEnvase("Bolsa Grande"));
        esparrago.agregarEnvase(obtenerEnvase("Tupper Mediano"));

        sistemaEcoShop.registrarArticulo(esparrago);
    }

    private void cargarZanahoria() {
        double densidadDeZanahoria = 1;
        double precioPorKGZanahoria = 1;
        String rutaDeImagenZanahoria = "interfazGrafica/imagenes/zanahoria.jpg";
        String calificadorZanahoria = "Verdura";

        IArticulo zanahoria = new Articulo("Zanahoria", rutaDeImagenZanahoria,
                precioPorKGZanahoria, densidadDeZanahoria, calificadorZanahoria);

        zanahoria.agregarEnvase(obtenerEnvase("Bolsa Mediana"));
        zanahoria.agregarEnvase(obtenerEnvase("Bolsa Grande"));

        sistemaEcoShop.registrarArticulo(zanahoria);
    }

    private void cargarGengibre() {
        double densidadDeNueces = 1;
        double precioPorKGNueces = 1;
        String rutaDeImagenNueces = "interfazGrafica/imagenes/gengibre.jpg";
        String calificadorNueces = "Verdura";

        IArticulo nuez = new Articulo("Gengibre", rutaDeImagenNueces,
                precioPorKGNueces, densidadDeNueces, calificadorNueces);

        nuez.agregarEnvase(obtenerEnvase("Bolsa Mediana"));
        nuez.agregarEnvase(obtenerEnvase("Bolsa Grande"));
        nuez.agregarEnvase(obtenerEnvase("Tupper Mediano"));

        sistemaEcoShop.registrarArticulo(nuez);
    }

    private void cargarApio() {
        double densidadDeNueces = 1;
        double precioPorKGNueces = 1;
        String rutaDeImagenNueces = "interfazGrafica/imagenes/apio.jpg";
        String calificadorNueces = "Verdura";

        IArticulo nuez = new Articulo("Apio", rutaDeImagenNueces,
                precioPorKGNueces, densidadDeNueces, calificadorNueces);

        nuez.agregarEnvase(obtenerEnvase("Bolsa Mediana"));
        nuez.agregarEnvase(obtenerEnvase("Bolsa Grande"));

        sistemaEcoShop.registrarArticulo(nuez);
    }

    /**
     *
     * @param envaseABuscar
     * @return
     */
    private IEnvase obtenerEnvase(String envaseABuscar) {
        ArrayList<IEnvase> envasesSistema = sistemaEcoShop.obtenerListaEnvases();
        IEnvase envaseSoloNombre = new Envase(envaseABuscar, -1, -1, -1, "");

        for (int i = 0; i < envasesSistema.size(); i++) {
            IEnvase envaseTmp = envasesSistema.get(i);

            if (envaseTmp.sonIguales(envaseSoloNombre)) {
                return envaseTmp;
            }
        }

        //Si no encontro se cae el programa
        assert (false);
        return null;
    }

}
