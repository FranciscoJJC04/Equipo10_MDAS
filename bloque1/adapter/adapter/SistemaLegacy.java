package adapter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
//https://www.geeksforgeeks.org/system-design/adapter-design-pattern-in-java/
//https://www.geeksforgeeks.org/system-design/adapter-pattern/
public class SistemaLegacy {
    
    public void anadirTexto(String fichero, String texto) throws IOException {
        FileWriter fw = new FileWriter(fichero, true); //pa añadir sin borrar lo anterior
        fw.write(texto + "\n");
        fw.close();
    }

    public String extraerParrafo(String fichero, int inicio, int fin) throws IOException {
        List<String> lineas = Files.readAllLines(Paths.get(fichero));
        StringBuilder resultado = new StringBuilder();//pa mapear un fichero y luego escribirlo

        for (int i = inicio - 1; i < fin && i < lineas.size(); i++) {resultado.append(lineas.get(i)).append("\n");}
        return resultado.toString();
    }

    public void dividirFichero(String fichero, int lineaCorte,String fichero1, String fichero2) throws IOException {

        List<String> lineas = Files.readAllLines(Paths.get(fichero));

        FileWriter fw1 = new FileWriter(fichero1);
        FileWriter fw2 = new FileWriter(fichero2);

        for (int i = 0; i < lineas.size(); i++) {
            if(i < lineaCorte - 1){fw1.write(lineas.get(i) + "\n");}
            if(i>=lineaCorte-1){fw2.write(lineas.get(i) + "\n");}
        }

        fw1.close();
        fw2.close();
    }
}
