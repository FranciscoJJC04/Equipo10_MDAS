public class Ejemplos {
    public static void crearEjemplos() throws Exception {

        SistemaLegacy legacy = new SistemaLegacy();

        //Correr solo una vez
        legacy.anadirTexto("f1.txt", "Linea 1 F1");
        legacy.anadirTexto("f1.txt", "Linea 2 F1");
        legacy.anadirTexto("f1.txt", "Linea 3 F1");
        legacy.anadirTexto("f2.txt", "Linea 1 F2");
        legacy.anadirTexto("f2.txt", "Linea 2 F2");
        legacy.anadirTexto("f2.txt", "Linea 3 F2");

        System.out.println("Ejemplos creados");
    }
}
