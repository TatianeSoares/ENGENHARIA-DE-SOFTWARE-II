package com.dao;

import com.bd.BancoDeDados;
import com.model.Usuario;
import java.util.List;


public class UsuarioDAO {

    public boolean inserir(Usuario usuario) {
        List<Usuario> usuarios = BancoDeDados.getTabelaUsuarios();
        usuarios.add(usuario);
        return true;
    }

    public Usuario buscarPorLogin(String login) {
        List<Usuario> usuarios = BancoDeDados.getTabelaUsuarios();
        if(usuarios == null){
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

