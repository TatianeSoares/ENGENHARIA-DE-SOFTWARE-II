package com.model;

public class Usuario {
    protected String matricula;
    protected String nome;
    protected Long id;
    protected String login;
    protected String senha;

    public Usuario(Long id, String matricula, String login, String senha, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
