package tk.mwacha.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import tk.mwacha.entities.Filme;
import tk.mwacha.entities.NotalAluguel;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
public class AluguelService {
    public NotalAluguel alugar(Filme filme){
        if(filme.getEstoque() == 0)
            throw new RuntimeException("Filme sem estoque");

        filme.setEstoque(filme.getEstoque() - 1);

        return NotalAluguel.builder()
                .preço(filme.getAluguel())
                .dataEntrega(LocalDate.now().plusDays(1))
                .build();
    }
}
