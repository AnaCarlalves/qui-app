package br.com.ifsp.quiapp.model;

import java.util.ArrayList;

import br.com.ifsp.quiapp.model.PerguntaVestibular;
import br.com.ifsp.quiapp.model.Perguntas;
import br.com.ifsp.quiapp.model.Usuario;

public class Tabela {
    private static ArrayList<Usuario> bancoUsuarios;
    private ArrayList<Perguntas> bancoPerguntas;

    public Tabela() {
        bancoUsuarios = new ArrayList<>();
        bancoPerguntas = new ArrayList<>();
    }

    
    public void init(){
        bancoUsuarios.add(new Usuario("Joao","aluno"));
        // bancoUsuarios.add(new Usuario("Joao","aluno"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        // bancoUsuarios.add(new Usuario("Joao"));
        
        
        
        bancoPerguntas.add(new PerguntaVestibular(null));
    }
    
    public void addUsuario(Usuario novo){
        bancoUsuarios.add(novo);
    }

    public void addPerguntas(Perguntas novo){
        bancoPerguntas.add(novo);
    }

    public void removerUsuario(Usuario usuario) {
    bancoUsuarios.remove(usuario);
}


    public ArrayList<Usuario> recuperaDadoUsuario(){
        return bancoUsuarios;
    }

    public ArrayList<Perguntas> recuperaDadoPerguntas(){
        return bancoPerguntas;
    }


    public Usuario recuperarUsuario(int id) {
        return bancoUsuarios.get(id);
    }
}