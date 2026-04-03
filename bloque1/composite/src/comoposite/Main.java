import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int nhoras = random.nextInt(24);
        System.out.println("Numero horas expendedora 1: " + nhoras);
        Aparatoelectrico expendedora1 = new Aparatoelectrico(nhoras, 150);

        nhoras = random.nextInt(24);
        System.out.println("Numero horas expendedora 2: " + nhoras);
        Aparatoelectrico expendedora2 = new Aparatoelectrico(nhoras, 150);

        nhoras = random.nextInt(24);
        System.out.println("Numero horas expendedoracafe: " + nhoras);
        Aparatoelectrico expendedoracafe = new Aparatoelectrico(nhoras, 150);

        nhoras = random.nextInt(24);
        System.out.println("Numero horas ordendor: " + nhoras);
        Aparatoelectrico ordenador = new Aparatoelectrico(nhoras, 150);

        nhoras = random.nextInt(24);
        System.out.println("Numero horas servidor: " + nhoras);
        Aparatoelectrico servidor = new Aparatoelectrico(nhoras, 150);

        ListaPorHabi ramonycajal = new ListaPorHabi();
        ramonycajal.adherir(ordenador);
        ramonycajal.adherir(servidor);

        ListaPorHabi aulario = new ListaPorHabi();
        aulario.adherir(expendedora1);
        aulario.adherir(expendedora2);
        aulario.adherir(expendedoracafe);

        ListaPorHabi rabanales = new ListaPorHabi();
        rabanales.adherir(ramonycajal);
        rabanales.adherir(aulario);
        rabanales.adherir(expendedora1);

        System.out.println("Consumo Total Estimado del Campus Principal: " + rabanales.getConsumoGlobal() + " W");
        System.out.println("Coste de todo: " + rabanales.getCoste());
    }
}
