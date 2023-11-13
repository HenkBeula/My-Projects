import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import java.io.*;
/**
 * @author  Henk Beula
 */
public class GestaoEleitoral{
    static Eleitor [] eleitor = new Eleitor[1];
    static Eleitor [] outEl;
    static Candidato [] candidato = new Candidato[1];
    static Candidato [] outCand;
    static Voto [] voto = new Voto[1];
    static Voto [] outVot;
    static Scanner sc = new Scanner(System.in);
    static UIManager UI=new UIManager();


    public static void registarEleitor(){//metodo para registar os dados dos Eleitores
        Eleitor reg = new Eleitor();
        byte cont;
        //Registrar os Eleitores
        do{
            //int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do Eleitor:"));
            reg.setNumeroDeEleitor(genId(eleitorFich2Array()));
            /*for (Eleitor el : eleitorFich2Array()) {
                if(num==el.getNumeroDeEleitor()){
                    JOptionPane.showMessageDialog(null, "Ja existe um eleitor com este numero");
                    menu();
                    return;//ignorar o resto e terminar o metodo
                }
            }*/
            reg.setName(JOptionPane.showInputDialog("Indique o nome do Eleitor:"));
            reg.setGender(JOptionPane.showInputDialog("Indique o genero do Eleitor:"));
            reg.setBirthDate(JOptionPane.showInputDialog("Indique a data de nascimento do Eleitor\\n Use o formato DD/MM/AAAA:"));
            reg.setNationality(JOptionPane.showInputDialog("Indique a nacionalidade do Eleitor:"));
            reg.setEndereco(JOptionPane.showInputDialog("Indique o endereco do Eleitor:"));
            JOptionPane.showMessageDialog(null, "O id do Eleitor e "+reg.getNumeroDeEleitor(), "Gestao Eleitoral", JOptionPane.INFORMATION_MESSAGE);

            eleitor[0]= new Eleitor(reg.getName(), reg.getGender(), reg.getBirthDate(), 0, reg.getNationality(), reg.getNumeroDeEleitor(), reg.getEndereco(), false);
            cont = Byte.parseByte(JOptionPane.showInputDialog("1.Continuar         \n"+"2.Sair              "));
            try {
                TextFile fich = new TextFile();
                fich.open4Write("src//Ficheiros//Eleitores.txt", true);
                fich.write2File(eleitor[0].toString());
                fich.closeWrite();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }while(cont!=2);
        menu(); 
    }

    public static int genId(Candidato [] arr){//para gerar automaticamente o id do candidato
        int id = 0;
        for (Candidato ids : arr) {
            if(ids!=null)
                id=ids.getNumeroDeCandidato();
        }
        return ++id;
    }

    public static int genId(Eleitor [] arr){//para gerar automaticamente o id do eleitor
        int id = 0;
        for (Eleitor ids : arr) {
            if(ids!=null)
                id=ids.getNumeroDeEleitor();
        }
        return ++id;
    }

    public static void registarCandidato(){//metodo para registar os dados dos Candidatos
        Candidato reg = new Candidato();
        byte cont;
        //Registrar os Candidatos
        do{

            //int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do candidato:"));
            reg.setNumeroDeCandidato(genId(candidatoFich2Array()));
            /*for (Eleitor el : eleitorFich2Array()) {
                if(num==el.getNumeroDeEleitor()){
                    JOptionPane.showMessageDialog(null, "Ja existe um candidato com este numero");
                    menu();
                    return;//ignorar o resto e terminar o metodo
                }
            }*/
            reg.setName(JOptionPane.showInputDialog("Digite o nome do candidato:"));
            reg.setGender(JOptionPane.showInputDialog("Digite o genero do candidato:"));
            reg.setBirthDate(JOptionPane.showInputDialog("Digite a data de nacimento do candidato\n Use o formato DD/MM/AAAA:"));
            reg.setNationality(JOptionPane.showInputDialog("Digite a nacionalidade do candidato:"));
            reg.setEndereco(JOptionPane.showInputDialog("Digite o endereco do candidato:"));
            reg.setPartidoPolitico(JOptionPane.showInputDialog("Digite o partido politico do candidato:"));
            reg.setEstadoDaCandidatura("Aprovado");
            JOptionPane.showMessageDialog(null, "O id do Candidato e "+reg.getNumeroDeCandidato(), "Gestao Eleitoral", JOptionPane.INFORMATION_MESSAGE);

            candidato[0]= new Candidato(reg.getName(), reg.getGender(), reg.getBirthDate(), 0, reg.getNationality(), reg.getNumeroDeCandidato(), reg.getEndereco(), reg.getPartidoPolitico(), reg.getEstadoDaCandidatura());
            cont = Byte.parseByte(JOptionPane.showInputDialog("1.Continuar         \n"+"2.Sair              "));
            try {
                TextFile fich = new TextFile();
                fich.open4Write("src//Ficheiros//Candidatos.txt", true);
                fich.write2File(candidato[0].toString());
                fich.closeWrite();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }while(cont!=2);
        menu(); 
    }

    public static void Votar(){//metodo para votar candidato
        Eleitor votar = new Eleitor();
        //Candidato condidato = new Candidato();
        byte cont;
        do{
            int num = Short.parseShort(JOptionPane.showInputDialog("Digite o codigo do Eleitor:"));
            for (Eleitor el : eleitorFich2Array()) {
                if(el!=null && num==el.getNumeroDeEleitor() && el.getVotou()==true){
                    JOptionPane.showMessageDialog(null, "Eleitor ja votou");
                    menu();
                    return;//ignorar o resto e terminar o metodo
                }
            }
            estadoDeVotoDeEleitor(num);
            Voto vot = new Voto();
            vot.setNumEleitor(num);
            vot.setNumCandidato(Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do candidato:")));
            vot.setDataHoraVoto(JOptionPane.showInputDialog("Indique a hora de voto, use o formato DD/MM/AAAA:HH:MM:"));
            vot.setVotoId(0);

            voto[0]= new Voto(vot.getNumEleitor(), vot.getNumCandidato(), vot.getDataHoraVoto(), vot.getVotoId());
            cont = Byte.parseByte(JOptionPane.showInputDialog("1.Continuar         \n"+"2.Sair              "));
            try {
                TextFile fich = new TextFile();
                fich.open4Write("src//Ficheiros//Votos.txt", true);
                fich.write2File(voto[0].toString());
                fich.closeWrite();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }while(cont!=2);
        menu(); 
    }

    public static void exitMethod() {
        // Your method logic here
        return; // Exits the method prematurely
    }

    public static void menu() throws InputMismatchException, NumberFormatException{//menu principal do programa
        UIManager.put("OptionPane.background",new ColorUIResource(150,150,150));
        UIManager.put("Panel.background",new ColorUIResource(255,255,255));
        int stop=1;
            do{
                short entrada=0;
                try {
                    entrada =Short.parseShort(JOptionPane.showInputDialog(null,
                    ("1. Registar Eleitor                            \n"
                    +"2. Registar Candidato                          \n"
                    +"3. Votar                                       \n"
                    +"4. Imprimir lista de Eleitores e Candidatos    \n"
                    +"5. Imprimir Resultados                         \n"
                    +"6. Procurar Eleitor                            \n"
                    +"7. Procurar Candidato                            \n"
                    +"0. Sair                                        \n"
                    +"Escolha uma opcao"), "Gestao Eleitoral",JOptionPane.INFORMATION_MESSAGE));

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Opcao invalida!", "Gestao Eleitoral", JOptionPane.ERROR_MESSAGE);
                    menu();
                }
                switch (entrada) {
                    case 1:
                        //some method
                        registarEleitor();
                        stop = 0;//assim que o metodo associado e invocado, este metodo (menu()) termina.
                        break;
                    
                    case 2:
                        //some method
                        registarCandidato();//registar candidatos 
                        menu();//Apos mostrar  alunos inscritos, volta para o menu principal do programa
                        stop = 0;
                        break;
                    
                    case 3:
                        //some method
                        Votar();
                        stop = 0;
                        break;
                    
                    case 4:
                        //Imprimir lista de Eleitores e Candidatos
                        imprimirDados();
                        menu();
                        stop = 0;
                    
                    case 5:
                        imprimirResultados();
                        menu();
                        stop = 0;
                        break;
                    
                    case 6:
                        //some procurar Eleitor
                        int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do eleitor que pretende ver"));
                        GestaoEleitoral.procurarEleitor(num);
                        menu();
                        stop = 0;
                        break;
                    
                    case 0:
                        stop = 0;
                        break;
                    
                    case 7:
                        //some procurar candidato
                        int nume = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do canditato que pretende ver"));
                        GestaoEleitoral.procurarCandidato(nume);
                        menu();
                        stop = 0;
                        break;
                    
                    default: JOptionPane.showMessageDialog(null, "Opcao inexistente! \n tente novamente","Gestao Eleitoral",JOptionPane.ERROR_MESSAGE);// caso uma opcao enexistente no menu seja introduzida
                        break;
                }
            }while(stop!=0);
    }

    public static void procurarCandidato(int numeroCandidato){
        boolean encontrado = false;
        for(Candidato regist: candidatoFich2Array()) {
            try {
                if(regist.getNumeroDeCandidato() == numeroCandidato){
                    JOptionPane.showMessageDialog(null,"              Candidato encontrado\n"+ "        Nome: "+regist.getName() + "     Genero: " + regist.getGender() + "      Data de aniversario: " + regist.getBirthDate() + "   id: " + 0 + "   Nacionalidade" + regist.getNationality() +
                    "     Numero de Candidato: " + regist.getNumeroDeCandidato() + "   Endereco" + regist.getEndereco() + "    Endereco:" + regist.getPartidoPolitico() + "     Estado da candidatura" + regist.getEstadoDaCandidatura());
                    encontrado=true;
                    break;
                }
            } catch (NullPointerException e) {//to handle NullPointerException cause of an empty line on the txt file
                //TODO: handle exception
            }
        }
        if(!encontrado)
            JOptionPane.showMessageDialog(null,"Canditato nao encontrado","Gestao Eleitoral",JOptionPane.INFORMATION_MESSAGE);
    }

    public static void procurarEleitor(int numeroEleitor){
        boolean encontrado = false;
        for(Eleitor regist: eleitorFich2Array()) {
            try {
                if(regist.getNumeroDeEleitor() == numeroEleitor){
                    JOptionPane.showMessageDialog(null,"              Candidato encontrado\n"+ "        Nome: "+regist.getName() + "   Genero:" + regist.getGender()+ "   Data de aniversario: " 
                +regist.getBirthDate()+ "   Id: " + 0+ "      Nacionalidede" +regist.getNationality()+ "    Numero de eleitor: " +regist.getNumeroDeEleitor()+ "    Endereco: " +regist.getEndereco());
                    encontrado=true;
                    break;
                }
            } catch (NullPointerException e) {//to handle NullPointerException cause of an empty line on the txt file
                //TODO: handle exception
            }
        }
        if(!encontrado)
            JOptionPane.showMessageDialog(null,"Eleitor nao encontrado","Gestao Eleitoral",JOptionPane.INFORMATION_MESSAGE);
    }


    public static void imprimirDados(){//Imprime todos os dados dos eleitores e candidatos
        String data="Eleitores\n";
        
        for(Eleitor dados: eleitorFich2Array()) {
            String votou="Nao votou";
            try {
                if(dados.getVotou()==true)
                    votou="Votou";

                data+="Nome: "+dados.getName() + "   Genero: " + dados.getGender()+ "   Data de aniversario: " 
                +dados.getBirthDate()+ "   Id: " + 0+ "      Nacionalidede: " +dados.getNationality()+ "    Numero de eleitor: " +dados.getNumeroDeEleitor()+ "    Endereco: " +dados.getEndereco()+"    Estado de voto: "+votou+"\n";
            } catch (NullPointerException e) {
                //TODO: handle exception
                System.err.println(e);
            }
        }

        data+="\n\nCandidatos\n";
        for(Candidato dados: candidatoFich2Array()) {
            try {
                data+="Nome: "+dados.getName() + "     Genero: " + dados.getGender() + "      Data de aniversario: " + dados.getBirthDate() + "   id: " + 0 + "   Nacionalidade: " + dados.getNationality() +
                "     Numero de Candidato: " + dados.getNumeroDeCandidato() + "   Endereco: " + dados.getEndereco() + "    Endereco: " + dados.getPartidoPolitico() + "     Estado da candidatura: " + dados.getEstadoDaCandidatura()+"\n";
            } catch (NullPointerException e) {
                //TODO: handle exception
            }
        }
        JOptionPane.showMessageDialog(null,data);
        
    }

    public static Eleitor[] eleitorFich2Array(){
        int linhas=0;
        Eleitor [] es;
        try {
            File fich = new File("src//Ficheiros//Eleitores.txt");
            Scanner sc = new Scanner(fich);
            Scanner cs = new Scanner(fich);
            while(cs.hasNextLine()){//para contar as linhas do ficheiro, para que se possa dimensionar o array(uma linha = um eleitor)
                String data = cs.nextLine();
                linhas++;
            }
            cs.close();
            es = new Eleitor[linhas];
            int i=0;
            while(sc.hasNext()){//A bloco do metodo registarNota(), que elimina a primeira linha vazia no ficheiro,
                                //cria uma outra linha vazia no fim do ficheiro, entao neste ciclo, para desconsiderar a tal linha vazia 
                                //e evitar retornar um dado null, utiliza-se o metodo hasNext(), que procura apenas se existe 
                                //um proximo simbolo no ficheiro, ignorando os espacos/linhas vazias.
                es[i++]= new Eleitor(sc.next(), sc.next(),sc.next(),Integer.parseInt(sc.next()),sc.next(),Integer.parseInt(sc.next()),sc.next(),Boolean.parseBoolean(sc.next()));
            }
            sc.close();
            return es;
        } catch (Exception e) {
            //TODO: handle exception
            JOptionPane.showMessageDialog(null,"Erro ao ler ficheiro","Gestao Eleitoral",JOptionPane.ERROR_MESSAGE);
        }
        return new Eleitor[0];
    }

    public static Candidato[] candidatoFich2Array(){
        int linhas=0;
        Candidato [] es;
        try {
            File fich = new File("src//Ficheiros//Candidatos.txt");
            Scanner sc = new Scanner(fich);
            Scanner cs = new Scanner(fich);
            while(cs.hasNextLine()){//para contar as linhas do ficheiro, para que se possa dimensionar o array(uma linha = um candidato)
                String data = cs.nextLine();
                linhas++;
            }
            cs.close();
            es = new Candidato[linhas];
            int i=0;
            while(sc.hasNext()){//A bloco do metodo registarNota(), que elimina a primeira linha vazia no ficheiro,
                                //cria uma outra linha vazia no fim do ficheiro, entao neste ciclo, para desconsiderar a tal linha vazia 
                                //e evitar retornar um dado null, utiliza-se o metodo hasNext(), que procura apenas se existe 
                                //um proximo simbolo no ficheiro, ignorando os espacos/linhas vazias.
                es[i++]= new Candidato(sc.next(),sc.next(),sc.next(),Integer.parseInt(sc.next()),sc.next(),Integer.parseInt(sc.next()),sc.next(),sc.next(),sc.next());
            }
            sc.close();
            return es;
        } catch (Exception e) {
            //TODO: handle exception
            JOptionPane.showMessageDialog(null,"Erro ao ler ficheiro","Gestao Eleitoral",JOptionPane.ERROR_MESSAGE);
            System.err.println(e);
        }
        return new Candidato[0];
    }

    public static Voto[] votoFich2Array(){
        int linhas=0;
        Voto [] es;
        try {
            File fich = new File("src//Ficheiros//Votos.txt");
            Scanner sc = new Scanner(fich);
            Scanner cs = new Scanner(fich);
            while(cs.hasNextLine()){//para contar as linhas do ficheiro, para que se possa dimensionar o array(uma linha = um candidato)
                String data = cs.nextLine();
                linhas++;
            }
            cs.close();
            es = new Voto[linhas];
            int i=0;
            while(sc.hasNext()){//A bloco do metodo registarNota(), que elimina a primeira linha vazia no ficheiro,
                                //cria uma outra linha vazia no fim do ficheiro, entao neste ciclo, para desconsiderar a tal linha vazia 
                                //e evitar retornar um dado null, utiliza-se o metodo hasNext(), que procura apenas se existe 
                                //um proximo simbolo no ficheiro, ignorando os espacos/linhas vazias.
                es[i++]= new Voto(Integer.parseInt(sc.next()),Integer.parseInt(sc.next()),sc.next(),Integer.parseInt(sc.next()));
            }
            sc.close();
            return es;
        } catch (Exception e) {
            //TODO: handle exception
            JOptionPane.showMessageDialog(null,"Erro ao ler ficheiro","Gestao Eleitoral",JOptionPane.ERROR_MESSAGE);
        }
        return new Voto[0];
    }

    //imprimir resultados
    public static void imprimirResultados(){
        int countvoto=0, linhas=0, data;
        String nome="";
        int [] candidato;
        for(Candidato cand: candidatoFich2Array()){
            if(cand != null){
                data = cand.getNumeroDeCandidato();
                ++linhas;
            }
        }
        candidato =  new int[linhas];
        int i=0;
        for(Candidato cand: candidatoFich2Array()){
            if(cand != null)
                candidato[i++] = cand.getNumeroDeCandidato();
        }
        HashMap<String, Integer> resultados = new HashMap<String, Integer>();
        i=0;
        for (int j = 0; j < candidatoFich2Array().length; j++) {
            countvoto = 0;
            nome=candidatoFich2Array()[j].getName();
            for (Voto vot : votoFich2Array()) {
                
                if(candidatoFich2Array()[j]!=null && candidatoFich2Array()[j].getNumeroDeCandidato() == vot.getNumCandidato()){
                    //System.out.println(vot.getNumCandidato());
                    countvoto+=1;
                    nome = candidatoFich2Array()[j].getName();
                }
            }
            resultados.put(nome, countvoto);
        }

        for (Voto vot : votoFich2Array()) {
        }

        String res = "";
        for(String result: resultados.keySet()){
            res += "Nome do candidato: " + result + "  Numero de votos: "+ resultados.get(result)+"\n";
        }
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : resultados.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        JOptionPane.showMessageDialog(null,res+"\n\n"+maxEntry.getKey()+" esta a ganhar");

    }

    public static void estadoDeVotoDeEleitor(int num){//para registar as notas do alunos
        outEl = new Eleitor[eleitorFich2Array().length];
        boolean encontrado=false;
        int i=0;
        for(Eleitor e: GestaoEleitoral.eleitorFich2Array()){
            GestaoEleitoral.outEl[i++]=e;
        } 
        try {
            for(Eleitor t: outEl){
                if(t.getNumeroDeEleitor()==num){//se o numero introduzido for igual ao de algum eleitor..
                    t.setVotou(true);
                    encontrado=true;//confirma que foi encontrado
                    break;//e para toda a operacao
                }
            }
            if(!encontrado)
                JOptionPane.showMessageDialog(null,"Eleitor com codigo "+num+" nao existe.","Gestao Eleitoral",JOptionPane.INFORMATION_MESSAGE);
            else{
                try {//para regravar os dados atualizados no ficheiro
                    File fich = new File("src//Ficheiros//Eleitores.txt");
                    FileWriter wr = new FileWriter(fich);
                    for(int j=0;j<outEl.length;j++){
                            wr.write(String.valueOf(outEl[j]));
                    }
                    wr.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Erro ao gravar no ficheiro","Gestao Eleitoral",JOptionPane.ERROR_MESSAGE);
                            //TODO: handle exception
                }
                try {//Para corregir um erro de leitura do ficheiro. Quando os dados atualizados sao armazenados no ficheiro,
                    //uma um paragrafo vazio e criado na primeira linha do ficheiro, e isso dava problema com o metodo fich2Array(),
                    //que faz a leitura do ficheiro para o array, como logo a primeira linha estava vazia, era retornado um dado nulo, o que causava o erro.
                    //Este bloco elimina a tal primeiram linha vazia.
                    File fich = new File("src//Ficheiros//Eleitores.txt");
                    Scanner fscan = new Scanner(fich);
                    fscan.nextLine();
                    FileWriter fs = new FileWriter(fich);
                    BufferedWriter ot = new BufferedWriter(fs);
                    while(fscan.hasNextLine()){
                        String next = fscan.nextLine();
                        if(next.equals("\n"))
                            ot.newLine();
                        else
                            ot.write(next);
                            ot.newLine();
                    }ot.close();
                } catch (NullPointerException e) {
                    //TODO: handle exception
                    System.err.println(e);
                }
                
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
