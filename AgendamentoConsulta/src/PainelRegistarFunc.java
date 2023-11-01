package src;

import javax.swing.*;
import src.db.JSqlCon;
import src.personel.Funcionario;
import src.personel.Medico;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelRegistarFunc extends JPanel implements ActionListener {
    private JButton saveButton;
    private JButton cancelButton;
    private JTextField nomeField = new JTextField();
    private JTextField generoField = new JTextField();
    private JTextField dataNascimentoField = new JTextField();
    private JTextField numeroBIField = new JTextField();
    private JTextField nacionalidadeField = new JTextField();
    private JTextField numeroCelularField = new JTextField();
    private JTextField emailField = new JTextField();
    private JTextField enderecoField = new JTextField();
    private JTextField cargoField = new JTextField();
    private JTextField salarioField = new JTextField("0.00");
    private JTextField dataContratacaoField = new JTextField();
    private JTextField horarioTrabalhoField = new JTextField();
    private JTextField nomeUtilizadorField = new JTextField();
    private JTextField passwordField = new JTextField();
    private JTextField observacoesField = new JTextField();

    public PainelRegistarFunc() {
        setLayout(new GridLayout(22, 2));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        add(new JLabel("Nome:"));
        add(nomeField);
        
        add(new JLabel("Genero:"));
        add(generoField);
        
        add(new JLabel("Data de Nascimento:"));
        add(dataNascimentoField);
        
        add(new JLabel("Numero de BI:"));
        add(numeroBIField);
        
        add(new JLabel("Nacionalidade:"));
        add(nacionalidadeField);
        
        add(new JLabel("Numero de Celular:"));
        add(numeroCelularField);
        
        add(new JLabel("Email:"));
        add(emailField);
        
        add(new JLabel("Endereco:"));
        add(enderecoField);
        
        add(new JLabel("Cargo:"));
        add(cargoField);
        
        add(new JLabel("Salario:"));
        add(salarioField);
        
        add(new JLabel("Data de Contratacao:"));
        add(dataContratacaoField);
        
        add(new JLabel("Horario de Trabalho:"));
        add(horarioTrabalhoField);
        
        add(new JLabel("Nome de Utilizador:"));
        add(nomeUtilizadorField);
        
        add(new JLabel("Password:"));
        add(passwordField);
        
        add(new JLabel("Observacoes:"));
        add(observacoesField);

        saveButton = new JButton("Save");
        cancelButton = new JButton("Cancel");

        constraints.gridx = 0;
        constraints.gridy = 12;
        add(saveButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 12;
        add(cancelButton, constraints);

        saveButton.setActionCommand("save");
        cancelButton.setActionCommand("cancel");

        saveButton.addActionListener(this);
        cancelButton.addActionListener((ActionListener) this);
        
        setBorder(BorderFactory.createTitledBorder("Registar Funcionario"));
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("save")) {
            // ... handle save button action here ...
            Funcionario funcionario = new Funcionario();
            System.out.println(funcionario.getLoginName());
            int id = JSqlCon.getId("funcionario");

            Medico med = new Medico();

            funcionario.setNome(nomeField.getText());
            funcionario.setDataNasc(null);
            funcionario.setGenero(generoField.getText());
            funcionario.setBi(numeroBIField.getText());
            funcionario.setNacionalidade(nacionalidadeField.getText());
            funcionario.setEndereco(enderecoField.getText());
            funcionario.setCelular(numeroCelularField.getText());
            funcionario.setEmail(emailField.getText());
            funcionario.setCargo(cargoField.getText());
            funcionario.setDataContratacao(null);
            funcionario.setSalario(Float.parseFloat(salarioField.getText()));
            funcionario.setHorarioTrabalho(horarioTrabalhoField.getText());
            funcionario.setStatus(true);
            funcionario.setLoginName(nomeUtilizadorField.getText());
            funcionario.setLoginPwd(passwordField.getText());
            funcionario.setAccessPermiss(true);
            funcionario.setHistorico(null);
            funcionario.setObs(observacoesField.getText());

            funcionario.setFuncId(id);
            funcionario = new Funcionario(++id,funcionario.getNome(),funcionario.getDataNasc(),funcionario.getGenero(),funcionario.getBi(),
            funcionario.getNacionalidade(),funcionario.getEndereco(), funcionario.getCelular(), funcionario.getEmail(), funcionario.getCargo(),
            funcionario.getDataContratacao(),funcionario.getSalario(),funcionario.getHorarioTrabalho(), funcionario.getStatus(), funcionario.getLoginName(),
            funcionario.getLoginPwd(),funcionario.getAccessPermiss(), funcionario.getHistorico(), funcionario.getObs());

            Funcionario.funcionarios.add(funcionario);//salvar funcionarios no arraylist

            Funcionario.salvarDados(Funcionario.funcionarios, null, "src/File/ficheiros/funcionarios.dat");

            JSqlCon.insertIntoFuncionario("funcionario", ++id, med.getEspecialidade(), med.getCRM() , funcionario.getCargo(), funcionario.getDataContratacao(),
            funcionario.getSalario(), funcionario.getNome(), funcionario.getDataNasc(), funcionario.getGenero(), funcionario.getNacionalidade(), funcionario.getEndereco(),
            funcionario.getEmail(), funcionario.getCelular(), funcionario.getStatus(), funcionario.getObs(), 1, funcionario.getHorarioTrabalho(), funcionario.getLoginName());
            
            //clear all textfields
            nomeField.setText("");
            generoField.setText("");
            dataNascimentoField.setText("");
            numeroBIField.setText("");
            nacionalidadeField.setText("");
            numeroCelularField.setText("");
            emailField.setText("");
            enderecoField.setText("");
            cargoField.setText("");
            salarioField.setText("0.00");
            dataContratacaoField.setText("");
            horarioTrabalhoField.setText("");
            nomeUtilizadorField.setText("");
            passwordField.setText("");
            observacoesField.setText("");
            JOptionPane.showMessageDialog(null,"Dados salvos com Sucesso");

        } else if (e.getActionCommand().equals("cancel")) {
            // ... handle cancel button action here ...
            //dispose panel
            Window parentWindow = SwingUtilities.getWindowAncestor(PainelRegistarFunc.this);

            if (parentWindow != null) {
                // Dispose of the parent window
                parentWindow.dispose();
        }

            //open main panel
            MainPanel mainPanel = new MainPanel();
            mainPanel.setVisible(true);
        }
    }
}