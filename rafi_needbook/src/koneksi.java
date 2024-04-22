
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SMKN 4 BDL
 */
public class koneksi {
    private static Connection KoneksiDatabase;
    
    public static Connection koneksiDB() throws SQLException{
        try{
            String url="jdbc:mysql://localhost:3306/needbook";
            String user="root";
            String password="";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            KoneksiDatabase = DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            System.err.println("koneksi gagal");
        }
        return KoneksiDatabase;
    }
}
