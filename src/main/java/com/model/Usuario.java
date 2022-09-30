package com.model;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
  @NotEmpty(message = "A matrícula/chapa deve ser preenchida")
  private String matricula;

  @NotEmpty(message = "O nome deve ser preenchido")
  private String nome;

  @NotEmpty(message = "O email deve ser preenchido")
  private String login;

  @NotEmpty(message = "A senha deve ser preenchida")
  private String senha;
}
