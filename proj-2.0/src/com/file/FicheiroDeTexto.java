package com.file;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;

public class FicheiroDeTexto {
    private BufferedReader readCh;
    private InputStream readLn;
    private FileWriter writeCh;
    private FileWriter writeLn;

    /**************************************/
    /*Start char by char file manipulation */
    /**************************************/
    public boolean open4ReadChar (String fileName) throws IOException {
        try{
            readCh = new BufferedReader(new FileReader(fileName));
            return true;
        }catch(IOException e){
            return false;
        }
    }

    public boolean open4WriteChars (String fileName) throws IOException {
        try{
            writeCh = new FileWriter(fileName);
            return true;
        }catch(IOException e){
            return false;
        }
    }

    public int readChar() throws IOException{
        return readCh.read();
    }

    public void writeChars(String ch) throws IOException{
        writeCh.append(ch);
    } 

    public void closeReadChar() throws IOException{
        readCh.close();
    }

    public void closeWriteCh() throws IOException{
        writeCh.close();
    }
    /**************************************/
    /*End char by char file manipulation*/
    /**************************************/


    /**************************************/
    /*Start line by line file manipulation */
    /**************************************/
    public boolean open4ReadLine (String fileName) throws IOException {
        try{
            readLn = new FileInputStream(fileName);
            return true;
        }catch(IOException e){
            return false;
        }
    }

    public boolean open4WriteLinesNoOveride (String fileName) throws IOException {
        try{
            writeLn = new FileWriter(fileName, true);
            return true;
        }catch(IOException e){
            return false;
        }
    }

    public boolean open4WriteLines (String fileName) throws IOException {
        try{
            writeLn = new FileWriter(fileName);
            return true;
        }catch(IOException e){
            return false;
        }
    }

    public String readLine(){
        int count = 0;
        StringBuilder bld = new StringBuilder();
        try (Scanner sc = new Scanner(readLn, StandardCharsets.UTF_8.name())){
            while(sc.hasNextLine()){
                bld.append(sc.nextLine()+"\n");
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Sao no total "+count+" linhas\n");
        return bld.toString();
    }

    public void writeLines(String data) throws IOException{
            writeLn.append(data);
    }

    public void closeReadLine() throws IOException{
        readLn.close();
    }

    public void closeWriteLines() throws IOException{
        writeLn.close();
    }
    /**************************************/
    /*End line by line file manipulation */
    /**************************************/
}
