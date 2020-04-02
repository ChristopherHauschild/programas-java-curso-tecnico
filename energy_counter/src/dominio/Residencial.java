/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

public class Residencial extends Consumidor{

    public Residencial(String nome, String cpf, String telefone) {
        super.nome = nome;
        super.cpf_cnpj = cpf;
        super.telefone = telefone;
    }

    public String getCpf() {
        return super.cpf_cnpj;
    }

    public void setCpf(String cpf) {
        super.cpf_cnpj = cpf;
    }


    public String getNome() {
        return super.nome;
    }

    public void setNome(String nome) {
        super.nome = nome;
    }

    public String getTelefone() {
        return super.telefone;
    }

    public void setTelefone(String telefone) {
        super.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Residencial " +super.nome+ ", " +super.cpf_cnpj+ ", " +super.telefone;
    }
    
    public void calcularCusto(){
        System.out.println("Erro");
    }
}
