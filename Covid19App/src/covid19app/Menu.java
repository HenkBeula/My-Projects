/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid19app;

import javax.swing.JOptionPane;
/**
 *
 * @author Henk Beula
 */
public class Menu {
    public void menu(){
        int opcao,stop=1;
        Menu atualizar = new Menu();
        do{
            try{
                opcao = Integer.parseInt(JOptionPane.showInputDialog("CovidApp"+"\n \n"+
                        "(1).Registar passiente"+"\n"+
                        "(2).Procurar"+"\n"+
                        "(3).Atulizar"+"\n"+
                        "(4).Imprimir lista"+"\n"+
                        "(0).Fechar programa"+"\n"+"\n \n"+"Escolha uma opçao!"));
                //stop=0 para este menu fechar ao escolher uma opcao
                switch(opcao){
                    case 1:
                        Registo.registar();
                        stop=0;
                        break;
                    case 2:
                        
                        Registo.pesquisa();
                        stop=0;
                        break;
                    case 3:
                        Registo.atualizarDados();
                        stop=0;
                        break;
                    case 4:
                        Registo.imprimeLista();
                        stop=0;
                        break;
                    case 0:
                        stop=0;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Opcao invalida! Tente Novamente");
                }
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Opcao invalida! Tente Novamente");
                e.printStackTrace();
            }
        }while(stop!=0);
    }
}