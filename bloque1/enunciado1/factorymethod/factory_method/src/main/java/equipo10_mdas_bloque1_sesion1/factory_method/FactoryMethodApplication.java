package equipo10_mdas_bloque1_sesion1.factory_method;

import equipo10_mdas_bloque1_sesion1.factory_method.factories.Factoria;
import equipo10_mdas_bloque1_sesion1.factory_method.factories.FactoriaLlevar;
import equipo10_mdas_bloque1_sesion1.factory_method.factories.FactoriaRestaurante;
import equipo10_mdas_bloque1_sesion1.factory_method.menus.Menu;

public class FactoryMethodApplication {

	public static void main(String[] args) {
		demo();
	}

	private static void demo() {
		Factoria factoriaRestaurante = new FactoriaRestaurante();
		Factoria factoriaLlevar      = new FactoriaLlevar();

		System.out.println("========== RESTAURANTE ==========");
		imprimirMenu("MenuSemanal",   factoriaRestaurante.crearMenuSemanal(TipoAcompanamiento.ENSALADA));
		imprimirMenu("MenuTemporada", factoriaRestaurante.crearMenuTemporada(TipoAcompanamiento.PATATAS));

		System.out.println("\n=========== PARA LLEVAR ==========");
		imprimirMenu("MenuSemanal",   factoriaLlevar.crearMenuSemanal(TipoAcompanamiento.ENSALADA));
		imprimirMenu("MenuTemporada", factoriaLlevar.crearMenuTemporada(TipoAcompanamiento.PATATAS));
	}

	private static void imprimirMenu(String tipoMenu, Menu menu) {
		System.out.println("\n-- " + tipoMenu + " --");
		for (Plato p : menu.getPlatos()) {
			System.out.printf("  %-20s | %-10s | %-25s | %.2f €%n",
				p.getNombre(),
				p.getTipo(),
				p.getAcompanamiento(),
				p.getPrecio());
		}
		System.out.printf("  TOTAL: %.2f €%n", menu.CalcularPrecio());
	}

}
