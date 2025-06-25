package apoio;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author maicon-dias
 */

import java.sql.*;
import java.io.*;
import java.util.*;

public class ConexaoMySQL {
    
    private static ConexaoMySQL instancia = null;
    private Connection conexao = null;
    
    public ConexaoMySQL() {
        try {
            // Carrega informações do arquivo de propriedades
            Properties prop = new Properties();            
            prop.load(new FileInputStream("db.properties"));
            
            String dbdriver = prop.getProperty("db.driver");
            String dburl = prop.getProperty("db.url");
            String dbuser = prop.getProperty("db.user");
            String dbsenha = "hackermans";

            // Carrega Driver do Banco de Dados
            Class.forName(dbdriver);

            if (dbuser.length() != 0) // conexão COM usuário e senha
            {
                conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);
            } else // conexão SEM usuário e senha
            {
                conexao = DriverManager.getConnection(dburl);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Retorna instância
    public static ConexaoMySQL getInstance() {
        if (instancia == null) {
            instancia = new ConexaoMySQL();
        }
        return instancia;
    }

    // Retorna conexão
    public Connection getConnection() {
        if (conexao == null) {
            throw new RuntimeException("conexao==null");
        }
        return conexao;
    }

    // Efetua fechamento da conexão
    public void shutDown() {
        try {
            conexao.close();
            instancia = null;
            conexao = null;
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}