package uninter;

import java.util.Random;


class Computador implements Jogador{
	//Metodo
	char tipo;
	
	// construtor
    public Computador(char ch){ 
    	tipo = ch;
    	}
    
    private int evalC(Tabuleiro t){
    	int melhor=-101, jogada, aux;
    	for(int i=0;i<9;i++){
    		if (t.jogadaValida(i, tipo)){ // se a jogada for válida
    			if (t.finalJogo()){
    				if (t.quemGanhou()==tipo)
    					melhor= 100; // valor alto
    				else // empate
    					melhor=0;
    				}
    			t.voltaJogada(i); // volta o tabuleiro a forma anterior
    			}
    		}
    	if (melhor>-101) // posso ganhar ou empatar
    		return melhor;
    	else {
    		for(int i=0;i<9;i++){
    			if (t.jogadaValida(i, tipo)){ // se a jogada for válida
    				aux = evalH(t); // avalia a jogada do computador
    				if (aux>melhor){ // se esta jogada for boa
    					melhor=aux;
    					jogada=i;
    					}
    				t.voltaJogada(i); // volta o tabuleiro a forma anterior
    				}
    			}
    		return melhor;
    		}
    	}
    private int evalH(Tabuleiro t){
    	int pior=101, jogada, aux;
    	char outro; // peca do outro jogador
    	outro = t.pecaAdversario(tipo);
    	for(int i=0;i<9;i++){
    		if (t.jogadaValida(i, outro)){ // se a jogada for válida
    			if (t.finalJogo()){
    				if (t.quemGanhou()==outro)
    					pior= -100; // valor baixo
    				else //empate
    					pior=0;     // se ele não pode ganhar, empata
    				}
    			t.voltaJogada(i); // volta o tabuleiro a forma anterior
    			}
    		}
    	if (pior<101) // o outro pode ganhar ou empatar
    		return pior;
    	else {
    		for(int i=0;i<9;i++){
    			if (t.jogadaValida(i, outro)){ // se a jogada for válida
    				aux = evalC(t); // avalia a jogada do humano
    				if (aux<pior){ // se esta jogada for boa
    					pior=aux;
    					jogada=i;
    					}
    				t.voltaJogada(i); // volta o tabuleiro a forma anterior
    				}
    			}
    		return pior;
    		}
    	}
		public void efetuaJogada(Tabuleiro t){
			int  aux,
			jogada = -1, // começa com uma melhor jogada inválida
			melhor = -101; // o valor dela é bem baixo (-infinito)
			Random a = new Random();

			System.out.println("");
			System.out.println("VEZ DO COMPUTADOR");

			
			
			// primeiro verifico se posso ganhar
			for(int i=0; i<9; i++){
				if (t.jogadaValida(i, tipo)){ // se a jogada for válida
					if (t.finalJogo()) // ganhei ou empatei
						return; // força a saída do método
					t.voltaJogada(i); // volta o tabuleiro a forma anterior
					}
				}
	
			// se cheguei até aqui vou fazer a recursão
			for(int i=0; i<9; i++){
				if (t.jogadaValida(i, tipo)){ // se a jogada for válida
					aux = evalH(t);
					if (aux>melhor){ // se a jogada i for melhor
						melhor=aux; 
						jogada=i;
						}
					else if (aux==melhor){ // se for igual coloca aleatoriedade
						if (a.nextInt(2)==1){
							melhor=aux;  // desta forma o computador "escolhe"
							jogada=i;    // entre jogadas equivalente
							}
						}
					t.voltaJogada(i); // retira a peça recem colocada
					}
				}
			t.jogadaValida(jogada, tipo);
		}
}
