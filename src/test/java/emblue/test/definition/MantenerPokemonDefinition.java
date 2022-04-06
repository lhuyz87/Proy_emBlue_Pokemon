package emblue.test.definition;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import emblue.test.step.IngresarSistemaStep;
import emblue.test.step.CrearPokemonStep;
import emblue.test.step.ConsultarPokemonStep;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import emblue.test.util.CucumberNewUtil;
import emblue.test.util.ReporteSerenityUtil;

public class MantenerPokemonDefinition {
	
	@Steps
	private IngresarSistemaStep ingresarSistemaStep;
	@Steps
	private CrearPokemonStep crearPokemonStep;
	@Steps
	private ConsultarPokemonStep consultarPokemonStep;
	
	@Steps
	private ReporteSerenityUtil reporteSerenityUtil;
	
	public static String idAux="";
	public static String nombreAux="";
	public static String colorAux="";
	public static String levelAux="";
	public static List<String> listaId = new ArrayList<String>();
	public static List<String> listaNombre = new ArrayList<String>();
	public static List<String> listaColor = new ArrayList<String>();
	public static List<String> listaLevel = new ArrayList<String>();
	@Given("^ingreso al sistema corporación capsula$")
	public void ingreso_al_sistema_corporación_capsula() {
	    // Write code here that turns the phrase above into concrete actions
		ingresarSistemaStep.ingresarSistema();
		Serenity.takeScreenshot();
	}

	@When("^selecciono opción 'crear nuevo pokemón'$")
	public void selecciono_opción_crear_nuevo_pokemón() {
	    // Write code here that turns the phrase above into concrete actions
		crearPokemonStep.seleccionarIngresoPokemon();
		Serenity.takeScreenshot();
	}

	@When("^ingreso la información del pókemon: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" y \"([^\"]*)\"$")
	public void ingreso_la_información_del_pókemon_y(String id, String nombre, String color, String level) {
	    // Write code here that turns the phrase above into concrete actions
		idAux=id;
		nombreAux=nombre;
		colorAux=color;
		levelAux=level;
		Serenity.takeScreenshot();
		crearPokemonStep.ingresarDatosPokemon(id, nombre, color, level);
		Serenity.takeScreenshot();
	}

	@When("^grabo los valores$")
	public void grabo_los_valor() {
	    // Write code here that turns the phrase above into concrete actions
		crearPokemonStep.grabarDatosPokemon();
		Serenity.takeScreenshot();
	}

	@When("^selecciono opción 'ver todos los pokemón'$")
	public void selecciono_opción_ver_todos_los_pokemón() {
		consultarPokemonStep.seleccionarMostrarPokemon();
		Serenity.takeScreenshot();
	}

	@Then("^se muestra el pokemón creado$")
	public void se_muestra_el_pokemón_creador() {
		String datosMostrados= consultarPokemonStep.obtenerDatosPokemonCreado();
		Serenity.takeScreenshot();
		String detDatosMostrados[] = datosMostrados.split("-");
		System.out.println(idAux+"------------"+detDatosMostrados[0]);
		
		assertEquals(idAux, detDatosMostrados[0]);
		assertEquals(nombreAux, detDatosMostrados[1]);
		assertEquals(colorAux, detDatosMostrados[2]);
		assertEquals(levelAux, detDatosMostrados[3]);
		reporteSerenityUtil.showStepMessage("Se muestra id " + idAux);
		reporteSerenityUtil.showStepMessage("Se muestra nombre " + nombreAux);
		reporteSerenityUtil.showStepMessage("Se muestra color " + colorAux);
		reporteSerenityUtil.showStepMessage("Se muestra level " + levelAux);
	}
	
	
	@When("^registro la información de los pokemons:$")
	public void registro_la_información_de_los_pokemons(DataTable table) {

		 CucumberNewUtil.ConvertDataTableToDict(table);
	        List<List<String>> data = table.raw();

	        for (int i = 1; i < data.size(); i++) {
	        	String idPokemon = CucumberNewUtil.GetCellValueWithRowIndex("id_pokemon", i);
	        	listaId.add(idPokemon);
	            String nombrePokemon = CucumberNewUtil.GetCellValueWithRowIndex("nombre_pokemon", i);
	            listaNombre.add(nombrePokemon);
	            String colorPokemon = CucumberNewUtil.GetCellValueWithRowIndex("color_pokemon", i);
	            listaColor.add(colorPokemon);
	            String levelPokemon = CucumberNewUtil.GetCellValueWithRowIndex("nivel_pokemon", i);
	            listaLevel.add(levelPokemon);
	            crearPokemonStep.ingresarDatosPokemon(idPokemon, nombrePokemon, colorPokemon, levelPokemon);
	            Serenity.takeScreenshot();
	            crearPokemonStep.grabarDatosPokemon();
	        }
	}
	
	@Then("^se muestra la lista de los pokemones creados correctamente$")
	public void se_muestra_lista_pokemones_creados() {
		Serenity.takeScreenshot();
		System.out.println("------------"+listaColor.size());
		for(int i=0; i<listaColor.size();i++) {
			System.out.println(listaId.get(i));
			String datosMostrados= consultarPokemonStep.obtenerListaPokemonCreado(i+3);
			String detDatosMostrados[] = datosMostrados.split("-");
			System.out.println(listaId.get(i)+"------------"+detDatosMostrados[0]);
			
			assertEquals(listaId.get(i), detDatosMostrados[0]);
			assertEquals(listaNombre.get(i), detDatosMostrados[1]);
			assertEquals(listaColor.get(i), detDatosMostrados[2]);
			assertEquals(listaLevel.get(i), detDatosMostrados[3]);
			reporteSerenityUtil.showStepMessage("Se muestra id " + detDatosMostrados[0]);
			reporteSerenityUtil.showStepMessage("Se muestra nombre " + detDatosMostrados[1]);
			reporteSerenityUtil.showStepMessage("Se muestra color " + detDatosMostrados[2]);
			reporteSerenityUtil.showStepMessage("Se muestra level " + detDatosMostrados[3]);
		}
		
	}
	
	@Then("^se debe mostrar mensaje de error$")
	public void mostrar_mensaje_de_eror() {
		
	}
	
	
	
	@Then("^no se debe mostrar el id repetido$")
	public void no_mostrar_id_repetido() {
		String datosMostrados= consultarPokemonStep.obtenerDatosPokemonCreado();
		Serenity.takeScreenshot();
		String detDatosMostrados[] = datosMostrados.split("-");
		System.out.println(idAux+"------------"+detDatosMostrados[0]);
		
		assertNotEquals("1", detDatosMostrados[0]);
		reporteSerenityUtil.showStepMessage("Se muestra id " + detDatosMostrados[0]);

	}

}
