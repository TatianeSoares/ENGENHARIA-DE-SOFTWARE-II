package com.client;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.business.SalaBusiness;
import com.exception.BusinessException;
import com.model.Sala;
import com.dao.SalaDAO;
import java.util.List;

@ApplicationScoped
public class SalaClient {
  @Inject private SalaBusiness salaBusiness;
  @Inject private SalaDAO salaDAO;

  public void salvarSala(Sala sala) throws BusinessException {
    salaBusiness.salvarSala(sala);
  }

  public void excluirSala(String identificador) {
    salaBusiness.excluirSala(identificador);

  }

  public List<Sala> buscaSalas(){
    return salaDAO.buscarSalas();
  }
}
