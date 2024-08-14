package model.dao.impl;

import model.dao.FuncionarioDao;
import model.entities.funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bancoDados.bancoDados;

public class funcionarioDaoJDBC implements FuncionarioDao {

    private Connection conn;
    public funcionarioDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void cadastrarFuncionario(funcionario f) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("insert into funcionario(nome, sexo, email, telefone) values(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1,f.getNome());
            st.setString(2,f.getSexo());
            st.setString(3,f.getEmail());
            st.setString(4,f.getTelefone());
            int linha = st.executeUpdate();
            if (linha > 0){
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()){
                    f.setId(rs.getInt(1));
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
    public void atualizarFuncionario(int id, funcionario f) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("update funcionario set " +
                    "nome = ?, sexo = ?, email = ?, telefone = ? " +
                    "where id_funcionario = ?");
            st.setString(1,f.getNome());
            st.setString(2, f.getSexo());
            st.setString(3,f.getEmail());
            st.setString(4,f.getTelefone());
            st.setInt(5,id);
            int aux = st.executeUpdate();
            if (aux > 0)
                System.out.println(f.getNome()+" atualizado.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closedStatement(st);
        }
    }

    @Override
    public void removerCliente(int id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("delete from funcionario where id_funcionario=?");
            st.setInt(1,id);
            int aux = st.executeUpdate();
            if (aux > 0){
                System.out.println("removido com sucesso");
            }else{
                System.out.println("algo deu errado T.T");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            bancoDados.closedStatement(st);
        }

    }

    @Override
    public funcionario procurarFuncionario(int id) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("Select id_funcionario, nome, sexo, email, telefone from funcionario where id_funcionario = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()){
                funcionario f = new funcionario();
                f.setId(rs.getInt("id_funcionario"));
                f.setNome(rs.getString("nome"));
                f.setEmail(rs.getString("email"));
                f.setSexo(rs.getString("sexo"));
                f.setTelefone(rs.getString("telefone"));
                return f;
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

}
