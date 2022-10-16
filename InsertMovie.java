package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsertMovie {
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
    public void insert(String name, String lead_actor,String lead_actress,String director,Integer  year_of_release) {
        String sql = "INSERT INTO movies(name,lead_actor,lead_actress,director,year_of_release) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, lead_actor);
            pstmt.setString(3, lead_actress);
            pstmt.setString(4, director);
            pstmt.setInteger(5, year_of_release);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
public static void main(String[] args) {
InsertMovie mov = new InsertMovie();
        mov.insert("KRK", "Vijay Sethupathi","Samantha","Wikky",2022);
        mov.insert("Indian", "Kamal","Manisha","Shankar",2001);
        mov.insert("VTV", "Simbu","Trisha","GVM",2010);
        mov.insert("Iron Man","Robert Downey","Bibb","John Favreau",2008);
    }
}