package com.bd;

import com.model.Usuario;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BancoDeDados {

  private BancoDeDados() {}

  private static final List<Usuario> usuarios = new ArrayList<>();

  public static List<Usuario> getTabelaUsuarios() {
    return usuarios;
  }
}
