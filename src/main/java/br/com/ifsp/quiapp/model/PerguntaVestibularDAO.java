package br.com.ifsp.quiapp.model;

import java.util.ArrayList;

import br.com.ifsp.quiapp.model.Tabela;

public class PerguntaVestibularDAO {

    private Tabela db;
    private static PerguntaVestibularDAO instance;

    private PerguntaVestibularDAO(){
       
    }

    public static PerguntaVestibularDAO getInstance(){
        if(instance == null){
            instance = new PerguntaVestibularDAO();
        }
        return instance;
    }

    // Recupera a conexão com o Banco de Dados
    private Tabela getConnection(){
        if(this.db == null){            
            Tabela db = new Tabela();
            db.init();
            this.db = db;
        }
        return this.db;    
    }

    //Cria um novo cadastro
    public void create(PerguntaVestibular novaPergunta){
        Tabela db = getConnection();
        db.addPerguntas(novaPergunta);
    }   

    // Recupera todas as listas
    public ArrayList<Perguntas> read(){
        Tabela db = getConnection();
        return db.recuperaDadoPerguntas();
    }

}
