package emblue.test.step;

import emblue.test.page.PaginaPrincipalPage;

public class IngresarSistemaStep {
	
	
	PaginaPrincipalPage paginaPrincipalPage = new PaginaPrincipalPage(); 
	
	
	
	public void ingresarSistema(){
		
		paginaPrincipalPage.ingresarCentroPokemon();
	}

}
