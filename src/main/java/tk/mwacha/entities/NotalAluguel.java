package tk.mwacha.entities;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotalAluguel {

    private double preço;
    private LocalDate dataEntrega;
}
