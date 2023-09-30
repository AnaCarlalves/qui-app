package br.com.ifsp.quiapp.controller;

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

    @DeleteMapping("/api/quiapp/jogada/deletar/{idUsuario}/{numJogada}")
    public String deletarJogada(@PathVariable int idUsuario,@PathVariable int numJogada){

        Usuario usuario = UsuarioDAO.getInstance().findById(idUsuario);

        Boolean resposta = usuario.deletarJogada(numJogada);

        if( resposta == true){
        return "------------ jogada excluida ------------\nnúmero da jogada: "+numJogada+"\nnumero de acertos: "+usuario.getJogadasDoUsuario().get(numJogada).getNumAcertosJogada()+"\nnúmero de erros: "+usuario.getJogadasDoUsuario().get(numJogada).getNumErroJogada();
        
        }else{
             return "------------ jogada não existe ------------";
        }
    }    
}