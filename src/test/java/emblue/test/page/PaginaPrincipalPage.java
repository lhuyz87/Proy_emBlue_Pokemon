package emblue.test.page;


import java.util.concurrent.TimeUnit;

import emblue.test.util.PageObjectUtil;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import emblue.test.xpath.PaginaPrincipalXpath;

@DefaultUrl("https://emblue-qa-challenge.vercel.app/")
public class PaginaPrincipalPage extends PageObject {
	
	protected PageObjectUtil pageObjectUtil = PageObjectUtil.getInstancia();
	
	PaginaPrincipalXpath paginaPrincipalXpath= new PaginaPrincipalXpath();
	
	
	public void ingresarCentroPokemon() {
		
		open();
//		getDriver().get("https://emblue-qa-challenge.vercel.app");
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
//		pageObjectUtil.sleep(10);

	
	}
	
	public void seleccionarCrearPokemon() {
		System.out.println( paginaPrincipalXpath.btnCrearPokemon);
		pageObjectUtil.seleniumClick(getDriver(), paginaPrincipalXpath.btnCrearPokemon,0);

	}
	
	public void ingresarId(String idPokemon) {
		pageObjectUtil.seleniumClick(getDriver(), paginaPrincipalXpath.txtIdPokemon,0);
		pageObjectUtil.seleniumEscribir(getDriver(), paginaPrincipalXpath.txtIdPokemon, idPokemon);
	}
	
	public void ingresarNombrePokemon(String nomPokemon) {
		pageObjectUtil.seleniumClick(getDriver(),  paginaPrincipalXpath.txtNomPokemon,0);
		pageObjectUtil.seleniumEscribir(getDriver(), paginaPrincipalXpath.txtNomPokemon, nomPokemon);
	}
	
	public void ingresarColorPokemon(String colorPokemon) {
		pageObjectUtil.seleniumClick(getDriver(),  paginaPrincipalXpath.txtColorPokemon,0);
		pageObjectUtil.seleniumEscribir(getDriver(), paginaPrincipalXpath.txtColorPokemon, colorPokemon);
	}
	
	public void ingresarLevelPokemon(String levelPokemon) {
		pageObjectUtil.seleniumClick(getDriver(),  paginaPrincipalXpath.txtlevelPokemon,0);
		pageObjectUtil.seleniumEscribir(getDriver(), paginaPrincipalXpath.txtlevelPokemon, levelPokemon);
	}
	
	
	public void seleccionarConfCrearPokemon() {
		pageObjectUtil.seleniumClick(getDriver(), paginaPrincipalXpath.btnConfirmarCrearPokemon,0);
		getDriver().switchTo().alert().accept();
//		pageObjectUtil.sleep(5);
	}

	public void seleccionarVerDatosPokemon() {
		pageObjectUtil.seleniumClick(getDriver(), paginaPrincipalXpath.btnMostrarPokemon,0);
		pageObjectUtil.sleep(3);
	}

	public String obtenerDatosCreados() {

		String fila =pageObjectUtil.obtenerTexto(getDriver(), paginaPrincipalXpath.lblFila);
		
		String [] detalle = fila.split("\\|");
		
		String idMostrado=detalle[0].trim().substring(4,detalle[0].length()-1);
		String nombreMostrado=detalle[1].trim().substring(6,detalle[1].length()-2);
		String colorMostrado=detalle[2].trim().substring(7,detalle[2].length()-2);
		String levelMostrado=detalle[3].trim().substring(7,detalle[3].length()-1);
//		for(int i=0; i<detalle.length;i++) {
//			System.out.println(detalle[i]);
//		}
		
		System.out.println("" +idMostrado +"-"+nombreMostrado+"-"+colorMostrado+"-"+levelMostrado);
		return idMostrado+"-"+nombreMostrado+"-"+colorMostrado+"-"+levelMostrado;
	}
	
	public String obtenerDatosListaPokemon(int numList) {

		String fila =pageObjectUtil.obtenerTexto(getDriver(), paginaPrincipalXpath.detalleLista(numList));
		
		String [] detalle = fila.split("\\|");
		
		String idMostrado=detalle[0].trim().substring(4,detalle[0].length()-1);
		String nombreMostrado=detalle[1].trim().substring(6,detalle[1].length()-2);
		String colorMostrado=detalle[2].trim().substring(7,detalle[2].length()-2);
		String levelMostrado=detalle[3].trim().substring(7,detalle[3].length()-1);
//		for(int i=0; i<detalle.length;i++) {
//			System.out.println(detalle[i]);
//		}
		
		System.out.println("" +idMostrado +"-"+nombreMostrado+"-"+colorMostrado+"-"+levelMostrado);
		return idMostrado+"-"+nombreMostrado+"-"+colorMostrado+"-"+levelMostrado;
	}

	

}
