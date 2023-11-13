import java.io.Serializable;
/**
 * @Author Henk Beula
 */
public class Eleitor  extends Pessoa implements Serializable{
    private int numeroDeEleitor;
    private String endereco;
    private boolean votou;

    public Eleitor() {
    }

    public Eleitor(String name, String gender, String birthDate, int id, String nationality, int numeroDeEleitor, String endereco, boolean votou) {
        super(name, gender, birthDate, id, nationality);
        this.numeroDeEleitor = numeroDeEleitor;
        this.endereco = endereco;
        this.votou = votou;
    }


    public boolean isVotou() {
        return this.votou;
    }

    public boolean getVotou() {
        return this.votou;
    }

    public void setVotou(boolean votou) {
        this.votou = votou;
    }

    public int getNumeroDeEleitor() {
        return this.numeroDeEleitor;
    }

    public void setNumeroDeEleitor(int numeroDeEleitor) {
        this.numeroDeEleitor = numeroDeEleitor;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Eleitor numeroDeEleitor(int numeroDeEleitor) {
        setNumeroDeEleitor(numeroDeEleitor);
        return this;
    }

    public Eleitor endereco(String endereco) {
        setEndereco(endereco);
        return this;
    }    

    

    @Override
    public String toString(){
        return "\n"+getName() + " " + getGender()+ " " +getBirthDate()+ " " + 0+ " " +getNationality()+ " " +getNumeroDeEleitor()+ " " +getEndereco()+ " " + getVotou();
    }

}
