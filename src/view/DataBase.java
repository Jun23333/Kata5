package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.*;

public class DataBase {
    private String URL;
    private Connection connection = null;
    
    public DataBase(String URL) {
        this.URL = URL;
    }

    public void open() {
        try {
            this.connection = DriverManager.getConnection(this.URL);
            System.out.println("OPEN");
        } catch (SQLException e) {
            System.out.println("OPEN ERROR: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if(this.connection != null)  {
                this.connection.close();
                System.out.println("CLOSE");
            }
        } catch (SQLException e) {
            System.out.println("CLOSE ERROR: " + e.getMessage());
        }
    }
    
    public void selectAllPeople(){
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

    public void addMailTable(String tableName) {
        String sql = "CREATE TABLE IF NOT EXISTS "+ tableName +" (\n"
                    + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                    + " direccion text NOT NULL);";
        try (Statement stmt = connection.createStatement()) {
            // Se crea la nueva tabla
            stmt.execute(sql);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println("No se ha podido crear la tabla");
        } 
    }
    
    public void addMailToTable(String tableName, List<Mail> mailList) {
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
