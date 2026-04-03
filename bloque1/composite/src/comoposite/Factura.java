package comoposite;

import java.util.Random;

public class Factura {
    //Aquí tendremos el main para calcular el consum de los cachcarros
    //PARA LOS NUMROS ALEATORIOS: https://medium.com/@generativeai.saif/java-random-number-generator-5-methods-explained-with-examples-bf9e53abed3c
    public static void mostrarFactura() {
        Random random=new Random();
        int nhoras=random.nextInt(24);
        System.out.println("Numero horas expendedora 1: "+ nhoras);
        Aparatoelectrico expendedora1 = new Aparatoelectrico("Expendedora 1", nhoras, 150);

        nhoras=random.nextInt(24);
        System.out.println("Numero horas expendedora 2: "+ nhoras);
        Aparatoelectrico expendedora2 = new Aparatoelectrico("Expendedora 2", nhoras, 150);

        nhoras=random.nextInt(24);
        System.out.println("Numero horas expendedoracafe: "+ nhoras);
        Aparatoelectrico expendedoracafe = new Aparatoelectrico("Expendedora Cafe", nhoras, 150);

        nhoras=random.nextInt(24);   
        System.out.println("Numero horas ordendor: "+ nhoras);
        Aparatoelectrico ordenador = new Aparatoelectrico("Ordenador", nhoras, 150);

        nhoras=random.nextInt(24);
        System.out.println("Numero horas servidor: "+ nhoras);
        Aparatoelectrico servidor = new Aparatoelectrico("Servidor", nhoras, 150);

        ListaPorHabi ramonycajal=new ListaPorHabi("Ramon y Cajal");
        ramonycajal.adherir(ordenador);
        ramonycajal.adherir(servidor);
        ListaPorHabi aulario=new ListaPorHabi("Aulario");
        aulario.adherir(expendedora1);
        aulario.adherir(expendedora2);
        aulario.adherir(expendedoracafe);
        ListaPorHabi rabanales=new ListaPorHabi("Campus Rabanales");
        rabanales.adherir(ramonycajal);
        rabanales.adherir(aulario);
        rabanales.adherir(expendedora1);
        System.out.println("Consumo Total Estimado del Campus Principal: "+ rabanales.getConsumoGlobal()+" kWh");
        System.out.println("Coste de todo: "+ rabanales.getCoste()+" EUR");
    }
}
