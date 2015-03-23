/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaATM.Hardware;

/**
 * EntradeDeCedulas.java
 * Representa a abertura para depósito do ATM
 * @author Lucas
 */

public class EntradaDeCedulas {
    // indica se o envelope foi recebido( sempre retorna true,
    // porque isso só é uma simulação do software de uma abertura para depósito real )
    public boolean envelopeFoiRecebido() {
            return true; // o envelope de depósito foi recebido
    }
}
