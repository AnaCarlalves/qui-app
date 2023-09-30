package br.com.ifsp.quiapp;

import java.util.ArrayList;

import br.com.ifsp.quiapp.model.Usuario;

public class DatabaseUsuario {
    private static ArrayList<Usuario> bancoUsuarios;


    public DatabaseUsuario() {
        bancoUsuarios = new ArrayList<>();
    }

    public void init(){
        bancoUsuarios.add(new Usuario("Joao","aluno"));
        bancoUsuarios.add(new Usuario("Pedro","aluno"));
    }
    
    public static void addUsuario(Usuario novo){
        bancoUsuarios.add(novo);
    }


    public static void removerUsuario(Usuario usuario) {
        bancoUsuarios.remove(usuario);
    }

    public ArrayList<Usuario> recuperaDadoUsuario(){
        return bancoUsuarios;
    }

    public Usuario recuperarUsuario(int id) {
        return bancoUsuarios.get(id);
    }
}