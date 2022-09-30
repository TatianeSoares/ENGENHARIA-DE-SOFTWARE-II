package com.business;

import com.dao.UsuarioDAO;
import com.model.Usuario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UsuarioBusiness {
    public boolean cadastrarUsuario(Usuario usuario, String senhaRepetida) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuarioExistente = dao.buscarPorLogin(usuario.getLogin());
        if(usuarioExistente != null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario ja cadastrado"));
            return false;
        }
        // verificar se o email tem @uel.br
        boolean loginCorreto = usuario.getLogin().endsWith("@uel.br");
        if(!loginCorreto){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O email deve terminar em @uel.br"));
            return false;
        }

        boolean senhasIguais = usuario.getSenha().equals(senhaRepetida);
        if(!senhasIguais){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Campo de senha nao corresponde"));
            return false;
        }

        return dao.inserir(usuario);
    }
}
