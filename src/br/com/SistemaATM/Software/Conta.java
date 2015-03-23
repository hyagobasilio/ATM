/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaATM.Software;

/**
 * Conta.java
 * Representa uma conta bancária
 * @author Lucas
 */
public class Conta {
    private int numeroDaConta; // número da conta
    private int pin; // PIN para autenticação
    private double saldoDisponivel; // dinheiro disponível para saque
    private double saldoTotal; // dinheiro disponível + depósitos pendentes

    // O construtor Conta inicializa os atributos
    public Conta( int numConta, int numPin,
            double sDisponivel, double sTotal ) {
            numeroDaConta 	= numConta;
            pin			= numPin;
            saldoDisponivel     = sDisponivel;
            saldoTotal		= sTotal;
    }

    // determina se o PIN especificado pelo usuário corresponde ao PIN em conta
    public boolean validaPIN( int usuarioPin ) {
            if( usuarioPin == pin )
                    return true;
            else
                    return false;
    }

    // retorna o saldo disponível
    public double getSaldoDisponivel() {
            return saldoDisponivel;
    }

    // retorna o saldo total
    public double getSaldoTotal() {
            return saldoTotal;
    }

    // credita uma quantia a conta
    public void credita( double quantia ) {
            saldoTotal += quantia; // adiciona ao saldo total
    }

    // debita uma quantia da conta
    public void debita( double quantia ) {
            saldoDisponivel -= quantia; // subtrai do saldo disponível
            saldoTotal		-= quantia; // subtrai do saldo total
    }

    // retorna o número da conta
    public int getNumeroDaConta() {
            return numeroDaConta;
    }
}
