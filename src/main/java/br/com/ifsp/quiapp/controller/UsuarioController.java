package br.com.ifsp.quiapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifsp.quiapp.model.Tabela;
import br.com.ifsp.quiapp.model.Usuario;
import br.com.ifsp.quiapp.model.UsuarioDAO;

@RestController
public class UsuarioController {

    @DeleteMapping("/api/quiapp/deletarHistorico/{id}")
    public  ResponseEntity<String> deletarHistorico(@PathVariable int id){

        Usuario usu = UsuarioDAO.getInstance().findById(id);
        usu.deletarHistorico();

        return ResponseEntity.ok("O historico do usuaro foi excluido com sucesso");
    }
/*Este método é mapeado para a rota /api/quiapp/deletarHistorico/{id} e lida com solicitações HTTP do tipo DELETE. 
Ele recebe um parâmetro id na URL,que representa o ID do usuário cujo histórico deve ser excluído.

Explicação:

O método findById(id) da classe UsuarioDAO é usado para recuperar um objeto Usuario com base no ID fornecido na URL.
Em seguida, o método deletarHistorico() é chamado no objeto usu para excluir o histórico do usuário.
A resposta HTTP retornada é uma resposta de sucesso (código 200 OK) com a mensagem "O histórico do usuário foi excluído com sucesso".
Método listaDeAlunosCadastrados */

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
}

/*
Este método é mapeado para a rota /api/quiapp/listaDeAlunosCadastrados e lida com solicitações HTTP do tipo GET. Ele retorna uma lista de objetos Usuario representando alunos cadastrados.

Explicação:

O método read() da classe UsuarioDAO é usado para recuperar todos os registros de usuários do banco de dados e armazená-los em uma lista chamada banco.
Uma nova lista chamada listaAluno é criada para armazenar os usuários que são do tipo "aluno".
O código, em seguida, itera sobre cada objeto Usuario na lista banco usando um loop for-each.
Para cada usuário, ele verifica se o tipo é "aluno" usando usuAux.getTipo(). Se o tipo for "aluno", o usuário é adicionado à lista listaAluno.
Finalmente, a lista listaAluno contendo todos os alunos é retornada como resposta da solicitação HTTP.
Em resumo, o método listaDeAlunosCadastrados recupera todos os usuários do banco de dados, filtra aqueles que são do tipo "aluno" e retorna uma lista contendo esses usuários. Isso é útil para listar todos os alunos cadastrados no sistema. 
Certifique-se de que a classe UsuarioDAO esteja implementada corretamente para acessar os dados do banco de dados conforme necessário.
 */