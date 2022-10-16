package net.sqlitetutorial;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SelectMovie {
    private Connection connect() {
        String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 public void selectAll(){
        String sql = "SELECT name,lead_actor,lead_actress,director,year_of_release FROM movies";
        try (Connection conn = this.connect();
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql)){
            while (rs.next()) {
                System.out.println(
                                                    rs.getString("name") + "\t" +
                                                    rs.getString("lead_actor")  + "\t"  +
                                                    rs.getString("lead_actress")  +  "\t" +
                                                    rs.getString("director") + "\t" +
                                                    rs.getInt("year_of_release");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        SelectMovie mov = new SelectMovie();
        mov.selectAll();
    }

}