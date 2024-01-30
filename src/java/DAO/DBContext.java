/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Child;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xuan Vinh
 */
public class DBContext implements DatabaseInfo {

    public static Connection getConnect() {
        try {
            Class.forName(DRIVERNAME);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver" + e);
        }
        try {
            Connection con = DriverManager.getConnection(DBURL, USERDB, PASSDB);
            return con;
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    /*public static Connection getConnect(){
        try{
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
                    DataSource ds = (DataSource) envContext.lookup("jdbc/mydb");
                    return ds.getConnection();
        } catch (SQLException | NamingException ex){
            System.out.println("Error: " + ex);
        }
        return null;
    }*/
   
//--------------------------------------------------------------------------------------------

   
 
//-----------------------------------------------------------------------------------


//-------------------------------------------------------------------------------------------
    public static ArrayList<Child> listAll() {
        ArrayList<Child> list = new ArrayList<>();
        //Connection con = getConnect();
        try (Connection con = getConnect()) {
            PreparedStatement stmt = con.prepareStatement("Select ChildID, Name, Age from DE180289 where Age > 5 ");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Child(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            con.close();
            return list;
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//--------------------------------------------------------------------------------------------

   
//-------------------------------------------------------------------------------------------------        

    
//------------------------------------------------------------

    
//---------------------------------------------------------
    public static void main(String[] a) {
        ArrayList<Child> list = DBContext.listAll();
        for (Child item : list) {
            System.out.println(item);
        }
    }
//---------------------------------------------------------------------------

}
