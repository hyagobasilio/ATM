/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.SistemaATM.Software;
import br.com.SistemaATM.Hardware.BancoDeDados;
import br.com.SistemaATM.Visual.ATM_Visual;

/**
 * Transacao.java
 * Superclasse Abstrata Responsavel pelo metodo executar - transacoes
 * @author Lucas
 */

public abstract class Transacao {
    private int numeroDaConta; // indica conta envolvida
    private BancoDeDados bancoDD; // banco de dados de informações sobre a conta
    public ATM_Visual atmVs;

    // Construtor de Transacao invocado pelas subclasses utilizando super()
    public Transacao( int userNumConta, BancoDeDados atmBDD, ATM_Visual atm ) {
        numeroDaConta 	= userNumConta;
        bancoDD		= atmBDD;
        atmVs           = atm;
    }

    // retorna o número de conta
    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    // retorna a referência ao banco de dados da instituição financeira
    public BancoDeDados getBDD() {
        return bancoDD;
    }

    // realiza a transação ( sobrescrita por cada subclasse )
    public abstract void executa();
}
