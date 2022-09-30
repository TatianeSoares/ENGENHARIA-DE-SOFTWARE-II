package com.dao;

import com.bd.BancoDeDados;
import com.model.Usuario;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class UsuarioDAO {

    public File buscarBd() {
        return new File("src/main/usuario.bd");
    }

    public boolean inserir(Usuario usuario) {
        ArrayList<Usuario> usuarios = BancoDeDados.getTabelaUsuarios();
        usuarios.add(usuario);
        return true;
    }

    public Usuario buscarPorLogin(String login) {
        ArrayList<Usuario> usuarios = BancoDeDados.getTabelaUsuarios();
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

