Feature: Alugar Filme
  Como um uauário
  Eu quero cadastrar aluguéis de filmes
  Para controlar preços e datas de entrega

  Scenario: Deve alugar um filme com sucesso
    Given um filme
       | estoque | 2 |
       | preco   | 3 |
    When alugar
    Then o preço do aluguel será R$ 3
    And a data de entrega será no dia seguinte
    And o estoque do filme será 1 unidade

  Scenario: não deve alugar filme sem estoque
    Given um filme com estoque de 0 unidades
    When alugar
    Then não será possível por falta de estoque
    And o estoque do filme será 0 unidade

  Scenario Outline: Deve dar condições tipo de aluguel
    Given um filme com estoque de 2 unidades
    And que o preço do aluguel seja R$ <preco>
    And que o tipo do aluguel seja <tipo>
    When alugar
    Then o preço do aluguel será R$ <valor>
    And a data de entrega será em <qtdDias> dias
    And a pontuação será de <pontuacao> pontos
    Examples:
      | preco | tipo      | valor | qtdDias | pontuacao |
      |  4    | extendido |  8    | 3       |   2       |
      |  4    | comum     |  4    | 1       |   1       |
      |  10   | extendido |  20   | 3       |   2       |
      |  5    | semanal   |  15   | 7       |   3       |




