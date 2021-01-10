Feature: Alugar Filme
  Como um uauário
  Eu quero cadastrar aluguéis de filmes
  Para controlar preços e datas de entrega

  Scenario: Deve alugar um filme com sucesso
    Given um filme com estoque de 2 unidades
    And que o preço do aluguel seja R$ 3
    When alugar
    Then o preço do aluguel será R$ 3
    And a data de entrega será no dia seguinte
    And o estoque do filme será 1 unidade

  Scenario: não deve alugar filme sem estoque
    Given um filme com estoque de 0 unidades
    When alugar
    Then não será possível por falta de estoque
    And o estoque do filme será 0 unidade

