package com.control;

import com.dao.UsuarioDAO;
import com.model.Usuario;

import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginController implements Serializable {
    Usuario usuario;
    Usuario usuarioBuscado;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public void buscarPorLogin(){
        UsuarioDAO dao = new UsuarioDAO();
        this.usuarioBuscado = dao.buscarPorLogin(this.usuario.getLogin());
        if(this.usuarioBuscado != null && this.usuarioBuscado.getSenha().equals(this.usuario.getSenha())){ // login existe e senha correta
            //  redirecionar para tela de login

        }
    }

    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
}
