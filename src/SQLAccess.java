
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marloncs
 */
public class SQLAccess {
    
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public SQLAccess() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
        }catch(Exception e){    
            throw e;
        }
    }
    
    

    public void insert(Person p) throws SQLException {
        try {
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB","root","root");
                preparedStatement = connect.prepareStatement("INSERT INTO testDB.Person VALUES(?,?,?)");
                preparedStatement.setString(1, p.getCode());
                preparedStatement.setString(2, p.getName());
                preparedStatement.setDate(3, p.getBirthDay());
                int rowsAffected = preparedStatement.executeUpdate();
                
                
        }catch(SQLException e){
            throw e;
        }finally {
            connect.close();
        }
    
    }
    
    
    public int update(Person p) throws  SQLException {
        try {
             connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB","root","root");
                preparedStatement = connect.prepareStatement("UPDATE testDB.Person SET code=?,name=?,birthday=?  WHERE code=?");
                preparedStatement.setString(1, p.getCode());
                preparedStatement.setString(2, p.getName());
                preparedStatement.setDate(3, p.getBirthDay());
                preparedStatement.setString(4, p.getCode());
                return preparedStatement.executeUpdate();
                
        }catch(SQLException e) {
            throw e;
        }finally {
            connect.close();
        }
    }
    
    public int delete(String code)  throws  SQLException {
        try {
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB","root","root");
                preparedStatement = connect.prepareStatement("DELETE FROM Person WHERE code=?");
                preparedStatement.setString(1, code);
                
                return preparedStatement.executeUpdate();
                
        }catch(SQLException e) {
            throw e;
        }finally {
            connect.close();
        }
    }
    
    public ArrayList<Person> getPersons() throws  SQLException {
        try {
            ArrayList<Person> list = new ArrayList();
               connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB","root","root");
               statement = connect.createStatement();
               resultSet = statement.executeQuery("SELECT * FROM Person");
               while (resultSet.next()) {
                    // It is possible to get the columns via name
                    // also possible to get the columns via the column number
                    // which starts at 1
                    // e.g. resultSet.getSTring(2);
                    String code = resultSet.getString("code");
                    String name = resultSet.getString("name");
                    Date date = resultSet.getDate("birthday");
                    list.add(new Person(code, name, date));
                    
                    
                }
                return list;
        }catch(SQLException e) {
            throw e;
        }finally {
            connect.close();
            resultSet.close();
        }
    }
    
}
