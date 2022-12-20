import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.file.FicheiroDeObjecto;
import com.file.FicheiroDeTexto;

public class App {
    static ArrayList<Estudante> array = new ArrayList<>();
    //static Queue fila = new Queue(100);
    public static void main(String [] args) throws IOException{
        menu();
       
    }

    /* Inicio Menu*/
    public static void menu() throws InputMismatchException, IOException{
        Scanner sc = new Scanner(System.in);
        int opcao = 1;
        do {
            System.out.println(
                "\n"+
                "*************************************\n"+
                "*        Topicos do 2o Teste        *\n"+
                "* 1.Execicio 1                      *\n"+
                "* 2.Execicio 2                      *\n"+
                "* 3.Execicio 3                      *\n"+
                "* 4.Execicio 4                      *\n"+
                "* 5.Execicio 5                      *\n"+
                "* 6.Execicio 6                      *\n"+
                "* 0.Sair                            *\n"+
                "*************************************"
            );//menu
            System.out.print(": ");
            opcao = sc.nextInt();//para escolher as opcoes disponiveis no menu

            switch(opcao){
                case 1:
                    opcao = 0;
                    menu1();//Exercicio 1
                    break;
                case 2:
                    opcao = 0;
                    menu2();//Exercicio 2
                    break;
                case 3:
                    opcao = 0;
                    menu3();//Exercicio 3
                    break;
                case 4:
                    opcao = 0;
                    menu4();//Exercicio 4
                    break;
                case 5:
                    opcao = 0;
                    menu5();//Exercicio 5
                    break;
                case 6:
                    opcao = 0;
                    menu6();//Exercicio 6
                    break;
                case 0:
                    opcao = 0;//o programa termina ao escolher a opcao 0
                    
                    System.out.println(arvoreDeNatal+"\nAte breve..");
                    break;
                default:
                    System.out.println("Opcao invalida!");//caso escolha uma opcao nao existente no menu
            }
        } while (opcao != 0);
    }
    public static void menu1() throws InputMismatchException, IOException{//menu exercicio 1
        Scanner sc = new Scanner(System.in);
        int opcao = 1;
        do {
            System.out.println(
                "*************************************\n"+
                "* 1.Correr o programa               *\n"+
                "* 0.Voltar                          *\n"+
                "************************************"
            );//menu
            System.out.print(": ");
            opcao = sc.nextInt();//para escolher as opcoes disponiveis no menu

            switch(opcao){
                case 1:
                    readWriteFileCharByChar("ficheiro.txt", "ficheiroSaida.txt");//metodo para ler estudantes
                    break;
                case 0:
                    opcao = 0;
                    menu();//voltar ao menu
                    break;
                default:
                    System.out.println("Opcao invalida!");//caso escolha uma opcao nao existente no menu
            }
        } while (opcao != 0);
    }
    public static void menu2() throws InputMismatchException, IOException{//menu exercicio 2
        Scanner sc = new Scanner(System.in);
        int opcao = 1;
        do {
            System.out.println(
                "*************************************\n"+
                "* 1.Correr o programa               *\n"+
                "* 0.Voltar                          *\n"+
                "************************************"
            );//menu
            System.out.print(": ");
            opcao = sc.nextInt();//para escolher as opcoes disponiveis no menu

            switch(opcao){
                case 1:
                    readWriteFileLineByLine("ficheiro.txt", "ficheiroSaida2.txt");//metodo para ler estudantes
                    break;
                case 0:
                    opcao = 0;
                    menu();//voltar ao menu
                    break;
                default:
                    System.out.println("Opcao invalida!");//caso escolha uma opcao nao existente no menu
            }
        } while (opcao != 0);
    }
    public static void menu3() throws InputMismatchException, IOException{//menu exercicio 3
        Scanner sc = new Scanner(System.in);
        int opcao = 1;
        do {
            System.out.println(
                "*************************************\n"+
                "* 1.Ler Estudante                   *\n"+
                "* 2.Imprimir Estudantes             *\n"+
                "* 0.Voltar                          *\n"+
                "************************************"
            );//menu
            System.out.print(": ");
            opcao = sc.nextInt();//para escolher as opcoes disponiveis no menu

            switch(opcao){
                case 1:
                    lerEstudante();
                    break;
                case 2:
                    for(Object t: readLineFromFile("estudantes.txt")){
                      System.out.println(t);
                    };
                    break;
                case 0:
                    opcao = 0;
                    menu();//voltar ao menu
                    break;
                default:
                    System.out.println("Opcao invalida!");//caso escolha uma opcao nao existente no menu
            }
        } while (opcao != 0);
    }
    public static void menu4() throws InputMismatchException, IOException, NullPointerException{//menu exercicio 4
        Scanner sc = new Scanner(System.in);
        int opcao = 1;
        do {
            System.out.println(
                "*************************************\n"+
                "* 1.Ler Estudante                   *\n"+
                "* 2.Imprimir Estudantes             *\n"+
                "* 0.Voltar                          *\n"+
                "************************************"
            );//menu
            System.out.print(": ");
            opcao = sc.nextInt();//para escolher as opcoes disponiveis no menu

            switch(opcao){
                case 1:
                    lerEstudante2();
                    break;
                case 2:
                    readObjFromFile("estudantes.dat");
                    break;
                case 0:
                    opcao = 0;
                    menu();//voltar ao menu
                    break;
                default:
                    System.out.println("Opcao invalida!");//caso escolha uma opcao nao existente no menu
            }
        } while (opcao != 0);
    }
    public static void menu5(){//menu exercicio 5
    }
    public static void menu6(){//menu exercicio 6
    }
    /* Fim Menu */
    

