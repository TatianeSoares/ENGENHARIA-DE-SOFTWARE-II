package com.bd;

import com.model.Usuario;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class BancoDeDados {
    protected static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static ArrayList<Usuario> getTabelaUsuarios(){
        System.out.println(usuarios);
        return usuarios;
    }

}
