package br.com.ifsp.quiapp.model;

import java.util.ArrayList;

import br.com.ifsp.quiapp.DatabasePergunta;

public class PerguntaDAO {
    private DatabasePergunta db;
    private static PerguntaDAO instance;

    // O construtor privado garante que uma única instância irá existir
    private PerguntaDAO(){
       
    }

    // Recupera a única instância do DAO
    public static PerguntaDAO getInstance(){
        if(instance == null){
            instance = new PerguntaDAO();
        }
        return instance;
    }

    // Recupera a conexão com o Banco de Dados
    private DatabasePergunta getConnection(){
        if(this.db == null){            
            DatabasePergunta db = new DatabasePergunta();
            this.db = db;
        }
        return this.db;    
    }

    //Cria um novo cadastro
    public void create(Pergunta novo){
        DatabasePergunta db = getConnection();
        db.addDadoPerguntas(novo);
    }   

    // Recupera todas as listas
    public ArrayList<Pergunta> read(){
        DatabasePergunta db = getConnection();
        return db.recuperarDadoPergunta();
    }

    public void delete(Pergunta delete){
        DatabasePergunta db = getConnection();
        db.removeDadosPergunta(delete);
    }

    public void update(Pergunta toUpdate){
        // Sem implementação
    }

    public ArrayList<Pergunta> findAll(){
        //return (List<Pergunta>) Pergunta.all();
        return (ArrayList<Pergunta>) DatabasePergunta.all();
    }
}
