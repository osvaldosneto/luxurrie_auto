import DAO.ClienteDAO;
import DAO.EstoqueDAO;
import entidade.Cliente;
import entidade.Estoque;
import entidade.Pessoa;

import java.time.LocalDate;
import java.util.List;


public class Principal {

    public static void main(String[] args){

        EstoqueDAO estoqueDAO = new EstoqueDAO();

        List<Estoque> listaEstoque = estoqueDAO.findAll();

        for(Estoque estoque : listaEstoque){
            System.out.println(estoque.getMarca() + " - " + estoque.getModelo());
        }

        ClienteDAO clienteDAO = new ClienteDAO();

        List<Cliente> litaCliente = clienteDAO.findAll();
        for(Cliente cliente : litaCliente){
            System.out.println(cliente.toString());
        }


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
