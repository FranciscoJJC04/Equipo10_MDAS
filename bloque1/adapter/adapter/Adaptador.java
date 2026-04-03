package adapter;

public interface  Adaptador {

    void unirFicheros(String f1, String f2, String destino) throws Exception;

    void combinarParrafos(String f1, String f2, int[][] rangosF1,int[][] rangosF2,String destino) throws Exception;

    void separarEnVarios(String fichero, int[] puntosCorte, String[] nombresSalida) throws Exception;
}

