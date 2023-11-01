package src.personel;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;

public class Paciente extends Pessoa implements Serializable{
    private String EmergencyInfo; //informacao de emergencia
    private int PacId;//numero de paciente
    private String endereco;
    private String estadoCivil;
    private String email;
    private String celular;
    private int numeroSegSaude;
    private String historicoMedico; 
    private String loginName;
    private String loginPwd;   
    private boolean accessPermiss;
    private boolean status;
    private String obs; //observacaoes
    public static ArrayList<Paciente> pacientes = new ArrayList<>();

    

    public Paciente() {
    }

    public Paciente(int PacId, String nome, Date dataNasc,String genero, String bi, String nacionalidade, String EmergencyInfo, String endereco,String email, String celular, String estadoCivil, int numeroSegSaude, String historicoMedico, String loginName, String loginPwd, boolean accessPermiss, boolean status, String obs) {
        super(nome, dataNasc, genero, bi, nacionalidade);
        this.EmergencyInfo = EmergencyInfo;
        this.PacId = PacId;
        this.endereco = endereco;
        this.estadoCivil = estadoCivil;
        this.email = email;
        this.celular = celular;
        this.numeroSegSaude = numeroSegSaude;
        this.historicoMedico = historicoMedico;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.accessPermiss = accessPermiss;
        this.status = status;
        this.obs = obs;
    }

    public boolean isStatus() {
        return this.status;
    }

    public String getEmergencyInfo() {
        return this.EmergencyInfo;
    }

    public void setEmergencyInfo(String EmergencyInfo) {
        this.EmergencyInfo = EmergencyInfo;
    }

    public int getPacId() {
        return this.PacId;
    }

    public void setPacId(int PacId) {
        this.PacId = PacId;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getNumeroSegSaude() {
        return this.numeroSegSaude;
    }

    public void setNumeroSegSaude(int numeroSegSaude) {
        this.numeroSegSaude = numeroSegSaude;
    }

    public String getHistoricoMedico() {
        return this.historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    public boolean isAccessPermiss() {
        return this.accessPermiss;
    }

    public boolean getAccessPermiss() {
        return this.accessPermiss;
    }

    public void setAccessPermiss(boolean accessPermiss) {
        this.accessPermiss = accessPermiss;
    }

    public boolean isActive() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return this.loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }


    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getObs() {
        return this.obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public void imprimeDados(){
        for(Paciente pc: pacientes){
            System.out.println("\n"+
                "Numero de Paciente: \t\t" + pc.getPacId() + "\n" +
                "Nome: \t\t\t\t" + pc.getNome() + "\n" +
                "Data de nascimento: \t\t" + pc.getDataNasc() + "\n" +
                "Genero: \t\t\t" + pc.getGenero() + "\n" +
                "Nacionalidade: \t\t\t" + pc.getNacionalidade() + "\n" +
                "Estado Civil: \t\t\t" + pc.getEstadoCivil() + "\n" +
                "Endereco: \t\t\t" + pc.getEndereco() + "\n" +
                "Celular: \t\t\t" + pc.getCelular() + "\n" +
                "Email: \t\t\t\t" + pc.getEmail() + "\n" +
                "Informacao de Emergencia: \t" + pc.getEmergencyInfo() + "\n" +
                "Numero de SegSaude: \t\t" + pc.getNumeroSegSaude() + "\n" +
                "Nome de utilizador: \t\t" + pc.getLoginName() + "\n" +
                "Permissao de acesso: \t\t" + pc.isAccessPermiss() + "\n" +
                "Status: \t\t\t" + pc.isStatus() + "\n" +
                "Historico Medico: \t\t" + pc.getHistoricoMedico() + "\n" +
                "Observacao: \t\t\t" + pc.getObs() + "\n" 
            );
        }
    }

    @Override
    public String toString() {
        return "{" +
            " EmergencyInfo='" + getEmergencyInfo() + "'" +
            ", PacId='" + getPacId() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", estadoCivil='" + getEstadoCivil() + "'" +
            ", email='" + getEmail() + "'" +
            ", celular='" + getCelular() + "'" +
            ", numeroSegSaude='" + getNumeroSegSaude() + "'" +
            ", historicoMedico='" + getHistoricoMedico() + "'" +
            ", loginName='" + getLoginName() + "'" +
            ", loginPwd='" + getLoginPwd() + "'" +
            ", accessPermiss='" + isAccessPermiss() + "'" +
            ", status='" + isStatus() + "'" +
            ", obs='" + getObs() + "'" +
            "}";
    }


}
