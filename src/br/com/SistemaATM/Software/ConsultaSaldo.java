/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaATM.Software;
import br.com.SistemaATM.Hardware.*;
import br.com.SistemaATM.Visual.ATM_Visual;

/**
 * ConsultaSaldo.java
 * Representa uma consulta de saldo no banco de dados do ATM
 * @author Lucas
 */

public class ConsultaSaldo extends Transacao {
    // Construtor de ConsultaSaldo
    public ConsultaSaldo( int userNumConta, BancoDeDados bancoDD, ATM_Visual atmVs ) {
        super( userNumConta, bancoDD, atmVs );
    }

    // realiza a transação
    @Override
    public void executa() {
        // obtém as referências ao banco de dados  do banco
        BancoDeDados bancoDD = getBDD();

        // obtém o saldo disponível da conta envolvida
        double saldoDisponivel = bancoDD.getSaldoDisponivel( getNumeroDaConta() );

        // obtém o saldo total da conta envolvida
        double saldoTotal = bancoDD.getSaldoTotal( getNumeroDaConta() );

        // exibe as informações sobre o saldo na tela
        atmVs.setJTxtAreaVisor( String.format(Tela.msgSaldoDisponivel, saldoDisponivel) + String.format(Tela.msgSaldoTotal, saldoTotal) );
        atmVs.setOnMenuPrincipal(true);
        atmVs.setBotaoApertado();
        return;
    }
}
