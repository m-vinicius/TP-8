package Ativ8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Construir
{
    //cria o objeto do tipo conectar
    private Connection conectar;
    public Construir(Connection conectar){
        this.conectar = conectar;
    }
    
    // Insert Dono
    public boolean createDono(int cpf, String nome){
        try{
            
            Statement statement = this.conectar.createStatement();
            statement.executeUpdate("INSERT INTO Dono VALUES("+cpf+", '"+nome+"')");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    // Insert Pet
    public boolean createPet(int IdPet, String NomePet, int CpfDono){
        try{
            
            Statement statement = this.conectar.createStatement();
            statement.executeUpdate("INSERT INTO Pet VALUES("+IdPet+", '"+NomePet+"',"+CpfDono+")");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    // Pesquisar Dados no banco(tabela Dono)
    
    public boolean readDono(int cpf){
        try{
            Statement statement = this.conectar.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Dono WHERE cpf = "+cpf);

            //ResultSet rs = statement.executeQuery("SELECT * FROM Aluno");
            
            while (rs.next()) {
                Integer id = rs.getInt("cpf");
                String Nome = rs.getString("Nome");

                System.out.println( cpf +" - " + Nome);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    // Pesquisar Dados no banco (tabela Pet)
    
    public boolean readPet(int IdPet){
        try{
            Statement statement = this.conectar.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Pet WHERE IdPet = "+IdPet);

            //ResultSet rs = statement.executeQuery("SELECT * FROM Aluno");
            
            while (rs.next()) {
                Integer idPet = rs.getInt("IdPet");
                String NomePet = rs.getString("NomePet");
                Integer CpfDono = rs.getInt("CpfDono");

                System.out.println( IdPet +" - " + NomePet + " - " + CpfDono);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    // Atualizar(tabelo Dono)
    
    public boolean updateDono(int cpf, String novoNome){
        try{
            Statement statement = this.conectar.createStatement();
            statement.executeUpdate("UPDATE Dono SET nome ='"+novoNome+"' WHERE CPF ="+cpf);
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    // Atualizar(tabela Pet)
    
    public boolean updatePet(int IdPet, String novoNomePet){
        try{
            Statement statement = this.conectar.createStatement();
            statement.executeUpdate("UPDATE Pet SET NomePet ='"+novoNomePet+"' WHERE IdPet ="+IdPet);
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    // Deletar(Tabela Dono)
    
    public boolean deleteDono(int cpf){
        try{
            Statement statement = this.conectar.createStatement();
            statement.executeUpdate("DELETE FROM Dono WHERE CPF ="+cpf+"");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    // Deletar(Tabela Pet)
    
    public boolean deletePet(int IdPet){
        try{
            Statement statement = this.conectar.createStatement();
            statement.executeUpdate("DELETE FROM Pet WHERE IdPet ="+IdPet+"");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    // Adicionar lista Dono
    
    // Usando comando LIKE
    
    public boolean likeDono(String Nome){
        try{
            Statement statement = this.conectar.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Dono WHERE Nome LIKE %M% = "+Nome);

            //ResultSet rs = statement.executeQuery("SELECT * FROM Aluno");
            
            //while (rs.next()) {
                //Integer id = rs.getInt("cpf");
                String nome = rs.getString("Nome");

                System.out.println( " > " + Nome);
            //}
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    
    public boolean likePet(String nomePet){
        try{
            Statement statement = this.conectar.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Dono WHERE Nome LIKE  %M% =" +nomePet);

            //ResultSet rs = statement.executeQuery("SELECT * FROM Aluno");
            
            //while (rs.next()) {
                //Integer id = rs.getInt("cpf");
                String nome = rs.getString("nomePet");

                System.out.println( " > " + nomePet);
            //}
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
}
