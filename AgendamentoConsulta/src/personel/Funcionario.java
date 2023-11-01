package src.personel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.sql.Date;
import src.db.JSqlCon;
/***
 * 
 */
public class Funcionario extends Pessoa  implements Serializable{
    private int funcId;//numero de funcionario
    private String endereco;
    private String celular;
    private String email;
    private String cargo;
    private LocalDate dataContratacao;
    private float salario;
    private String horarioTrabalho;
    private boolean status; //funcionario no ativo ou nao!
    private String loginName;//nome de utilizador de acesso ao sistema
    private String loginPwd;//Palavra-passe de acesso ao sistema
    private boolean accessPermiss;//permissao de acesso ao sistema!
    private String historico;
    private String obs;//observacaoes
    public static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    Scanner sc= new Scanner(System.in);
    

    public Funcionario(){}


    public Funcionario(int funcId, String nome, Date dataNasc,String genero, String bi, String nacionalidade, String endereco, String celular, String email,String cargo, LocalDate dataContratacao, float salario, String horarioTrabalho, boolean status, String loginName, String loginPwd, boolean accessPermiss, String historico, String obs) {
        super(nome, dataNasc, genero, bi, nacionalidade);
        this.funcId = funcId;
        this.endereco = endereco;
        this.celular = celular;
        this.email = email;
        this.cargo=cargo;
        this.dataContratacao = dataContratacao;
        this.salario = salario;
        this.horarioTrabalho = horarioTrabalho;
        this.status = status;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.accessPermiss = accessPermiss;
        this.historico = historico;
        this.obs = obs;
    }

    //Metodos acessores, getters and setters
    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataContratacao() {
        return this.dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public float getSalario() {
        return this.salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getHorarioTrabalho() {
        return this.horarioTrabalho;
    }

    public void setHorarioTrabalho(String horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

    public boolean isStatus() {
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


    public boolean isAccessPermiss() {
        return this.accessPermiss;
    }

    public boolean getAccessPermiss() {
        return this.accessPermiss;
    }

    public void setAccessPermiss(boolean accessPermiss) {
        this.accessPermiss = accessPermiss;
    }

    public String getHistorico() {
        return this.historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getObs() {
        return this.obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }


    public int getFuncId() {
        return this.funcId;
    }

    public void setFuncId(int funcId) {
        this.funcId = funcId;
    }


    public void confimarConsulta(){//confirmar umna consulta agendada (confirmada, cancelada, adiada..)

    }

    public void monitorarSistema(){//mostrar uma visao geral so sistema

    }

    //metodo para imprimir os dados do Funcionario
    @Override
    public void imprimeDados(){
        for(Funcionario fc: funcionarios){
            System.out.println("\n"+
                "Codigo de funcionario:\t\t "+fc.getFuncId()+ "\n" +
                "Nome:\t\t\t\t "+fc.getNome()+ "\n" +
                "Data de nascimento:\t\t "+fc.getDataNasc()+ "\n" +
                "Genero:\t\t\t\t "+fc.getGenero()+ "\n" +
                "Numero de bilhete de identidade: "+fc.getBi()+ "\n" +
                "Nacionalidade:\t\t\t "+fc.getNacionalidade()+ "\n" +
                "Endereco:\t\t\t " + fc.getEndereco() + "\n" +
                "Celular:\t\t\t " + fc.getCelular() + "\n" +
                "Email:\t\t\t\t " + fc.getEmail() + "\n" +
                "Data de contratacao:\t\t " + fc.getDataContratacao() + "\n" +
                "Salario:\t\t\t " + fc.getSalario() + "\n" +
                "Horario de trabalho:\t\t " + fc.getHorarioTrabalho() + "\n" +
                "Status:\t\t\t\t " + fc.isStatus() + "\n" +
                "Nome de utilizador:\t\t\t " + fc.getLoginName() + "\n" +
                "Permissao de acesso:\t\t " + fc.isAccessPermiss() + "\n" +
                "Observacoes:\t\t\t " + fc.getObs() + "\n"
            );
        }
    }

    public static void salvarDados(ArrayList<Funcionario> obj1, ArrayList<Paciente> obj2, String fileName){
        try {
            // Criar um FileOutputStream para escrever no arquivo .dat
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);

            // Criar um ObjectOutputStream para escrever objetos no FileOutputStream
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            if(obj1.equals(null)){
             // Escrever objeto no arquivo
                objectOutputStream.writeObject(obj2);
                System.out.println("Objeto Paciente salvo em "+fileName);
            }
            else if(obj2.equals(null)){
                // Escrever objeto no arquivo
                objectOutputStream.writeObject(obj1);
                System.out.println("Objeto Funcionario salvo em "+fileName);
            }
            else
                System.out.println("Nao pode gravar dois ojectos em simultaneo. Atencao!");
            
            // Fechar fluxos
            objectOutputStream.close();
            fileOutputStream.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
