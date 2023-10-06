package br.com.ifsp.quiapp.model;

import java.util.ArrayList;

import br.com.ifsp.quiapp.DatabaseUsuario;

public class UsuarioDAO{
    private DatabaseUsuario db;
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
    private DatabaseUsuario getConnection(){
        if(this.db == null){            
            DatabaseUsuario db = new DatabaseUsuario();
            db.init();
            this.db = db;
        }
        return this.db;    
    }

    public void create(Usuario novo){
        DatabaseUsuario db = getConnection();
        db.addUsuario(novo);
    }   

    public ArrayList<Usuario> read(){
        DatabaseUsuario db = getConnection();
        return db.recuperaDadoUsuario();
    }

    public void delete(Usuario deletar) {
        DatabaseUsuario db = getConnection();
        db.removerUsuario(deletar);
    }

    public Usuario findById(int id) {
        DatabaseUsuario db = getConnection();
        return db.recuperarUsuario(id);
    }

}