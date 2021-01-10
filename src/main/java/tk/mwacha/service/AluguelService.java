package tk.mwacha.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import tk.mwacha.entities.Filme;
import tk.mwacha.entities.NotalAluguel;
import tk.mwacha.enums.TipoAluguel;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
public class AluguelService {
    public NotalAluguel alugar(Filme filme, TipoAluguel tipoAluguel){
        if(filme.getEstoque() == 0)
            throw new RuntimeException("Filme sem estoque");

        filme.setEstoque(filme.getEstoque() - 1);
        NotalAluguel nota =  NotalAluguel.builder().build();

        switch (tipoAluguel) {
            case EXTENDIDO:
                nota.setPreço(filme.getAluguel() * 2);
                nota.setDataEntrega(LocalDate.now().plusDays(3));
                nota.setPontuacao(2);
                break;
            case SEMANAL:
                nota.setPreço(filme.getAluguel() * 3);
                nota.setDataEntrega(LocalDate.now().plusDays(7));
                nota.setPontuacao(3);
                break;
            case COMUM:
                nota.setPreço(filme.getAluguel());
                nota.setDataEntrega(LocalDate.now().plusDays(1));
                nota.setPontuacao(1);
                break;
        }


        return nota;
    }
}
