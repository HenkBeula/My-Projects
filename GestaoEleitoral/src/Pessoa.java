/****
 * @author Henk Beula
 ***/

public abstract class Pessoa{
    protected String name;
    protected String gender;
    protected String birthDate;
    protected int id;
    protected String nationality;


    public Pessoa() {
    }

    public Pessoa(String name, String gender, String birthDate, int id, String nationality) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.id = id;
        this.nationality = nationality;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Pessoa name(String name) {
        setName(name);
        return this;
    }

    public Pessoa gender(String gender) {
        setGender(gender);
        return this;
    }

    public Pessoa birthDate(String birthDate) {
        setBirthDate(birthDate);
        return this;
    }

    public Pessoa id(int id) {
        setId(id);
        return this;
    }

    public Pessoa nationality(String nationality) {
        setNationality(nationality);
        return this;
    }

    public abstract String toString();

    
    
}
