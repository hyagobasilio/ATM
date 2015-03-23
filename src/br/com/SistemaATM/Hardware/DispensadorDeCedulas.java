/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.SistemaATM.Hardware;

/**
 * DispensadorDeCedulas.java
 * Representa o Dispensador de Cedulas do ATM
 * @author Lucas
 */
public class DispensadorDeCedulas {
    // o número inicial padrão de cédulas no dispensador de cédulas
	private final static int CONTADOR_INICIAL = 500;
	private int contador; // número de cédulas de R$ 20 remanescente
	
	// construtor sem argumentos DispensadorDeCedulas inicializa  o contador para o padrão
	public DispensadorDeCedulas()
	{
		contador = CONTADOR_INICIAL; // configura atributo contador como o padrão
	}
	
	// simula a entrega da quantia especificada de cédulas
	public void dispensaCedulas( int quantia )
	{
		int cedulasExigidas = quantia / 20; // número de cédulas de R$ 20 requerido
		contador -= cedulasExigidas; // atualiza a contagem das cédulas
	}
	
	// indica se o dispensador de cédulas pode entregar a quantia desejada
	public boolean dinheiroSuficienteDisponivel( int quantia )
	{
		int cedulasExigidas = quantia / 20; // número de cédulas de R$ 20 requerido
		
		if( contador >= cedulasExigidas)
			return true; // há cédulas suficientes disponíveis
		else
			return false; // não há cédulas disponíveis
	}
}
