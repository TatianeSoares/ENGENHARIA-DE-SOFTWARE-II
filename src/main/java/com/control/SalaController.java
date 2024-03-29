package com.control;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.client.SalaClient;
import com.exception.BusinessException;
import com.model.Sala;

import org.omnifaces.util.Messages;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class SalaController {
  @Inject private SalaClient salaClient;
  @Getter @Setter private Sala sala;

  @PostConstruct
  public void init(){
    sala = new Sala();
  }

  public void salvarSala() {
    try{
      salaClient.salvarSala(this.sala);
      FacesContext.getCurrentInstance().getExternalContext().redirect("gerenciamentoSala.xhtml");
    } catch (BusinessException | IOException e) {
      Messages.addGlobalError(e.getLocalizedMessage());
    }
  }

  public void excluirSala(String identificador) {
    salaClient.excluirSala(identificador);
  }
}
