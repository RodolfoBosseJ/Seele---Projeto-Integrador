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

public class Alertas {
    
    private int id_alerta;
    private String tipo_alerta;
    private String descricao;
    private String data_alerta;
    private int id_motorista;
    private int id_veiculo;

    public int getIdAlerta() {
        return id_alerta;
    }

    public void setIdAlerta(int id_alerta) {
        this.id_alerta = id_alerta;
    }

    public String getTipoAlerta() {
        return tipo_alerta;
    }

    public void setTipoAlerta(String tipo_alerta) {
        this.tipo_alerta = tipo_alerta;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDataAlerta() {
        return data_alerta;
    }

    public void setDataAlerta(String data_alerta) {
        this.data_alerta = data_alerta;
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
