/*
 * This class manipulate text files
 */
import java.io.*;
/**
 *
 * @author  Helder Campos
 */
public class TextFile {
    private FileWriter wr;
    private FileReader rd;

    public boolean open4Read (String fileName) throws IOException {
		try{
			rd = new FileReader(fileName);
			return true;
		}catch(IOException e){
			return false;
		}
	}

	public void open4Write (String fileName, boolean append) throws IOException {
		wr = new FileWriter(fileName, append);
	}

	
	public Object readFromFile () throws IOException, ClassNotFoundException {
		return rd.read();
	}


	public void write2File (String o) throws IOException {
		wr.write(o);
	}


	public void closeRead() throws IOException {
		rd.close();
	}

	public void closeWrite() throws IOException {
		wr.close();
	}

    public FileReader getRd() {
        return rd;
    }

    public void setRd(FileReader rd) {
        this.rd = rd;
    }

    public FileWriter getWr() {
        return wr;
    }

    public void setWr(FileWriter wr) {
        this.wr = wr;
    }

	public void cleanFile(String path){
	}
}
