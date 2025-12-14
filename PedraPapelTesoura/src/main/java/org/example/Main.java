package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String carregar = "||";
        String opc = "";

        System.out.println("Carregando o Jogo......");
        for (int i = 0; i<=9; i++){
            System.out.print("\r"+carregar);
            Thread.sleep(500);
            carregar += "||";
        }

        while(!opc.equals("SAIR")){
            Regras regras =  new Regras();
            System.out.print("\nDigite SAIR para encerrar o jogo\nDigite Regras para ver como jogar\nPedra\nPapel\nTesoura\nLagarto\nSpock\nDigite a sua jogada: ");
            opc = sc.nextLine().toUpperCase();

            if(opc.equals("REGRAS")){
                System.out.print("""
                                
                        Tesoura corta Papel
                        Papel cobre Pedra
                        Pedra esmaga Lagarto
                        Lagarto envenena Spock
                        Spock quebra Tesoura
                        Tesoura decapita Lagarto
                        Lagarto come Papel
                        Papel refuta Spock
                        Spock vaporiza Pedra
                        Pedra quebra Tesoura
                        """);
            } else{
                regras.computador();
                System.out.println(regras.jogoAcontecendo(opc));
            }

        }

    }
}
