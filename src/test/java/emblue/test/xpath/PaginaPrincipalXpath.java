package emblue.test.xpath;

public class PaginaPrincipalXpath {
	
	
	
	public final String btnCrearPokemon="//button[contains(text(),'Create new pokemon')]";
	public final String btnMostrarPokemon="//button[contains(text(),'Show all pokemons')]";
	
	//Crear nuevo pokemón
	
	public final String txtIdPokemon="//input[@id='idInput']";
	public final String txtNomPokemon="//input[@id='nameInput']";
	public final String txtColorPokemon="//input[@id='colorInput']";
	public final String txtlevelPokemon="//input[@id='levelInput']";
	public final String btnConfirmarCrearPokemon="//button[contains(text(),'Create new Pokemon')]";
	
	
	//Mostrar Pokemon
	
	public final String lblIdPokemon="//div[@class='card-body']/following :: b[5]//following :: text()[2]";
	public final String lblNomPokemon="//div[@class='card-body']/following :: b[5]//following :: text()[6]";
	public final String lblColorPokemon="//div[@class='card-body']/following :: b[5]//following :: text()[10]";
	public final String lblLevelPokemon="//div[@class='card-body']/following :: b[5]//following :: text()[14]";
	public final String lblFila="//div[@class='card'][3]";
	
	public String detalleLista(int numLista) {
		
			final String xpathLista="//div[@class='card']["+numLista+"]";
		
		return xpathLista;
		
	}
}
