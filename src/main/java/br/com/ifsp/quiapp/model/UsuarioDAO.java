package br.com.ifsp.quiapp.model;

import java.util.ArrayList;

import br.com.ifsp.quiapp.model.Tabela;

public class UsuarioDAO{
    private Tabela db;
    private static UsuarioDAO instance;

    public UsuarioDAO() {
    }

    public static UsuarioDAO getInstance(){
        if(instance == null){
            instance = new UsuarioDAO();
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

    public void create(Usuario novo){
        Tabela db = getConnection();
        db.addUsuario(novo);
    }   

    public ArrayList<Usuario> read(){
        Tabela db = getConnection();
        return db.recuperaDadoUsuario();
    }

public void delete(Usuario deletar) {
    Tabela db = getConnection();
    db.removerUsuario(deletar);
}



}