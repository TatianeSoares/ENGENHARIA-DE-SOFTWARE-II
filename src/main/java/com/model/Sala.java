package com.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sala implements Serializable {
    @NotEmpty(message = "O identificador de sala deve ser preenchido")
    private String identificador;

    @NotEmpty(message = "O tipo deve ser preenchido")
    private String tipo;

    @NotNull(message = "A capacidade deve ser preenchida")
    private int capacidade;

    @NotEmpty(message = "O departamento deve ser preenchido")
    private String departamento;

    private String infoAdicional;
}
