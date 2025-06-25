/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import apoio.ConexaoMySQL;
import apoio.IDAOT;
import entidade.Entregas;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author maicon-dias
 */
public class EntregasDAO implements IDAOT <Entregas> {

    @Override
    public String salvar(Entregas o) {
        try {
            System.out.println("SQL: teste");
            Statement st = ConexaoMySQL.getInstance().getConnection().createStatement();

            String sql = "INSERT into Entregas "
                    + "values"
                    + "(default, "
                    + "'" + o.getDestino() + "',"
                    + "'" + o.getCargaPerigosa() + "',"
                    + "'" + o.getStatus() + "',"
                    + "'" + o.getDataEntrega() + "',"
                    + "'" + o.getIdMotorista() + "',"
                    + "'" + o.getIdVeiculo() + "')";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir C: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Entregas o) {
        try {
            Statement st = ConexaoMySQL.getInstance().getConnection().createStatement();

            String sql = "UPDATE Entregas "
                    + "SET "
                    + "destino = '" + o.getDestino() + "', "
                    + "carga_perigosa = " + o.getCargaPerigosa() + ", "
                    + "status = '" + o.getStatus() + "', "
                    + "data_entrega = '" + o.getDataEntrega() + "', "
                    + "id_motoristas = " + o.getIdMotorista() + ", "
                    + "id_veiculos = " + o.getIdVeiculo() + " "
                    + "WHERE id = " + o.getIdEntrega() + ";";

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

            String sql = "DELETE FROM Entregas "
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
    public ArrayList<Entregas> consultarTodos() {
            
        ArrayList<Entregas> veiculos = new ArrayList();
        
        try {
            Statement st = ConexaoMySQL.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from Entregas "
                    + "order by id";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);
            
            while (retorno.next()) {
                Entregas entregas = new Entregas();
                
                entregas.setIdEntrega(retorno.getInt("id"));
                entregas.setDestino(retorno.getString("destino"));
                entregas.setCargaPerigosa(retorno.getBoolean("carga_perigosa"));
                entregas.setStatus(retorno.getString("status"));
                entregas.setDataEntrega(retorno.getString("data_entrega"));
                entregas.setIdMotorista(retorno.getInt("id_motoristas"));
                entregas.setIdVeiculo(retorno.getInt("id_veiculos"));
                
                veiculos.add(entregas);                
            }


        } catch (Exception e) {
            System.out.println("Erro ao consultar base de dados: " + e);
        }
        
        return veiculos;
    }

    @Override
    public ArrayList<Entregas> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entregas consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
