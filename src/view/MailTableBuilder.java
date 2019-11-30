package view;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MailTableBuilder {

    public static String build(String tableName) {
        return "CREATE TABLE IF NOT EXISTS "+ tableName +" (\n"
                    + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                    + " direccion text NOT NULL);";
    }
}
