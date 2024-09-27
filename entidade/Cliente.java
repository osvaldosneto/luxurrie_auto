package entidade;

import java.util.Date;

public class Cliente extends Pessoa {

    private int idCliente;

    public Cliente(int id, String cpf, String nome, Date dataNascimento, String email, String phone, int idCliente) {
        super(id, cpf, nome, dataNascimento, email, phone);
        this.idCliente = idCliente;
    }

    public Cliente() {
        super();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
