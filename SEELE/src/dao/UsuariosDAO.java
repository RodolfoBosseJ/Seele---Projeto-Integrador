/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoMySQL;
import apoio.IDAOT;
import entidade.Usuarios;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author maicon-dias
 */
public class UsuariosDAO implements IDAOT<Usuarios> {

    @Override
    public String salvar(Usuarios o) {
                try {
            Statement st = ConexaoMySQL.getInstance().getConnection().createStatement();

            String sql = "INSERT into Usuarios "
                    + "values"
                    + "(default, "
                    + "'" + o.getNome() + "',"
                    + "'" + o.getLogin() + "',"
                    + "'" + o.getSenha() + "',"
                    + "'" + o.getTipoAcesso() + "',"
                    + "" + o.getAtivo() + ")";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir C: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Usuarios o) {
        try {
            Statement st = ConexaoMySQL.getInstance().getConnection().createStatement();

            String sql = "UPDATE Usuarios "
                    + "SET "
                    + "nome = '" + o.getNome() + "', "
                    + "login = '" + o.getLogin() + "', "
                    + "senha = '" + o.getSenha() + "', "
                    + "tipo_acesso = '" + o.getTipoAcesso() + "', "
                    + "ativo = " + o.getAtivo() + " "
                    + "WHERE id = " + o.getIdUsuario() + ";";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir C: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
         Statement st = ConexaoMySQL.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM Usuarios "
                    + "WHERE id = " + id + ";";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir C: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Usuarios> consultarTodos() {
            
        ArrayList<Usuarios> list = new ArrayList();
        
        try {
            Statement st = ConexaoMySQL.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from usuarios "
                    + "order by id";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);
            
            while (retorno.next()) {
                Usuarios obj = new Usuarios();
                
                obj.setIdUsuario(retorno.getInt("id"));
                obj.setNome(retorno.getString("nome"));
                obj.setLogin(retorno.getString("login"));
                obj.setSenha(retorno.getString("senha"));
                obj.setTipoAcesso(retorno.getString("tipo_acesso"));
                obj.setAtivo(retorno.getBoolean("ativo"));
                
                list.add(obj);                
            }


        } catch (Exception e) {
            System.out.println("Erro ao consultar base de dados: " + e);
        }
        
        return list;
    }

    @Override
    public ArrayList<Usuarios> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuarios consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
