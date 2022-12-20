import java.io.Serializable;
import java.util.Date;
public class Estudante implements Serializable{
    private int id;
    private String fullName;
    private Date dataNasc;
    private String genero;
    private String curso;
    private float nota1;
    private float nota2;
    private float media;

    public Estudante(int id, String fullName, Date dataNasc, String genero, String curso, float nota1, float nota2, float media) {
        this.id = id;
        this.fullName = fullName;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.curso = curso;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.media = media;
    }

    public Estudante(int id, String fullName, Date dataNasc, String genero, String curso) {
        this.id = id;
        this.fullName = fullName;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.curso = curso;
    }

    public Estudante(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFirstName(String fullName){
        String fname [] = fullName.split(" ");
        return fname[0];
    }

    public String getLastName(String fullName){
        String lname []= fullName.split(" ");
        return lname[lname.length - 1];
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return id +","+ fullName + "," + dataNasc + "," + genero + "," + curso + "," + nota1 + "," + nota2 +"," + media + "\n";
    }
}