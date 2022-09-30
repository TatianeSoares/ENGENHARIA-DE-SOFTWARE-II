package com.client;

import com.business.UsuarioBusiness;
import com.exception.BusinessException;
import com.model.Usuario;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UsuarioClient implements Serializable {
  @Inject private UsuarioBusiness usuarioBusiness;

  public void cadastrarUsuario(Usuario usuario, String senhaRepetida) throws BusinessException {
    usuarioBusiness.cadastrarUsuario(usuario, senhaRepetida);
  }

  public void verificarCadastro(Usuario usuario) throws BusinessException {
    usuarioBusiness.verificarCadastro(usuario);
  }
}
