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

public class Motoristas {
    
    private int id_motorista;
    private String nome;
    private String cpf;
    private String cnh;
    private String categoria_cnh;
    private Object validade_cnh;
    private boolean treinamento_ok;

    public int getIdMotorista() {
        return id_motorista;
    }

    public void setIdMotorista(int id_motorista) {
        this.id_motorista = id_motorista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
    
    public String getCategoriaCnh() {
        return categoria_cnh;
    }

    public void setCategoriaCnh(String categoria_cnh) {
        this.categoria_cnh = categoria_cnh;
    }
    
    public Object getValidadeCnh() {
        return validade_cnh;
    }

    public void setValidadeCnh(Object validade_cnh) {
        this.validade_cnh = validade_cnh;
    }
    
    public boolean getTreinamentoOk() {
        return treinamento_ok;
    }

    public void setTreinamentoOk(boolean treinamento_ok) {
        this.treinamento_ok = treinamento_ok;
    }
    
    
}
