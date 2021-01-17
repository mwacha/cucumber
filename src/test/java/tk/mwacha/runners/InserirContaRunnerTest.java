package tk.mwacha.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/report-html/report.html", "json:target/report.json"},
        tags = "not @ignore",
        monochrome = true, snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = true,
        features = "src/test/resources/features/inserir_conta.feature",
        glue = "tk.mwacha.steps")
public class InserirContaRunnerTest {

    @BeforeClass
    public static void reset(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://srbarriga.herokuapp.com/");
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("senha")).sendKeys("123");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }
}
