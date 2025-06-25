/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author maicon-dias
 */

public class Entregas {
    
    private int id_entrega;
    private String destino;
    private boolean carga_perigosa;
    private String status;
    private String data_entrega;
    private int id_motorista;
    private int id_veiculo;

    public int getIdEntrega() {
        return id_entrega;
    }

    public void setIdEntrega(int id_entrega) {
        this.id_entrega = id_entrega;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public boolean getCargaPerigosa() {
        return carga_perigosa;
    }

    public void setCargaPerigosa(boolean carga_perigosa) {
        this.carga_perigosa = carga_perigosa;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDataEntrega() {
        return data_entrega;
    }

    public void setDataEntrega(String data_entrega) {
        this.data_entrega = data_entrega;
    }
    
    public int getIdMotorista() {
        return id_motorista;
    }

    public void setIdMotorista(int id_motorista) {
        this.id_motorista = id_motorista;
    }
    
    public int getIdVeiculo() {
        return id_veiculo;
    }

    public void setIdVeiculo(int id_veiculo) {
        this.id_veiculo = id_veiculo;
    }
}
