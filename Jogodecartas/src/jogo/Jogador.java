package jogo;

public class Jogador {
	private Carta[] cartasJogador;
	private int qtdDeCarta;
	private boolean perdeu;
	private int somaJogador;
	
	public Jogador() {
		this.cartasJogador = new Carta[10];
		this.perdeu = false;
		this.qtdDeCarta = 0;
		this.somaJogador = 0;
		
	}
	
	public String mostrarUmaCarta() {
		return " [" + this.cartasJogador[0].toString() + "] [Carta escondida]";
	}
	
	public String mostrarCartas() {
		String stringMao = "";
		
		for(int i = 0; i < this.qtdDeCarta; i++) {
			stringMao += " [" + this.cartasJogador[i].toString() + "] ";
			
		}
		return stringMao;
	}
	
	public void comprarCarta(Baralho baralho) {
		this.cartasJogador[qtdDeCarta] = baralho.getCartaTopo();
		this.qtdDeCarta++;
		this.calculaSoma();
	}
	
//	public int getQtdCarta() {
//		return this.qtdDeCarta;
//	}
	
	public void esvaziarMao() {
		for(int i = 0 ; i < this.cartasJogador.length ; i++) {
			this.cartasJogador[i] = null;
			this.qtdDeCarta = 0;
			this.somaJogador = 0;
		}
	}

	public void changeStatus(){
		if(this.perdeu == false){
			this.perdeu = true;
		}else{
			this.perdeu = false;
		}
	}

	public boolean getStatus(){
		return this.perdeu;
	}
	
	public int getSoma() {
		return this.somaJogador;
	}
	
	public void calculaSoma() {
		int somaTotal = 0;
		int qtdDeAces = 0;
		
		for(int i = 0; i < qtdDeCarta; i++) {
			switch(this.cartasJogador[i].getValor()) {
				case "2":
					somaTotal += 2;
					break;
				case "3":
					somaTotal += 3;
					break;
				case "4":
					somaTotal += 4;
					break;
				case "5":
					somaTotal += 5;
					break;
				case "6":
					somaTotal += 6;
					break;
				case "7":
					somaTotal += 7;
					break;
				case "8":
					somaTotal += 8;
					break;
				case "9":
					somaTotal += 9;
					break;
				case "10":
					somaTotal += 10;
					break;
				case "Valete":
					somaTotal += 10;
					break;
				case "Dama":
					somaTotal += 10;
					break;
				case "Rei":
					somaTotal += 10;
					break;
				case "As":
					qtdDeAces++;
					break;
			}
		}
		for(int i = 0; i < qtdDeAces; i++) {
			if(somaTotal <= 10) {
				somaTotal += 11;
			}else {
				somaTotal++;
			}
		}
		
		this.somaJogador = somaTotal;
		
	}
	
	
}
