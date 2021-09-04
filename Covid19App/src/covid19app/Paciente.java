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
public class Paciente extends Pessoa {
    private int numero;
    private Date dataTeste;
    private int codigoLocalTeste;
    private String codigoResultado;
    private String codigoSitFinal;
    private Date dataSitFinal;

    public Paciente(int numero, String nome, String sexo, Date dataNascimento, Date dataTeste, int codigoLocalTeste) {
        super(nome, sexo, dataNascimento);
        this.numero = numero;
        this.dataTeste = dataTeste;
        this.codigoLocalTeste = codigoLocalTeste;
    }

    public Paciente() {
    }
    
    
    /**
     *
     * @return
     */
    public int getNumero() {
        return numero;
    }
    /**
     *
     * @return
     */
    @Override
    public String getNome() {
        return nome;
    }
    /**
     *
     * @return
     */
    @Override
    public String getSexo() {
        return sexo;
    }
    /**
     *
     * @return
     */
    @Override
    public Date getDataNascimento() {
        return dataNascimento;
    }
    /**
     *
     * @return
     */
    public Date getDataTeste() {
        return dataTeste;
    }
    /**
     *
     * @return
     */
    public int getCodigoLocalTeste() {
        return codigoLocalTeste;
    }
    /**
     *
     * @return
     */
    public String getCodigoResultado() {
        return codigoResultado;
    }
    /**
     *
     * @return
     */
    public String getCodigoSitFinal() {
        return codigoSitFinal;
    }
    /**
     *
     * @return
     */
    public Date getDataSitFinal() {
        return dataSitFinal;
    }
    /**
     *
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    /**
     *
     * @param nome
     */
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     *
     * @param sexo
     */
    @Override
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     *
     * @param dataNascimento
     */
    @Override
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     *
     * @param dataTeste
     */
    public void setDataTeste(Date dataTeste) {
        this.dataTeste = dataTeste;
    }

    /**
     *
     * @param codigoLocalTeste
     */
    public void setCodigoLocalTeste(int codigoLocalTeste) {
        this.codigoLocalTeste = codigoLocalTeste;
    }

    /**
     *
     * @param codigoResultado
     */
    public void setCodigoResultado(String codigoResultado) {
        this.codigoResultado = codigoResultado;
    }

    /**
     *
     * @param codigoSitFinal
     */
    public void setCodigoSitFinal(String codigoSitFinal) {
        this.codigoSitFinal = codigoSitFinal;
    }

    /**
     *
     * @param dataSitFinal
     */
    public void setDataSitFinal(Date dataSitFinal) {
        this.dataSitFinal = dataSitFinal;
    }
    
    @Override
    public String toString(){
        return getNome()+","+getNumero()+","+getSexo()+","+getDataNascimento()+","+getDataTeste()
                +","+getCodigoLocalTeste()+","+getCodigoResultado()+","+getCodigoSitFinal()+","+getDataSitFinal()+"\n";
    }
}