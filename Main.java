package Ativ8;


import Ativ8.Conectar;
import Ativ8.Construir;
import java.sql.Statement;
import java.sql.SQLException;


public class Main
{
    public static void main(String args[])throws Exception{
        Conectar connect = new Conectar();
        connect.abrirConexao();
        Construir construir = new Construir(connect.getConnect());
        
        // Inserindo cadastro no banco
        //construir.createDono(60541704, "Marcus Souza");
        
        // Consultar uma linha no banco
        //System.out.println(construir.readDono(940));
        //System.out.println(construir.readPet(2));
        
        // Alterar um registro no banco
        //construir.updateDono(460,"NovoNome");
        //construir.updatePet(1,"luna");
        
        
        // Deletar um registro no banco
        //construir.deleteDono(460);
        //construir.deletePet(4);
        
        //System.out.println(construir.likeDono("m"));
        
        System.out.println(construir.likePet("l"));
    }
}
