package emblue.test.runner;

import cucumber.api.CucumberOptions;
import java.io.IOException;
import org.junit.runner.RunWith;
import com.ibm.icu.impl.InvalidFormatException;


@RunWith(RunPersonalizar.class)



@CucumberOptions(features = { "src/test/resources/features/" }, tags = { "@IdRepetido" }, glue = { "emblue.test.definition" })





public class Runner {
	@RunBefore
    public static void previo() throws IOException, InvalidFormatException {
        System.out.println("ENTRA AL PREVIO");

    }
}

