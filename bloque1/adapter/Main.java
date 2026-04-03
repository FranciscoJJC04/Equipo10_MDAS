//ANTES DE EJECUTAR COMPRAB QUE EXISTEN LSO FICHEROS F1 Y F2 EN EL FICHERO EJEMPLOS.JAVA
public class Main {

    public static void main(String[] args) throws Exception {

        SistemaLegacy legacy = new SistemaLegacy();
        Adapater adapater = new Adapater(legacy);

        adapater.unirFicheros("f1.txt", "f2.txt", "union.txt");

                    //{ini fin} pa mapear un fichero
        int[][] r1 = {{1,1}, {2,2}};
        int[][] r2 = {{1,1}, {2,2}};
        adapater.combinarParrafos("f1.txt", "f2.txt", r1, r2, "combinado.txt");


        int[] cortes = {2, 4};
        String[] nombres = {"parte1.txt", "parte2.txt", "parte3.txt"};
        adapater.separarEnVarios("f1.txt", cortes, nombres);

        System.out.println("Proceso completado.");
    }
}
