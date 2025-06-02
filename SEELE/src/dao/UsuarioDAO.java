/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Usuario;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author maicon-dias
 */
public class UsuarioDAO implements IDAOT<Usuario> {

    @Override
    public String salvar(Usuario o) {
        // exemplo de insercao
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into Cliente "
                    + "values"
                    + "(default, "
                    + "'" + o.getIdUsuario() + "',"
                    + "'" + o.getNome() + "',"
                    + "'" + o.getLogin() + "',"
                    + "'" + o.getSenha() + "',"
                    + "'" + o.getTipoAcesso() + "',"
                    + "'" + o.getAtivo() + "')";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir C: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> consultarTodos() {
        
        ArrayList<Usuario> usuarios = new ArrayList();
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from cliente "
                    + "order by id";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);
            
            while (retorno.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setIdUsuario(retorno.getInt("id_usuario"));
                usuario.setNome(retorno.getString("nome"));
                usuario.setLogin(retorno.getString("login"));
                usuario.setTipoAcesso(retorno.getString("tipo_acesso"));
                usuario.setAtivo(retorno.getBoolean("ativo"));
                
                usuarios.add(usuario);                
            }


        } catch (Exception e) {
            System.out.println("Erro ao consultar USUARIOS: " + e);
        }
        
        return usuarios;
    }

    @Override
    public ArrayList<Usuario> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
