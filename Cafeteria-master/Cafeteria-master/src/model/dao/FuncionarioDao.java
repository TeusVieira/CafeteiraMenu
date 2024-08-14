package model.dao;
import model.entities.funcionario;
public interface FuncionarioDao {
    void cadastrarFuncionario(funcionario f);
    void atualizarFuncionario(int id, funcionario f);
    void removerCliente(int id );
    funcionario procurarFuncionario(int id);
}
