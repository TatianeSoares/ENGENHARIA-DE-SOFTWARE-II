package com.control;

import java.io.Serializable;
import javax.annotation.PostConstruct;
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
public class SalaController implements Serializable {
  @Inject private SalaClient salaClient;
  @Getter @Setter private Sala sala;

  @PostConstruct
  public void init(){
    sala = new Sala();
  }

  public void salvarSala() {
    try{
      salaClient.salvarSala(this.sala);
    } catch (BusinessException e) {
      Messages.addGlobalError(e.getLocalizedMessage());
    }
  }

  public void atualizarSala() {
      salaClient.atualizarSala(this.sala);
  }

  public void excluirSala(String identificador) {
    salaClient.excluirSala(identificador);
  }
}
