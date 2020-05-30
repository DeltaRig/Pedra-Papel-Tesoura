/**
 * Automatiza o resultado de um jogo de Pedra-Papel-Tesoura(Lagarto-Spocke);
 * 
 * Ideias sobre o scan no comentario do darlan_machado: https://www.guj.com.br/t/qual-a-diferenca-entre-next-e-nextline/366387/13
 * 
 * Desafio da cadeira de Fudamentos da Programação elaborado por Lúcia Giraffa.
 * 
 * @author (Daniela Pereira Rigoli) 
 * @version (29/05/2020)
 */
import java.util.Scanner;
public class Main{
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String player1, player2;
        
        System.out.println("\fQual o nome do jogador 1?");
        player1 = scan.nextLine();
        System.out.println("Qual o nome do jogador 2?");
        player2 = scan.nextLine();
        
        Jogo jogo;
        jogo = new Jogo(player1, player2);
        Placar placar;
        placar = new Placar();
        int op = -1;
        String vencedor = "";
        
        //Para não ter que reescrever todas as opções 2 vezes:
        String PPT = "(0) Pedra\n(1) Papel\n(2) Tesoura";
        String PPTLS = "(0) Pedra\n(1) Papel\n(2) Tesoura\n(3) Lagarto\n(4) Spock";
        do{
            System.out.println("O que você desejam fazer?" +
                "\n(1) Jogar Pedra-Papel-Tesoura!" +
                "\n(2) Ver as regras de Pedra-Papel-Tesoura" +
                "\n(3) Jogar Pedra-Papel-Tesoura-Lagarto-Spock!" +
                "\n(4) Ver as regras Pedra-Papel-Tesoura-Lagarto-Spock" + 
                "\n(5) Ver placar" +
                "\n(6) Trocar um dos jogadores" +
                "\n(0) Sair");
            op = Integer.valueOf(scan.nextLine());
            int jogada1, jogada2;
            switch(op){
                case 1:
                    do{
                        System.out.println("\fPedra-Papel-Tesoura! JOGADA1");
                        System.out.println("Qual a jogada do jogador 1 " + player1);
                        System.out.println(PPT);
                        jogada1 = Integer.valueOf(scan.nextLine());
                    }while(jogada1 < 0 || jogada1 > 2);
                    do{
                        System.out.println("\fPedra-Papel-Tesoura! JOGADA2");
                        System.out.println("Qual a jogada do jogador 2 " + player2);
                        System.out.println(PPT);
                        jogada2 = Integer.valueOf(scan.nextLine());
                    }while(jogada2 < 0 || jogada2 > 2);
                    
                    vencedor = jogo.partida(jogada1, jogada2);
                    System.out.println("A/O vencedor(a) é: " + vencedor);
                    
                    if(vencedor.equals(player1))
                        placar.setJ1(placar.getJ1() + 1);
                    else if(vencedor.equals(player1))
                        placar.setJ2(placar.getJ2() + 1);
                    break;
                case 2:
                    System.out.println("o Tesoura corta papel" +
                        "\no Papel cobre pedra" + 
                        "\no Pedra quebra tesoura");
                    break;
                case 3:       
                    do{
                        System.out.println("\fPedra-Papel-Tesoura! JOGADA1");
                        System.out.println("Qual a jogada do jogador 1 " + player1);
                        System.out.println(PPTLS);
                        jogada1 = Integer.valueOf(scan.nextLine());
                    }while(jogada1 < 0 || jogada1 > 4);
                    do{
                        System.out.println("\fPedra-Papel-Tesoura! JOGADA2");
                        System.out.println("Qual a jogada do jogador 2 " + player2);
                        System.out.println(PPTLS);
                        jogada2 = Integer.valueOf(scan.nextLine());
                    }while(jogada2 < 0 || jogada2 > 4);
                    
                    vencedor = jogo.PPTLS(jogada1, jogada2);
                    System.out.println("A/O vencedor(a) é: " + vencedor);
                    
                    if(vencedor.equals(player1))
                        placar.setJ1(placar.getJ1() + 1);
                    else if(vencedor.equals(player2))
                        placar.setJ2(placar.getJ2() + 1);
                    break;
                case 4:
                    System.out.println("o Tesoura corta papel" +
                        "\no Papel cobre pedra" + 
                        "\no Pedra esmaga lagarto" +
                        "\no Lagarto envenena Spock" +
                        "\no Spock esmaga (ou derrete) tesoura" +
                        "\no Tesoura decapita lagarto" +
                        "\no Lagarto come papel" +
                        "\no Papel refuta Spock" + 
                        "\no Spock vaporiza pedra" +
                        "\no Pedra quebra tesoura");
                    break;
                case 5:
                    System.out.println("Jogador 1: " + player1 + "\nJogador 2: " + player2);
                    System.out.println(placar);
                    break;
                case 6:
                    do{
                        System.out.println("Aviso: O placar será reiniciado!" +
                            "\nQual jogador irá trocar? Digite '1' ou '2'" +
                            "\ne 3 para cancelar");
                        op = Integer.valueOf(scan.nextLine());
                    }while(op < 1 || op > 3);
                    if(op == 1){
                        System.out.println("Digite o nome do novo jogador 1:");
                        player1 = scan.nextLine();
                        jogo.setPlayer1(player1);
                        placar.setJ1(0);
                        placar.setJ2(0);
                    }else if(op == 2){
                        System.out.println("Digite o nome do novo jogador 2:");
                        player2 = scan.nextLine();
                        jogo.setPlayer2(player2);
                        placar.setJ1(0);
                        placar.setJ2(0);
                    }
                    break;
                case 0:
                    System.out.println("\nTchau");
                    break;
                default:
                    System.out.println("\nO valor digitado não está nas opções");
            }
        }while(op != 0);
    }
    
}
