/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seeleMain;

import apoio.ConexaoBD;
import java.sql.*;
import javax.swing.JOptionPane;
import view.LoginView;

/**
 *
 * @author engenharia06 & maicon-dias
 */

public class SeeleMain {
    static Connection conexao = null;
    
    public static void main(String[] args) {
        //new FrmPrincipal().setVisible(true);
//
//        if (abrirConexao()) {
//            new FrmPrincipal().setVisible(true);
//        } else {
//            JOptionPane.showMessageDialog(null, "Erro ao conectar no Banco de Dados!");
//        }

        // com classe ConexaoBD.java
        if(ConexaoBD.getInstance().getConnection() != null) {
            new LoginView().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no Banco de dados!");
        }
    } 
//    private static boolean abrirConexao() {
//        try {
//            String dbdriver = "org.postgresql.Driver";
//            String dburl = "jdbc:postgresql://localhost:5432/oficina";
//            String dbuser = "postgres";
//            String dbsenha = "postgres";
//
//            // Carrega Driver do Banco de Dados
//            Class.forName(dbdriver);
//
//            if (dbuser.length() != 0) // conexão COM usuário e senha
//            {
//                conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);
//            } else // conexão SEM usuário e senha
//            {
//                conexao = DriverManager.getConnection(dburl);
//            }
//
//            return true;
//
//        } catch (Exception e) {
//            System.err.println("Erro ao tentar conectar: " + e);
//            return false;
//        }
//    }
}
