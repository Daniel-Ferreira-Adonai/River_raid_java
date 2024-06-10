package br.com.mvbos.lgj;
import br.com.mvbos.lgj.base.Texto;

import java.awt.*;
import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Ranking extends Texto {
    private List<Player> players;
    private int count = 0;
    private boolean update = false;
    private String nome;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Ranking() {
        players = loadRanking();


        try {


            this.image = ImageIO.read(new File(".\\River_raid_av3_ranking_semi\\River_raid_av3_ranking\\Assets\\logo.png"));
            if (image == null) {
                throw new IOException("Image not found at specified path.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLargura(image.getWidth());
        setAltura(image.getHeight());
    }

    public void updateRanking(int pontos) {
       if(!update) {
           try {
               nome = JOptionPane.showInputDialog("Game Over! Insira seu nome:");
               if (nome == null || nome.trim().isEmpty()) {
                   // O usuário clicou em "Cancel" ou não inseriu um nome
                   System.exit(0); // Fechar o jogo
                   return; // Sair do método
               }
               nome = nome.trim();
               if (nome != null) {
                   players.add(new Player(nome, pontos));
                   players.sort(new Comparator<Player>() {
                       @Override
                       public int compare(Player p1, Player p2) {
                           return Integer.compare(p2.getPontos(), p1.getPontos());
                       }
                   });

                   // Mantém apenas os top 10 jogadores
                   if (players.size() > 10) {
                       players = players.subList(0, 10);
                   }

                   saveRanking(players);
                   update = true;
               }

           } catch (Exception e) {
               e.printStackTrace();
               System.err.println("Erro ao atualizar o ranking: " + e.getMessage());
           }
       }
    }

    public void desenharRanking(Graphics2D g, Hud hud) {
        if (this.image != null) {

            g.drawImage(image, 300, 20, getLargura() , getAltura(), null);

        }
        g.setColor(Color.white);
        desenha(g, "Ranking:");
        setPy(py+50);
        for (int i = 0; i < count; i++) {
            g.setColor(Color.white);
            Player player = players.get(i);
            if(player.getNome().equals(nome) && player.getPontos() == hud.getPontos() -1 ){
                g.setColor(Color.yellow);

            }
            String rankingEntry = (i + 1) + ". " + player.getNome() + " - " + player.getPontos() + " Pontos";
            desenha(g, rankingEntry);
            setPy(py + 50);
                }
            }


    private void saveRanking(List<Player> players) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(".\\River_raid_av3_ranking_semi\\River_raid_av3_ranking\\Ranking.txt"))) {
            for (int i = 0; i < players.size(); i++) {
                Player player = players.get(i);
                writer.write(String.format("%d. %s - %d Pontos%n", i + 1, player.getNome(), player.getPontos()));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error salvando ranking: " + e.getMessage());
        }
    }


    private List<Player> loadRanking() {
        List<Player> players = new ArrayList<>();
        try (InputStream arquivo = new FileInputStream(".\\River_raid_av3_ranking_semi\\River_raid_av3_ranking\\Ranking.txt");
             Scanner scanner = new Scanner(arquivo)) {

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] parts = linha.split(" - ");
                String name = parts[0].substring(parts[0].indexOf(".") + 2);
                int score = Integer.parseInt(parts[1].split(" ")[0]);
                players.add(new Player(name, score));
            }
        } catch (IOException e) {
            System.out.println("arquivo não encontrado ao carregar o ranking");
        }
        return players;
    }
}
