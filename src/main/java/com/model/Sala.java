package com.model;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sala implements Serializable {
  @NotEmpty(message = "A identificação da sala deve ser preenchida")
  private String identificador;

  @NotEmpty(message = "O tipo de sala deve ser preenchido")
  private String tipo;

  @NotNull(message = "A capacidade deve ser preenchida")
  private Integer capacidade;

  @NotEmpty(message = "O departamento deve ser preenchido")
  private String departamento;

  private String infoAdicional;

  public Integer getCapacidade() {
    return capacidade;
  }

  public void setCapacidade(Integer capacidade) {
    this.capacidade = capacidade;
  }
}
