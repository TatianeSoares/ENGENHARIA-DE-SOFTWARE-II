package com.control;

import com.business.UsuarioBusiness;
import com.model.Usuario;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.annotation.PostConstruct;
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
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }

    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

}
