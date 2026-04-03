package comoposite;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int nhoras = random.nextInt(24) + 1;
        Aparatoelectrico ordenador = new Aparatoelectrico("Ordenador", nhoras, 300);

        nhoras = random.nextInt(24) + 1;
        Aparatoelectrico servidor = new Aparatoelectrico("Servidor", nhoras, 500);

        nhoras = random.nextInt(24) + 1;
        Aparatoelectrico expendedora1 = new Aparatoelectrico("Expendedora 1", nhoras, 150);

        nhoras = random.nextInt(24) + 1;
        Aparatoelectrico expendedora2 = new Aparatoelectrico("Expendedora 2", nhoras, 150);

        nhoras = random.nextInt(24) + 1;
        Aparatoelectrico expendedoraCafe = new Aparatoelectrico("Expendedora Cafe", nhoras, 200);

        nhoras = random.nextInt(24) + 1;
        Aparatoelectrico iluminacion = new Aparatoelectrico("Sistema de Iluminacion", nhoras, 1000);

        ListaPorHabi salaInformatica = new ListaPorHabi("Sala Informatica (Ramon y Cajal)");
        salaInformatica.adherir(ordenador);
        salaInformatica.adherir(servidor);

        ListaPorHabi areaDescanso = new ListaPorHabi("Area de Descanso (Aulario)");
        areaDescanso.adherir(expendedora1);
        areaDescanso.adherir(expendedora2);
        areaDescanso.adherir(expendedoraCafe);

        ListaPorHabi edificioRamonCajal = new ListaPorHabi("Edificio Ramon y Cajal");
        edificioRamonCajal.adherir(salaInformatica);
        edificioRamonCajal.adherir(iluminacion);

        ListaPorHabi edificioAulario = new ListaPorHabi("Edificio Aulario");
        edificioAulario.adherir(areaDescanso);

        ListaPorHabi campusPrincipal = new ListaPorHabi("CAMPUS PRINCIPAL");
        campusPrincipal.adherir(edificioRamonCajal);
        campusPrincipal.adherir(edificioAulario);

        System.out.println("\n================================================================================");
        System.out.println(" DESGLOSE DE CONSUMO ENERGETICO DEL CAMPUS");
        System.out.println("================================================================================\n");

        campusPrincipal.mostrarDetalles("");

        System.out.println("\n================================================================================");
        System.out.println(" RESUMEN TOTAL");
        System.out.println("================================================================================");
        System.out.println(String.format("Consumo Total Estimado: %.2f kWh", campusPrincipal.getConsumoGlobal()));
        System.out.println(String.format("Coste Total Estimado: %.2f EUR", campusPrincipal.getCoste()));
        System.out.println("================================================================================\n");
    }
}
