package com.control;

import com.business.UsuarioBusiness;
import com.dao.UsuarioDAO;
import com.model.Usuario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.Serializable;

@Named
@ViewScoped
public class CadastroController implements Serializable {
    private Usuario usuario;

    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public void cadastrarUsuario() throws Exception {
        UsuarioBusiness usuarioBusiness = new UsuarioBusiness();
        usuarioBusiness.cadastrarUsuario(this.usuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario cadastrado com sucesso"));
    }

    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

}
