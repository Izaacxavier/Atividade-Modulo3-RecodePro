package dao;

import connection.connectionMysql;
import model.Permissoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PermissoesDao {

    private static int id_permissao;
    private int id_Permissao;

    //CREATE
    public void save(Permissoes permissao){

        String sql = "INSERT INTO permissoes (tipo_permissoes) VALUES(?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = connectionMysql.createConnectionMysql();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, permissao.getTipo_permissao());

            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pstm != null){
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

    //UPDATE
    public void update(Permissoes permissao){

        String sql = "UPDATE permissoes SET tipo_permissoes = ? WHERE id_permissoes = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{

            conn = connectionMysql.createConnectionMysql();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, permissao.getTipo_permissao());
            pstm.setInt(2, permissao.getId_permissoes());

            pstm.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pstm != null){
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
    public List<Permissoes> getPermissoes(){
        String sql = "SELECT * FROM permissoes";

        List<Permissoes> permissoes = new ArrayList<Permissoes>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            conn =connectionMysql.createConnectionMysql();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Permissoes permissao = new Permissoes(id_Permissao);

                permissao.setId_permissoes(rset.getInt("id_permissoes"));
                permissao.setTipo_permissao(rset.getString("tipo_permissoes"));

                permissoes.add(permissao);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return permissoes;
    }

    //DELETE
    public void deleteById(int id){

        String sql = "DELETE FROM permissoes WHERE id_permissoes = ?";

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
            try {
                if (pstm != null){
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

    public static Permissoes getPermissoesById(int id_permissoes){

        String sql = "SELECT * FROM permissoes WHERE id_permissoes = ?";

        Permissoes permissao = new Permissoes(id_permissao);

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try{

            conn = connectionMysql.createConnectionMysql();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id_permissoes);

            rset = pstm.executeQuery();
            rset.next();

            permissao.setId_permissoes(rset.getInt(id_permissoes));
            permissao.setTipo_permissao(rset.getString("tipo_permissoes"));



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
        return permissao;
    }
}
