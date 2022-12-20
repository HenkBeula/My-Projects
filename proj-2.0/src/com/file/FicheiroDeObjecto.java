package com.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FicheiroDeObjecto {
    private ObjectInputStream iS;
	private ObjectOutputStream oS;

	public boolean openToRead (String fileName) throws IOException, FileNotFoundException {
		try{
			iS = new ObjectInputStream (new FileInputStream(fileName));
			return true;
		}catch(IOException e){
			return false;
		}
	}

	public void open4Write (String fileName) throws IOException {
		oS = new ObjectOutputStream (new FileOutputStream(fileName));
	}

	public Object readObj () throws IOException, ClassNotFoundException, NullPointerException {
		return iS.readObject();
	}

	public void writeObj (Object o) throws IOException {
		oS.writeObject(o);
		}

	public void closeRead() throws IOException {
		iS.close();
	}

	public void closeWrite() throws IOException {
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
