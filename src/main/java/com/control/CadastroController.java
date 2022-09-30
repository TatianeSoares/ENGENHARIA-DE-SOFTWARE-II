package com.control;

import com.business.UsuarioBusiness;
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
  @Inject private UsuarioBusiness usuarioBusiness;
  @Getter @Setter private Usuario usuario;
  @Getter @Setter private String senhaRepetida;

  @PostConstruct
  public void init() {
    usuario = new Usuario();
  }

  public void cadastrarUsuario() {
    try{
    usuarioBusiness.cadastrarUsuario(this.usuario, this.senhaRepetida);
    FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    catch (BusinessException | IOException e){
      Messages.addGlobalError(e.getLocalizedMessage());
    }
  }
}
