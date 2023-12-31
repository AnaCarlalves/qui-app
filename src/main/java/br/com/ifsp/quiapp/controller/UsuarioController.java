package br.com.ifsp.quiapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.protobuf.Internal.LongList;

import br.com.ifsp.quiapp.DatabaseUsuario;
import br.com.ifsp.quiapp.model.Jogadas;
import br.com.ifsp.quiapp.model.Usuario;
import br.com.ifsp.quiapp.model.UsuarioDAO;
import br.com.ifsp.quiapp.repository.JogadasRepository;
import br.com.ifsp.quiapp.repository.UsuarioRepository;

@RestController
@CrossOrigin
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    JogadasRepository jogadasRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    
    
    //botar um 'if' para verificar se é professor
    @PostMapping("/api/quiapp/cadastro/cadastroProfessor")
    public String addProfessor(@RequestBody Usuario novo){
        novo.setPassword(
            passwordEncoder.encode(novo.getPassword())
        );
        Usuario usuarioCriado = usuarioRepository.save(novo);

        if(usuarioCriado != null && usuarioCriado.getTipo().equals("professor"))
            return "professor criado com sucesso!";        
        
        return "Erro ao criar professor";
    }

    @DeleteMapping("/api/quiapp/delete/deleteCadastroUsuario")
    public ResponseEntity<String> delCadastroUsuario(@RequestBody Usuario usuario){
        DatabaseUsuario.removerUsuario(usuario);
        return ResponseEntity.ok("O Usuario foi deletado do sistema com sucesso");
    }

    @DeleteMapping("/api/quiapp/deletarHistorico/{id}")
    public  String deletarHistorico(@PathVariable long id){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.deletarHistorico();
            usuarioRepository.save(usuario); // Salva as alterações no usuário
            return ("O historico do usuário foi excluido com sucesso");
        } else {
            return ("O usuário com o ID especificado não foi encontrado");
        }
    }


    @GetMapping("/api/quiapp/listaDeAlunosCadastrados")
    public Iterable<Usuario> listaDeAlunosCadastrados(){

        return usuarioRepository.findAll();
    }

    @GetMapping("/api/quiapp/RecuperarUsuario/{id}")
    public Usuario recuperaUsuario(@PathVariable Long id){

        // Usuario usuario = UsuarioDAO.getInstance().findById(id);
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

        if(optionalUsuario.isPresent()){
        return optionalUsuario.get();
        }
        else{
            return null;
        }
    }

 @PostMapping("/api/quiapp/usuario/criar")
 public String criarUsuario(@RequestBody Usuario usuario){

    usuario.setPassword(
        passwordEncoder.encode(usuario.getPassword())
    );
    Usuario usuarioCriado = usuarioRepository.save(usuario);

    if(usuarioCriado != null)
        return "Usuário criado com sucesso!";        
    
    return "Erro ao criar usuário";
}
     
 // no thunderbird esta dando ok, mas não esta adicionado a jogada no banco
    @PostMapping("/api/quiapp/adicionarJogada/{id}")
    public boolean adicionarJogada(@RequestBody Jogadas jogadasDoUsuario, @PathVariable Long id) {

        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.getJogadasDoUsuario().add(jogadasDoUsuario);
            usuarioRepository.save(usuario); // Salva as alterações no usuário
            return true;
        } else {
            return false; // O usuário com o ID especificado não foi encontrado
        }
    }
}