package src;

import javax.swing.*;
import src.db.JSqlCon;
import src.personel.Funcionario;
import src.personel.Paciente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelRegistarPac extends JPanel implements ActionListener {
    private JButton saveButton;
    private JButton cancelButton;

    private JTextField nomeField = new JTextField();
    private JTextField dataNascField = new JTextField();
    private JTextField generoField = new JTextField();
    private JTextField biField = new JTextField();
    private JTextField nacionalidadeField = new JTextField();
    private JTextField emergencyInfoField = new JTextField();
    private JTextField enderecoField = new JTextField();
    private JTextField emailField = new JTextField();
    private JTextField celularField = new JTextField();
    private JTextField estadoCivilField = new JTextField();
    private JTextField numeroSegSaudeField = new JTextField("0");
    private JTextField historicoMedicoField = new JTextField();
    private JTextField loginNameField = new JTextField();
    private JTextField loginPwdField = new JTextField();
    private JTextField accessPermissField = new JTextField();
    private JTextField statusField = new JTextField();
    private JTextField obsField = new JTextField();

    public PainelRegistarPac() {
        setLayout(new GridLayout(22, 2));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        add(new JLabel("Nome:"));
        add(nomeField);
        
        add(new JLabel("Genero:"));
        add(generoField);
        
        add(new JLabel("Data de Nascimento:"));
        add(dataNascField);
        
        add(new JLabel("Numero de BI:"));
        add(biField);
        
        add(new JLabel("Nacionalidade:"));
        add(nacionalidadeField);
        
        add(new JLabel("Numero de Celular:"));
        add(celularField);
        
        add(new JLabel("Email:"));
        add(emailField);
        
        add(new JLabel("Endereco:"));
        add(enderecoField);
        
        add(new JLabel("Estado civil:"));
        add(estadoCivilField);
        
        add(new JLabel("Numero de suguro de saude"));
        add(numeroSegSaudeField);
        
        add(new JLabel("Historico medico:"));
        add(historicoMedicoField);
        
        add(new JLabel("Informcacao de emergencia:"));
        add(emergencyInfoField);
        
        add(new JLabel("Nome de Utilizador:"));
        add(loginNameField);
        
        add(new JLabel("Password:"));
        add(loginPwdField);
        
        add(new JLabel("Observacoes:"));
        add(obsField);

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
        
        setBorder(BorderFactory.createTitledBorder("Registar Paciente"));
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("save")) {
            // ... handle save button action here ...
            Paciente paciente = new Paciente();
            int id = JSqlCon.getId("paciente");

            paciente.setNome(nomeField.getText());
            paciente.setDataNasc(null);
            paciente.setGenero(generoField.getText());
            paciente.setBi(biField.getText());
            paciente.setNacionalidade(nacionalidadeField.getText());
            paciente.setEndereco(enderecoField.getText());
            paciente.setCelular(celularField.getText());
            paciente.setEmail(emailField.getText());
            paciente.setEstadoCivil(estadoCivilField.getText());
            paciente.setNumeroSegSaude(Integer.parseInt(numeroSegSaudeField.getText()));
            paciente.setHistoricoMedico(historicoMedicoField.getText());
            paciente.setStatus(true);
            paciente.setEmergencyInfo(emergencyInfoField.getText());
            paciente.setLoginPwd(loginNameField.getText());
            paciente.setAccessPermiss(true);
            paciente.setLoginPwd(loginPwdField.getText());
            paciente.setObs(obsField.getText());
            paciente.setPacId(id);

            paciente = new Paciente(++id,
            paciente.getNome(),paciente.getDataNasc(),paciente.getGenero(),paciente.getBi(),paciente.getNacionalidade(),
            paciente.getEmergencyInfo(),paciente.getEndereco(),paciente.getEmail(),paciente.getCelular(),paciente.getEstadoCivil(),
            paciente.getNumeroSegSaude(),paciente.getHistoricoMedico(),paciente.getLoginName(),paciente.getLoginPwd(),
            paciente.getAccessPermiss(),paciente.getStatus(),paciente.getObs());

            Paciente.pacientes.add(paciente);//salvar Pacientes no array

            JSqlCon.insertIntoPaciente(id, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, id, null, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY, getFocusTraversalKeysEnabled(), TOOL_TIP_TEXT_KEY, id);
            
            Funcionario.salvarDados(null, Paciente.pacientes, "src/File/ficheiros/pacientes.dat");
            
        } else if (e.getActionCommand().equals("cancel")) {
            // ... handle cancel button action here ...
            //dispose panel
            Window parentWindow = SwingUtilities.getWindowAncestor(PainelRegistarPac.this);

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