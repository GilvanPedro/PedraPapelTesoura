package org.example;

import java.util.Random;

public class Regras {
    private Random rand;
    private int num;

    public Regras() {
        this.rand = new Random();
    }

    public String computador() {
        num = rand.nextInt(3) + 1;

        switch (num) {
            case 1: return "PEDRA";
            case 2: return "PAPEL";
            case 3: return "TESOURA";
            default: return "ERRO";
        }
    }

    public String jogoAcontecendo(String tipo) {
        String escolhaComputador = computador();

        System.out.println("Escolha do computador: " + escolhaComputador);
        if (tipo.equals(escolhaComputador)) {
            return "EMPATE";
        }

        if (
                (tipo.equals("PEDRA") && escolhaComputador.equals("TESOURA")) ||
                        (tipo.equals("TESOURA") && escolhaComputador.equals("PAPEL")) ||
                        (tipo.equals("PAPEL") && escolhaComputador.equals("PEDRA"))
        ) {
            return "JOGADOR GANHOU";
        } else {
            if(!tipo.equals("PEDRA") || !tipo.equals("TESOURA") || !tipo.equals("PAPEL")){
                return "JOGADA INVÁLIDA!";
            }
            return "COMPUTADOR GANHOU";
        }
    }

}
