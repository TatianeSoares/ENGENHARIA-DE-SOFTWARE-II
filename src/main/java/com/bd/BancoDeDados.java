package com.bd;

import com.model.Sala;
import com.model.Usuario;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BancoDeDados {

  private BancoDeDados() {}

  private static final List<Usuario> usuarios = new ArrayList<>();
  private static final List<Sala> salas = new ArrayList<>();

  public static List<Usuario> getTabelaUsuarios() {
    return usuarios;
  }
  public static List<Sala> getTabelaSalas() {
    return salas;
  }
}
