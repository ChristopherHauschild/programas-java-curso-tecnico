
package dominio;

public abstract class Consumidor {
    protected String nome;
    protected String telefone;
    protected String cpf_cnpj;
    
    public abstract void calcularCusto();
}
