/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domínio;

/*
CHRISTOPHER HAUSCHILD
08/11/2019
 */
public class Bebida extends Item{

    public Bebida(String nome, String unidade, float preco, int quantidade) {
        super.nome = nome;
        super.unidade = unidade;
        super.preco = preco;
        super.quantidade = quantidade;
    }

    public String getNome() {
        return super.nome;
    }

    public void setNome(String nome) {
        super.nome = nome;
    }

    public String getUnidade() {
        return super.unidade;
    }

    public void setUnidade(String unidade) {
        super.unidade = unidade;
    }

    public float getPreco() {
        return super.preco;
    }

    public void setPreco(float preco) {
        super.preco = preco;
    }

    public int getQuantidade() {
        return super.quantidade;
    }

    public void setQuantidade(int quantidade) {
        super.quantidade = quantidade;
    }
    
    
    
    @Override
    public String toString() {
        return super.quantidade+ " " +super.unidade+ " - " +super.nome+ " - " +super.preco;
    }
    
    public void adicionarConvidadoItem() {
        System.out.println("Erro");
    }
    
}
