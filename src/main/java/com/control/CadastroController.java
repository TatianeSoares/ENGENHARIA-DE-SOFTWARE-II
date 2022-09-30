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
    private String senhaRepetida;

    public String getSenhaRepetida() {
        return senhaRepetida;
    }

    public void setSenhaRepetida(String senhaRepetida) {
        this.senhaRepetida = senhaRepetida;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public void cadastrarUsuario() throws Exception {
        UsuarioBusiness usuarioBusiness = new UsuarioBusiness();

        if(usuarioBusiness.cadastrarUsuario(this.usuario, this.senhaRepetida)){
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }
    }

    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

}
