package src.File;
/**
 * @author HCG
 * This class manipulates object files
 */
import java.io.*;
public class ObjectsFile {
	private ObjectInputStream iS;
	private ObjectOutputStream oS;

	public boolean objOpenToRead (String fileName) throws IOException {
		try{
			iS = new ObjectInputStream (new FileInputStream(fileName));
			return true;
		}catch(IOException e){
			return false;
		}
	}

	public void objOpen4Write (String fileName, boolean append) throws IOException {
		oS = new ObjectOutputStream (new FileOutputStream(fileName, append));//best practice, leave append as false
	}

	public Object readFromObj () throws IOException, ClassNotFoundException {
		return iS.readObject();
	}


	public void write2Obj (Object o) throws IOException {
		oS.writeObject(o);
		}


	public void objCloseRead() throws IOException {
		iS.close();
	}

	public void objCloseWrite() throws IOException {
		oS.close();
	}

    public ObjectInputStream getiS() {
        return iS;
    }

    public void setiS(ObjectInputStream iS) {
        this.iS = iS;
    }

    public ObjectOutputStream getoS() {
        return oS;
    }

    public void setoS(ObjectOutputStream oS) {
        this.oS = oS;
    }     
}