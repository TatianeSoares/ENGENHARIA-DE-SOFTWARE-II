package com.control;

import com.dao.UsuarioDAO;
import com.model.Usuario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginController implements Serializable {
    @Inject SessaoController sessaoController;
    Usuario usuario;
    Usuario usuarioBuscado;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public void verificarCadastro() throws IOException {
        UsuarioDAO dao = new UsuarioDAO();
        this.usuarioBuscado = dao.buscarPorLogin(this.usuario.getLogin());
        if(this.usuarioBuscado == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario nao cadastrado"));
            return;
        }
        if (this.usuarioBuscado.getSenha().equals(this.usuario.getSenha())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Senha incorreta"));
            return;
        }

        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        sessaoController.login(usuario);
    }

    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
}
