package jogo;

public class Carta {
	private String valor;
	private String naipe;
	
	public Carta(String valor, String naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}
	
	public String toString() {
		return this.valor + " de " + this.naipe;
	}
	
	public String getValor() {
		return this.valor;
	}
}
