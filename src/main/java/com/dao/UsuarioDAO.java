package com.dao;

import com.model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class UsuarioDAO {
    private static long id = 0;

    public File buscarBd(){
        return new File("src/main/usuario.bd");
    }

    public boolean inserir(Usuario usuario) {
        try{
            File bd = this.buscarBd();
            FileWriter fr = new FileWriter(bd, true);
            usuario.setId(id);
            id++;
            fr.write(usuario.getId() + "\t" + usuario.getMatricula() + "\t" + usuario.getLogin()+ "\t" +
                    usuario.getSenha()+ "\t" + usuario.getNome() + "\n");
            fr.close();
            return true;
        } catch (IOException ignored) {

        }
        return false;
    }
    public Usuario buscarPorLogin(String login) {
        ArrayList<Usuario> usuarios = this.lerBanco();
        for(Usuario temp: usuarios){
            if(temp.getLogin().equals(login)){
                return temp;
            }
        }

        return null;
    }

    private ArrayList<Usuario> lerBanco() {
        try {
            File bd = this.buscarBd();
            BufferedReader bfReader = new BufferedReader(new FileReader(bd));
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            Usuario temp;
            String linha;
            String[] array;
            while(true){
                linha = bfReader.readLine();
                if (linha == null){
                    break;
                }
                array = linha.split(Pattern.quote("\t"));
                temp = new Usuario(Long.valueOf(array[0]), array[1], array[2], array[3], array[4]);
                usuarios.add(temp);
            }
            return usuarios;
        } catch (IOException ignored){
        }
        return new ArrayList<>();
    }
}
