/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid19app;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 *
 * @author Henk Beula
 */
public class Registo {
    public static void gravarFicheiro(Paciente cadastro,ArrayList<String> conteiner,String caminho){
        if(cadastro!=null){//para gravar os dados do paciente na primeira vez que for registar-se
             ArrayList<Paciente> List;
             List = new ArrayList<>();
             List.add(cadastro);//guarda os valores dos atributos de pessoa no arraylist
             try{
                 File listaCidadao = new File(caminho);
                 /*este trecho de codigo testa se o ficheiro existe, caso sim ele escreve  a informacao contida
                 no array para o ficheiro*/
                 if(listaCidadao.exists() && listaCidadao.canWrite()){
                     try (FileWriter gravar = new FileWriter(listaCidadao,true)) {
                         JOptionPane.showMessageDialog(null, "Informacao armazenada com sucesso");
                         for(Object lista: List){
                             gravar.write(lista.toString());
                         }
                         gravar.close();//Fecha o ficheiro (termina de gravar)
                     }
                 } 
                 //caso o ficheiro nao exista este trecho de codigo cria o ficheiro e grava a informacao nele
                 else if(listaCidadao.createNewFile()){
                     try (FileWriter gravar = new FileWriter("C:\\Users\\Henk Beula\\OneDrive\\Documents\\NetBeansProjects\\Covid19App\\src\\File\\ListaCidadao.txt")) {
                          JOptionPane.showMessageDialog(null, "Ficheiro criado com sucesso");
                          JOptionPane.showMessageDialog(null, "Informacao armazenada com sucesso");
                          for(Object lista: List){
                              gravar.write(lista.toString());
                          }
                     }
                 }
             }catch(IOException e){
                 JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
             }
        }
        else if(conteiner!=null){//para guardar os dados do paciente, atualizados
             try{
                 File listaCidadao = new File(caminho);
                 if(listaCidadao.exists() && listaCidadao.canWrite()){
                     try (FileWriter gravar = new FileWriter(listaCidadao,true)){
                         JOptionPane.showMessageDialog(null, "Informacao armazenada com sucesso");
                         for(Object lista: conteiner){
                             gravar.write(lista.toString());
                         }
                         gravar.close();
                    }
                 } 
                 else if(listaCidadao.createNewFile()){
                     try (FileWriter gravar = new FileWriter("C:\\Users\\Henk Beula\\OneDrive\\Documents\\NetBeansProjects\\Covid19App\\src\\File\\ListaCidadao.txt")) {
                          JOptionPane.showMessageDialog(null, "Ficheiro criado com sucesso");
                          JOptionPane.showMessageDialog(null, "Informacao armazenada com sucesso");
                          for(Object lista: conteiner){
                              gravar.write(lista.toString());
                          }
                     }
                 }
             }catch(IOException e){
                 JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
             }
        }
    }
    public static void registar(){
        ArrayList<Paciente> List;
        List = new ArrayList<>();
        Paciente cadastro = new Paciente();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Menu voltar = new Menu();
        int stop=0,opcao;
        do{
            /*int numero, String nome, char sexo, Date dataNascimento, Date dataTeste, int codigoLocalTeste*/
            cadastro.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite um numero para o paciente")));
            cadastro.setNome(JOptionPane.showInputDialog("Selecionou a opcao 1"+"\n \n"+"Nome do paciente \n Primeiro nome e apelido"));
            cadastro.setSexo(JOptionPane.showInputDialog("Sexo! ex: Femenino/F ou Masculino/M"));
                String dataTest = null;    
                String dataNasc = null;
                while(dataNasc == null){
                      dataNasc = JOptionPane.showInputDialog("Data de nascimente! ex: yyyy-mm-dd ");
                      try {
                           //Convertendo String em Date
                           cadastro.setDataNascimento(format.parse(dataNasc));
                      } catch (ParseException e) {
                           // TODO Auto-generated catch block
                           JOptionPane.showMessageDialog(null,"Formato invalido, tente novamente");
                           dataNasc = null;
                      }
                }
                while(dataTest == null){
                      dataTest = JOptionPane.showInputDialog("Data de teste! ex: yyyy-mm-dd ");
                      try {
                           //Convertendo String em Date
                           cadastro.setDataTeste(format.parse(dataTest));
                      } catch (ParseException e) {
                           // TODO Auto-generated catch block
                           JOptionPane.showMessageDialog(null,"Formato invalido, tente novamente");
                           dataTest = null;
                      }
                }
            cadastro.setCodigoLocalTeste(Integer.parseInt(JOptionPane.showInputDialog("Codigo do local de teste!")));

            opcao = Integer.parseInt(JOptionPane.showInputDialog("1.Registar Teste"
                    +"\n 2.Descartar" + " \n Escolha uma opcao"));
            switch(opcao){
                case 1: 
                    Registo.gravarFicheiro(cadastro,null,"C:\\Users\\Henk Beula\\OneDrive\\Documents\\NetBeansProjects\\Covid19App\\src\\File\\ListaCidadao.txt");
                    stop=0;
                    break;
                case 2://Descarta os dados introduzidos e nenhum dado e guardo
                    stop=0;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcao invalida!");
            }
            int proximo = Integer.parseInt(JOptionPane.showInputDialog("1.Registar novo passiente"
                    + "\n 2.Voltar ao menu"));
            if(proximo==1){
                stop=1;}
            else{
                    voltar.menu();}
        }while(stop!=0);
    }
    
