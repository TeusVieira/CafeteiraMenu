package model.entities;

public class pedidoDetalhe {

    private int id_pedidoDetalhe;
    private int id_pedido;
    private int id_produto;
    private int quantidade;

    private float preco_unitario;

    public int getId_pedidoDetalhe() {
        return id_pedidoDetalhe;
    }

    public void setId_pedidoDetalhe(int id_pedidoDetalhe) {
        this.id_pedidoDetalhe = id_pedidoDetalhe;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public float getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(float preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
