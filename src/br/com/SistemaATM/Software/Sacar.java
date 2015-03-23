/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaATM.Software;
import br.com.SistemaATM.Hardware.*;
import br.com.SistemaATM.Visual.ATM_Visual;

/**
 * Sacar.java
 * Representa uma transação de saque no ATM
 * @author Lucas
 */

public class Sacar extends Transacao {
    private DispensadorDeCedulas dispensadorDeCedulas; // referência ao dispensador de cédulas

    // constante que corresponde a opção cancelar no Menu
    private final static int CANCELAR = 6;

    // Contrutor de Sacar
    public Sacar( int userNumConta, BancoDeDados bd, ATM_Visual atmVs, DispensadorDeCedulas atmDDC )
    {
            // inicializa as variáveis da superclasse
            super( userNumConta, bd, atmVs );

            // inicializa a referência ao dispensador de cédulas
            dispensadorDeCedulas = atmDDC;
    }

    // efetua Transação
    @Override
    public void executa() {        
        atmVs.setOnMenuDeSaque(true); // diz que o usuário está no menu de saque
        atmVs.exibiMenuDeSaque();        
    } // fim do método executa
    
    public void processaSaque(int escolhaDoUsuario ) {
        double saldoDisponivel; // quantia disponível para saque
        int quantia = 0; // variável local para armazenar o valor da quantia de saque escolhida pelo usuário
        BancoDeDados bancoDD = getBDD(); // obtém a referência ao banco de dados e tela do banco
        
        // array de quantias que correspondem aos números no menu
        int[] quantias = { 0, 20, 40, 60, 100, 200 };

        // determina como prosseguir com base no valor de entrada do usuário e atribui o valor da quantia de acordo com a entrada
        switch( escolhaDoUsuario ) {
            case 1: // se o usuário escolheu uma quantia de saque
            case 2: // ( isto é, escolheu a opção 1, 2, 3, 4 ou 5 ), retorna a
            case 3: // quantia correspondente do array de quantias
            case 4:
            case 5:
                quantia = quantias[escolhaDoUsuario]; // salva a escolha do usuário
                break;
            case CANCELAR: // usuário escolheu cancelar
                quantia = CANCELAR;
                break;
        }

        // verifica se o usuário escolheu uma quantia de saque ou cancelou
        if( quantia != CANCELAR ) {
            // obtém o saldo disponível na conta envolvida
            saldoDisponivel = bancoDD.getSaldoDisponivel( getNumeroDaConta() );

            // verifica se o usuário tem dinheiro suficiente na conta
            if( quantia <= saldoDisponivel ) {
                // verifica se o dispensador de cédulas tem cédulas suficientes
                if( dispensadorDeCedulas.dinheiroSuficienteDisponivel( quantia ) ) {
                    // atualiza a conta envolvida para refletir a retirada/saque
                    bancoDD.debita( getNumeroDaConta(), quantia );

                    dispensadorDeCedulas.dispensaCedulas( quantia );

                    // instrui o usuário a pegar as cédulas
                    atmVs.setJTxtAreaVisor(Tela.msgDinheiroEntregue);
                    atmVs.setOnMenuPrincipal(true); // Diz que é para estar no menu principal caso aperte enter
                    atmVs.setBotaoApertado(); // configura botao como nada para voltar ao menu principal quando apertar enter
                }
                else { // o dispensador de cédulas não tem cédulas suficientes
                    atmVs.setJTxtAreaVisor(Tela.msgDinInsuficienteATM);
                    atmVs.setOnMenuPrincipal(true); // Diz que é para estar no menu principal caso aperte enter
                    atmVs.setBotaoApertado(); // configura botao como nada para voltar ao menu principal quando apertar enter
                }
            }
            else { // não há dinheiro suficiente disponível na conta do usuário
                atmVs.setJTxtAreaVisor(Tela.msgDinInsuficienteConta);
                atmVs.setOnMenuDeSaque(true); // Diz que é para estar no menu principal caso aperte enter
                atmVs.setBotaoApertado(); // configura botao como nada para voltar ao menu principal quando apertar enter
            }
        }
        else { // o usuário escolheu a opção CANCELAR no menu
            atmVs.setJTxtAreaVisor(Tela.msgCancelaSaque);
            atmVs.setOnMenuPrincipal(true); // Diz que é para estar no menu principal caso aperte enter
            atmVs.setBotaoApertado(); // configura botao como nada para voltar ao menu principal quando apertar enter
        }
    }
}