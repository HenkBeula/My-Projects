package src.db;

import java.sql.*;
import java.text.MessageFormat;
import java.time.LocalDate;

/**
 * JSqlCon
 */
public class JSqlCon {
    static final String DB_URL = "jdbc:mysql://localhost:3306/clinicaeit";
    static final String USER = "root";
    static final String PASS = "";
    static final String QUERY = "SELECT * FROM funcionario, Paciente";
    static Connection conn;

    public static boolean connectDb() {
        try {// Open a connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return true;
        } catch (Exception e) {
            System.out.println("Occoreu um erro ao se conectar a base de dados!");
        }
        return false;
    }

    public static int getId(String table) {
        int id = 0;
        connectDb();
        String query = MessageFormat.format("SELECT ID FROM {0} ORDER BY ID DESC LIMIT 1", table);
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                id = rs.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    // Testing DB connection
    public static void getData() {
        connectDb();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("ID"));
                System.out.print(", Login Name: " + rs.getString("LoginName"));
                System.out.print(", Name: " + rs.getString("Nome") + "\n");
                System.out.print(", Tipo de perfil: " + rs.getString("TipoUsuarioID") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoPaciente(int id, String loginName, String nome, int numeroSeguroSaude,
            Date dataNascimento, String genero, String nacionalidade, String endereco, String email, String celular,
            boolean status, String observacao, int tipoUsuarioID) {
        connectDb();
        try {
            String update = MessageFormat.format(
                    "INSERT INTO `Paciente` (`ID`, `LoginName`, `Nome`, `NumeroSeguroSaude`, `DataNascimento`, `Genero`, `Nacionalidade`, `Endereco`, `Email`, `Celular`, `Status`, `Observacao`, `TipoUsuarioID`) VALUES ({0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12})",
                    id, loginName, nome, numeroSeguroSaude, dataNascimento, genero, nacionalidade, endereco, email,
                    celular, status, observacao, tipoUsuarioID);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(update);
            System.out.println("Sucesso");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void insertIntoFuncionario(String table, int id, String especialidade, int CRM, String cargo,
            LocalDate dataContratacao, float salario, String nome, Date dataNascimento, String genero,
            String nacionalidade, String endereco, String email, String celular, boolean status, String observacao,
            int tipoUsuarioID, String horarioTrabalho, String loginName) {
        connectDb();
        try {
            String update = MessageFormat.format(
                    "INSERT INTO {0} (`ID`, `Especialidade`, `CRM`, `Cargo`, `DataContratacao`, `Salario`, `Nome`, `DataNascimento`,"+
                    " `Genero`, `Nacionalidade`, `Endereco`, `Email`, `Celular`, `Status`, `Observacao`, `TipoUsuarioID`, `HorarioTrabalho`,"+
                    " `LoginName`) VALUES ('"+id+"', '"+especialidade+"', '"+CRM+"', '"+cargo+"', '"+dataContratacao+"', '"+salario+"', '"+"'"+nome+"'"+"', '"+dataNascimento+"', '"+"'"+genero+"'"+"', '"+nacionalidade+"',"+
                    " '"+endereco+"', '"+email+"', '"+celular+"', '"+status+"', '"+"'"+observacao+"'"+"', '"+tipoUsuarioID+"', '"+horarioTrabalho+"', '"+"'"+loginName+"'"+"')", table
                );

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(update);
            System.out.println("Sucesso");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
