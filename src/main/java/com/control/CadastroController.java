package com.control;

import com.client.UsuarioClient;
import com.exception.BusinessException;
import com.model.Usuario;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.util.Messages;

@Named
@ViewScoped
public class CadastroController implements Serializable {
  @Inject private SessaoController sessaoController;
  @Inject private UsuarioClient usuarioClient;
  @Getter @Setter private Usuario usuario;
  @Getter @Setter private String senhaRepetida;

  @PostConstruct
  public void init() {
    usuario = new Usuario();
  }

  public void cadastrarUsuario() {
    try {
      usuarioClient.cadastrarUsuario(this.usuario, this.senhaRepetida);
      sessaoController.login(usuario);
      FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    } catch (BusinessException | IOException e) {
      Messages.addGlobalError(e.getLocalizedMessage());
    }
  }
}
