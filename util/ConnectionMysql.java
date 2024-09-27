package util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql{

    private static final String URL = "jdbc:mysql://localhost:3306/auto-luxurrie";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";
    public static Connection connection = null;

    public static Connection openConnection(){
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado com sucesso.");
        } catch (SQLException e){
            System.out.println("Problemas ao conectar no banco " + e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        try{
            if(!connection.isClosed()){
                connection.close();
                System.out.println("Conexão encerrada com sucesso.");
            }
        } catch (SQLException e){
            System.out.println("Problemas ao fechar conexão " + e.getMessage());
        }
    }

}
