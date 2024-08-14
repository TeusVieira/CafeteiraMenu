package model.entities;

import java.util.Objects;

public class cliente {

    private int id_cliente;
    private String nome;
    private String email;
    private String endereco;
    private String telefone;

    public cliente(){

    }


    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "cliente{" +
                "id_cliente=" + id_cliente +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        cliente cliente = (cliente) o;
        return id_cliente == cliente.id_cliente && Objects.equals(nome, cliente.nome) && Objects.equals(email, cliente.email) && Objects.equals(endereco, cliente.endereco) && Objects.equals(telefone, cliente.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_cliente, nome, email, endereco, telefone);
    }
}
