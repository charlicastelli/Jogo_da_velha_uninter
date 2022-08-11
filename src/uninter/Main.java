package uninter;

public class Main {
	public static void main(String[] args) {
		
		//Métodos
		Tabuleiro t = new Tabuleiro();
	    Jogador j1,j2;
	    char ch=t.escolhePeca();
	    j1 = (Jogador) new Humano(ch);
	    j2 = new Computador(t.pecaAdversario(ch));
	    Jogador atual;
	    
	    //Exibe mensagem e instrução ao jogador 
	    System.out.println("");
	    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    System.out.println("        JOGO DA VELHA CONTRA O COMPUTADOR");
	    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
	    System.out.println("");
	    System.out.println("O jogador que estiver com o X começa!");
	    System.out.println("No sorteio você ficou com o "+ch);
	    System.out.println("Na tabela abaixo está as coordenadas do jogo!");
	    System.out.println("");
	    System.out.println("0|1|2");
	    System.out.println("-----");
	    System.out.println("3|4|5");
	    System.out.println("-----");
	    System.out.println("6|7|8");
	    System.out.println("");
	    
	    if (ch=='X') // começa jogando o jogador com o X 
	    	atual = j1; 
	    else
	    	atual = j2; 
	    //Enquanto tabuleiro não está finalizado as jogadas são efetuadas
	    while (!t.finalJogo()){
	    	atual.efetuaJogada(t);
	    	t.imprimeTabuleiro();
	    	if (atual==j1) // agora é a vez do j2
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