    /*********************/
    /*Inicio Exercicio 1 */
    /*********************/
    public static void readWriteFileCharByChar(String inFile, String outFile) throws IOException{
        FicheiroDeTexto fich = new FicheiroDeTexto();
        StringBuilder bld = new StringBuilder();

        /*Lendo ficheiro, caracter por caracter*/
        try {
            fich.open4ReadChar(inFile);//abre o ficheiro para leitura caracter por caracter
            int chr;
            int count =0;
            
            while((chr=fich.readChar())!=-1){ //le caracter por caracter ate que ja nao tenha mais nada no ficheiro
                System.out.println((char) chr);//converte do tipo inteiro para caracter e imprime no ecra
                bld.append((char) chr);
                count++; //conta o numero de caracteres
            }
            System.out.println("\n\nSao no total "+count+" caracteres");
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            fich.closeReadChar(); //fecha a leitura caracter por caracter
        }

        /*Escrevendo no ficheiro de saida, caracter por caracter*/
        try {
            fich.open4WriteChars(outFile);
            fich.writeChars(bld.toString());
            fich.closeWriteCh();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    /*******************/
    /* Fim Exercicio 1 */
    /*******************/


    /**********************/
    /* Inicio Exercicio 2 */
    /**********************/
    public static void readWriteFileLineByLine(String inFile, String outFile) throws IOException{
        FicheiroDeTexto fich = new FicheiroDeTexto();//instancia da classe para manipular ficheiros
        String data="";//variavel auxilidar para guarda o conteudo que sera lido no ficheiro de entrada
        try {
            fich.open4ReadLine(inFile);//abre o ficheiro de entrada para leitura linha a linha
            fich.open4WriteLines(outFile); //abre o ficheiro de saida para escrita
            data+=fich.readLine(); //le as linhas do ficheiro de entrada e guarda na variavel data
            System.out.print(data);//imprime o conteudo do ficheiro de entrada
            fich.writeLines(data);//escreve o conteudo lido do ficheiro de entrada no ficheiro de saida
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            fich.closeReadLine();//fecha leitura do ficheiro de entrada
            fich.closeWriteLines();//fecha leitura do ficheiro de saida
        }
    }
    /*******************/
    /* Fim Exercicio 2 */
    /*******************/


    /**********************/
    /* Inicio Exercicio 3 */
    /**
     * @throws IOException
     * /
    /* Inicio lerEstudante */
    public static void lerEstudante() throws IOException{
        Scanner scan = new Scanner(System.in);//Para permitir leitura de dados via teclado pelo utilizador
        Scanner sc = new Scanner(System.in);//Para permitir leitura de dados via teclado pelo utilizador
        System.out.println("* Registar Estudantes *");

        int id = generateNewID("estudantes.txt"); 

        System.out.print("Introduza o nome completo: ");
        String fullName = sc.nextLine(); 
        System.out.println("");

        /*Inicio Validacao de data */
        Date dataNasc = null;
        String dataNc = null;
        DateFormat format = new SimpleDateFormat("yyyy.mm.dd");//definir formato de data
        
        while (dataNc == null) {
            System.out.print("Introduza a data de nascimento no seguinte formato. yyyy.mm.dd: ");
            dataNc = scan.next();
            try {
                dataNasc = format.parse(dataNc);// converte String para Date
            } catch (ParseException | InputMismatchException e) {
                System.out.println("Formato invalido! Tente novamente");
                dataNc = null;//caso seja introduzido um formato de data diferente do solicitado, o utilizador sera solicitado a reintroduzir
            }
        }
        /*Fim Validacao de data */
        System.out.println("");

        System.out.print("Introduza o genero (Masculino ou Femenino): ");
        String genero = scan.next(); 
        System.out.println("");

        System.out.print("Introduza o curso: ");
        String curso = scan.next(); 
        System.out.println("");

        Estudante estudante = new Estudante(id, fullName, dataNasc, genero, curso);//criar novo estudante com os dados acima introducidos

        write2TxtFile(estudante.toString(), "estudantes.txt");
    }
    /* Fim lerEstudante */

    /*Inicio Metodo para gravar esrudante em ficheiro de texto*/
    public static void write2TxtFile(String inData,String myFile) throws IOException{
        FicheiroDeTexto fich = new FicheiroDeTexto();//instacia da classe para manipular ficheiros
        fich.open4WriteLinesNoOveride(myFile);//abre o ficheiro para escrita
        fich.writeLines(inData);//escreve no ficheiro
        fich.closeWriteLines();//fecha o ficheiro
    }
    /*Inicio Metodo para gravar esrudante em ficheiro de texto*/
    
    /* Inicio metodo para ler ficheiro linha a linha criar objecto estudante e escrever no ecra*/
    public static ArrayList<Estudante> readLineFromFile(String inFile) throws IOException{
        int id; String fullName; Date dataNasc; String genero; String curso; float nota1; float nota2; float media;
        //String []  estudantes;

        InputStream readLn = new FileInputStream(inFile);
        InputStream readLn_ = new FileInputStream(inFile);
        DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");//definir formato de data

        try {
            Scanner sc = new Scanner(readLn, StandardCharsets.UTF_8.name());

            while(sc.hasNextLine()){
                    String [] estudantes = sc.nextLine().split(",");//dividir os dados lidos com virgula "," como separador

                    //Converter os dados lidos do ficheiro para os respectivos formatos
                    id = Integer.parseInt(estudantes[0]);
                    fullName = estudantes[1];
                    dataNasc = format.parse(estudantes[2]);
                    genero = estudantes[3];
                    curso = estudantes[4];
                    nota1 = Float.parseFloat(estudantes[5]);
                    nota2 = Float.parseFloat(estudantes[6]);
                    media = Float.parseFloat(estudantes[7]);

                    Estudante est = new Estudante(id, fullName, dataNasc, genero, curso, nota1, nota2,media);//criar novo objecto estudante com os dados recuperados do ficheiro
                    array.add(est);//gravar o objecto estudante no array
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }
    /* Inicio metodo para ler ficheiro linha a linha criar objecto estudante e escrever no ecra*/

    /*******************/
    /* Fim Exercicio 3 */
    /*******************/
    //ler
    
    /**********************/
    /* Inicio Exercicio 4 */
    /**********************/
    /* Inicio lerEstudante */
    public static void lerEstudante2() throws IOException{
        Scanner scan = new Scanner(System.in);//Para permitir leitura de dados via teclado pelo utilizador
        Scanner sc = new Scanner(System.in);//Para permitir leitura de dados via teclado pelo utilizador
        System.out.println("* Registar Estudantes *");

        int id = generateNewID("estudantes.txt"); 

        System.out.print("Introduza o nome completo: ");
        String fullName = sc.nextLine(); 
        System.out.println("");

        /*Inicio Validacao de data */
        Date dataNasc = null;
        String dataNc = null;
        DateFormat format = new SimpleDateFormat("yyyy.mm.dd");//definir formato de data
        
        while (dataNc == null) {
            System.out.print("Introduza a data de nascimento no seguinte formato. yyyy.mm.dd: ");
            dataNc = scan.next();
            try {
                dataNasc = format.parse(dataNc);// converte String para Date
            } catch (ParseException | InputMismatchException e) {
                System.out.println("Formato invalido! Tente novamente");
                dataNc = null;//caso seja introduzido um formato de data diferente do solicitado, o utilizador sera solicitado a reintroduzir
            }
        }
        /*Fim Validacao de data */
        System.out.println("");

        System.out.print("Introduza o genero (Masculino ou Femenino): ");
        String genero = scan.next(); 
        System.out.println("");

        System.out.print("Introduza o curso: ");
        String curso = scan.next(); 
        System.out.println("");

        Estudante estudante = new Estudante(id, fullName, dataNasc, genero, curso);//criar novo estudante com os dados acima introducidos

        Queue<Estudante> queue = new LinkedList<>();//fila
        queue.add(estudante);//grava estudante na fila

        write2ObjFile(queue, "estudantes.dat");
    }

    /*Inicio Metodo para gravar esrudante em ficheiro de texto*/
    public static void write2ObjFile(Queue<Estudante> queue,String myFile) throws IOException{
        FicheiroDeObjecto obj = new FicheiroDeObjecto();
        obj.open4Write(myFile);
        obj.writeObj(queue);
        obj.closeWrite();
    }
    /*Inicio Metodo para gravar esrudante em ficheiro de texto*/

    public static void readObjFromFile(String inFile) throws IOException, NullPointerException {
        FicheiroDeObjecto b = new FicheiroDeObjecto();
        b.openToRead(inFile);
        Object obj;
        try {
            obj = b.readObj();
            System.out.println(obj);
        } catch (ClassNotFoundException | NullPointerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        b.closeRead();
    }
    /* Fim lerEstudante */
    /*******************/
    /* Fim Exercicio 4 */
    /*******************/

    static String arvoreDeNatal = 
    "                *\n"+
    "              *****\n"+
    "             *** ***\n"+
    "            ***   ***\n"+
    "           ***     ***\n"+
    "          ***       ***\n"+
    "         ***         ***\n"+
    "        ***           ***\n"+
    "       ***             ***\n"+
    "      ***               ***\n"+
    "     ***********************\n"+
    "    *************************\n"+
    "               ***\n"+
    "               ***\n"+
    "               ***\n"+
    "               ***\n"+
    "               ***\n"+
    "               ***\n"+
    "             *******\n"+
    "             *******\n"+
    "            Feliz Natal";

    /*
     * Metodo para gerar ID para novos estudantes
     * Le o ficheiro de estudantes, pega o ID do ultimo estudante 
     * incrementa em uma unidade e retorna como novo ID
     */
    public static int generateNewID(String inFile) throws IOException{
        int id=100;
        try (InputStream readLn = new FileInputStream(inFile)) {
            Scanner sc = new Scanner(readLn, StandardCharsets.UTF_8.name());

            while(sc.hasNextLine()){
                    String [] estudantes = sc.nextLine().split(",");//dividir os dados lidos com virgula "," como separador
                    id = Integer.parseInt(estudantes[0]);//converte texto para inteiro
            }
            readLn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ++id;
    }
}
