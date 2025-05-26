/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seeleMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.LoginView;

/**
 *
 * @author engenharia06
 */
public class SeeleMain {
    static Connection conexao = null;
    
    public static void main(String[] args) {
        if(ConexaoBD.getInstance().getConnection() != null) {
            new LoginView().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no Banco de dados!");
        }
    } 
    
    private static boolean abrirConexao () {
        
        String url = "jdbc:postgresql://localhost:5432/seele";
        String usuario = "postgres";
        String senha = "admin";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado com sucesso!");
            conexao.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return false;
        }
    }
}
