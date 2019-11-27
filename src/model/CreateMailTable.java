package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateMailTable  implements CreateTable{
    
    String tableName;
    Connection connection;

    public CreateMailTable(Connection connection, String tableName) {
        this.tableName = tableName;
        this.connection = connection;
    }

    @Override
    public void create() {
        String sql = "CREATE TABLE IF NOT EXISTS "+ tableName +" (\n"
                    + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                    + " direccion text NOT NULL);";
        try (Statement stmt = connection.createStatement()) {
            // Se crea la nueva tabla
            stmt.execute(sql);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
}
