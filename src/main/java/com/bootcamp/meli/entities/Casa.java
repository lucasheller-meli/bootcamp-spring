package com.bootcamp.meli.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Casa {

    private String nome;
    private String endereco;
    private List<Comodos> comodos;


}
