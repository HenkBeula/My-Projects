/**
 *
 * @author Helder Campos
 */

public class Voto {
    private int numEleitor;
    private int numCandidato;
    private String DataHoraVoto;
    private int votoId;


    public Voto() {
    }

    public Voto(int numEleitor, int numCandidato, String DataHoraVoto, int votoId) {
        this.numEleitor = numEleitor;
        this.numCandidato = numCandidato;
        this.DataHoraVoto = DataHoraVoto;
        this.votoId = votoId;
    }

    public int getNumEleitor() {
        return this.numEleitor;
    }

    public void setNumEleitor(int numEleitor) {
        this.numEleitor = numEleitor;
    }

    public int getNumCandidato() {
        return this.numCandidato;
    }

    public void setNumCandidato(int numCandidato) {
        this.numCandidato = numCandidato;
    }

    public String getDataHoraVoto() {
        return this.DataHoraVoto;
    }

    public void setDataHoraVoto(String DataHoraVoto) {
        this.DataHoraVoto = DataHoraVoto;
    }

    public int getVotoId() {
        return this.votoId;
    }

    public void setVotoId(int votoId) {
        this.votoId = votoId;
    }

    public Voto numEleitor(int numEleitor) {
        setNumEleitor(numEleitor);
        return this;
    }

    public Voto numCandidato(int numCandidato) {
        setNumCandidato(numCandidato);
        return this;
    }

    public Voto DataHoraVoto(String DataHoraVoto) {
        setDataHoraVoto(DataHoraVoto);
        return this;
    }

    public Voto votoId(int votoId) {
        setVotoId(votoId);
        return this;
    }

    @Override
    public String toString() {
        return "\n"+getNumEleitor()+ " " + getNumCandidato() + " " + getDataHoraVoto() + " " + getVotoId();
    }
    

}
