/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domínio;

/*
CHRISTOPHER HAUSCHILD SCHOTT
08/11/2019
 */

public abstract class Item {
    protected String nome;
    protected String unidade;
    protected float preco;
    protected int quantidade;
    
    public abstract void adicionarConvidadoItem();
}
