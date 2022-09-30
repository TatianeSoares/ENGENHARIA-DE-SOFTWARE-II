package com.model;

public class Usuario {
    protected String matricula;
    protected String nome;
    protected String login;
    protected String senha;

    public Usuario(String matricula, String login, String senha, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(){

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
