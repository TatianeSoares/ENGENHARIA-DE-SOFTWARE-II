package com.control;

import com.client.UsuarioClient;
import com.exception.BusinessException;
import com.model.Usuario;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import java.io.IOException;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;

@Named
@SessionScoped
public class LoginController implements Serializable {
  @Inject SessaoController sessaoController;
  @Inject UsuarioClient usuarioClient;
  @Getter @Setter Usuario usuario;

  @PostConstruct
  public void init() {
    usuario = new Usuario();
  }

  public void verificarCadastro() {
    try {
      usuarioClient.verificarCadastro(usuario);
      sessaoController.login(usuario);
      FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    } catch (BusinessException | IOException e) {
      Messages.addGlobalError(e.getLocalizedMessage());
    }
  }
}
