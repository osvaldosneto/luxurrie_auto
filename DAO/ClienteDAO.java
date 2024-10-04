package DAO;

import entidade.Cliente;
import entidade.Estoque;
import util.ConnectionMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public Cliente createCliente(Cliente cliente){
        try{
            Connection conn = ConnectionMysql.openConnection();

            //Query1 - inserindo pessoa no banco
            String sqlPessoa = "INSERT INTO pessoa (cpf, nome, data_nascimento, email, telefone) " +
                    "VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sqlPessoa);
            statement.setString(1, cliente.getCpf());
            statement.setString(2, cliente.getNome());
            statement.setString(3, String.valueOf(cliente.getDataNascimento()));
            statement.setString(4, cliente.getEmail());
            statement.setString(5, cliente.getPhone());
            statement.executeUpdate();

            //Query 2 - select para localizar o id da pessoa criada acima
            String sqlPessoaFind = "SELECT id_pessoa FROM pessoa WHERE cpf=? LIMIT 1";
            PreparedStatement statementPessoa = conn.prepareStatement(sqlPessoaFind);
            statementPessoa.setString(1, cliente.getCpf());
            ResultSet resultSet = statementPessoa.executeQuery();
            int idPessoa = -1;
            while(resultSet.next()){
                idPessoa = resultSet.getInt("id_pessoa");
            }

            //Query 3 - Salvando o cliente
            String sqlCliente = "INSERT INTO cliente (pessoa_idpessoa) VALUES (?)";
            PreparedStatement statementCliente = conn.prepareStatement(sqlCliente);
            statementCliente.setString(1, String.valueOf(idPessoa));
            statementCliente.executeUpdate();
        } catch (SQLException e){
            System.out.println("Problemas ao salvar Cliente " + e.getMessage());
        }
        return cliente;
    }


    public List<Cliente> findAll(){
        //listar todos o estoque no banco e retornar pra quem o solicitou
        List<Cliente> listaCliente = new ArrayList<>();
        try{
            Connection conn = ConnectionMysql.openConnection();

            String sql = "SELECT * FROM pessoa " +
                    "join cliente on pessoa.id_pessoa = cliente.pessoa_idpessoa";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt("id_pessoa"));
                cliente.setIdCliente(resultSet.getInt("id_cliente"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setPhone(resultSet.getString("telefone"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setDataNascimento(resultSet.getDate("data_nascimento"));
                listaCliente.add(cliente);
            }
        } catch (SQLException e){
            System.out.println("Não foi possível executar o findall em estoque");
        }
        return listaCliente;
    }

//    Cliente findById(int id){
//        //seleciona um usuário pelo id
//        //retur usuario;
//    }
}
