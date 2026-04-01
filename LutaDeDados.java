package br.com.meujogo;

import java.util.Random;



public class LutaDeDados {

	private int jogador1Vida;

	private int jogador2Vida;

	private Random dado;

	
	public LutaDeDados() {

	    jogador1Vida = 100;

	    jogador2Vida = 100;

	    dado = new Random();

	
	}

	private int lancarDados() {

	    return dado.nextInt(6) + 1;

	}

	public String turno(int danoJogador1, int danoJogador2) {

	    int dano1 = danoJogador1 + lancarDados();

	    int dano2 = danoJogador2 + lancarDados();



	    jogador2Vida -= dano1;

	    jogador1Vida -= dano2;



	    return "Jogador 1 causou " + dano1 + " de dano. " +

	           "Jogador 2 causou " + dano2 + " de dano.";

	}


	// VERIFICAR VENCEDOR

	public String verificarVencedor() {

	    if (jogador1Vida <= 0 && jogador2Vida > 0) {

	        return "Jogador 2 venceu!";

	    }

	    if (jogador2Vida <= 0 && jogador1Vida > 0) {

	        return "Jogador 1 venceu!";

	    }

	    if (jogador1Vida <= 0 && jogador2Vida <= 0) {

	        return "Empate!";

	    }

	    return "O jogo continua.";

	}

	public int getVidaJogador1() {

	    return jogador1Vida;

	}



	public int getVidaJogador2() {

	    return jogador2Vida;

	}

}