package br.com.ifsp.quiapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsp.quiapp.Tabela;
import br.com.ifsp.quiapp.model.Perguntas;

public class PerguntaVestibularController {
    @GetMapping("/api/quiapp/recupera/recuperaTabela")
    public List<Perguntas> listaPerguntas(){
        return Tabela.recuperaDadoPerguntas();
    }
}
