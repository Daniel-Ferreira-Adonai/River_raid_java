package br.com.mvbos.lgj;
public class Player implements Comparable<Player> {
    private String nome;
    private int pontos;

    public Player(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return (pontos - 1);
    }
    @Override
    public int compareTo(Player other) {
        return Integer.compare(other.pontos, this.pontos);
    }
    @Override
    public String toString() {
        return nome + " - " + pontos + " Pontos";
    }
}