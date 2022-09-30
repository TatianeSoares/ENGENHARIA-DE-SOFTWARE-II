package com.business;

import com.dao.UsuarioDAO;
import com.exception.BusinessException;
import com.model.Usuario;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UsuarioBusiness implements Serializable {
  @Inject private UsuarioDAO usuarioDAO;

  public void cadastrarUsuario(Usuario usuario, String senhaRepetida) throws BusinessException {
    Usuario usuarioExistente = usuarioDAO.buscarPorLogin(usuario.getLogin());
    if (usuarioExistente != null) {
      throw new BusinessException("Usuário ja cadastrado");
    }
    boolean loginCorreto = usuario.getLogin().endsWith("@uel.br");
    if (!loginCorreto) {
      throw new BusinessException("O e-mail deve terminar em @uel.br");
    }
    if (!usuario.getSenha().equals(senhaRepetida)) {
      throw new BusinessException("Campos de senha diferentes");
    }
    usuarioDAO.inserir(usuario);
  }

  public void verificarCadastro(Usuario usuario) throws BusinessException {
    Usuario usuarioExistente = usuarioDAO.buscarPorLogin(usuario.getLogin());
    if (usuarioExistente == null) {
      throw new BusinessException("Usuário não cadastrado");
    }
    if (usuarioExistente.getSenha().equals(usuario.getSenha())) {
      throw new BusinessException("Senha incorreta");
    }
  }
}
