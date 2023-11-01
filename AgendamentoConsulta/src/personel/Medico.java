package src.personel;
import java.time.LocalDate;
import java.sql.Date;

public class Medico extends Funcionario{
    private String especialidade;
    private int CRM;//numero de registo medico

    public Medico(int funcId, String nome, Date dataNasc, String genero, String bi, String nacionalidade, String endereco, String celular, String email,String cargo, LocalDate dataContratacao, int salario, String horarioTrabalho, boolean status, String loginName, String loginPwd, boolean accessPermiss, String historico, String obs, String especialidade, int CRM){
        super(funcId, nome, dataNasc, genero, bi, nacionalidade, endereco, celular, email, cargo, dataContratacao, salario, horarioTrabalho, status, loginName, loginPwd, accessPermiss, historico, obs);
        this.especialidade = especialidade;
        this.CRM = CRM;
    }

    public Medico(){}

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getCRM() {
        return this.CRM;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public void gerirAgenda(){//Permitir ao medico, ver e gerir a sua agenda de consultas

    }

    public void aceitarConsulta(){//aceitar uma consulta agenda (apos a confirmacao)
    }

    public void rejeitarConsulta(){//rejeitar uma consulta agendada 

    }
}
