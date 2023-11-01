package src.operations;
import java.util.Date;
public class Consulta {
    private Date dataConsulta;
    private int paciente;//id do paciente
    private int medico;//id do medico
    private String consultaStatus; //agendada, confirmada, realizada, cancelada
    private String obs;//observacoes

    public Consulta(Date dataConsulta, int paciente, int medico, String consultaStatus, String obs) {
        this.dataConsulta = dataConsulta;
        this.paciente = paciente;
        this.medico = medico;
        this.consultaStatus = consultaStatus;
        this.obs = obs;
    }

    public Consulta(){}

    public Date getDataConsulta() {
        return this.dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public int getPaciente() {
        return this.paciente;
    }

    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    public int getMedico() {
        return this.medico;
    }

    public void setMedico(int medico) {
        this.medico = medico;
    }

    public String getconsultaStatus() {
        return this.consultaStatus;
    }

    public void setconsultaStatus(String consultaStatus) {
        this.consultaStatus = consultaStatus;
    }

    public String getObs() {
        return this.obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void agendarConsulta(){//cria uma nova consulta no sitema
        
    }

    public void confirmarConsulta(){//confirmar uma consulta agendada

    }

    public void realizaConsulta(){//Registar detalhes da consulta e marcar como realizada

    }


    public String imprimeDados() {
        return 
            "Data da consulta:\t "+getDataConsulta()+ "\n" +
            "Paciente:\t\t "+getPaciente()+ "\n" +
            "Medico:\t\t\t "+getMedico()+ "\n" +
            "Estado da consulta:\t "+getconsultaStatus()+ "\n" +
            "Observacoes:\t\t " + getObs() + "\n";
    }

}