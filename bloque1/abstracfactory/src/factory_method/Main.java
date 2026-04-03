package factory_method;

import factory_method.factories.Factoria;
import factory_method.factories.FactoriaLlevar;
import factory_method.factories.FactoriaRestaurante;
import factory_method.menus.Menu;

public class Main {

	public static void main(String[] args) {
		Factoria factoriaRestaurante = new FactoriaRestaurante();
		Factoria factoriaLlevar      = new FactoriaLlevar();

        Menu menuRestaurante = factoriaRestaurante.crearMenuSemanal(TipoAcompanamiento.ENSALADA);
        Menu menuLlevar      = factoriaLlevar.crearMenuTemporada(TipoAcompanamiento.PATATAS);
		System.out.println("MENU REST");
		menuRestaurante.getPlatos();
		System.out.println("MENU LLEVAR");
		menuLlevar.getPlatos();

	}



}