    public static void imprimeLista(){
        //Metodo para Ler dados no ficheiro e imprimir
        int stop=1,opcao;
        Registo print = new Registo();
        do{
            opcao=Integer.parseInt(JOptionPane.showInputDialog("1.Imprimir lista "+"\n"
                    + "2.Imprimir Lista atualizada"+"\n"+"3.Voltar"));
            switch(opcao){//para escolher de que Ficheiro quer imprimir a lista
                case 1:
                    print.lerFicheiro("C:\\Users\\Henk Beula\\OneDrive\\Documents\\NetBeansProjects\\Covid19App\\src\\File\\ListaCidadao.txt");
                    break;
                case 2:
                    print.lerFicheiro("C:\\Users\\Henk Beula\\OneDrive\\Documents\\NetBeansProjects\\Covid19App\\src\\File\\ListaCidadaoFinal.txt");
                    break;
                case 3:
                    Menu voltar=new Menu();
                    stop=0;
                    voltar.menu();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcao invalida! Tente novamente");
            }
        
        }while(stop!=0);
    }
    
    public void lerFicheiro(String caminho){
        try{             File ler;
            ler = new File(caminho);
             Scanner leitor = new Scanner(ler);
             System.out.println("\n Lista de Cidadaos registados \n");
             
             //enquanto houver uma nova linha, copia o conteudo do ficheiro
             //para a variavel data
             while(leitor.hasNextLine()){
                   String data = leitor.nextLine();
                   System.out.println(data);
             }
           leitor.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
        }
    }
    
        //dMenu voltar = new Menu();
        //voltar.menu();*/
     public static void pesquisa(){
         String caminho="";
        int stop=0,opcao;
         do{//Para escolher em que fivheiro procurar dados do paciente
            opcao=Integer.parseInt(JOptionPane.showInputDialog("1.Procurar na lista inicial"+"\n"
                    +"2.Procurar na lista atualizada"+"\n"+"3.Voltar"));
            //caso clique a opcao 1 ou 2, um caminho para amlocalizacao do ficheiro e indicado
            if(opcao==1){
                Registo.procura("C:\\Users\\Henk Beula\\OneDrive\\Documents\\NetBeansProjects\\Covid19App\\src\\File\\ListaCidadao.txt");
            }else if(opcao==2){
                Registo.procura("C:\\Users\\Henk Beula\\OneDrive\\Documents\\NetBeansProjects\\Covid19App\\src\\File\\ListaCidadaoFinal.txt");
            }else if(opcao==3){
                Menu voltar = new Menu();
                stop=0;
                voltar.menu();
            }else
                JOptionPane.showMessageDialog(null,"Opcao invalida! Tente novamente");
        }while(stop!=0);
     }
     
