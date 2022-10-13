package model;

public class Viagem {

    private int id_viagem;
    private String destinos;
    private String data_ida;
    private String data_volta;

    public Viagem(int id, String destino) {
    }

    public Viagem(int id_viagem, String destinos, String data_ida, String data_volta) {
        this.id_viagem = id_viagem;
        this.destinos = destinos;
        this.data_ida = data_ida;
        this.data_volta = data_volta;
    }

    public Viagem(String destino) {
    }

    public int getId_viagem() {
        return id_viagem;
    }

    public void setId_viagem(int id_viagem) {
        this.id_viagem = id_viagem;
    }

    public String getDestinos() {
        return destinos;
    }

    public void setDestinos(String destinos) {
        this.destinos = destinos;
    }

    public String getData_ida() {
        return data_ida;
    }

    public void setData_ida(String data_ida) {
        this.data_ida = data_ida;
    }

    public String getData_volta() {
        return data_volta;
    }

    public void setData_volta(String data_volta) {
        this.data_volta = data_volta;
    }
}

