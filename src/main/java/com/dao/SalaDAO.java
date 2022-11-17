package com.dao;

import com.bd.BancoDeDados;
import com.model.Sala;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class SalaDAO {

    public void inserir(Sala sala) {
        List<Sala> salas = BancoDeDados.getTabelaSalas();
        salas.add(sala);
    }

    public void remove(Sala salaExistente) {
        List<Sala> salas = BancoDeDados.getTabelaSalas();
        salas.remove(salaExistente);
    }

    public Sala buscarPorIdentificador(String identificador) {
        List<Sala> salas = BancoDeDados.getTabelaSalas();
        if (salas == null) {
            return null;
        }
        for (Sala temp : salas) {
            if (temp.getIdentificador().equals(identificador)) {
                return temp;
            }
        }
        return null;
    }
}
