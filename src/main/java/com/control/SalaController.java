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
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class SalaController implements Serializable {
  @Inject private SalaClient salaClient;
  @Getter @Setter private Sala sala;
  @Getter @Setter private List<Sala> todasSalas;
  @Getter @Setter private boolean novaSala;

  @PostConstruct
  public void init(){

    sala = new Sala();
    buscaTodasSalas();
  }

  public void salvarSala() {
    try{
      if (novaSala) {
        salaClient.salvarSala(this.sala);
        buscaTodasSalas();
        Messages.addGlobalInfo("Sala criada com sucesso!");
      }
      else {
        salaClient.atualizarSala(this.sala);
        Messages.addGlobalInfo("Sala atualizada com sucesso!");
      }
    } catch (BusinessException e) {
      Messages.addGlobalError(e.getLocalizedMessage());
    }
    sala = new Sala();
  }

  public void buscaTodasSalas() {
    todasSalas = salaClient.buscaSalas();
  }

  public void excluirSala(String identificador) {
    salaClient.excluirSala(identificador);
    buscaTodasSalas();
    Messages.addGlobalInfo("Sala excluída com sucesso!");
  }

  public void escolherSala(Sala s) {
    if (s == null) {
      sala = new Sala();
      novaSala = true;
    }
    else {
      sala = s;
      novaSala = false;
    }
  }
}
