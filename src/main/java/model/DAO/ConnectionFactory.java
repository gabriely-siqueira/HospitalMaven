/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; 
    private static final String BANCO = "jdbc:mysql://localhost:3306/hospital";
    private static final String USUARIO = "root";
    private static final String SENHA = "pmt.0519";
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(BANCO + "?verifyServerCertificate=false"
                   + "&useSSL=false" + "&requireSSL=false" 
                   + "&user=" + USUARIO + "&password=" + SENHA 
                   + "&serverTimezone=UTC");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void closeConnection(Connection conexao, PreparedStatement instrucao, ResultSet resultado) { 
        if(resultado != null ){
            try{
            resultado.close();
            instrucao.close();
            conexao.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }  
            }else if (instrucao != null){
                try{
                instrucao.close();
                conexao.close();
                }catch(SQLException ex){
                ex.printStackTrace();
            }  
            }else{
            try{
                conexao.close();
                }catch(SQLException ex){
                ex.printStackTrace();
            }
                
        }
        
    }}
    