     public static void procura(String caminho) {
        ArrayList<String> pacientes= new ArrayList<>();
        String procurados[];
        int lineNumb=0,i=0;
        try{//os comando estao entre o bloco try..catch para lhe dar com possiveis erros
           File ler = new File(caminho);
                 Scanner leitor = new Scanner(ler);
                 System.out.println("Cidadao Procurado \n");
                 
                 //para saber o numero de linhas do ficheiro
                 while(leitor.hasNextLine()){
                     String data = leitor.nextLine();
                     lineNumb++;
                 }
                 /*a capacidade do array e dado pelo numero de linhas linhas no file
                 multiplicado pelo numero de atributos*/
                 procurados = new String[lineNumb*9];
                 Scanner reader = new Scanner(ler);
                 
                 //enquanto houver uma nova linha, copia o conteudo do ficheiro
                 //para a variavel data copiar para um array
                 while(reader.hasNextLine()){
                     String linha = reader.nextLine();
                     
                     String[] dados = linha.split(",");
                     
                     for(String conteudo:dados){
                         pacientes.add(i++, conteudo);
                     }
                 }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
        }
        String procura = JOptionPane.showInputDialog("Procure pelo nome:");
        
        //recebe a posicao no arrayList do elemento procurado
        int posicao=Registo.pesquisaSequencial(pacientes, procura);
        
        //Se elemento encontrado, mostra dados
        //caso nao, mostra mensagem "paciente nao encontrado"
        if(posicao>=0){
            /*corre um ciclo a partir da posicao onde se encontra o elemento procurado
            +9 posicoes, para poder imprimir todos os 9 atributos do passiente*/
            for(int index=posicao;index<posicao+9;index++){
                System.out.println(pacientes.get(index));
            }
        }else if(posicao<0)
            JOptionPane.showMessageDialog(null, "Paciente nao encontrado");
        Registo.pesquisa();
    }
     
     public static int pesquisaSequencial(ArrayList<String> array, Object elementoProcurado){
        int tamanhoVetor = array.size();
        for(int i = 0; i<tamanhoVetor; i++)
            if(array.get(i).equals(elementoProcurado))
                return i;
        return -1;
    }
    
