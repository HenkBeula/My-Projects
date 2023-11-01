package src;
import javax.swing.*;
import src.personel.Paciente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JFrame {
    public MainPanel() {
        setTitle("Sistema de agendamento de consultas");
        setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton regFuncBtn = new JButton("Registrar funcionario");
        JButton visAgendaBtn =  new JButton("Visualizar agenda");
        JButton regPacBtn = new JButton("Registrar paciente");
        JButton confConsultBtn = new JButton("Confirmar consultas");
        JButton hisMedBtn = new JButton("Historico medico");

        JToolBar toolbar = new JToolBar();
        toolbar.add(regFuncBtn);
        toolbar.add(regPacBtn);
        toolbar.add(confConsultBtn);
        toolbar.add(visAgendaBtn);
        toolbar.add(hisMedBtn);
        panel.add(toolbar, BorderLayout.NORTH);

        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Adding action listeners to the buttons
        regPacBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 //dispose of the panel
                dispose();

                // Open panel for registering func
                MainPanel mainPanel = new MainPanel();
                mainPanel.setVisible(false);

                JFrame frame = new JFrame("Painel Registar de Paciente");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new PainelRegistarPac());
                frame.pack();
                frame.setVisible(true);
            }
        });

        regFuncBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose of the panel
                dispose();

                // Open panel for registering func
                MainPanel mainPanel = new MainPanel();
                mainPanel.setVisible(false);

                JFrame frame = new JFrame("Painel Registar de Funcionario");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new PainelRegistarFunc());
                frame.pack();
                frame.setVisible(true);
                
            }
        });

        hisMedBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open panel for viewing schedule
                Paciente paciente=  new Paciente();
                int pacId = Integer.parseInt(JOptionPane.showInputDialog("Numero do Paciente"));
                for (Paciente Pacient : Paciente.pacientes) {
                    if(paciente.getPacId()==pacId)
                        JOptionPane.showMessageDialog(null, paciente.getHistoricoMedico(), "Historico Medico", ABORT);
                }
            }
        });

        confConsultBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open panel for Confirm consulta
                JFrame frame = new JFrame("Confirmar Consulta");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new ConfirmarConsultaPanel());
                frame.pack();
                frame.setVisible(true);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
    }
}