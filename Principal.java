import DAO.ClienteDAO;
import DAO.EstoqueDAO;
import DAO.FuncionarioDAO;
import entidade.Cliente;
import entidade.Estoque;
import entidade.Funcionario;
import entidade.Pessoa;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public class Principal {

    public static void main(String[] args){

        LocalDate dataAtual = LocalDate.now();

        Funcionario funcionario = new Funcionario();
        funcionario.setStatus(1);
        funcionario.setSetor("vendas");
        funcionario.setCargo("vendedor");
        funcionario.setSalario(1500.00);
        funcionario.setCpf("76676754321");
        funcionario.setDataNascimento(java.sql.Date.valueOf(dataAtual));
        funcionario.setEmail("pedro@delara.com");
        funcionario.setNome("Pedro de Lara");
        funcionario.setPhone("9878979797987");


        Funcionario f2 = new Funcionario(2500.00, "Joana Darck",
                java.sql.Date.valueOf(dataAtual), "email@email.com", "987987987987",
                "financeiro", "98797979809", "vendas", 1);

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionarioLocalizado = funcionarioDAO.findById(9);
        System.out.println(funcionarioLocalizado.toString());

//        funcionarioDAO.createFuncionario(f2);

//        EstoqueDAO estoqueDAO = new EstoqueDAO();
//
//        List<Estoque> listaEstoque = estoqueDAO.findAll();
//
//        for(Estoque estoque : listaEstoque){
//            System.out.println(estoque.getMarca() + " - " + estoque.getModelo());
//        }
//
//        ClienteDAO clienteDAO = new ClienteDAO();
//
//        List<Cliente> litaCliente = clienteDAO.findAll();
//        for(Cliente cliente : litaCliente){
//            System.out.println(cliente.toString());
//        }


//        ClienteDAO clienteDAO = new ClienteDAO();

//        LocalDate dataAtual = LocalDate.now();
//
//        Cliente c1 = new Cliente();
//        c1.setNome("Pedro");
//        c1.setCpf("990909099");
//        c1.setDataNascimento(java.sql.Date.valueOf(dataAtual));
//        c1.setEmail("email@email.com");
//        c1.setPhone("99999999999");
//        clienteDAO.createCliente(c1);
//

//
//        Estoque estoque = new Estoque();
//        estoque.setAno(java.sql.Date.valueOf(dataAtual));
//        estoque.setCor("black");
//        estoque.setMarca("Ferrari");
//        estoque.setModelo("F50");
//
//        EstoqueDAO estoqueDAO = new EstoqueDAO();
//        estoqueDAO.createEstoque(estoque);


    }

}
