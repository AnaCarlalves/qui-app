package br.com.ifsp.quiapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsp.quiapp.model.Pergunta;
import br.com.ifsp.quiapp.repository.PerguntaRepository;

@RestController
@CrossOrigin
public class PerguntaController {

    @Autowired
    PerguntaRepository perguntaRepository;
    
    //Incerir Perguntas no BDD
    @PostMapping("/app/quiapp/perguntas/inserir")
    public List<Pergunta> incerirPerguntaLista(@RequestBody List<Pergunta> perguntasInceridas) {
        return (List<Pergunta>)perguntaRepository.saveAll(perguntasInceridas);
    }

    // Imprime na tela todas as Pergutas do BDD
    // mudar esse caminh depois
    @GetMapping("/app/quiapp/recupera/recuperaTabela")
    public Iterable<Pergunta> imprimirPergintas() {
        return perguntaRepository.findAll();
    }

    // Imprime na tela de acordo com o codigo a Perguta do BDD
    @GetMapping("/app/quiapp/pergunta/{codigo}")
    public Optional<Pergunta> impriPerguntaComCodigo(@PathVariable("codigo") long codigoPergunta) {
        return perguntaRepository.findById(codigoPergunta);
    }

    // Deleta a Pergunda do BDD
    @DeleteMapping("/app/quiapp/pergunta/deletarPergunta/{codigo}")
    public void deletePerguntaComCodigo(@PathVariable("codigo") long codigoDeletar) {
        perguntaRepository.deleteById(codigoDeletar);
    }
}
