/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaATM.Software;

import br.com.SistemaATM.Hardware.*;
import br.com.SistemaATM.Visual.ATM_Visual;

/**
 * ATM.java
 * Representa um caixa eletrônico - Inicia o sistema
 * @author Lucas Santos
 * Criado em 02/04/2012, 09:30:19
 */

public class ATM {
    private ATM_Visual atmVs;
    private BancoDeDados bD             = new BancoDeDados();
    private DispensadorDeCedulas dDC    = new DispensadorDeCedulas();
    private EntradaDeCedulas eDC        = new EntradaDeCedulas();
    private int numAtualDaConta         = 0;
    private boolean usuarioAutenticado  = false; // true se o usuário existe e está logado
    private boolean onMS                = false; // true se o usuário está no menu de saque
    private boolean onMD                = false; // true se o usuário está digitando o deposito

    // constantes que correspondem às opções do menu principal
    private static final int CONSULTAR_SALDO = 1;
    private static final int SACAR           = 2;
    private static final int DEPOSITAR       = 3;
    private static final int SAIR            = 4;
    
    public ATM( ATM_Visual atm ) {
        this.atmVs = atm;
    }
    
    // Tenta autenticar o usuário com o banco de dados
    public void verificaUsuario(int login, int senha ) {
        // configura usuarioAutenticado em ATM_Visual como um valor booleano retornado pelo banco de dados
        usuarioAutenticado = bD.autenticaUsuario( login, senha );
        if( usuarioAutenticado == true   ) {
            numAtualDaConta = login;
        }
        else {
            return;
        }
    }

    // exibe o menu principal e realiza transações e retorna uma escolha
    public void efetuaTransacoes( int escolha ) {
        // se o usuário está no menu de saque
        if( onMS ) {
            onMS = false;
            Sacar t = new Sacar( numAtualDaConta, bD, atmVs, dDC );
            t.processaSaque(escolha);
        }
        // se o usuário está no menu de depósito
        else if( onMD ) {
            onMD = false;
            Depositar d = new Depositar( numAtualDaConta, bD, atmVs, eDC );
            d.processaDeposito(escolha);
        }
        else {
            // variável local para armazenar a transação atualmente processada
            Transacao transacaoAtual = null;

            // decide como prosseguir com base na seleção de menu feita pelo usuário
            switch( escolha ) {
                // o usuário optou por realizar um entre três tipos de transações
                case CONSULTAR_SALDO:
                case SACAR:
                case DEPOSITAR:

                    // inicializa como o novo objeto do tipo escolhido
                    transacaoAtual = criaTransacao( escolha );
                    transacaoAtual.executa(); // executa a transação
                    break;
                case SAIR: // usuário optou por terminar a sessão
                    atmVs.setJTxtAreaVisor(Tela.msgSaindo + Tela.msgLogin);
                    atmVs.setBotaoApertado();
                    atmVs.setLogin();
                    atmVs.setLoginSet(false);
                    atmVs.setLoginStr();
                    atmVs.setSenha();
                    atmVs.setSenhaSet(false);
                    atmVs.setSenhaStr();
                    usuarioAutenticado = false;
                    break;
            } // fim do switch
        }
    } // fim do método efetuaTransacoes

    // retorna o objeto da subclasse de Transacao especificada
    private Transacao criaTransacao( int tipo ) {
        Transacao temp = null; // variável de transação temporária

        // determina qual tipo de transação criar
        switch( tipo ) {
            case CONSULTAR_SALDO: // cria uma nova transação ConsultaSaldo
                temp = new ConsultaSaldo( numAtualDaConta, bD, atmVs );
                break;
            case SACAR: // cria uma nova transação Sacar
                temp = new Sacar( numAtualDaConta, bD, atmVs, dDC );
                break;
            case DEPOSITAR: // cria uma nova transação Depositar
                temp = new Depositar( numAtualDaConta, bD, atmVs, eDC );
                break;
        }

        return temp; // retorna o objeto recém-criado
    }

    public void setOnMS( boolean b ) {
        this.onMS = b;
    }

    public void setOnMD( boolean b ) {
        this.onMD = b;
    }
    
    public boolean getUsuarioAutenticado() {
        return usuarioAutenticado;
    }
}
