/**
 * PEDRA PAPEL TESOURA (Lagarto e Spock)
 * Toda partida vai ter o player1 e o player2;
 * Métodos básicos.
 * E alem disso,
 * partida: recebe as jogada e retorna o vencedor de PPT(Pedra-Papel-Tesoura)
 * PPTLS: recebe as jogada e retorna o vencedor de PPTLS(Pedra-Papel-Tesoura-Lagarto-Spock)
 * 
 * @author (Daniela Pereira Rigoli) 
 * @version (29/05/2020)
 */
public class Jogo{
    private String player1;
    private String player2;
    
    //metodo construtor com regramento para instanciar (criar) um objeto **este e com uso de parametro 
    public Jogo(String player1, String player2){
        setPlayer1(player1);
        setPlayer2(player2);
    }
    
    //getters ***metodos de acesso ao conteudo dos atributos do objeto (valor)
    public String getPlayer1(){
        return player1;    
    }
    public String getPlayer2(){
        return player2;    
    }
    
    //metodos de modificao ***** setters *******
    public void setPlayer1(String player1){
        this.player1 = player1;
    }
    public void setPlayer2(String player2){
        this.player2 = player2;
    }
    
    //Quem venceu? Pedra-PapelTesoura
    public String partida(int jogada1, int jogada2){
        //0 = pedra; 1 = papel; 2 = tesoura;
        if(jogada1 == jogada2)
            return "Empate!";
        else{
            switch(jogada1){
                case 0:
                    if(jogada2 == 1)
                        return player2;
                    else
                        return player1;
                case 1:
                    if(jogada2 == 2)
                        return player2;
                    else
                        return player1;
                case 2:
                    if(jogada2 == 0)
                        return player2;
                    else
                        return player1;
                default: return "Resultado não encontrado";
            }
        }
    }
    
    //aplicando a expansão Pedra-Papel-Tesoura-Lagarto-Spock
    public String PPTLS(int jogada1, int jogada2){
        //0 = pedra; 1 = papel; 2 = tesoura;
        String vencedor = player2;
        if(jogada1 == jogada2)
            vencedor = "Empate!";
        else{
            switch(jogada1){
                case 0:
                    if(jogada2 == 3 || jogada2 == 2)
                        vencedor = player1;
                    break;
                case 1:
                    if(jogada2 == 0 || jogada2 == 4)
                        vencedor = player1;
                    break;
                case 2:
                    if(jogada2 == 1 || jogada2 == 3)
                        vencedor = player1;
                    break;
                case 3:
                    if(jogada2 == 1 || jogada2 == 4)
                        vencedor = player1;
                    break;
                case 4:
                    if(jogada2 == 0 || jogada2 == 2)
                        vencedor = player1;
                    break;
                default: return "Resultado não encontrado";
            }
        }
        return vencedor;
    }
    
}





















