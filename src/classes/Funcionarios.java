/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Thalles Rodrigues
 */
public class Funcionarios {
    
    String nome;
    String CPF;
    String telefone;
    String funcao;
    String endereco;
    String salario;

    public Funcionarios(String nome, String CPF, String telefone, String funcao, String endereco, String salario) {
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
        this.funcao = funcao;
        this.endereco = endereco;
        this.salario = salario;
    }

    public Funcionarios() {
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getSalario() {
        return salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }
    
    
    
}
