package entidade;

import java.util.Date;

public class Funcionario extends Pessoa{

    private int idFuncionario;

    private String cargo;

    private Double salario;

    private String setor;

    private int status;

    public Funcionario(int id, String cpf, String nome, Date dataNascimento, String email, String phone, int idFuncionario,
                       String cargo, Double salario, String setor, int status) {
        super(id, cpf, nome, dataNascimento, email, phone);
        this.idFuncionario = idFuncionario;
        this.cargo = cargo;
        this.salario = salario;
        this.setor = setor;
        this.status = status;
    }

    public Funcionario(Double salario, String nome, Date dataNascimento, String email, String phone,
                       String cargo, String cpf, String setor, int status) {
        this.phone = phone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.nome = nome;
        this.idFuncionario = idFuncionario;
        this.cargo = cargo;
        this.salario = salario;
        this.setor = setor;
        this.status = status;
    }

    public Funcionario(){
        super();
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "idFuncionario=" + idFuncionario +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", setor='" + setor + '\'' +
                ", status=" + status +
                ", id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
