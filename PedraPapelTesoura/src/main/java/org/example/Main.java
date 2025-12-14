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
            carregar+= "||";
        }

        while(!opc.equals("SAIR")){
            Regras regras =  new Regras();
            System.out.print("\nDigite SAIR para encerrar o jogo\nPedra\nPapel\nTesoura\nDigite a sua jogada:");
            opc = sc.nextLine().toUpperCase();

            regras.computador();
            System.out.println(regras.jogoAcontecendo(opc));

        }

    }
}