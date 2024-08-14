package model.dao;

import bancoDados.bancoDados;
import model.dao.impl.clienteDaoJDBC;
import model.dao.impl.funcionarioDaoJDBC;
import model.dao.impl.produtoDaoJDBC;


public class DAOfactory {
    public static clienteDaoJDBC createClienteDao(){
        return new clienteDaoJDBC(bancoDados.getConnection());
    }
    public static funcionarioDaoJDBC createFuncionarioDao(){
        return new funcionarioDaoJDBC(bancoDados.getConnection());
    }
    public static produtoDaoJDBC createProdutoDao(){
        return new produtoDaoJDBC(bancoDados.getConnection());
    }
}
