/**
 *
 * @author Helder Campos
 */
public class Candidato extends Pessoa{
    private int numeroDeCandidato;
    private String endereco;
    private String partidoPolitico;
    private String estadoDaCandidatura; //aprovada, pendente, rejeitada
    private int voto;


    public Candidato() {
    }

    public Candidato(String name, String gender, String birthDate, int id, String nationality, int numeroDeCandidato, String endereco, String partidoPolitico, String estadoDaCandidatura) {
        super(name, gender, birthDate, id, nationality);
        this.numeroDeCandidato = numeroDeCandidato;
        this.endereco = endereco;
        this.partidoPolitico = partidoPolitico;
        this.estadoDaCandidatura = estadoDaCandidatura;
    }

    public int getNumeroDeCandidato() {
        return this.numeroDeCandidato;
    }

    public void setNumeroDeCandidato(int numeroDeCandidato) {
        this.numeroDeCandidato = numeroDeCandidato;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPartidoPolitico() {
        return this.partidoPolitico;
    }

    public void setPartidoPolitico(String partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public String getEstadoDaCandidatura() {
        return this.estadoDaCandidatura;
    }

    public void setEstadoDaCandidatura(String estadoDaCandidatura) {
        this.estadoDaCandidatura = estadoDaCandidatura;
    }

    public Candidato numeroDeCandidato(int numeroDeCandidato) {
        setNumeroDeCandidato(numeroDeCandidato);
        return this;
    }

    public Candidato endereco(String endereco) {
        setEndereco(endereco);
        return this;
    }

    public Candidato partidoPolitico(String partidoPolitico) {
        setPartidoPolitico(partidoPolitico);
        return this;
    }

    public Candidato estadoDaCandidatura(String estadoDaCandidatura) {
        setEstadoDaCandidatura(estadoDaCandidatura);
        return this;
    }


    @Override
    public String toString(){
        return "\n"+getName() + " " + getGender() + " " + getBirthDate() + " " + 0 + " " + getNationality() + " " + getNumeroDeCandidato() + " " + getEndereco() + " " + getPartidoPolitico() + " " + getEstadoDaCandidatura();
    }
    
}
