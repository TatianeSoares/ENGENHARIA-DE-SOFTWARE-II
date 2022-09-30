package com.business;

import com.dao.UsuarioDAO;
import com.model.Usuario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UsuarioBusiness {
    public boolean cadastrarUsuario(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuarioExistente = dao.buscarPorLogin(usuario.getLogin());
        if(usuarioExistente != null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario ja cadastrado"));
            return false;
        }
        // verificar se o email tem @uel.br
        boolean loginCorreto = usuario.getLogin().endsWith("@uel.br");
        if(loginCorreto){
            return dao.inserir(usuario);
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O email deve terminar em @uel.br"));
        return false;
    }
}