     public static void atualizarDados(){
        ArrayList<String> pacientes= new ArrayList<>();
        String procurados[];
        int lineNumb=0,i=0;
        try{//os comando estao entre o bloco try..catch para lhe dar com possiveis erros
           File ler = new File("C:\\Users\\Henk Beula\\OneDrive\\Documents\\NetBeansProjects\\Covid19App\\src\\File\\ListaCidadao.txt");
                 Scanner leitor = new Scanner(ler);
                 System.out.println("Cidadao Procurado \n");
                 
                 while(leitor.hasNextLine()){
                     String data = leitor.nextLine();
                     lineNumb++;
                 }
                 /*a capacidade do array e dado pelo numero de linhas linhas no file
                 multiplicado pelo numero de atributos*/
                 procurados = new String[lineNumb*9];
                 Scanner reader = new Scanner(ler);
                 while(reader.hasNextLine()){
                     String linha = reader.nextLine();
                     
                     String[] dados = linha.split(",");
                     
                     for(String conteudo:dados){
                         pacientes.add(i++, conteudo);
                     }
                 }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro!");
        }
        String procura = JOptionPane.showInputDialog("Procure pelo nome:");
        
        //recebe a posicao no arrayList do elemento procurado
        int posicao=Registo.pesquisaSequencial(pacientes, procura);
        
        //Se elemento encontrado, mostra dados
        //caso nao, mostra mensagem "paciente nao encontrado"
        ArrayList<String> paciente = new ArrayList<>();
        ArrayList<Paciente> list = new ArrayList<>();
        if(posicao>=0){
            /*corre um ciclo a partir da posicao onde se encontra o elemento procurado
            +9 posicoes, para poder imprimir todos os 9 atributos do passiente*/
            for(int index=posicao;index<posicao+9;index++){
                paciente.add(pacientes.get(index)+", ");
            }
        }else if(posicao<0)
            JOptionPane.showMessageDialog(null, "Paciente nao encontrado");
        int stop=1,opcao;
        Menu voltar = new Menu();
        Paciente updateDados = new Paciente();
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        //for(int k=0;k<paciente.size();k++)
          //   System.out.println(paciente.get(k));
        do{
            try{
                opcao = Integer.parseInt(JOptionPane.showInputDialog("Atualizar os dados de "+procura+"\n"+
                        "(1).Atualizar Nome"+"\n"+
                        "(2).Atualizar Sexo"+"\n"+
                        "(3).Atualizar data de nascimento"+"\n"+
                        "(4).Atualizar codigo de resultado"+"\n"+
                        "(5).Atualizar codigo de situacao final"+"\n"+
                        "(6).Atualizar data de situacao final"+"\n"+
                        "(7).Salvar alteracoes"+"\n"+
                        "8.Voltar"+"\n \n"+"Escolha uma opçao!"));
                //stop=0 para este menu fechar ao escolher uma opcao
                switch(opcao){
                    //apaga o atributo a ser alterado, da posicao i do array
                    //adiciona o atualizado na mesma posicao que o anterior
                    case 1://para atualizar o nome do paciente
                        updateDados.setNome(JOptionPane.showInputDialog("Selecionou a opcao 1"+"\n \n"+"Nome do paciente \n Primeiro nome e apelido"));
                        paciente.remove(0); 
                        paciente.add(0,updateDados.getNome()+", ");
                        break;
                    case 2://para atualizar o genero do paciente
                         updateDados.setSexo(JOptionPane.showInputDialog("Selecionou a opcao 2"+"\n \n"+"Sexo! ex: F ou M"));
                         paciente.remove(2);//apaga o nome a ser alterado, da posicao zero do array
                         paciente.add(2,updateDados.getSexo()+", ");
                        break;
                    case 3://para atualizar data de Nacimento do paciente
                        String dataNasc=null;
                        while(dataNasc==null){
                            dataNasc=JOptionPane.showInputDialog("Selecionou a opcao 3"+"\n \n"+"Data de nascimento ex: yyyy-mm-dd");
                            try{
                                updateDados.setDataNascimento(format.parse(dataNasc));//converte String para Date
                            }catch(ParseException e){
                                JOptionPane.showMessageDialog(null, "Formato invalido! Tente novamente");
                                dataNasc=null;
                            }
                        }
                        paciente.remove(3);
                        //adiciona no array, reconvertendo Date em String
                        paciente.add(3, updateDados.getDataNascimento().toString()+", ");
                        break;
                    case 4:
                        updateDados.setCodigoResultado(JOptionPane.showInputDialog("Selecionou a opcao 4"+"\n \n"+"O resultado do teste de "+procura+" ex: Positivo ou Negativo"));
                        paciente.remove(6);
                        paciente.add(6,updateDados.getCodigoResultado()+", ");
                        break;
                    case 5:
                        updateDados.setCodigoSitFinal(JOptionPane.showInputDialog("Selecionou a opcao 5"+"\n \n"+"Situacao final "+procura+" ex: Obito ou Recuperado"));
                        paciente.remove(7);
                        paciente.add(7,updateDados.getCodigoSitFinal()+", ");
                        break;
                    case 6:
                         String dataSitFinal=null;
                        while(dataSitFinal==null){
                            dataSitFinal=JOptionPane.showInputDialog("Selecionou a opcao 6"+"\n \n"+"Data de situacao final ex: yyyy-mm-dd");
                            try{
                                updateDados.setDataSitFinal(format.parse(dataSitFinal));//converte String para Date
                            }catch(ParseException e){
                                JOptionPane.showMessageDialog(null, "Formato invalido! Tente novamente");
                                dataSitFinal=null;
                            }
                        }
                        paciente.remove(8);
                        //adiciona no array, reconvertendo Date em String
                        paciente.add(8, updateDados.getDataNascimento().toString()+", ");
                        break;
                    case 7:
                        Registo.gravarFicheiro(null,paciente,"C:\\Users\\Henk Beula\\OneDrive\\Documents\\NetBeansProjects\\Covid19App\\src\\File\\ListaCidadaoFinal.txt");
                        break;
                    case 8:
                        stop=0;
                        voltar.menu();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcao invalida! Escolha novamente.");
                }
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Opcao invalida! Tente Novamente");
            }
        }while(stop!=0);
     }
     
     public void situacaoFinal(){
         
     }
}