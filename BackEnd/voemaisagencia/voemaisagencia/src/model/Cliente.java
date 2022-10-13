package model;

public class Cliente {

    private int id_cliente;
    private String nome;
    private String sobrenome;
    private String endereco;
    private String telefone;
    private String cpf;
    private String email;
    private String senha;

    private static Permissoes permissoes;


    public Cliente(String nome, String sobrenome, String endereco, String telefone, String cpf, String email, String senha) {

    }

    public Cliente(int id_cliente, String nome, String sobrenome, String endereco, String telefone, String cpf, String email) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.permissoes = permissoes();

    }

    private Permissoes permissoes() {
        return null;
    }

    public Cliente(String nome) {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static Permissoes getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Permissoes permissoes) {
        this.permissoes = permissoes;
    }

    public void add(Cliente cliente) {
    }
}


