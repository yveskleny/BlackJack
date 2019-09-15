package jogo;

import java.util.Scanner;

public class MainJogo {

	public static void printFinalStatus(Jogador jogador, Jogador dealer) {
		System.out.println("----------------------------------------");
		System.out.println("Suas cartas: ");
		System.out.println(jogador.mostrarCartas());
		System.out.println("Sua soma = " + jogador.getSoma());
		
		System.out.println("Cartas Dealer: ");
		System.out.println(dealer.mostrarCartas());
		System.out.println("Soma dealer = " + dealer.getSoma());
		System.out.println("----------------------------------------");
	}
	
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		Jogador jogador = new Jogador();
		Jogador dealer = new Jogador();
		
		boolean continuarJogando = true;
		
		while(continuarJogando) {
			Baralho baralho = new Baralho();
			
			baralho.embaralhar();
			
			jogador.comprarCarta(baralho);
			jogador.comprarCarta(baralho);
			
			dealer.comprarCarta(baralho);
			dealer.comprarCarta(baralho);
			
			
			boolean fimTurno = false;
			
			
			while(!fimTurno) {

				System.out.println("----------------------------------------");
				System.out.println("Suas cartas: ");
				System.out.println(jogador.mostrarCartas());
				System.out.println("Soma = " + jogador.getSoma());
				
				System.out.println("Cartas do Dealer: ");
				System.out.println(dealer.mostrarUmaCarta());
				System.out.println("----------------------------------------");
					
//				if(jogador.getSoma() == 21) {
//					if(dealer.getSoma() < 21) {
//						dealer.changeStatus();
//					}else {
//						dealer.changeStatus();
//						jogador.changeStatus();
//					}
//					break;
//				}
				
				System.out.println("Escolha: ");
				System.out.println("[1]Pedir Carta  [2]Parar");
				
				int resposta = Integer.parseInt(input.nextLine());
				
				if (resposta == 1){
					jogador.comprarCarta(baralho);
					if(jogador.getSoma() > 21) {
						System.out.println("----------------------------------------");
						System.out.println("Você ultrapassou 21!");
						if(jogador.getStatus() == false) {
							jogador.changeStatus();
							break;
						}
					}
				}
				
				if(resposta == 2){
					System.out.println("----------------------------------------");
					System.out.println("Cartas Dealer: ");
					System.out.println(dealer.mostrarCartas());
					System.out.println("Soma dealer = " + dealer.getSoma());
					
					while(dealer.getSoma() < 17){
						
						dealer.comprarCarta(baralho);
						System.out.println("----------------------------------------");
						System.out.println("Cartas Dealer: ");
						System.out.println(dealer.mostrarCartas());
						System.out.println("Soma dealer = " + dealer.getSoma());
						
						if(dealer.getSoma() > 21){
							//printFinalStatus(jogador, dealer);
							System.out.println("----------------------------------------");
							System.out.println("Dealer ultrapassou 21!");
							if(dealer.getStatus() == false) {
								dealer.changeStatus();
								break;
							}
						}
					}
					fimTurno = true;
				}
			}
			if(jogador.getStatus() == true && dealer.getStatus() == true) {
				printFinalStatus(jogador, dealer);
				System.out.println("Empate");
			}else if(jogador.getStatus() == false && dealer.getStatus() == true) {
				printFinalStatus(jogador, dealer);
				System.out.println("Jogador ganhou!");
			}else if(jogador.getStatus() == true && dealer.getStatus() == false) {
				printFinalStatus(jogador, dealer);
				System.out.println("Dealer ganhou!");
			}else if(jogador.getStatus() == false && dealer.getStatus() == false) {
				if(jogador.getSoma() > dealer.getSoma()) {
					printFinalStatus(jogador, dealer);
					System.out.println("Jogador ganhou!");
				}
				if(jogador.getSoma() < dealer.getSoma()) {
					printFinalStatus(jogador, dealer);
					System.out.println("Dealer ganhou!");
				}
				if(jogador.getSoma() == dealer.getSoma()) {
					printFinalStatus(jogador, dealer);
					System.out.println("Empate");
				}
			}
			jogador.esvaziarMao();
			dealer.esvaziarMao();
			System.out.println("----------------------------------------");
			System.out.println("Deseja continuar? [1]sim ou [2]não");
			int resp = Integer.parseInt(input.nextLine());
			
			if(resp == 2) {
				continuarJogando = false;
			}else {
				continue;
			}
			
		}
		
		
	
				
		input.close();
			
		}
	
		

	}



