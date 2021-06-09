package com.exemplo.qualidade1.manha;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class Subject {
    @NotNull(message = "O nome é obrigatório")
    @Size(min = 8, max = 50, message = "O nome deve ter entre 8 e 50 caracteres")
    @Pattern(regexp = "^[a-z]+$", message = "O nome só pode conter letras")
    private String name;
    @NotNull(message = "A nota é obrigatória")
    @DecimalMax("10")
    @DecimalMin("0")
    private Integer grade;
}
