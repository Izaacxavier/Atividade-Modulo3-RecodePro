package model;

import java.time.LocalDate;

public class Passagem {

    private int id_passagem;
    private LocalDate dataDaCompra;

    private Pacote pacote;

    public Passagem() {
    }

    public Passagem(int id_passagem, LocalDate dataDaCompra, Pacote pacote) {
        this.id_passagem = id_passagem;
        this.dataDaCompra = dataDaCompra;
        this.pacote = pacote;
    }

    public int getId_passagem() {
        return id_passagem;
    }

    public void setId_passagem(int id_passagem) {
        this.id_passagem = id_passagem;
    }

    public LocalDate getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(LocalDate dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }
}


