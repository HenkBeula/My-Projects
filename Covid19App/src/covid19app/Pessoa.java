/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid19app;
import java.util.Date;
/**
 *
 * @author Henk Beula
 */
public class Pessoa {
    protected String nome;
    protected String sexo;
    protected Date dataNascimento;

    public Pessoa(String nome, String sexo, Date dataNascimento) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public Pessoa() {
    }
    

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString(){
        return getNome()+","+getSexo()+","+getDataNascimento()+"\n";
    }
    
    
}
