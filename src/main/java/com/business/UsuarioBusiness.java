package com.business;

import com.dao.UsuarioDAO;
import com.model.Usuario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UsuarioBusiness {
    public boolean cadastrarUsuario(Usuario usuario) throws Exception {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuarioExistente = dao.buscarPorLogin(usuario.getLogin());
        if(usuarioExistente != null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario ja cadastrado"));
            return false;
        }

        return dao.inserir(usuario);
    }
}
