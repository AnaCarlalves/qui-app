package br.com.ifsp.quiapp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsp.quiapp.model.Jogadas;
import br.com.ifsp.quiapp.model.Usuario;
import br.com.ifsp.quiapp.model.UsuarioDAO;

@RestController
public class JogadasController {

    @PostMapping("/api/quiapp/adicionarJogada/{id}")
    public boolean adicionarJogada(@RequestBody Jogadas jogadasDoUsuario, @PathVariable int id){
       Usuario usu  = UsuarioDAO.getInstance().findById(id);
       return usu.getJogadasDoUsuario().add(jogadasDoUsuario);

    }
    
}
