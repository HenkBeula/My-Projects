package src;
import src.db.JSqlCon;
import src.personel.*;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * App
 */


public class App extends JPanel {

    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;

    public App() {
        // Set the layout manager n
        setLayout(new GridBagLayout());

        // Initialize components
        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");

        // Configure components
        usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // Add components to the panel
        add(usernameLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.NONE,
                new Insets(10, 10, 5, 5), 0, 0));
        add(usernameField, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(10, 0, 5, 10), 0, 0));
        add(passwordLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.NONE,
                new Insets(5, 10, 5, 5), 0, 0));
        add(passwordField, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                new Insets(5, 0, 5, 10), 0, 0));
        add(loginButton, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 10, 10, 5), 0, 0));
        add(cancelButton, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 10, 10), 0, 0));

        // Add action listeners
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (user.equals("admin") && password.equals("admin")) {
                    // if login is successful, dispose the login dialog and open the main panel
                    
                    // Dispose of the App frame
                    Window window = SwingUtilities.windowForComponent(App.this);
    
                    if (window instanceof Frame) {
                        // Dispose of the parent frame
                        ((Frame) window).dispose();
                    } else if (window instanceof Dialog) {
                        // Dispose of the parent dialog
                        ((Dialog) window).dispose();
                    }
                    // Open the main panel
                    MainPanel mainPanel = new MainPanel();
                    mainPanel.setVisible(true);
                    //frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Here, you can handle the cancel button action
                // For example, you can close the application or
                // the login dialog
                System.exit(0);
            }
        });
    }

    

    public static void main(String[] args) {
        // Create a frame to hold the panel
        JFrame frame = new JFrame("Login Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel and add it to the frame
        App panel = new App();
        frame.getContentPane().add(panel);

        // Display the frame
        frame.pack();
        frame.setVisible(true);
    }

    public static void registorUtilizador(){
        Scanner sc =  new Scanner(System.in);
        System.out.println(
            "\nSistema de agendamento de consultas\n\n"+
            "1.Registar Paciente\n"+
            "2.Registar Funcionario\n\n"+
            "Escolha uma opcao"
        );

        int escolha;

        do{
            escolha = sc.nextInt();
            switch(escolha){
                case 1:
                    System.out.println("Brevemente");
                    escolha=0;
                    break;
                case 2:
                    System.out.println("Brevemente");
                    escolha=0;
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }while(escolha!=0);

        sc.close();
    }
}