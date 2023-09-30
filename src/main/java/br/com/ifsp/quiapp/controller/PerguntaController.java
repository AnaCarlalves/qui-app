package br.com.ifsp.quiapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsp.quiapp.model.Pergunta;
import br.com.ifsp.quiapp.model.PerguntaDAO;
import br.com.ifsp.quiapp.repository.PerguntaRepository;
import br.com.ifsp.quiapp.repository.UsuarioRepository;

@RestController
@CrossOrigin
public class PerguntaController {

    @Autowired
    PerguntaRepository PerguntaRepository;
    
    //Incerir Perguntas no BDD
    @PostMapping("/app/quiapp/perguntas/inserir")
    public List<Pergunta> incerirPerguntaLista(@RequestBody List<Pergunta> perguntasRecebe) {

        PerguntaDAO perguntaBancoDados = PerguntaDAO.getInstance();
        // Conecta com o DataBase de Perguntas
        boolean existente = false;
        // Um verdadeiro ou falso para saber se o codigo que tenta incerir ja existe

        for (Pergunta perguntaCont : perguntaBancoDados.findAll()) {
            // Roda um for para verificar as listas
            for (Pergunta pergunta : perguntasRecebe) {
                if (pergunta.getidPergunta() == perguntaCont.getidPergunta()) {
                    // Um IF para verificar se o código das perguntas já não existe no Banco de Dados
                    existente = true;
                    break;
                    // Na primeira verifição quebra a rodagem
                }
            }
        }
        if (existente == true) {
            // Se já existir não adicionará nenhuma das perguntas
            return null;
        } else {
            // Se não existir, adiciona toda a lista
            for (Pergunta perguntaList : perguntasRecebe) {
                perguntaBancoDados.create(perguntaList);
            }
            return null;
        }
    }

    // Imprime na tela todas as Pergutas do BDD
    @GetMapping("/app/quiapp/pergunta")
    public List<Pergunta> imprimirPergintas() {

        //Conecta com o DataBase de Perguntas
        PerguntaDAO perguntaBancoDados = PerguntaDAO.getInstance();
        // Imprime as perguntas
        return perguntaBancoDados.findAll();
    }

    // Imprime na tela de acordo com o codigo a Perguta do BDD
    @GetMapping("/app/quiapp/pergunta/{codigo}")
    public Pergunta impriPerguntaComCodigo(@PathVariable("codigo") long codigoPergunta) {

        PerguntaDAO perguntaBancoDados = PerguntaDAO.getInstance();
        // Conecta com o DataBase de Perguntas

        for (Pergunta perguntaCont : perguntaBancoDados.findAll()) {
            // Roda um FOR para verificar as listas
            if (perguntaCont.getidPergunta() == codigoPergunta) {
                // verifica se o codigo
                return perguntaCont;
                // Imprime a pergunta com o codigo pedido
            }
        }
        return null;
    }

    // Deleta a Pergunda do BDD
    @DeleteMapping("/app/quiapp/pergunta/deletarPergunta/{codigo}")
    public void deletePerguntaComCodigo(@PathVariable("codigo") long codigoRelato) {
        
        PerguntaDAO perguntaBancoDados = PerguntaDAO.getInstance();
        // Conecta com o DataBase de Perguntas

        for (Pergunta perguntaCont : perguntaBancoDados.findAll()) {
            // Roda um for para verificar as listas
            if (perguntaCont.getidPergunta() == codigoRelato) {
                // Se o codigo da pergunta existir no Banco, irá deletar do Banco de Dados
                perguntaBancoDados.delete(perguntaCont);
                break;
            }
        }
    }
}
