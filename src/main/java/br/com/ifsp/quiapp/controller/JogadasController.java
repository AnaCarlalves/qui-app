package br.com.ifsp.quiapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsp.quiapp.model.Jogadas;
import br.com.ifsp.quiapp.model.Usuario;
import br.com.ifsp.quiapp.model.UsuarioDAO;
import br.com.ifsp.quiapp.repository.JogadasRepository;
import br.com.ifsp.quiapp.repository.UsuarioRepository;

@RestController
@CrossOrigin
public class JogadasController {

    @Autowired
    JogadasRepository jogadasRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @DeleteMapping("/api/quiapp/jogada/deletar/{idJogada}")//não especifico mais qual o id do usuario, somente a posição da jogada na tabela de jogadas
    public String deletarJogada(@PathVariable Long idJogada){


    Optional<Jogadas> optionalJogada = jogadasRepository.findById(idJogada);

    if(optionalJogada.isPresent()){
    
    jogadasRepository.deleteById(idJogada);

    Optional<Usuario> optionalUsuario = usuarioRepository.findById(optionalJogada.get().getUsuario().getIdUsuarios());

    ArrayList<Jogadas> jogadasUsuario = new ArrayList<>();
    
    for(Jogadas jogada : jogadasRepository.findAll()){
        if (jogada.getUsuario().getIdUsuarios() == optionalUsuario.get().getIdUsuarios()){
            jogadasUsuario.add(jogada);
        }
    }
    optionalUsuario.get().setJogadasDoUsuario(jogadasUsuario);


    usuarioRepository.save(optionalUsuario.get());

    return "jogada deletada com sucesso";

    }
    
    else{
        return "jogada com o ID especificado não existe";
    }
}
}