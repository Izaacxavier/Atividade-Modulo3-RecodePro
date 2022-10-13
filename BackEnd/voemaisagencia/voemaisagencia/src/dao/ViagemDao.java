package dao;

import connection.connectionMysql;
import model.Viagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViagemDao {

    private String destino;

    //CREATE
    public void save(Viagem viagem){

        String sql = "INSERT INTO viagem (destinos, data_ida, data_volta) VALUES(?, ?, ?)";

            Connection conn = null;
            PreparedStatement pstm = null;

        try{
             conn = connectionMysql.createConnectionMysql();
             pstm = conn.prepareStatement(sql);

             pstm.setString(1, viagem.getDestinos());
             pstm.setString(2, viagem.getData_ida());
             pstm.setString(3, viagem.getData_volta());

             pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if( pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();

                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }


        }

    //READ
    public List<Viagem> getViagem() throws SQLException {

        List<Viagem> viagem = new ArrayList<Viagem>();

        String sql = "SELECT * FROM viagem";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{

            conn = connectionMysql.createConnectionMysql();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

        while(rset.next()){
            Viagem viagens = new Viagem(destino);

            viagens.setId_viagem(rset.getInt("id_viagem"));
            viagens.setDestinos(rset.getString("Destinos"));
            viagens.setData_ida(rset.getString("data_ida"));
            viagens.setData_volta(rset.getString("data_volta"));

            viagem.add(viagens);
        }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (rset != null){
                    rset.close();
                }
                if (conn != null){
                    conn.close();
                }
                if (pstm != null){
                    pstm.close();
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }

        return viagem;
    }

    //UPDATE
    public void update( Viagem viagem){

        String sql = "UPDATE viagem SET destinos = ?, data_ida = ?, data_volta = ? WHERE id_viagem = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{

            conn = connectionMysql.createConnectionMysql();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, viagem.getDestinos());
            pstm.setString(2, viagem.getData_ida());
            pstm.setString(3, viagem.getData_volta());
            pstm.setInt(4, viagem.getId_viagem());

            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            try{
                if (conn != null){
                    conn.close();
                }
                if (pstm != null){
                    pstm.close();
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
    //DELETE
    public void deleteById(int id){

        String sql = "DELETE FROM viagem WHERE id_viagem = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{

            conn = connectionMysql.createConnectionMysql();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (conn != null){
                    conn.close();
                }
                if (pstm != null){
                    pstm.close();
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}
