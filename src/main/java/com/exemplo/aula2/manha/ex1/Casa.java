package com.exemplo.aula2.manha.ex1;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Casa {
    private String nome;
    private String endereco;
    private List<Comodo> comodos;
}
