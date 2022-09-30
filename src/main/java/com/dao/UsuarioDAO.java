package com.dao;

import com.bd.BancoDeDados;
import com.model.Usuario;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioDAO {

  public void inserir(Usuario usuario) {
    List<Usuario> usuarios = BancoDeDados.getTabelaUsuarios();
    usuarios.add(usuario);
  }

  public Usuario buscarPorLogin(String login) {
    List<Usuario> usuarios = BancoDeDados.getTabelaUsuarios();
    if (usuarios == null) {
      return null;
    }
    for (Usuario temp : usuarios) {
      if (temp.getLogin().equals(login)) {
        return temp;
      }
    }
    return null;
  }
}
