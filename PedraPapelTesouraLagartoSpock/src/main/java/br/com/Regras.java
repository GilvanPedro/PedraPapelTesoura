package br.com;

import java.util.Random;

public class Regras {

    private final Random rand = new Random();
    private String escolhaComputador;

    public String computador() {
        int num = rand.nextInt(5);

        escolhaComputador = switch (num) {
            case 0 -> "PEDRA";
            case 1 -> "PAPEL";
            case 2 -> "TESOURA";
            case 3 -> "LAGARTO";
            case 4 -> "SPOCK";
            default -> "";
        };

        return escolhaComputador;
    }

    public String jogoAcontecendo(String jogador) {
        jogador = jogador.toUpperCase();

        if (jogador.equals(escolhaComputador)) {
            return "EMPATE";
        }

        if (
                (jogador.equals("TESOURA") && escolhaComputador.equals("PAPEL")) ||
                        (jogador.equals("PAPEL") && escolhaComputador.equals("PEDRA")) ||
                        (jogador.equals("PEDRA") && escolhaComputador.equals("LAGARTO")) ||
                        (jogador.equals("LAGARTO") && escolhaComputador.equals("SPOCK")) ||
                        (jogador.equals("SPOCK") && escolhaComputador.equals("TESOURA")) ||

                        (jogador.equals("TESOURA") && escolhaComputador.equals("LAGARTO")) ||
                        (jogador.equals("LAGARTO") && escolhaComputador.equals("PAPEL")) ||
                        (jogador.equals("PAPEL") && escolhaComputador.equals("SPOCK")) ||
                        (jogador.equals("SPOCK") && escolhaComputador.equals("PEDRA")) ||
                        (jogador.equals("PEDRA") && escolhaComputador.equals("TESOURA"))
        ) {
            return "JOGADOR GANHOU";
        }

        return "COMPUTADOR GANHOU";
    }

    public String getEscolhaComputador() {
        return escolhaComputador;
    }
}
