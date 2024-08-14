package model.dao.impl;

import bancoDados.bancoDados;
import model.entities.cliente;
import model.dao.ClienteDao;

import java.sql.*;

public class clienteDaoJDBC implements ClienteDao{

    private Connection conn;

    public clienteDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void cadastrarCliente(cliente c) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("insert into"+
                            " cliente(id_cliente,nome,email,endereco,telefone) values(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1,c.getId_cliente());
            st.setString(2,c.getNome());
            st.setString(3,c.getEmail());
            st.setString(4,c.getEndereco());
            st.setString(5,c.getTelefone());

            int linha = st.executeUpdate();
            if (linha > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    c.setId_cliente(rs.getInt(1));
                }
                bancoDados.closeResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closedStatement(st);
        }
    }

    public void atualizarCliente(int id, cliente c){
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE cliente SET nome = ?, email = ?, endereco = ?, telefone = ? WHERE id_cliente = ?");
            st.setString(1,c.getNome());
            st.setString(2, c.getEmail());
            st.setString(3,c.getEndereco());
            st.setString(4,c.getTelefone());
            st.setInt(5, id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closedStatement(st);
        }


    }

    public cliente procurarCliente(int id){
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select id_cliente, nome from cliente where id_cliente =?");
            st.setInt(1,id);
            rs = st.executeQuery();

            if (rs.next()){
                cliente c = new cliente();
                c.setId_cliente(rs.getInt("id_cliente"));
                c.setNome(rs.getString("nome"));
                return c;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            bancoDados.closeResultSet(rs);
            bancoDados.closedStatement(st);
        }

        return null;
    }
    @Override
    public void fazerPedido(cliente c) {

    }

    @Override
    public void removerCliente(int id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("delete from cliente where id_cliente=?");
            st.setInt(1,id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closedStatement(st);
        }

    }

    @Override
    public void verMenu() {

    }
}
