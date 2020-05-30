/**
 * Faz o placar do Jogo
 * 
 * @author (Daniela Pereira Rigoli) 
 * @version (29/05/2020)
 */
public class Placar{
    private int j1;
    private int j2;
    
    //metodo construtor com regramento para instanciar (criar) um objeto **este e com uso de parametro 
    public Placar(){
        setJ1(0);
        setJ2(0);
    }
    
    //getters ***metodos de acesso ao conteudo dos atributos do objeto (valor)
    public int getJ1(){
        return j1;    
    }
    public int getJ2(){
        return j2;    
    }
    
    //metodos de modificao ***** setters *******
    public void setJ1(int j1){
        this.j1 = j1;
    }
    public void setJ2(int j2){
        this.j2 = j2;
    }
    
    public String toString(){
        String aux = "Jogador 1 venceu: " + j1 +
            "\nJogador 2 venceu: " + j2;
        return aux;
    }
}

