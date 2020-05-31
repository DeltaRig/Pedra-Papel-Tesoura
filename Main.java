/**
 * Automatiza o resultado de um jogo de Pedra-Papel-Tesoura(Lagarto-Spocke);
 * Não da erro ao receber valores String onde se espera valores inteiros.
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
        
        //Variaveis para auxiliar no menu
        Jogo jogo;
        jogo = new Jogo(player1, player2);
        Placar placar;
        placar = new Placar();
        String opcao = "-1";
        int op = -1;
        String vencedor = "";
        boolean x;
        
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
            opcao = scan.nextLine();
            
            x = true;
            
                x = validaTransInt(opcao);
                op = transInt(opcao);
        
            
            String jogada1, jogada2;
            int jogadaInt1, jogadaInt2;
            switch(op){
                case 1:
                    do{
                        System.out.println("\fPedra-Papel-Tesoura! JOGADA1");
                        System.out.println("Qual a jogada do jogador 1 " + player1);
                        System.out.println(PPT);
                        jogada1 = scan.nextLine();
                        
                        jogadaInt1 = transInt(jogada1);
                    }while(jogadaInt1 < 0 || jogadaInt1 > 2);
                    do{
                        System.out.println("\fPedra-Papel-Tesoura! JOGADA2");
                        System.out.println("Qual a jogada do jogador 2 " + player2);
                        System.out.println(PPT);
                        jogada2 = scan.nextLine();
                        
                        jogadaInt2 = transInt(jogada2);
                    }while(jogadaInt2 < 0 || jogadaInt2 > 2);
                    
                    vencedor = jogo.partida(jogadaInt1, jogadaInt2);
                    System.out.println("A/O vencedor(a) é: " + vencedor);
                    
                    if(vencedor.equals(player1))
                        placar.setJ1(placar.getJ1() + 1);
                    else if(vencedor.equals(player2))
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
                        jogada1 = scan.nextLine();
                        
                        jogadaInt1 = transInt(jogada1);
                    }while(jogadaInt1 < 0 || jogadaInt1 > 4);
                    do{
                        System.out.println("\fPedra-Papel-Tesoura! JOGADA2");
                        System.out.println("Qual a jogada do jogador 2 " + player2);
                        System.out.println(PPTLS);
                        jogada2 = scan.nextLine();
                        
                        jogadaInt2 = transInt(jogada2);
                    }while(jogadaInt2 < 0 || jogadaInt2 > 4);
                    
                    vencedor = jogo.PPTLS(jogadaInt1, jogadaInt2);
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
                        opcao = scan.nextLine();
                        
                        op = transInt(opcao);
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
    
    public static boolean validaTransInt(String valor){
        boolean x = true;
        try {
            Integer.parseInt(valor);
            x = false;
        } catch (NumberFormatException e) {
            x = true;
        }
        return x;
    }
    public static int transInt(String valor){
        int newValor = -1;
        try {
            newValor = Integer.parseInt(valor);
        } catch (NumberFormatException e) {
        }
        return newValor;
    }
    
    
    
}
