package jogo;

import java.util.Random;

public class Baralho {
	private Carta[] baralho;
	private int tamanhoBaralho = 52;
	
	public Baralho() {
		this.baralho = new Carta[tamanhoBaralho];
		
		String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei", "As"};
		String[] naipes = {"Copas", "Ouros", "Espada", "Paus"};
		
		int cont = 0;
		
		for(String cadaNaipe : naipes) {
			for(String cadaValor : valores) {
				this.baralho[cont] = new Carta(cadaValor, cadaNaipe);
				cont++;
			}
		}
	}
	
	public String toString() {
		String stringBaralho = "";
		
		for(int i = 0; i < this.tamanhoBaralho; i++) {
			stringBaralho += " \n" + this.baralho[i].toString();
			
		}
		return stringBaralho;
	}
	
	public void embaralhar() {
		Random randomNum = new Random();
		
		int randomIndex = 0;
		Carta temp;
		
		for(int i = 0 ; i < 1000 ; i++) {
			for(int j = 0; j < this.tamanhoBaralho; j++) {
				
				randomIndex = randomNum.nextInt(this.tamanhoBaralho);
				
				temp = this.baralho[j];
				this.baralho[j] = this.baralho[randomIndex];
				this.baralho[randomIndex] = temp;
			}
		}	
	}
	
	public Carta getCartaTopo() {
		Carta retorno = this.baralho[0];
		
		for(int i = 1; i < this.tamanhoBaralho; i++) {
			this.baralho[i-1] = this.baralho[i];
		}
		this.tamanhoBaralho--;
		
		return retorno;
		
	}
}
