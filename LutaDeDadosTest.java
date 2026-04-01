package br.com.meujogo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LutaDeDadosTest {

    private LutaDeDados jogo;

    @BeforeEach
    void setUp() {
        jogo = new LutaDeDados();
    }

    // Teste de inicialização
    @Test
    void testeInicializacao() {
        assertEquals(100, jogo.getVidaJogador1());
        assertEquals(100, jogo.getVidaJogador2());
    }

    // Teste de dano (verifica se a vida diminui)
    @Test
    void testeDano() {
        jogo.turno(5, 5);

        assertTrue(jogo.getVidaJogador1() < 100);
        assertTrue(jogo.getVidaJogador2() < 100);
    }

    // Teste de vitória do Jogador 1
    @Test
    void testeVitoriaJogador1() {
        // Dano alto para garantir vitória
        for (int i = 0; i < 20; i++) {
            jogo.turno(50, 0);
        }

        assertEquals("Jogador 1 venceu!", jogo.verificarVencedor());
    }

    // Teste de vitória do Jogador 2
    @Test
    void testeVitoriaJogador2() {
        for (int i = 0; i < 20; i++) {
            jogo.turno(0, 50);
        }

        assertEquals("Jogador 2 venceu!", jogo.verificarVencedor());
    }

    // Teste de empate
    @Test
    void testeEmpate() {
        for (int i = 0; i < 20; i++) {
            jogo.turno(50, 50);
        }

        assertEquals("Empate!", jogo.verificarVencedor());
    }

    // Teste de jogo em andamento
    @Test
    void testeJogoEmAndamento() {
        jogo.turno(5, 5);

        assertEquals("O jogo continua.", jogo.verificarVencedor());
    }

    // Teste indireto do dado (valores entre 1 e 6)
    @Test
    void testeLancarDadosIndiretamente() {
        int vidaAntes1 = jogo.getVidaJogador1();
        int vidaAntes2 = jogo.getVidaJogador2();

        jogo.turno(0, 0);

        int danoRecebido1 = vidaAntes1 - jogo.getVidaJogador1();
        int danoRecebido2 = vidaAntes2 - jogo.getVidaJogador2();

        // Como o dado vai de 1 a 6
        assertTrue(danoRecebido1 >= 1 && danoRecebido1 <= 6);
        assertTrue(danoRecebido2 >= 1 && danoRecebido2 <= 6);
    }
}