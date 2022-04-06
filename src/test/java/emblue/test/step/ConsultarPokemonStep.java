package emblue.test.step;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.ArrayList;
import java.util.List;

import emblue.test.page.*;
import emblue.test.util.PageObjectUtil;
import junit.framework.Assert;

public class ConsultarPokemonStep {

	
	PaginaPrincipalPage paginaPrincipalPage = new PaginaPrincipalPage();

	public void seleccionarMostrarPokemon() {
		// TODO Auto-generated method stub
		paginaPrincipalPage.seleccionarVerDatosPokemon();
	}

	public String obtenerDatosPokemonCreado() {
		// TODO Auto-generated method stub
		
		return paginaPrincipalPage.obtenerDatosCreados();
		
	}
	
	
	public String obtenerListaPokemonCreado(int numLista) {
		// TODO Auto-generated method stub
		
		return paginaPrincipalPage.obtenerDatosListaPokemon(numLista);
		
	}
	
	

	  


  
}