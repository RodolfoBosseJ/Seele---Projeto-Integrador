/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import apoio.ConexaoMySQL;
import apoio.IDAOT;
import entidade.Veiculos;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author maicon-dias
 */
public class VeiculosDAO implements IDAOT <Veiculos> {

    @Override
    public String salvar(Veiculos o) {
                try {
            Statement st = ConexaoMySQL.getInstance().getConnection().createStatement();

            String sql = "INSERT into Veiculos "
                    + "values"
                    + "(default, "
                    + "'" + o.getPlaca() + "',"
                    + "'" + o.getModelo() + "',"
                    + "'" + o.getTipo() + "',"
                    + "'" + o.getCapacidade() + "',"
                    + "'" + o.getStatus() + "')";
                    //+ "'" + o.getDocVencimento() + "')";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir C: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Veiculos o) {
        try {
            Statement st = ConexaoMySQL.getInstance().getConnection().createStatement();

            String sql = "UPDATE Veiculos "
                    + "SET "
                    + "placa = '" + o.getPlaca() + "', "
                    + "modelo = '" + o.getModelo() + "', "
                    + "tipo = '" + o.getTipo() + "', "
                    + "capacidade = '" + o.getCapacidade() + "', "
                    + "status = '" + o.getStatus() + "'"
                    + "WHERE id = " + o.getIdVeiculo() + ";";

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

            String sql = "DELETE FROM Veiculos "
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
    public ArrayList<Veiculos> consultarTodos() {
            
        ArrayList<Veiculos> veiculos = new ArrayList();
        
        try {
            Statement st = ConexaoMySQL.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from veiculos "
                    + "order by id";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);
            
            while (retorno.next()) {
                Veiculos veiculo = new Veiculos();
                
                veiculo.setIdVeiculo(retorno.getInt("id"));
                veiculo.setPlaca(retorno.getString("placa"));
                veiculo.setModelo(retorno.getString("modelo"));
                veiculo.setTipo(retorno.getString("tipo"));
                veiculo.setCapacidade(retorno.getFloat("capacidade"));
                veiculo.setStatus(retorno.getString("status"));
                //veiculos.setDocVencimento(retorno.getString("doc_vencimento"));
                
                veiculos.add(veiculo);                
            }


        } catch (Exception e) {
            System.out.println("Erro ao consultar base de dados: " + e);
        }
        
        return veiculos;
    }

    @Override
    public ArrayList<Veiculos> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Veiculos consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
