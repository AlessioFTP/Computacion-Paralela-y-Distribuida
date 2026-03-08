package org.paralela.distribuida.computacion.dataset;

public enum Producto {
    AGUACATE_HASS("Aguacate Hass"),
    CURUBA("Curuba"),
    PAPA_CRIOLLA("Papa criolla"),
    PAPA_PASTUSA("Papa pastusa"),
    PLATANO_MADURO("Plátano maduro"),
    PLATANO_VERDE("Plátano verde"),
    CEBOLLA_REDONDA("Cebolla redonda"),
    TOMATE_DE_ARBOL("Tomate de árbol"),
    LECHE_ENTERA_BOLSA("Leche entera bolsa"),
    LECHE_ENTERA_CAJA("Leche entera caja"),
    QUESO_CAMPESINO("Queso campesino"),
    YOGUR_DE_FRESA("Yogur de fresa"),
    HUEVOS_AA("Huevos AA x30"),
    HUEVOS_AAA("Huevos AAA x30"),
    MANTEQUILLA_CON_SAL("Mantequilla con sal"),
    ARROZ_ROA("Arroz Roa"),
    ARROZ_DIANA("Arroz Diana"),
    CAFE_SELLO_ROJO("Café Sello Rojo"),
    CAFE_JUAN_VALDEZ("Café Juan Valdez"),
    PANELA_CUADRADA("Panela cuadrada"),
    ACEITE_VEGETAL("Aceite vegetal"),
    ACEITE_GIRASOL("Aceite girasol"),
    FRIJOL_BOLA_ROJA("Frijol bola roja"),
    LENTEJAS("Lentejas"),
    ALMOJABANAS("Almojábanas"),
    PAN("Pan"),
    PAN_TAJADO("Pan tajado"),
    MOGOLLA_INTEGRAL("Mogolla integral"),
    CROISSANT("Croissant"),
    PONQUE_RAMO("Ponqué Ramo"),
    PECHUGA_DE_POLLO("Pechuga de pollo"),
    CARNE_DE_RES_PARA_ASAR("Carne de res para asar"),
    TOCINO_AHUMADO("Tocino ahumado"),
    CHORIZO_ANTIOQUENO("Chorizo antioqueño"),
    FILETE_DE_SALMON("Filete de salmón"),
    DETERGENTE_EN_POLVO("Detergente en polvo"),
    JABON_REY("Jabón Rey"),
    LIMPIAPISOS_LAVANDA("Limpiapisos lavanda"),
    PAPEL_HIGIENICO("Papel higiénico x12"),
    BLANQUEADOR("Blanqueador"),
    JABON_DE_MANOS("Jabón de manos"),
    CREMA_DENTAL("Crema dental"),
    DESODORANTE_MASCULINO("Desodorante masculino"),
    DESODORANTE_FEMENINO("Desodorante femenino"),
    PANITOS_HUMEDOS("Pañitos húmedos"),
    GASEOSA_POSTOBON("Gaseosa Postobón"),
    GASEOSA_COCA_COLA("Gaseosa Coca Cola"),
    GASEOSA_PEPSI("Gaseosa Pepsi"),
    JUGO_HIT_DE_CAJA("Jugo Hit de caja"),
    CERVEZA_CLUB_COLOMBIA("Cerveza Club Colombia"),
    CERVEZA_POKER("Cerveza Póker"),
    AGUA_BRISA("Agua Brisa"),
    AGUA_CRISTAL("Agua Cristal"),
    CONCENTRADO_PARA_PERRO("Concentrado para perro"),
    CONCENTRADO_PARA_GATO("Concentrado para gato"),
    ARENA_PARA_GATOS("Arena para gatos"),
    SNACKS_PARA_MASCOTAS("Snacks para mascotas");

    private final String nombre;

    Producto(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }
}