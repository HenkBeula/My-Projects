import java.io.Serializable;
/**
 * @author Henk Beula
 */
public class Estudante implements Serializable{
    //atributos da classe
    private short num;
    private String nome;
    private float nota1;
    private float nota2;
    private float notaExame;
    private double media;
    private String obs;

    //contrutor da classe
    public Estudante(short num, String nome, float nota1, float nota2, float notaExame, double media, String obs) {
        this.num = num;
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.notaExame = notaExame;
        this.media = media;
        this.obs = obs;
    }

    public Estudante(){}

    public float getNotaExame() {
        return notaExame;
    }
    public void setNotaExame(float notaExame) {
        this.notaExame = notaExame;
    }
    public short getnum() {
        return this.num;
    }
    public void setnum(short num) {
        this.num = num;
    }
    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getobs() {
        return this.obs;
    }
    public void setobs(String obs) {
        this.obs = obs;
    }
    public float getNota1() {
        return this.nota1;
    }
    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }
    public float getNota2() {
        return this.nota2;
    }
    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }
    public double getMedia() {
        return this.media;
    }
    
    //calcula a media para saber se exclui, vai ao exame ou aprova
    public void setMedia(float nota1, float nota2) {
        double mediaAritmetica;
        mediaAritmetica=Math.round((nota1+nota2)/2);
        this.media = mediaAritmetica;
    }

    //calcula a media depois do exame, para saber se aprova ou reprova
    public void setMedia(float nota1, float nota2, float notaExame) {
        double mediaAritmetica;
        mediaAritmetica=Math.round((nota1+nota2+notaExame)/3);
        this.media = mediaAritmetica;
    }

    @Override
    public String toString(){
        return "\n"+getnum() + " " + getNome() + " " + getNota1() + " " + getNota2() + " " + getNotaExame() + " " + getMedia() + " " + getobs();
    }
}