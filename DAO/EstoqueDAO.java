package DAO;

import entidade.Estoque;
import util.ConnectionMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {

    public Estoque createEstoque(Estoque estoque){
        try{
            //abrindo conexão com o banco
            Connection conn = ConnectionMysql.openConnection();

            //query a ser executada
            String sql = "INSERT INTO estoque (marca, modelo, ano_fabricacao, cor) " +
                    "VALUES (?,?,?,?)";

            //statement - responsável por executar a query
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, estoque.getMarca());
            statement.setString(2, estoque.getModelo());
            statement.setString(3, String.valueOf(new java.sql.Date(estoque.getAno().getTime())));
            statement.setString(4, estoque.getCor());
            statement.executeUpdate();
            ConnectionMysql.closeConnection();
        } catch (SQLException e){
            System.out.println("Problemas ao salvar Estoque " + e.getMessage());
        }
        return estoque;
    }

    public List<Estoque> findAll (){
        //listar todos o estoque no banco e retornar pra quem o solicitou
        List<Estoque> listaEstoque = new ArrayList<>();
        try{
            Connection conn = ConnectionMysql.openConnection();

            String sql = "SELECT * FROM estoque";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Estoque estoque = new Estoque();
                estoque.setId(resultSet.getInt("id_estoque"));
                estoque.setModelo(resultSet.getString("modelo"));
                estoque.setAno(resultSet.getDate("ano_fabricacao"));
                estoque.setMarca(resultSet.getString("marca"));
                estoque.setCor(resultSet.getString("cor"));
                listaEstoque.add(estoque);
            }
        } catch (SQLException e){
            System.out.println("Não foi possível executar o findall em estoque");
        }
        return listaEstoque;
    }

}
