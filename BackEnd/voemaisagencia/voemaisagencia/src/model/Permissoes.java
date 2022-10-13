package model;

public class Permissoes {

    private int id_permissoes;
    private String tipo_permissao;

    public Permissoes(int id_Permissao) {
    }

    public Permissoes(int id_permissoes, String tipo_permissao) {
        this.id_permissoes = id_permissoes;
        this.tipo_permissao = tipo_permissao;
    }

    public int getId_permissoes() {
        return id_permissoes;
    }

    public void setId_permissoes() {
        setId_permissoes(0);
    }

    public void setId_permissoes(int id_permissoes) {
        this.id_permissoes = id_permissoes;
    }

    public String getTipo_permissao() {
        return tipo_permissao;
    }

    public void setTipo_permissao(String tipo_permissao) {
        this.tipo_permissao = tipo_permissao;
    }


}
