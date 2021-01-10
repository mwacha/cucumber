package tk.mwacha.steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class AprenderCucumberSteps {

    @Given("que criei o arquivo corretamente")
    public void queCrieiOArquivoCorretamente() {

    }

    @When("executá-lo")
    public void executaLo() {

    }
    @Then("a especificação de finalizar com sucesso")
    public void aEspecificacaoDeFinalizarComSucesso() {

    }

    private int contador = 0;
    @Given("que o valor do contador e {int}")
    public void queOValorDoContadorE(Integer int1) {
        contador = int1;
    }


    @When("eu incrementar em {int}")
    public void euIncrementarEm(Integer int1) {
        contador += int1;
    }
    @Then("o valor do contador sera {int}")
    public void oValorDoContadorSera(Integer int1) {
        Assert.assertEquals(java.util.Optional.ofNullable(int1), java.util.Optional.ofNullable(contador));
    }

    LocalDate localDate = LocalDate.now();

    @Given("que a entrega e (.*)$")
    public void que_a_entrega_e(LocalDate date) {
        localDate = date;
        System.out.println(localDate);
    }

  //  @ParameterType("dia|dias|mês|meses")
    @When("a entrega atrasar em {int} {word}")
    public void a_entrega_atrasar_em_dias(Integer int1, String tempo) {
        switch (tempo){
            case "meses":
                localDate =  localDate.plusMonths(int1);
                break;
            case "dias":
                localDate =  localDate.plusDays(int1);
                break;
        }
    }

    @Then("a entrega sera efetuada em {int}\\/{int}\\/{int}")
    public void a_entrega_sera_efetuada_em(Integer day, Integer month, Integer year) {
        LocalDate deliveryDate =  LocalDate.of(year, month, day);
        System.out.println(deliveryDate);
        Assert.assertEquals(localDate,deliveryDate);
    }

    @Given("^que o ticket( especial)? e A.(\\d{3})$")
    public void que_o_ticket_e_af(String tipo, String int1) {

    }

    @Given("que o valor da passagem e R$ {double}")
    public void que_o_valor_da_passagem_e_r$(Double double1) {

    }

    @Given("que o nome do passageiro e \"(.{5,20})\"$")
    public void que_o_nome_do_passageiro_e(String string) {

    }

    @Given("que o telefone do passageiro e (9\\d{3}-\\d{4})$")
    public void que_o_telefone_do_passageiro_e(String telefone) {

    }

    @When("criar os steps")
    public void criar_os_steps() {

    }

    @Then("o teste vai funcionar")
    public void o_teste_vai_funcionar() {
       
    }

}
