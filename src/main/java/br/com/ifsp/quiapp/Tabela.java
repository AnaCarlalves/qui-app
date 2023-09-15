package br.com.ifsp.quiapp;

import java.util.ArrayList;

import br.com.ifsp.quiapp.model.Perguntas;
import br.com.ifsp.quiapp.model.Usuario;

public class Tabela {
    private static ArrayList<Usuario> bancoUsuarios;
    private static ArrayList<Perguntas> bancoPerguntas;

    public Tabela() {
        bancoUsuarios = new ArrayList<>();
        bancoPerguntas = new ArrayList<>();
    }

    public void init(){
        bancoUsuarios.add(new Usuario("Joao","aluno"));
        bancoUsuarios.add(new Usuario("Pedro","aluno"));
    }
    
    public static void addUsuario(Usuario novo){
        bancoUsuarios.add(novo);
    }

    public void addPerguntas(Perguntas novo){
        bancoPerguntas.add(novo);
    }

    public static void removerUsuario(Usuario usuario) {
        bancoUsuarios.remove(usuario);
    }

    public ArrayList<Usuario> recuperaDadoUsuario(){
        return bancoUsuarios;
    }

    public static ArrayList<Perguntas> recuperaDadoPerguntas(){
        return bancoPerguntas;
    }

    public Usuario recuperarUsuario(int id) {
        return bancoUsuarios.get(id);
    }
}