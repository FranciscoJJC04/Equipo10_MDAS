package adapter;

import java.io.FileWriter;

public class Adapater implements  Adaptador{
    
    private SistemaLegacy legacy;

    public Adapater(SistemaLegacy legacy) {
        this.legacy = legacy;
    }

    // 1) Unir dos ficheros
    @Override
    public void unirFicheros(String f1, String f2, String destino) throws Exception {

        String contenido1 = legacy.extraerParrafo(f1, 1, Integer.MAX_VALUE);
        String contenido2 = legacy.extraerParrafo(f2, 1, Integer.MAX_VALUE);

        FileWriter fw = new FileWriter(destino);
        fw.write(contenido1);
        fw.write(contenido2);
        fw.close();
    }

    // 2) Combinar párrafos alternando
    @Override
    public void combinarParrafos(String f1, String f2, int[][] rangosF1, int[][] rangosF2, String destino) throws Exception {

        FileWriter fw = new FileWriter(destino);
        int max = Math.max(rangosF1.length, rangosF2.length);

        for (int i = 0; i < max; i++) {
            if (i < rangosF1.length) {
                String p1 = legacy.extraerParrafo(f1, rangosF1[i][0], rangosF1[i][1]);
                fw.write(p1);
            }

            if (i < rangosF2.length) {
                String p2 = legacy.extraerParrafo(f2, rangosF2[i][0], rangosF2[i][1]);
                fw.write(p2);
            }
        }

        fw.close();
    }

    // 3) Separar en varios ficheros
    @Override
    public void separarEnVarios(String fichero, int[] puntosCorte, String[] nombresSalida) throws Exception {
        int inicio = 1;

        for (int i = 0; i < puntosCorte.length && i < nombresSalida.length; i++) {
            int fin = puntosCorte[i] - 1;
            try (FileWriter fw = new FileWriter(nombresSalida[i])) {
                if (fin >= inicio) {
                    fw.write(legacy.extraerParrafo(fichero, inicio, fin));
                }
            }
            inicio = puntosCorte[i];
        }

        if (nombresSalida.length > puntosCorte.length) {
            try (FileWriter fw = new FileWriter(nombresSalida[nombresSalida.length - 1])) {
                fw.write(legacy.extraerParrafo(fichero, inicio, Integer.MAX_VALUE));
            }
        }
    }
}
