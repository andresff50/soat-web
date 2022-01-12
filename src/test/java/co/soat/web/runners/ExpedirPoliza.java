package co.soat.web.runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/expedir_poliza.feature"},
        glue = {"co.soat.web"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ExpedirPoliza {
}
