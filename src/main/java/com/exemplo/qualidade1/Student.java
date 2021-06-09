package com.exemplo.qualidade1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @NotNull(message = "O nome é obrigatório")
    @Size(min = 8, max = 50, message = "O nome deve ter entre 8 e 50 caracteres")
    @Pattern(regexp = "^[a-z]+$", message = "O nome só pode conter letras")
    private String name;
    @NotEmpty(message = "A lista de matérias não pode ser vazia")
    @Valid
    private List<Subject> subjects;
}
