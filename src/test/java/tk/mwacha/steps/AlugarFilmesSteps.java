package tk.mwacha.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tk.mwacha.entities.Filme;
import tk.mwacha.entities.NotalAluguel;
import tk.mwacha.service.AluguelService;

import java.time.LocalDate;

public class AlugarFilmesSteps {

    private Filme filme;
    private AluguelService service;
    private NotalAluguel nota;
    private String erro;

    @Given("um filme com estoque de {int} unidades")
    public void umFilmeComEstoqueDeUnidades(Integer unidades) {
       filme = Filme.builder().estoque(unidades).build();
    }

    @Given("que o preço do aluguel seja R$ {double}")
    public void queOPrecoDoAluguelSeja(Double val) {
      filme.setAluguel(val);
    }
    @When("alugar")
    public void alugar() throws Throwable {
        try {
            service = AluguelService.builder().build();
            nota = service.alugar(filme);
        } catch (RuntimeException e){
            erro = e.getMessage();
        }
    }
    @Then("o preço do aluguel será R$ {double}")
    public void oPrecoDoAluguelSera(Double val) {
       Assert.assertEquals(java.util.Optional.ofNullable(val), java.util.Optional.ofNullable(nota.getPreço()));
    }
    @Then("a data de entrega será no dia seguinte")
    public void aDataDeEntregaSeraNoDiaSeguinte() {
        LocalDate data = LocalDate.now().plusDays(1);

        LocalDate retorno = nota.getDataEntrega();

        Assert.assertEquals(data.getDayOfMonth(), retorno.getDayOfMonth());
        Assert.assertEquals(data.getMonth(), retorno.getMonth());
        Assert.assertEquals(data.getYear(), retorno.getYear());
    }
    @Then("o estoque do filme será {int} unidade")
    public void oEstoqueDoFilmeSeraUnidade(Integer unidade) {
        Assert.assertEquals(java.util.Optional.ofNullable(unidade), java.util.Optional.ofNullable(filme.getEstoque()));
    }

    @Then("não será possível por falta de estoque")
    public void naoSeraPossivelPorFaltaDeEstoque() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
