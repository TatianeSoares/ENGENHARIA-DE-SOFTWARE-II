package com.dao;

import com.bd.BancoDeDados;
import com.model.Sala;

import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class SalaDAO {

    public void inserir(Sala sala) {
        List<Sala> salas = BancoDeDados.getTabelaSalas();
        salas.add(sala);
    }

    public void atualizar(Sala sala) {
        List<Sala> salas = BancoDeDados.getTabelaSalas();
        Sala salaExistente = salas.stream().filter(s -> s.getIdentificador().equals(sala.getIdentificador())).collect(
            Collectors.toList()).get(0);
        salaExistente.setCapacidade(sala.getCapacidade());
        salaExistente.setDepartamento(sala.getDepartamento());
        salaExistente.setTipo(sala.getTipo());
        salaExistente.setInfoAdicional(sala.getInfoAdicional());
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

    public List<Sala> buscarSalas(){
        return BancoDeDados.getTabelaSalas();
    }
}
