package tk.mwacha.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tk.mwacha.entities.Filme;
import tk.mwacha.entities.NotalAluguel;
import tk.mwacha.enums.TipoAluguel;
import tk.mwacha.service.AluguelService;

import java.time.LocalDate;
import java.util.Map;

public class AlugarFilmesSteps {

    private Filme filme;
    private AluguelService service;
    private NotalAluguel nota;
    private String erro;
    private TipoAluguel tipoAluguel = TipoAluguel.COMUM;

    @Given("um filme com estoque de {int} unidades")
    public void umFilmeComEstoqueDeUnidades(Integer unidades) {
        filme = Filme.builder().estoque(unidades).build();
    }


    @Given("que o preço do aluguel seja R$ {double}")
    public void queOPrecoDoAluguelSeja(Double val) {
        filme.setAluguel(val);
    }

    @Given("um filme")
    public void umFilme(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        filme = Filme.builder()
                .estoque(Integer.parseInt(map.get("estoque")))
                .aluguel(Double.parseDouble(map.get("preco"))).build();
    }


    @When("alugar")
    public void alugar() throws Throwable {
        try {
            service = AluguelService.builder().build();
            nota = service.alugar(filme, tipoAluguel);
        } catch (RuntimeException e) {
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
        Assert.assertEquals("Filme sem estoque", erro);
    }

    @Given("que o tipo do aluguel seja extendido")
    public void queOTipoDoAluguelSejaExtendido() {
        tipoAluguel = TipoAluguel.EXTENDIDO;
    }

    @Then("a data de entrega será em {int} dias")
    public void aDataDeEntregaSeraEmDias(Integer int1) {
        LocalDate dataEsperada = LocalDate.now().plusDays(int1);
        LocalDate dataEntrega = nota.getDataEntrega();

        Assert.assertEquals(dataEsperada, dataEntrega);
    }

    @Then("a pontuação será de {int} pontos")
    public void aPontuacaoSeraDePontos(Integer ponto) {
        Assert.assertEquals(java.util.Optional.ofNullable(ponto), java.util.Optional.ofNullable(nota.getPontuacao()));
    }

    @Given("que o tipo do aluguel seja comum")
    public void queOTipoDoAluguelSejaComum() {
        tipoAluguel = TipoAluguel.COMUM;
    }

    @Given("que o tipo do aluguel seja semanal")
    public void queOTipoDoAluguelSejaSemanal() {
        tipoAluguel = TipoAluguel.SEMANAL;
    }
}
