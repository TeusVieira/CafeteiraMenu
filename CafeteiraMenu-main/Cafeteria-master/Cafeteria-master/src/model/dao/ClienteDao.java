package model.dao;
import model.entities.cliente;
public interface ClienteDao {
    void cadastrarCliente(cliente c);
    void fazerPedido(cliente c);
    void removerCliente(int id);
    void atualizarCliente(int id, cliente c);
    void verMenu();
    cliente procurarCliente(int id);

}
