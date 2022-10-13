package model;

public class Pacote {

    private int id_pacote;

    //chaves estrangeiras
    private Cliente cliente;
    private Viagem viagem;

    public Pacote() {
    }

    public Pacote(int id_pacote, Cliente cliente, Viagem viagem) {
        this.id_pacote = id_pacote;
        this.cliente = cliente;
        this.viagem = viagem;
    }

    public int getId_pacote() {
        return id_pacote;
    }

    public void setId_pacote(int id_pacote) {
        this.id_pacote = id_pacote;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }
}
