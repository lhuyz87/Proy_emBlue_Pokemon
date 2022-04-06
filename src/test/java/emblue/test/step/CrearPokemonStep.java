package emblue.test.step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;
import emblue.test.page.PaginaPrincipalPage;
import emblue.test.page.*;
import emblue.test.util.PageObjectUtil;
import junit.framework.Assert;

public class CrearPokemonStep {

	
	PaginaPrincipalPage paginaPrincipalPage = new PaginaPrincipalPage();

	
	@Step
	public void seleccionarIngresoPokemon() {
		paginaPrincipalPage.seleccionarCrearPokemon();
	}
	
	
	@Step
	public void ingresarDatosPokemon(String id, String nombre, String color, String level) {
		paginaPrincipalPage.ingresarId(id);
		paginaPrincipalPage.ingresarNombrePokemon(nombre);
		paginaPrincipalPage.ingresarColorPokemon(color);
		paginaPrincipalPage.ingresarLevelPokemon(level);
//		paginaPrincipalPage.seleccionarConfCrearPokemon();
	}
	
	@Step
	public void grabarDatosPokemon() {
		paginaPrincipalPage.seleccionarConfCrearPokemon();
	}
	
	
	@Step
	public void verDatosPokemon() {
		paginaPrincipalPage.seleccionarVerDatosPokemon();
	}
	
	

    


  
}