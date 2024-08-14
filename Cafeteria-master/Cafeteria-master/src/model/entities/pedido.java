package model.entities;
import java.util.Date;


public class pedido {

    private int id_pedido;
    private cliente id_cliente;
    private String status;
    private Date data;
    private funcionario  id_funcionario;


    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public funcionario getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(funcionario id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
