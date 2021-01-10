Feature: Aprender Cucumber
  Como um aluno
  Eu quero aprender a utilizar  Cucumber
  Para que eu possa automatizar critérios de aceitação

  Scenario: Deve executar especificação
    Given que criei o arquivo corretamente
    When executá-lo
    Then a especificação de finalizar com sucesso

  Scenario: Deve incrementar contador
    Given que o valor do contador e 15
    When eu incrementar em 3
    Then o valor do contador sera 18

  Scenario: Deve calcuar atraso na entrega
    Given que a entrega e 05/04/2018
    When a entrega atrasar em 2 dias
    Then a entrega sera efetuada em 07/04/2018

  Scenario: Deve calcuar atraso na entrega
    Given que a entrega e 05/04/2018
    When a entrega atrasar em 2 meses
    Then a entrega sera efetuada em 05/06/2018

  Scenario: Deve criar steps genéricos para estes passos
    Given que o ticket e AF345
    Given que o valor da passagem e R$ 230.45
    Given que o nome do passageiro e "Fulano da Silva"
    Given que o telefone do passageiro e 9999-9999
    When criar os steps
    Then o teste vai funcionar

  Scenario: Deve reaproveitar os steps "Dado" do cenário anterior
    Given que o ticket e AB167
    Given que o ticket especial e AB167
    Given que o valor da passagem e R$ 1120.23
    Given que o nome do passageiro e "Cicrano de Oliveira"
    Given que o telefone do passageiro e 9888-8888

  Scenario: Deve negar todos os steps "Dado" dos cenários anteriores
    Given que o ticket é CD123
    Given que o ticket é AG1234
    Given que o valor da passagem é R$ 1.1345,56
    Given que o nome do passageiro é "Beltrano Souza Matos de Alcântara Azevedo"
    Given que o telefone do passageiro é 1234-5678
    Given que o telefone do passageiro é 999-2223