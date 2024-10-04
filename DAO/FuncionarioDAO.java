package DAO;

import entidade.Cliente;
import entidade.Funcionario;
import util.ConnectionMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO {

    public Funcionario createFuncionario(Funcionario funcionario){
        try{
            Connection conn = ConnectionMysql.openConnection();

            //salvando uma pessoa na tabela pessoa
            String sqlPessoa = "INSERT INTO pessoa (cpf, nome, data_nascimento, email, telefone) " +
                    "VALUES (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sqlPessoa);
            statement.setString(1, funcionario.getCpf());
            statement.setString(2, funcionario.getNome());
            statement.setString(3, String.valueOf(funcionario.getDataNascimento()));
            statement.setString(4, funcionario.getEmail());
            statement.setString(5, funcionario.getPhone());
            statement.executeUpdate();

            //capturando o id da pessoa
            String sqlPessoaFind = "SELECT id_pessoa FROM pessoa WHERE cpf=? LIMIT 1";
            PreparedStatement statementPessoa = conn.prepareStatement(sqlPessoaFind);
            statementPessoa.setString(1, funcionario.getCpf());
            ResultSet resultSet = statementPessoa.executeQuery();
            int idPessoa = -1;
            while(resultSet.next()){
                idPessoa = resultSet.getInt("id_pessoa");
            }

            // inserindo funcionário na tabela funcionario
            String sqlCliente = "INSERT INTO funcionario (pessoa_idpessoa, cargo, salario, setor, status) VALUES (?,?,?,?,?)";
            PreparedStatement statementCliente = conn.prepareStatement(sqlCliente);
            statementCliente.setString(1, String.valueOf(idPessoa));
            statementCliente.setString(2, funcionario.getCargo());
            statementCliente.setDouble(3, funcionario.getSalario());
            statementCliente.setString(4, funcionario.getSetor());
            statementCliente.setInt(5, funcionario.getStatus());
            statementCliente.executeUpdate();

        } catch (SQLException e){
            System.out.println("Problemas ao salvar funcionário " + e.getMessage());
        }
        return funcionario;
    }

    public Funcionario findById(int id){
        Funcionario funcionario = new Funcionario();
        try{
            Connection conn = ConnectionMysql.openConnection();

            String sql = "SELECT * FROM pessoa " +
                    "JOIN funcionario on pessoa.id_pessoa=funcionario.pessoa_idpessoa " +
                    "WHERE id_funcionario = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                funcionario.setId(resultSet.getInt("id_pessoa"));
                funcionario.setIdFuncionario(resultSet.getInt("id_funcionario"));
                funcionario.setCpf(resultSet.getString("cpf"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setPhone(resultSet.getString("telefone"));
                funcionario.setEmail(resultSet.getString("email"));
                funcionario.setDataNascimento(resultSet.getDate("data_nascimento"));
                funcionario.setSalario(resultSet.getDouble("salario"));
                funcionario.setCargo(resultSet.getString("cargo"));
                funcionario.setSetor(resultSet.getString("setor"));
                funcionario.setStatus(resultSet.getInt("status"));
            }
        } catch (SQLException e){
            System.out.println("Problemas ao consultar funcionário " + e.getMessage());
        }
        return funcionario;
    }

}
