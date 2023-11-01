package src.personel;
import java.sql.Date;

/****
 * @author 
 ***/

public abstract class Pessoa{
    protected String nome;
    protected Date dataNasc;
    protected String genero;
    protected String bi;//numero de bilhete de de identidade
    protected String nacionalidade;
    
    

    public Pessoa(){}//metodo contrutor vazio

    public Pessoa(String nome, Date dataNasc, String genero, String bi, String nacionalidade){//metodo construtor com parametros
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.bi = bi;
        this.nacionalidade = nacionalidade;
    }

    public String getNome(){
        return this.nome;
    }

    public Date getDataNasc(){
        return this.dataNasc;
    }

    public String getBi(){
        return this.bi;
    }

    public String getNacionalidade(){
        return this.nacionalidade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }


    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }    

    public void setDataNasc(Date dataNasc){
        this.dataNasc = dataNasc;
    }

    public void setBi(String bi){
        this.bi = bi;
    }

    public void setNacionalidade(String nacionalidade){
        this.nacionalidade = nacionalidade;
    }

    //metodo abstracto
    public abstract void imprimeDados();

    //public abstract int pinGen();

    //protected abstract void salvarDados(Pessoa obj, String fileName);
}
