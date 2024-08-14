package model.dao.impl;

import bancoDados.bancoDados;
import model.dao.ProdutoDao;
import model.entities.produto;

import java.sql.*;

public class produtoDaoJDBC implements ProdutoDao {

    private Connection conn;

    public produtoDaoJDBC(Connection connection) {
        this.conn = connection;
    }

    public void cadastrarProduto(produto p) {
            PreparedStatement st = null;
        try {
            st = conn.prepareStatement("insert into"+
                            " produto(id_produto,nome,preco,quant_estoque) values(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1,p.getId_produto());
            st.setString(2,p.getNome());
            st.setDouble(3,p.getPreco());
            st.setInt(4,p.getQtd_estoque());

            int linha = st.executeUpdate();


            if (linha > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    p.setId_produto(rs.getInt(1));
                }
                bancoDados.closeResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closedStatement(st);
        }
    }

    @Override
    public produto procurarPorId(int id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("select id_produto, nome, preco, quant_estoque from produto where id_produto = ?");
            st.setInt(1,id);
            rs = st.executeQuery();

            if(rs.next()){
                produto p = new produto();
                p.setId_produto(rs.getInt("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getFloat("preco"));
                p.setQtd_estoque(rs.getInt("quant_estoque"));
                return p;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closeResultSet(rs);
            bancoDados.closedStatement(st);
            bancoDados.closedConnection();
        }
        return null;
    }

    @Override
    public void removerProduto(int id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("delete from produto where id_produto=?");
            st.setInt(1,id);
            int aux = st.executeUpdate();
            if (aux>0){
                System.out.println("Produto removido");
            }else {
                System.out.println("algo deu errado(???)");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closedStatement(st);
        }

    }

    @Override
    public void atualizarProduto(int id, produto p) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("update produto set nome = ?, " +
                    " preco = ?, quant_estoque = ? where id_produto = ?");
            st.setString(1,p.getNome());
            st.setDouble(2,p.getPreco());
            st.setInt(3,p.getQtd_estoque());
            st.setInt(4,id);
            int aux = st.executeUpdate();
            if (aux > 0)
                System.out.println(p.getNome()+" atualizado");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closedStatement(st);
        }

    }
}
