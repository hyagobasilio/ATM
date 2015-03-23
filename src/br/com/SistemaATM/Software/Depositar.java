/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaATM.Software;
import br.com.SistemaATM.Hardware.*;
import br.com.SistemaATM.Visual.ATM_Visual;

/**
 * Depositar.java
 * Representa uma transação de depósito no atm
 * @author Lucas
 */
public class Depositar extends Transacao {
    private double quantia; // quantia a depositar
    private EntradaDeCedulas entradaDeCedulas; // referência à abertura para depósito
    private final static int CANCELAR = 0; // constante para a opção de cancelamento

    // Construtor de Depositar
    public Depositar( int userNumConta, BancoDeDados bd, ATM_Visual atmVs, EntradaDeCedulas entradaDC )
    {
            // inicializa as variáveis da superclasse
            super( userNumConta, bd, atmVs );

            // inicializa a referência a abertura para depósito
            entradaDeCedulas = entradaDC;
    }

    // realiza a transação
    @Override
    public void executa()
    {
        atmVs.setOnMenuDeDeposito(true); // diz que o usuário está no menu de depósito
        atmVs.exibiQuantiaDeposito();   
    } // fim do método executa

    // solicita que o usuário insira uma quantia de depósito em centavos
    public void processaDeposito( int q )
    {
        BancoDeDados bancoDD = getBDD(); // obtém a referência

        quantia = q;

        // verifica se usuário inseriu uma quantia de depósito ou cancelou
        if( quantia != CANCELAR )
        {

                // recebe o envelope de depósito
                boolean envelopeRecebido = entradaDeCedulas.envelopeFoiRecebido();

                // verifica se envelope de depósito foi recebido
                if( envelopeRecebido ) {
                        // credita na conta para refletir depósito
                        bancoDD.credita( getNumeroDaConta(), quantia );
                        atmVs.setJTxtAreaVisor(String.format("Por favor insira o envelope contendo o depósito de R$%,.2f", quantia) +
                                Tela.msgEnvelopeRecebido );
                        atmVs.setOnMenuPrincipal(true); // Diz que é para estar no menu principal caso aperte enter
                        atmVs.setBotaoApertado(); // configura botao como nada para voltar ao menu principal quando apertar enter
                }
        }
        else { // o usuário cancelou em vez de inserir uma quantia
                atmVs.setJTxtAreaVisor(Tela.msgCancelaDeposito);
                atmVs.setOnMenuPrincipal(true); // Diz que é para estar no menu principal caso aperte enter
                atmVs.setBotaoApertado(); // configura botao como nada para voltar ao menu principal quando apertar enter
        }
    }
}
