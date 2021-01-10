package tk.mwacha.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoAluguel {
    EXTENDIDO("EXTENDIDO"),
    COMUM("COMUM"),
    SEMANAL("SEMANAL");

    private final String value;

}
