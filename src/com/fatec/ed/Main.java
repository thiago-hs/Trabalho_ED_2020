package com.fatec.ed;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		System.out.println("--------------------------------------------");
        System.out.println("Trabalho de estrutura de dados - 2020");
		System.out.println("--------------------------------------------");
        System.out.println("* Integrantes do grupo:");
        System.out.println("- Daniel Lopes da Costa");
        System.out.println("- Flávio Ribeiro de Barros da Silva");
        System.out.println("- Jaide Alonso Ambrosio");
        System.out.println("- Thiago Henrique da Silva");
        System.out.println("- Vitor Martinelli Lobo ");
        
        System.out.println("--------------------------------------------");
        
        while (true) { 
        	
            
            Cidades operacoesCidade = new Cidades("cidades.txt");
            operacoesCidade.hashLinear = operacoesCidade.iniciarHashLinear();
            operacoesCidade.hashLinkedList = operacoesCidade.iniciarHashLinkedList();
            
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
            		CRUD.create("DadosReciclagem_v02.csv");
            		break;
            	case 2:
            		CRUD.read("entrada.txt");
            		break;
            	case 3:
            		CRUD.delete("entrada.txt");
            		break;
            	case 4:
            		if (CRUD.insert(inserirAtualizar(INSERT), "entrada.txt")) {
            			System.out.println();
            			System.out.println("--------------------------------------------");
            	        System.out.println("Inclusao realizada com sucesso");
            	        System.out.println("--------------------------------------------");
            		} else {
            			System.out.println();
            			System.out.println("--------------------------------------------");
            	        System.out.println("Erro ao tentar fazer a inclusao");
            	        System.out.println("--------------------------------------------");
            		}
            		break;
            	case 5:
            		if (CRUD.update(inserirAtualizar(UPDATE), "entrada.txt") > 0) {
            			System.out.println();
            			System.out.println("--------------------------------------------");
            	        System.out.println("Atualizacao realizada com sucesso");
            	        System.out.println("--------------------------------------------");
            		} else {
            			System.out.println();
            			System.out.println("--------------------------------------------");
            	        System.out.println("Nao foi possivel realizar a atualizacao");
            	        System.out.println("--------------------------------------------");
            		}
            		break;
            	case 6:
            		CRUD.sortBySelectionSort("entrada.txt");
            		break;
            	case 7:
            		CRUD.sortByQuickSort("entrada.txt");
            		break;
            	case 8:
            		CRUD.pesquisa("entrada.txt");
            		break;
            	case 9:
            		operacoesCidade.imprimirHashLinear();
            		break;
            	case 10:
            		operacoesCidade.imprimirHashLinkedList();
            		break;
            	case 11:
            		Main.printarComDestaque("Fim do programa ! Obrigado por me executar :)");
            		in.close();
               		return;
               	default:
            		Main.printarComDestaque("Entrada invalida!");
                    break;
            }
        }
	}
	
	// -------------------------------------------------------------------------------------------
	
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
        System.out.println("8) Pesquisar Dados");
        System.out.println("9) Hash Table das cidades");
        System.out.println("10) Hash Table com lista ligada das cidades");
        System.out.println("11) Sair");

        System.out.println("");
	}
	
	// -------------------------------------------------------------------------------------------
	
	public static void printarComDestaque(String conteudo) {
        System.out.println("");
		System.out.println("--------------------------------------------");
        System.out.println(conteudo);
        System.out.println("--------------------------------------------");
        System.out.println("");
	}
	
	// -------------------------------------------------------------------------------------------
	
	private static final int INSERT = 1;
	private static final int UPDATE = 2;
	
	private static Registro inserirAtualizar(int tipo) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println();
		System.out.println();
		
		if (tipo == INSERT) {
			System.out.println("Novo registro:");
		} else if (tipo == UPDATE) {
			System.out.println("Atualizacao de registro:");
		}
		
        System.out.println("---------------------");
		
        Registro  r = new Registro();
        
        try {
        	
            System.out.print("Digite o ID [int]: ");
            String inputText = in.nextLine().trim();
            r.setId(Integer.parseInt(inputText));
            
            System.out.print("Digite o Estado [String]: ");
            inputText = in.nextLine().trim();
            r.setUf(inputText);
    		
            System.out.print("Digite a Producao de Lixo a/a (em milhoes ton) [float]: ");
            inputText = in.nextLine().trim();
            r.setProdLixo(Float.parseFloat(inputText));
    		
            System.out.print("Digite a qtde. de Postos de Coleta [int]: ");
            inputText = in.nextLine().trim();
            r.setPostosColeta(Integer.parseInt(inputText));
            
            System.out.print("Digite a porcetagem de Reciclagem [float]: ");
            inputText = in.nextLine().trim();
            r.setPorcentagemReciclagem(Float.parseFloat(inputText));
            
            System.out.print("Digite a economia gerada em R$ (milhoes) [float]: ");
            inputText = in.nextLine().trim();
            r.setEconomiaEmValores(Float.parseFloat(inputText));
            
            System.out.print("Digite a qtde. de Empregos Gerados [int]: ");
            inputText = in.nextLine().trim();
            r.setQtdeEmpregosGerados(Integer.parseInt(inputText));
            
        }catch( Exception e) {
        	
        	System.out.println("Erro ao manipular registro :(");
        	return null;
        	
        }
 
		return r;
	}
}
