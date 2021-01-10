package tk.mwacha.entities;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Filme {
    private int estoque;
    private double aluguel;

}
