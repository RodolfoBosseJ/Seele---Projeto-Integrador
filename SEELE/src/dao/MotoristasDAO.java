/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import apoio.ConexaoMySQL;
import apoio.IDAOT;
import entidade.Motoristas;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author maicon-dias
 */
public class MotoristasDAO implements IDAOT <Motoristas> {

    @Override
    public String salvar(Motoristas o) {
                try {
            Statement st = ConexaoMySQL.getInstance().getConnection().createStatement();

            String sql = "INSERT into Motoristas "
                    + "values"
                    + "(default, "
                    + "'" + o.getNome() + "',"
                    + "'" + o.getCpf() + "',"
                    + "'" + o.getCnh() + "',"
                    + "'" + o.getCategoriaCnh() + "',"
                    + "'" + o.getValidadeCnh() + "',"
                    + "default);";
                    
            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir C: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Motoristas o) {
        try {
            Statement st = ConexaoMySQL.getInstance().getConnection().createStatement();

            String sql = "UPDATE Motoristas "
                    + "SET "
                    + "nome = '" + o.getNome() + "', "
                    + "cpf = '" + o.getCpf() + "', "
                    + "cnh = '" + o.getCnh() + "', "
                    + "categoria_cnh = '" + o.getCategoriaCnh() + "', "
                    + "validade_cnh = '" + o.getValidadeCnh() + "'"
                    + "WHERE id = " + o.getIdMotorista() + ";";

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

            String sql = "DELETE FROM Motoristas "
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
    public ArrayList<Motoristas> consultarTodos() {
            
        ArrayList<Motoristas> veiculos = new ArrayList();
        
        try {
            Statement st = ConexaoMySQL.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from Motoristas "
                    + "order by id";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);
            
            while (retorno.next()) {
                Motoristas veiculo = new Motoristas();
                
                veiculo.setIdMotorista(retorno.getInt("id"));
                veiculo.setNome(retorno.getString("nome"));
                veiculo.setCpf(retorno.getString("cpf"));
                veiculo.setCnh(retorno.getString("cnh"));
                veiculo.setCategoriaCnh(retorno.getString("categoria_cnh"));
                veiculo.setValidadeCnh(retorno.getString("validade_cnh"));
                
                veiculos.add(veiculo);                
            }


        } catch (Exception e) {
            System.out.println("Erro ao consultar base de dados: " + e);
        }
        
        return veiculos;
    }

    @Override
    public ArrayList<Motoristas> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Motoristas consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
