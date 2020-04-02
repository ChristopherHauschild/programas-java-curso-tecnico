/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

public class Industrial extends Consumidor {
    private String email;
    private String setor;

    public Industrial(String nome, String cnpj,String telefone, String email, String setor) {
        super.nome = nome;
        super.cpf_cnpj = cnpj;
        super.telefone = telefone;
        this.email = email;
        this.setor = setor;
    }

    public String getCnpj() {
        return super.cpf_cnpj;
    }

    public void setCnpj(String cnpj) {
        super.cpf_cnpj = cnpj;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSetor() {
        return this.setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
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
         return "Industrial " +super.nome+ ", " +super.cpf_cnpj+ ", " +super.telefone+ ", " +this.email+ ", " +this.setor;
    }
    
    public void calcularCusto(){
        System.out.println("Erro");
    }
}
