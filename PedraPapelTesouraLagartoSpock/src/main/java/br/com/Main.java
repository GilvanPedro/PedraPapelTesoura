package br.com;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private JLabel lblJogador;
    private JLabel lblComputador;
    private JLabel lblResultado;
    private Regras regras;

    public Main() {
        regras = new Regras();

        setTitle("Pedra, Papel, Tesoura, Lagarto, Spock");
        setSize(600, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ================== TOPO ==================
        JLabel titulo = new JLabel("Pedra, Papel, Tesoura, Lagarto, Spock", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        add(titulo, BorderLayout.NORTH);

        // ================== CENTRO ==================
        JPanel painelCentro = new JPanel(new GridLayout(3, 1, 15, 15));
        painelCentro.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        lblJogador = new JLabel("Jogador: ", SwingConstants.CENTER);
        lblComputador = new JLabel("Computador: ", SwingConstants.CENTER);
        lblResultado = new JLabel("Faça sua jogada", SwingConstants.CENTER);

        Font fonteInfo = new Font("Arial", Font.BOLD, 18);
        Font fonteResultado = new Font("Arial", Font.BOLD, 22);

        lblJogador.setFont(fonteInfo);
        lblComputador.setFont(fonteInfo);
        lblResultado.setFont(fonteResultado);

        painelCentro.add(lblJogador);
        painelCentro.add(lblComputador);
        painelCentro.add(lblResultado);

        add(painelCentro, BorderLayout.CENTER);

        // ================== BOTOES ==================
        JPanel painelBotoes = new JPanel(new GridLayout(2, 3, 10, 10));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        JButton pedra = new JButton("Pedra");
        JButton papel = new JButton("Papel");
        JButton tesoura = new JButton("Tesoura");
        JButton lagarto = new JButton("Lagarto");
        JButton spock = new JButton("Spock");
        JButton regrasBtn = new JButton("Regras");

        painelBotoes.add(pedra);
        painelBotoes.add(papel);
        painelBotoes.add(tesoura);
        painelBotoes.add(lagarto);
        painelBotoes.add(spock);
        painelBotoes.add(regrasBtn);

        add(painelBotoes, BorderLayout.SOUTH);

        // ================== AÇÕES ==================
        pedra.addActionListener(e -> jogar("PEDRA"));
        papel.addActionListener(e -> jogar("PAPEL"));
        tesoura.addActionListener(e -> jogar("TESOURA"));
        lagarto.addActionListener(e -> jogar("LAGARTO"));
        spock.addActionListener(e -> jogar("SPOCK"));

        regrasBtn.addActionListener(e -> mostrarRegras());
    }

    private void jogar(String escolhaJogador) {

        regras.computador(); // computador joga UMA vez

        String resultado = regras.jogoAcontecendo(escolhaJogador);
        String escolhaComputador = regras.getEscolhaComputador();

        lblJogador.setText("Jogador escolheu: " + escolhaJogador);
        lblComputador.setText("Computador escolheu: " + escolhaComputador);

        switch (resultado) {
            case "EMPATE" -> lblResultado.setText("EMPATE!");
            case "JOGADOR GANHOU" -> lblResultado.setText("VOCÊ GANHOU!");
            default -> lblResultado.setText("COMPUTADOR GANHOU!");
        }
    }


    private void mostrarRegras() {
        JOptionPane.showMessageDialog(this, """
                REGRAS DO JOGO:

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
                """,
                "Regras",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
