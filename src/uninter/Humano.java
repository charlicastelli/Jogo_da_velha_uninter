package uninter;

class Humano implements Jogador{
	//Metodo
	char tipo;
	
	//Construtor
	public Humano(char ch){ 
		tipo = ch;
		}
	
	public void efetuaJogada(Tabuleiro t){
		int num;
		
		System.out.println("");
		System.out.println("SUA VEZ, faça a sua jogada entrando com um número entre 0 e 8:");

		//Enquanto a jogada for invalida, pede para tentar novamente.
	    num=Leitura.leInt();
	    while(!t.jogadaValida(num, tipo)){
	    	System.out.println("POR FAVOR, TENTE NOVAMENTE!");
	    	num=Leitura.leInt();
	    	}
	    }
	}

