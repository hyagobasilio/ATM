/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaATM.Hardware;
import br.com.SistemaATM.Software.Conta;

/**
 * BancoDeDados.java
 * Representa o banco de dados com as informações sobre as contas bancárias
 * @author Lucas
 */
public class BancoDeDados {
    private Conta[] contas; // array de Contas
    
    // construtor BancoDB sem argumentos inicializa as contas
    public BancoDeDados() {
            contas = new Conta[2]; // apenas duas contas para teste
            contas[0] = new Conta( 12345, 54321, 1000.0, 1200.0 );
            contas[1] = new Conta( 98765, 56789, 200.0, 200.0 );
    }

    // recupera o objeto Conta que contém o número de conta especificado
    private Conta getConta( int numConta ) {
            // faz um loop pelas contas procurando uma correspondência com o número da conta
            for( Conta contaAtual : contas ) {
                    // retorna a conta atual se uma correspondência for localizada
                    if( contaAtual.getNumeroDaConta() == numConta )
                            return contaAtual;
            }

            return null; // se nenhuma correspondência com uma conta foi localizada, retorna null
    }

    // determina se número da conta e PIN especificados pelo usuário correspondem
    // aqueles de uma conta no banco de dados
    public boolean autenticaUsuario( int userNumConta, int userPIN ) {
            // tenta recuperar a conta com o número da conta
            Conta usuarioConta = getConta( userNumConta );

            // se a conta existir, retorna o resultado do método validaPIN de Conta
            if( usuarioConta != null )
                    return usuarioConta.validaPIN( userPIN );
            else
                    return false; // número de conta não foi localizado, portanto retorna false
    }

    // retorna o saldo disponível de Conta com o número da conta especificado
    public double getSaldoDisponivel( int numDaConta ) {
            return getConta( numDaConta ).getSaldoDisponivel();
    }

    // retorna o saldo total de Conta com o número da conta especificado
    public double getSaldoTotal( int numDaConta ) {
            return getConta( numDaConta ).getSaldoTotal();
    }

    // credita uma quantia a Conta com o número de conta especificado
    public void credita( int numDaConta, double quantia ) {
            getConta( numDaConta ).credita( quantia );
    }

    // debita uma quantidade da Conta com o número de conta especificado
    public void debita( int numDaConta, double quantia ) {
            getConta( numDaConta ).debita( quantia );
    }
}
