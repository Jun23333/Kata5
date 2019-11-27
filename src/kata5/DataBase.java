package kata5;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.*;

class DataBase {
    private String URL;
    private Connection connection = null;
    
    public DataBase(String URL) {
        this.URL = URL;
    }

    void open() {
        try {
            this.connection = DriverManager.getConnection(this.URL);
            System.out.println("OPEN");
        } catch (SQLException e) {
            System.out.println("OPEN ERROR: " + e.getMessage());
        }
    }

    void close() {
        try {
            if(this.connection != null)  {
                this.connection.close();
                System.out.println("CLOSE");
            }
        } catch (SQLException e) {
            System.out.println("CLOSE ERROR: " + e.getMessage());
        }
    }
    
    public void selectAll(){
    String sql = "SELECT * FROM PEOPLE";
        try (Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            // Bucle sobre el conjunto de registros.
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                rs.getString("Nombre") + "\t" +
                rs.getString("Apellidos") + "\t" +
                rs.getString("Departamento") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    void createTableMail(String tableName) {
        CreateTable newTable = new CreateMailTable(connection, tableName);
        newTable.create();
    }

    void addToTable(String tableName, List<Mail> mailList) {
        String sql;
        for (Mail mail : mailList) {
            sql = "INSERT INTO "+tableName+"(direccion) VALUES ('"+mail.getDomain()+"')";
            try (Statement stmt = connection.createStatement()) {
                stmt.execute(sql);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
        }
        System.out.println("Fin insertar email");
    }
}
