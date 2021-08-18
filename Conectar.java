package Ativ8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conectar {
    
    private Connection connect;
    public Conectar(){
        this.connect = null;
    }
    
    private void setConnect(Connection connect){
        this.connect = connect;
    }
    public Connection getConnect(){
        return this.connect;
    }
    
    public boolean abrirConexao(){
      
      try
      {
        // create a database connection
        connect = DriverManager.getConnection("jdbc:sqlite:C:/Users/marcu/ProjetoTp8/tp8.db");
        this.setConnect(connect);        
        return true;

      }
      catch(SQLException e)
      {        
        return false;
      }
    }
      public boolean fecharConexao(){
        try
        {
          if(this.getConnect() != null)
                this.getConnect().close();
                return true;
        }
        catch(SQLException e)
        {
          return false;
        }
    }
}