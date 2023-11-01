import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.*;
/**
 * @author Henk Beula
 */
public class GerirPauta{
    static Estudante [] estudante = new Estudante[1];
    static Estudante [] out;
    static Scanner sc = new Scanner(System.in);

    public static void lerDados(){//metodo para registar os dados dos estudantes
        Estudante ler = new Estudante();
        byte cont;
        //Registrar os estudantes
        do{
            ler.setnum(Short.parseShort(JOptionPane.showInputDialog("Digite o numero do estudante:")));
            ler.setNome(JOptionPane.showInputDialog("Digite o nome do estudante:"));

            estudante[0]= new Estudante(ler.getnum(), ler.getNome(), 0, 0,0, 0, null);
            cont = Byte.parseByte(JOptionPane.showInputDialog("1.Continuar         \n"+"2.Sair              "));
            try {
                TextFile fich = new TextFile();
                fich.open4Write("src//Ficheiros//Estudantes.txt", true);
                fich.write2File(estudante[0].toString());
                fich.closeWrite();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }while(cont!=2);
        menu(); 
    }

    public static void menu() throws InputMismatchException{//menu principal do programa
        int stop=1;
            do{
                short entrada =Short.parseShort(JOptionPane.showInputDialog(null,
                    ("\n            Gestao de Estudantes               \n"
                    +"\n"
                    +"1. Registar estudantes                         \n"
                    +"2. Imprimir lista de inscritos                 \n"
                    +"3. Registar resultados de testes               \n"
                    +"4. Imprimir Pauta                              \n"
                    +"5. Procurar estudante                          \n"
                    +"0. Sair                                        \n"
                    +"Escolha uma opcao"), "Gerir Pauta",JOptionPane.INFORMATION_MESSAGE));

                switch (entrada) {
                    case 1 -> {
                        //some method
                        lerDados();
                        stop = 0;//assim que o metodo associado e invocado, este metodo (menu()) termina.
                    }
                    case 2 -> {
                        //some method
                        imprimirInscritos();
                        menu();//Apos mostrar os alunos inscritos, volta para o menu principal do programa
                        stop = 0;
                    }
                    case 3 -> {
                        //some method
                        menu2();
                        stop = 0;
                    }
                    case 4 -> {
                        //some method
                        imprimirPauta();
                        menu();
                        stop = 0;
                    }
                    case 5 -> {
                        //some method
                        String str = JOptionPane.showInputDialog("Digite o nome ou numero do estudante que pretende ver");
                        if(isNumber(str))
                            GerirPauta.procuraEstudante(Integer.parseInt(str));
                        else
                            GerirPauta.procuraEstudante(str);
                        menu();
                        stop = 0;
                    }
                    case 0 -> {
                        stop = 0;
                    }
                    default -> JOptionPane.showMessageDialog(null, "Opcao inexistente! \n tente novamente","Gerir Pauta",JOptionPane.ERROR_MESSAGE);// caso uma opcao enexistente no menu seja introduzida
                }
            }while(stop!=0);
    }

    public static void menu2(){//Menu de registro de notas e calculo de medias
        int stop=1;
            do{
                
                //short entrada = sc.nextShort();
                short entrada =Short.parseShort(JOptionPane.showInputDialog(null,
                "\n       Gestao de Estudantes       \n"
                +"\n"
                +"1. Registar teste 1               \n"
                +"2. Registar teste 2               \n"
                +"3. Registar nota do exame         \n"
                +"4. Calcular medias                \n"
                +"5. Calcular medias apos Exame     \n"
                +"0. Voltar                         \n"
                +"Escolha uma opcao","Gerir Pauta",JOptionPane.INFORMATION_MESSAGE));

                switch (entrada) {
                    case 1, 2, 3 -> {
                        //some method
                        registaNota(entrada);
                        stop = 0;
                    }
                    case 4 -> {
                        //some method
                        calculaMedias();
                        stop = 0;
                    }
                    case 5 -> {
                        //some method
                        out = new Estudante[fich2Array().length];
                        calculaMediasExame(out);
                        stop = 0;
                    }
                    case 0 -> {
                        //some method
                        menu();
                        stop = 0;
                    }
                    default -> JOptionPane.showMessageDialog(null, "Opcao inexistente! \n tente novamente","Gerir Pauta",JOptionPane.ERROR_MESSAGE);
                }
            }while(stop!=0);
    }

    public static void imprimirInscritos(){// imprime o numero e nome de todos os estudantes inscritos
        String data="************Lista de alunos inscritos************\n";
            
            for(Estudante insc: fich2Array()) {
                try {
                    data+="        Numero: "+insc.getnum()+"  Nome: "+insc.getNome()+"\n";
                } catch (NullPointerException e) {//to handle NullPointerException cause of an empty line on the txt file
                    //TODO: handle exception
                }
            }
            JOptionPane.showMessageDialog(null, data);
    }

    public static void procuraEstudante(int numero){

        boolean encontrado = false;
        for(Estudante insc: fich2Array()) {
            try {
                if(insc.getnum()==numero){
                    JOptionPane.showMessageDialog(null,"***********Estudante encontrado************\n"+ "         Nome: "+insc.getNome()+"  Nota 1: "+insc.getNota1()+"  Nota 2: "+insc.getNota2()
                    +"  Media: "+insc.getMedia()+"  Nota do exame: "+insc.getNotaExame()+"  Observacao: "+insc.getobs());
                    encontrado=true;
                    break;
                }
            } catch (NullPointerException e) {//to handle NullPointerException cause of an empty line on the txt file
                //TODO: handle exception
            }
        }
        if(!encontrado)
            JOptionPane.showMessageDialog(null,"Estudante nao encontrado");
    }

    public static void procuraEstudante(String nome){
        boolean encontrado = false;
        for(Estudante insc: fich2Array()) {
            try {
                if(insc.getNome().equalsIgnoreCase(nome)){
                    JOptionPane.showMessageDialog(null,"              Estudante encontrado\n"+ "         Nome: "+insc.getNome()+"  Nota 1: "+insc.getNota1()+"  Nota 2: "+insc.getNota2()
                    +"  Media: "+insc.getMedia()+"  Nota do exame: "+insc.getNotaExame()+"  Observacao: "+insc.getobs());
                    encontrado=true;
                    break;
                }
            } catch (NullPointerException e) {//to handle NullPointerException cause of an empty line on the txt file
                //TODO: handle exception
            }
        }
        if(!encontrado)
            JOptionPane.showMessageDialog(null,"Estudante nao encontrado","Gerir Pauta",JOptionPane.INFORMATION_MESSAGE);
    }

    public static void imprimirPauta(){//Imprime todos os dados dos estudantes
        String data="             Pauta                  ";
        for(Estudante pauta: fich2Array()) {
            try {
                data+="         Nome: "+pauta.getNome()+"  Nota 1: "+pauta.getNota1()+"  Nota 2: "+pauta.getNota2()
                +"  Media: "+pauta.getMedia()+"  Nota do exame: "+pauta.getNotaExame()+"  Observacao: "+pauta.getobs()+"\n";
            } catch (NullPointerException e) {
                //TODO: handle exception
            }
        }
        JOptionPane.showMessageDialog(null,data);
    }

    public static Estudante[] fich2Array(){
        int linhas=0;
        Estudante [] es;
        try {
            File fich = new File("src//Ficheiros//Estudantes.txt");
            Scanner sc = new Scanner(fich);
            Scanner cs = new Scanner(fich);
            while(cs.hasNextLine()){//para contar as linhas do ficheiro, para que se possa dimensionar o array(uma linha = um estudante)
                String data = cs.nextLine();
                linhas++;
            }
            cs.close();
            es = new Estudante[linhas];
            int i=0;
            while(sc.hasNext()){//A bloco do metodo registarNota(), que elimina a primeira linha vazia no ficheiro,
                                //cria uma outra linha vazia no fim do ficheiro, entao neste ciclo, para desconsiderar a tal linha vazia 
                                //e evitar retornar um dado null, utiliza-se o metodo hasNext(), que procura apenas se existe 
                                //um proximo simbolo no ficheiro, ignorando os espacos/linhas vazias.
                es[i++]= new Estudante(Short.parseShort(sc.next()), sc.next(), Float.parseFloat(sc.next()),
                Float.parseFloat(sc.next()), Float.parseFloat(sc.next()), Double.parseDouble(sc.next()), sc.next());
            }
            sc.close();
            return es;
        } catch (Exception e) {
            //TODO: handle exception
            JOptionPane.showMessageDialog(null,"Erro ao ler ficheiro","Gerir Pauta",JOptionPane.ERROR_MESSAGE);
        }
        return new Estudante[0];
    }

    public static void registaNota(int test){//para registar as notas do alunos
        out = new Estudante[fich2Array().length];
        short num = Short.parseShort(JOptionPane.showInputDialog("Digite o codigo do estudante:"));
        boolean encontrado=false;
        int i=0;
        for(Estudante e: GerirPauta.fich2Array()){
            GerirPauta.out[i++]=e;
        } 
        try {
            for(Estudante t: out){
                if(test==1 && t.getnum()==num){//se o numero introduzido for igual ao de algum estudante..
                    t.setNota1(Float.parseFloat(JOptionPane.showInputDialog("Digite a nota do primeiro teste do "+ t.getNome()+" :")));
                    encontrado=true;//confirma que foi encontrado
                    break;//e para toda a operacao
                }
                else if(test==2 && t.getnum()==num){
                    t.setNota2(Float.parseFloat(JOptionPane.showInputDialog("Digite a nota do  segundo teste do "+ t.getNome()+" :")));
                    encontrado=true;
                    break;
                }
                else if(test==3 && t.getnum()==num){
                    t.setNotaExame(Float.parseFloat(JOptionPane.showInputDialog("Digite a nota de exame do "+ t.getNome()+" :")));
                    encontrado=true;
                    break;
                }
            }
            if(!encontrado)
                JOptionPane.showMessageDialog(null,"Estudante com codigo "+num+" nao existe.","Gerir Pauta",JOptionPane.INFORMATION_MESSAGE);
            else{
                try {//para regravar os dados atualizados no ficheiro
                    File fich = new File("src//Ficheiros//Estudantes.txt");
                    FileWriter wr = new FileWriter(fich);
                    for(int j=0;j<out.length;j++){
                            wr.write(String.valueOf(out[j]));
                    }
                    wr.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Erro ao gravar no ficheiro","Gerir Pauta",JOptionPane.ERROR_MESSAGE);
                            //TODO: handle exception
                }
                try {//Para corregir um erro de leitura do ficheiro. Quando os dados atualizados sao armazenados no ficheiro,
                    //uma um paragrafo vazio e criado na primeira linha do ficheiro, e isso dava problema com o metodo fich2Array(),
                    //que faz a leitura do ficheiro para o array, como logo a primeira linha estava vazia, era retornado um dado nulo, o que causava o erro.
                    //Este bloco elimina a tal primeiram linha vazia.
                    File fich = new File("src//Ficheiros//Estudantes.txt");
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
                    JOptionPane.showMessageDialog(null,"Estudante com codigo "+num+" nao existe.","Gerir Pauta",JOptionPane.INFORMATION_MESSAGE);
                    menu2();
                }
                
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        menu2();
    }

    public static void calculaMediasExame(Estudante [] exame){//Calcula a media de todos os alunos
        exame = new Estudante[fich2Array().length];
        int i=0;
        for(Estudante e: GerirPauta.fich2Array()){
            GerirPauta.out[i++]=e;
        }
        for(Estudante est: out){
                if(est.getobs().equalsIgnoreCase("Exame")){
                    est.setMedia(est.getNota1(),est.getNota2(),est.getNotaExame());
                    if(est.getMedia() < 9.5 || est.getNotaExame()<8)
                        est.setobs("Reprovado");
                    else
                        est.setobs("Aprovado");
                }
        }
        try {//ver no metodo registarNota()
            File fich = new File("src//Ficheiros//Estudantes.txt");
            FileWriter wr = new FileWriter(fich);
                for(int j=0;j<out.length;j++){
                    wr.write(String.valueOf(out[j]));
                }
                wr.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao gravar no ficheiro","Gerir Pauta",JOptionPane.ERROR_MESSAGE);
                    //TODO: handle exception
            }
            try {//ver no metodo registarNota()
                File fich = new File("src//Ficheiros//Estudantes.txt");
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
            } catch (Exception e) {
                //TODO: handle exception
            }
        menu2();
    }

    public static void calculaMedias(){//Calcula a media de todos os alunos
        out = new Estudante[fich2Array().length];
        int i=0;
        for(Estudante e: GerirPauta.fich2Array()){
            GerirPauta.out[i++]=e;
        }
        for(Estudante est: out){
                est.setMedia(est.getNota1(),est.getNota2());
                if(est.getMedia()<=9.5 && est.getMedia()>=7.5 || est.getNota1()< 10 && est.getMedia() >= 7.5 || est.getNota2() < 10 && est.getMedia() >= 7.5)
                    est.setobs("Exame");
                if(est.getMedia()<7.5)
                    est.setobs("Excluido");
                if(est.getNota1()>=10 && est.getNota2()>=10 || est.getNotaExame()>=8 && est.getMedia()>=9.5)
                    est.setobs("Aprovado");
        }
        try {//ver no metodo registarNota()
            File fich = new File("src//Ficheiros//Estudantes.txt");
            FileWriter wr = new FileWriter(fich);
                for(int j=0;j<out.length;j++){
                    wr.write(String.valueOf(out[j]));
                }
                wr.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro ao gravar no ficheiro","Gerir Pauta",JOptionPane.ERROR_MESSAGE);
                    //TODO: handle exception
            }
            try {//ver no metodo registarNota()
                File fich = new File("src//Ficheiros//Estudantes.txt");
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
            } catch (Exception e) {
                //TODO: handle exception
            }
        menu2();
    }

    public static boolean isNumber(String str){//Verificar se foi introduzido um numero
        for(int i = 0; i < str.length(); i++)
            if(!Character.isDigit(str.charAt(i)))
                return false;
        return true;
    }
}