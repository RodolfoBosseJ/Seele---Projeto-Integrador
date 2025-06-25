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

public class Veiculos {
    
    private int id_veiculo;
    private String placa;
    private String modelo;
    private String tipo;
    private float capacidade;
    private String status;
    private String doc_vencimento;

    public int getIdVeiculo() {
        return id_veiculo;
    }

    public void setIdVeiculo(int id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public float getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(float capacidade) {
        this.capacidade = capacidade;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDocVencimento() {
        return doc_vencimento;
    }

    public void setDocVencimento(String doc_vencimento) {
        this.doc_vencimento = doc_vencimento;
    }
    
    
}
