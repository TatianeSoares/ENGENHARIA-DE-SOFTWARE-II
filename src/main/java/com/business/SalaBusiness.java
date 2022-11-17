package com.business;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.dao.SalaDAO;
import com.exception.BusinessException;
import com.model.Sala;

@ApplicationScoped
public class SalaBusiness {
  @Inject private SalaDAO salaDAO;

  public void salvarSala(Sala sala) throws BusinessException {
    Sala salaExistente = salaDAO.buscarPorIdentificador(sala.getIdentificador());
    if(salaExistente != null){
      throw new BusinessException("Sala ja cadastrada");
    }

    salaDAO.inserir(sala);

  }

  public void excluirSala(String identificador) {
    Sala salaExistente = salaDAO.buscarPorIdentificador(identificador);
    salaDAO.remove(salaExistente);
  }
}
