package dao;

import connection.connectionMysql;
import model.Cliente;
import model.Permissoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteDao {
    private String nome;
    private Object id_permissao;

    //CREATE
    public static void save(Cliente cliente) {
        //criar query
        String sql = ("INSERT INTO cliente" + "(nome, sobrenome, endereco, telefone, cpf, email, senha, id_permissoes)" +
                "VALUES(?,?,?,?,?,?,?,?)");
        //conexao
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = connectionMysql.createConnectionMysql();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getSobrenome());
            pstm.setString(3, cliente.getEndereco());
            pstm.setString(4, cliente.getTelefone());
            pstm.setString(5, cliente.getCpf());
            pstm.setString(6, cliente.getEmail());
            pstm.setString(7, cliente.getSenha());
            //FOREIGN KEY
            pstm.setInt(8, Cliente.getPermissoes().getId_permissoes());

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
            //READ
            public List<Cliente> getCliente() throws SQLException {

                //arraylist
                List<Cliente> cliente = new ArrayList<Cliente>();

                //criar query
                String sql = "SELECT * FROM cliente";


                //conexao
                Connection conn = null;
                PreparedStatement pstm = null;
                ResultSet rset = null;

                try{
                    conn = connectionMysql.createConnectionMysql();
                    pstm = conn.prepareStatement(sql);
                    rset =  pstm.executeQuery();

                    while (rset.next()){
                        Cliente clientes = new Cliente(nome);
                        new PermissoesDao();
						Permissoes permissao = PermissoesDao.getPermissoesById((Integer) id_permissao);
                        clientes.setId_cliente(rset.getInt("id_cliente"));
                        clientes.setNome(rset.getString("nome"));
                        clientes.setSobrenome(rset.getString("sobrenome"));
                        clientes.setEndereco(rset.getString("endereco"));
                        clientes.setTelefone(rset.getString("telefone"));
                        clientes.setCpf(rset.getString("cpf"));
                        clientes.setEmail(rset.getString("email"));
                        clientes.setSenha(rset.getString("senha"));

                        permissao.setTipo_permissao(rset.getString("Tipo_permissoes"));
                        clientes.setPermissoes(permissao);

                        cliente.add(clientes);

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (rset != null){
                        rset.close();
                    }
                    if (conn != null){
                        conn.close();
                    }
                    if(pstm != null){
                        pstm.close();
                    }
                }
                return cliente;
    }

            //UPDADE

            public void update (Cliente cliente){

                String sql = "UPDATE Cliente" + "SET nome = ?, sobrenome = ?, endereco = ?, telefone = ?," +
                        " cpf = ?, email = ?, senha = ?, id_permissoes = ?, id_cliente = ?" + "  WHERE id_cliente = ?";

                Connection conn = null;
                PreparedStatement pstm = null;

                try{
                    conn = connectionMysql.createConnectionMysql();
                    pstm = conn.prepareStatement(sql);

                    pstm.setString(1, cliente.getNome());
                    pstm.setString(2,cliente.getSobrenome());
                    pstm.setString(3, cliente.getEndereco());
                    pstm.setString(4, cliente.getTelefone());
                    pstm.setString(5, cliente.getCpf());
                    pstm.setString(6, cliente.getEmail());
                    pstm.setString(7, cliente.getSenha());
                    pstm.setInt(8, Cliente.getPermissoes().getId_permissoes());
                    pstm.setInt(9, cliente.getId_cliente());

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

            //DELETE
            public void deletebyId(int id) throws SQLException {

                 String sql = "DELETE FROM cliente WHERE id_cliente = ?";

                 Connection conn = null;
                 PreparedStatement pstm = null;

                 try{

                     conn = connectionMysql.createConnectionMysql();
                     pstm = conn.prepareStatement(sql);

                     pstm.setInt(1, id);

                     pstm.execute();

                 } catch (Exception e){
                     e.printStackTrace();
                 }finally {
                     if (pstm != null){
                         pstm.close();
                     }
                     if (conn != null){
                         conn.close();
                     }

                 }

            }

}

