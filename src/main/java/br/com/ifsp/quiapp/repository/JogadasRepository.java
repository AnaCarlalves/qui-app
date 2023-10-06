package br.com.ifsp.quiapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.ifsp.quiapp.model.Jogadas;
import br.com.ifsp.quiapp.model.Usuario;

public interface JogadasRepository extends CrudRepository<Jogadas, Long> {

}
