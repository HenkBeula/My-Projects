package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmarConsultaPanel extends JPanel {

    private JLabel numeroDoPacienteLabel;
    private JTextField numeroDoPacienteTextField;
    private JLabel numeroDoMedicoLabel;
    private JTextField numeroDoMedicoTextField;
    private JLabel dataDaConsultaLabel;
    private JTextField dataDaConsultaTextField;
    private JLabel statusLabel;
    private JTextField statusTextField;
    private JComboBox<String> comboBox;
    private JButton saveButton;
    private JButton cancelButton;

    public ConfirmarConsultaPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        numeroDoPacienteLabel = new JLabel("Numero do Paciente:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(numeroDoPacienteLabel, constraints);

        numeroDoPacienteTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(numeroDoPacienteTextField, constraints);

        numeroDoMedicoLabel = new JLabel("Numero de medico:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(numeroDoMedicoLabel, constraints);

        numeroDoMedicoTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        add(numeroDoMedicoTextField, constraints);

        dataDaConsultaLabel = new JLabel("Data da consulta:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(dataDaConsultaLabel, constraints);

        dataDaConsultaTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        add(dataDaConsultaTextField, constraints);

        statusLabel = new JLabel("Status:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(statusLabel, constraints);

        statusTextField = new JTextField("Pendding");
        statusTextField.setEditable(false);
        constraints.gridx = 1;
        constraints.gridy = 3;
        add(statusTextField, constraints);

        comboBox = new JComboBox<>(new String[]{"Aceitar", "Rejeitar", "Remarcar"});
        constraints.gridx = 1;
        constraints.gridy = 4;
        add(comboBox, constraints);

        saveButton = new JButton("Save");
        constraints.gridx = 0;
        constraints.gridy = 5;
        add(saveButton, constraints);

        cancelButton = new JButton("Cancel");
        constraints.gridx = 1;
        constraints.gridy = 5;
        add(cancelButton, constraints);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == saveButton) {
                    // Implement the logic to save the data
                } else if (e.getSource() == cancelButton) {
                    // Implement the logic to cancel the operation
                      // ... handle cancel button action here ...
                    //dispose panel
                    Window parentWindow = SwingUtilities.getWindowAncestor(ConfirmarConsultaPanel.this);
                    if (parentWindow != null) {
                         // Dispose of the parent window
                        parentWindow.dispose();
                    }
                }
            }
        };

        saveButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
    }
}