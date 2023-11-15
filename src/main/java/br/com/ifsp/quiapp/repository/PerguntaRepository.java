package br.com.ifsp.quiapp.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import br.com.ifsp.quiapp.model.Pergunta;

public interface PerguntaRepository extends CrudRepository<Pergunta, Long> {

}