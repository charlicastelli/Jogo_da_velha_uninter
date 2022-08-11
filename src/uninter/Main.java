package uninter;

public class Main {
	public static void main(String[] args) {
		
		//M�todos
		Tabuleiro t = new Tabuleiro();
	    Jogador j1,j2;
	    char ch=t.escolhePeca();
	    j1 = (Jogador) new Humano(ch);
	    j2 = new Computador(t.pecaAdversario(ch));
	    Jogador atual;
	    
	    //Exibe mensagem e instru��o ao jogador 
	    System.out.println("");
	    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    System.out.println("        JOGO DA VELHA CONTRA O COMPUTADOR");
	    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    System.out.println("");
	    System.out.println("O jogador que estiver com o X come�a!");
	    System.out.println("No sorteio voc� ficou com o "+ch);
	    System.out.println("Na tabela abaixo est� as coordenadas do jogo!");
	    System.out.println("");
	    System.out.println("0|1|2");
	    System.out.println("-----");
	    System.out.println("3|4|5");
	    System.out.println("-----");
	    System.out.println("6|7|8");
	    System.out.println("");
	    
	    if (ch=='X') // come�a jogando o jogador com o X 
	    	atual = j1; 
	    else
	    	atual = j2; 
	    //Enquanto tabuleiro n�o est� finalizado as jogadas s�o efetuadas
	    while (!t.finalJogo()){
	    	atual.efetuaJogada(t);
	    	t.imprimeTabuleiro();
	    	if (atual==j1) // agora � a vez do j2
	    		atual=j2;
	    	else
	    		atual=j1;
	    	}
	    //imprime na tela o tabuleiro finalizado e se houve ganhador ou se terminou em empate
	    t.imprimeTabuleiro();
	    if (t.quemGanhou()==' ')
	    	System.out.println("O JOGO TERMINOU EMPATADO!!!");
	    else
	    	System.out.println("Ganhou o jogador com: "+t.quemGanhou());
	    }
	}