package br.com.meujogo;



public class Main {



	 public static void main(String[] args) {



	        LutaDeDados jogo = new LutaDeDados();



	        System.out.println("=== INÍCIO DO JOGO ===");


	        for (int i = 1; i <= 5; i++) {

	            System.out.println("\nTurno " + i);



	            String resultado = jogo.turno(5, 5);

	            System.out.println(resultado);



	            System.out.println("Vida Jogador 1: " + jogo.getVidaJogador1());

	            System.out.println("Vida Jogador 2: " + jogo.getVidaJogador2());



	            String vencedor = jogo.verificarVencedor();

	            System.out.println(vencedor);



	            if (!vencedor.equals("O jogo continua.")) {

	                break;

	            }

	        }

	    }

	}

