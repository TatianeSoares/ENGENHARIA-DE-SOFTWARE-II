package com.control;

import com.model.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Getter;

@Named
@SessionScoped
public class SessaoController implements Serializable {
  @Getter private Usuario usuarioLogado;

  public void login(Usuario usuario) {
    this.usuarioLogado = usuario;
  }

  public void logout() throws IOException {
    this.usuarioLogado = null;
    FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
  }
}
