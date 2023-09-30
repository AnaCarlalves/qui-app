package br.com.ifsp.quiapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsp.quiapp.DatabaseUsuario;
import br.com.ifsp.quiapp.model.Jogadas;
import br.com.ifsp.quiapp.model.Usuario;
import br.com.ifsp.quiapp.model.UsuarioDAO;
import br.com.ifsp.quiapp.repository.UsuarioRepository;

@RestController
@CrossOrigin
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;
    
    
    @PostMapping("/api/quiapp/cadastro/cadastroProfessor")
    public void addProfessor(@RequestBody Usuario novo){
        usuarioRepository.save(novo);
        // DatabaseUsuario.addUsuario(novo);
    }

    @DeleteMapping("/api/quiapp/delete")
    public ResponseEntity<String> delCadastroUsuario(@RequestBody Usuario usuario){
        DatabaseUsuario.removerUsuario(usuario);
        return ResponseEntity.ok("O Usuario foi deletado do sistema com sucesso");
    }

    @DeleteMapping("/api/quiapp/deletarHistorico/{id}")
    public  ResponseEntity<String> deletarHistorico(@PathVariable int id){

        Usuario usu = UsuarioDAO.getInstance().findById(id);
        usu.deletarHistorico();

        return ResponseEntity.ok("O historico do usuaro foi excluido com sucesso");
    }


    @GetMapping("/api/quiapp/listaDeAlunosCadastrados")
    public List<Usuario> listaDeAlunosCadastrados(){
        ArrayList<Usuario> banco = UsuarioDAO.getInstance().read();
        ArrayList<Usuario> listaAluno = new ArrayList<>();

        for(Usuario usuAux : banco){
            if(usuAux.getTipo().equals("aluno")){
                listaAluno.add(usuAux);
            }
        }
        return listaAluno;
    }

 @GetMapping("/api/quiapp/RecuperarUsuario/{id}")

 public Usuario recuperaUsuario(@PathVariable int id){

     Usuario usuario = UsuarioDAO.getInstance().findById(id);
     return usuario;

 }

 @PostMapping("/api/quiapp/usuario/criar")
 public String criarUsuario(@RequestBody Usuario usuario){
     
     UsuarioDAO.getInstance().create(usuario);

     return "usuario adicionado com sucesso.";
 
 }

}