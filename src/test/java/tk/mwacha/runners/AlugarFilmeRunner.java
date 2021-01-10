package tk.mwacha.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty",
monochrome = true, snippets = CucumberOptions.SnippetType.CAMELCASE,
features = "src/test/resources/features/alugar_filme.feature",
glue = "tk.mwacha.steps")
public class AlugarFilmeRunner {
}
