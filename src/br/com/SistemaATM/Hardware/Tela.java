/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaATM.Hardware;

/**
 * Tela.java
 * Representa a Tela (Visor) do ATM - Armazena todas as Strings possiveis e exibi no Visor
 * @author Lucas Santos
 * Criado em 02/04/2012, 09:48:18
 */

public class Tela {
    public static final String msgLogin                = "Bem-Vindo!\n\nPor favor, entre com o número da sua conta: ";
    public static final String msgSenha                = "\nPor favor, entre com a senha da sua conta: ";
    public static final String msgSenhaInvalida        = "Número da conta ou senha inválidos. Por favor, tente novamente.\n\n";
    public static final String msgSaindo               =  "Saindo do Sistema...\nVocê saiu do sistema com sucesso!\n\n";
    public static final String msgSaldoDisponivel      = "Informações sobre o saldo:\n - Saldo disponível: R$%,.2f";
    public static final String msgSaldoTotal           = "\n - Saldo total:            R$%,.2f\n\nAPERTE ENTER PARA VOLTAR AO MENU PRINCIPAL";
    public static final String msgDinInsuficienteATM   = "Dinheiro insuficiente no ATM.\nPor favor escolha uma quantia menor." +
            "\n\nAPERTE ENTER PARA VOLTAR AO MENU PRINCIPAL";
    public static final String msgDinInsuficienteConta = "Dinheiro insuficiente na sua conta.\nPor favor escolha uma quantia menor." +
            "\n\nAPERTE ENTER PARA VOLTAR AO MENU DE SAQUE";
    public static final String msgDinheiroEntregue     = "Seu dinheiro foi dispensado. Por favor pegue seu dinheiro agora." +
            "\n\nAPERTE ENTER PARA VOLTAR AO MENU PRINCIPAL";
    public static final String msgCancelaSaque         = "Cancelando transação de saque...\n\nAPERTE ENTER PARA VOLTAR AO MENU PRINCIPAL";
    public static final String msgCancelaDeposito      = "Cancelando transação de depósito...\n\nAPERTE ENTER PARA VOLTAR AO MENU PRINCIPAL";
    public static final String msgMenuDeSaque          = "Menu de saque:\n1 - R$20\n2 - R$40\n3 - R$60\n4 - R$100\n5 - R$200" + 
            "\n6 - CANCELAR TRANSAÇÃO\nDigite uma opção: ";
    public static final String msgMenuPrincipal        = "Você entrou no sistema com sucesso!\nMenu Principal:\n1 - Visualizar meu saldo" + 
            "\n2 - Sacar dinheiro\n3 - Depositar dinheiro\n4 - Sair\nDigite uma opção: ";
    public static final String msgEnvelopeRecebido     = "\nSeu envelope foi recebido.\nNOTA: O dinheiro depositado não estará disponível " +
            "até nós verifcarmos a\n quantia anexada e os seus cheques.\n\nAPERTE ENTER PARA VOLTAR AO MENU PRINCIPAL";
    public static final String msgPedeQuantia          = "Por favor, entre com o valor do depósito em REAIS." +
            "\nAPERTE 0 e ENTER PARA CANCELAR.\nQuantia: ";
}

