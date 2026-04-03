package adapter;

//ANTES DE EJECUTAR COMPRAB QUE EXISTEN LSO FICHEROS F1 Y F2 EN EL FICHERO EJEMPLOS.JAVA
public class Main {

    public static void main(String[] args) throws Exception {

        SistemaLegacy legacy = new SistemaLegacy();
        Adapater adapater = new Adapater(legacy);

        String basePath = "bloque1/adapter/"; //Ajustamos la ruta para que el main fufe bien

        adapater.unirFicheros(basePath + "f1.txt", basePath + "f2.txt", basePath + "union.txt");

                    //{ini fin} pa mapear un fichero
        int[][] r1 = {{1,1}, {2,2}};
        int[][] r2 = {{1,1}, {2,2}};
        adapater.combinarParrafos(basePath + "f1.txt", basePath + "f2.txt", r1, r2, basePath + "combinado.txt");


        int[] cortes = {2, 4};
        String[] nombres = {basePath + "parte1.txt", basePath + "parte2.txt", basePath + "parte3.txt"};
        adapater.separarEnVarios(basePath + "f1.txt", cortes, nombres);

        System.out.println("Proceso completado.");
    }
}
