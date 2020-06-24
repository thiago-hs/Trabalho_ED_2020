package com.fatec.ed;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		System.out.println("--------------------------------------------");
        System.out.println("Trabalho de estrutura de dados - 2020");
        System.out.println("<Explicação do trabalho>");
        System.out.println("--------------------------------------------");
        
        while (true) {

        	Main.printarMenu();
        	
            String inputText = in.nextLine().trim();
            
            int inputEntry = 0;
            
            try {
            	
                inputEntry = Integer.parseInt(inputText);

            }catch(Exception e) {
            	
        		Main.printarComDestaque("Entrada invalida!");

                continue;
            }
            
            
            switch(inputEntry) {
            	case 1:
            	case 2:
            	case 3:
            	case 4:
            	case 5:
            	case 6:
            	case 7:
            	case 8:
            	case 9:
            	case 10:
            		Main.printarComDestaque("Fim do programa!");
               		return;
               	default:
            		Main.printarComDestaque("Entrada invalida!");
                    break;
            }
        }
	}
	
	public static void printarMenu() {
        System.out.println("");

        System.out.println("Opções do sistema: ");
        
        System.out.println("");

        System.out.println("1) Create");
        System.out.println("2) Read");
        System.out.println("3) Delete");
        System.out.println("4) Insert");
        System.out.println("5) Update");
        System.out.println("6) Classificação por Selection Sort");
        System.out.println("7) Classificação por Quick Sort");
        System.out.println("8) Pesquisa");
        System.out.println("9) Hash das cidades");
        System.out.println("10) Sair");

        System.out.println("");
	}
	
	public static void printarComDestaque(String conteudo) {
        System.out.println("");
		System.out.println("--------------------------------------------");
        System.out.println(conteudo);
        System.out.println("--------------------------------------------");
        System.out.println("");
	}
}
