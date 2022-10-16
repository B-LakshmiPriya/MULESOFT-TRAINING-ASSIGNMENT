package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Create {
    public static void createNewTable() {
        String url = "jdbc:sqlite:C://sqlite/db/tests.db";
        String sql = "CREATE TABLE IF NOT EXISTS movies (\n"
                + "	name text NOT NULL,\n"
                + "	lead_actor text NOT NULL,\n"
                + "	lead_actress text NOT NULL,\n"
                +"                  director text NOT NULL,\n"
                +"                  year_of_release integer\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        createNewTable();
    }

}
