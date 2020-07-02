package com.fatec.ed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CRUD {

	
	
	/**
	 * Cria um arquivo de entrada chamado <b>entrada.txt</b> a partir de outro arquivo.
	 * @param path : Caminho do arquivo.
	 * @return
	 * <code>true</code> se a leitura do arquivo for bem-sucedida. Caso contrario retorna <code>false</code>.
	 */
	public static boolean create(String path) {
		// Leitura do arquivo de origem
		List<String> dados = new ArrayList<String>();
		
		try {
			BufferedReader leitor = new BufferedReader(new FileReader(path));
			String linha = "";
			boolean flag = true;
			
			while (flag) {
				linha = leitor.readLine();
				if (linha != null) {
					dados.add(linha);
				} else {
					flag = false;
				}
			}
			leitor.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		// criacao do arquivo de entrada
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter("entrada.txt"));
			
			for (int i = 0; i < dados.size(); i++) {
				escritor.append(dados.get(i) + "\r\n");
			}
			
			escritor.flush();
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		System.out.println();
		System.out.println("--------------------------------------------");
		System.out.println("Arquivo entrada.txt criado com sucesso !");
        System.out.println("--------------------------------------------");
        
		return true;
	}
	
	// -------------------------------------------------------------------------------------------
	
	public static boolean read(String path) {
		List<String[]> dados = new ArrayList<String[]>();
		
		// Leitura do arquivo
		try {
			BufferedReader leitor = new BufferedReader(new FileReader(path));
			String linha = "";
			boolean flag = true;
			
			System.out.println("Leitura do arquivo: '" + path + "'");
			System.out.println();
			
			while (flag) {
				linha = leitor.readLine();
				if (linha != null) {
					String[] temp = linha.split(";");
					dados.add(temp);
				} else {
					flag = false;
				}
			}
			
			leitor.close();
		} catch (FileNotFoundException e) {
			System.out.println();
			System.out.println("--------------------------------------------");
			System.out.println("Arquivo entrada.txt nÃ£o encontrado :( , Crie-o ande de executar essa operaÃ§Ã£o :) ");
	        System.out.println("--------------------------------------------");
			return false;
		} catch (IOException e) {
			System.out.println();
			System.out.println("--------------------------------------------");
			System.out.println("Arquivo entrada.txt nÃ£o encontrado :( , Crie-o ande de executar essa operaÃ§Ã£o :) ");
	        System.out.println("--------------------------------------------");
			return false;
		}
		
		// apresentacao dos dados
		/* recupera o tamanho do cabecalho pra fazer a formatacao */
		String[] temp = dados.get(0);
		int[] iArray = new int[temp.length];
		
		for (int i = 0; i < dados.size(); i++) {
			
			temp = dados.get(i);
			
			for (int j = 0; j < temp.length; j++) {
				if (iArray[j] < temp[j].length()) {
					iArray[j] = temp[j].length() + 3;
				}
			}
		}
		
		// imprime o cabecalho	
		temp = dados.get(0);
		int lenCab = 0;
		
		for (int b = 0; b < temp.length; b++) {
			if (temp[b].length() < (iArray[b])) {
				int tam = iArray[b] - temp[b].length(); 
				lenCab += temp[b].length() + 3;
				String s = temp[b];
				int t = 0;
				
				while (t < tam) {
					s += " ";
					t++;
				}
				
				s += " | ";
				System.out.print(s);
			} else {
				System.out.print(temp[b] + " | ");
				lenCab += temp[b].length() + 3;
			}
		}
		
		String linhaCabecalho = "";
		for (int k = 0; k < (lenCab * 1.30); k++) {
			linhaCabecalho += "-";
		}
		
		System.out.println();
		System.out.println(linhaCabecalho);
		
		// imprime os dados de acordo com o tamanho de cada titulo do cabecalho
		// contador comeca com 1 pra pular o cabecalho
		for (int a = 1; a < dados.size(); a++) {
			temp = dados.get(a);
			
			for (int b = 0; b < temp.length; b++) {
				if (temp[b].length() < (iArray[b])) {
					int tam = iArray[b] - temp[b].length(); 
					String s = temp[b];
					int t = 0;
					
					while (t < tam) {
						s += " ";
						t++;
					}
					
					s += " | ";
					System.out.print(s);
				} else {
					System.out.print(temp[b]);
				}
			}
			System.out.println();
		}
		
		return true;
	}
	
	// -------------------------------------------------------------------------------------------
	
	public static boolean delete(String path) {
		List<String> dados = new ArrayList<>();
		
		// Leitura do arquivo
		try {
			BufferedReader leitor = new BufferedReader(new FileReader(path));
			boolean flag = true;
			int linhaAtual = 0;
			
			while (flag) {
				String linha = leitor.readLine();
				
				if ((linha != null)) {
					if (linhaAtual == 1) {
						// pula esta linha e nÃ£o adiciona
					} else {
						dados.add(linha);
					}
				} else {
					flag = false;
				}
				linhaAtual++;
			}
			
			leitor.close();
		} catch (FileNotFoundException e) {
			System.out.println();
			System.out.println("--------------------------------------------");
			System.out.println("Arquivo entrada.txt nÃ£o encontrado :( , Crie-o ande de executar essa operaÃ§Ã£o :) ");
	        System.out.println("--------------------------------------------");
			return false;
		} catch (IOException e) {
			return false;
		}
		
		// escrita no novo arquivo
		try {
			BufferedWriter escritor = new BufferedWriter(new FileWriter("entrada2.txt"));
			
			for (int i = 0; i < dados.size(); i++) {
				escritor.append(dados.get(i) + "\r\n");
			}
			
			escritor.close();
		} catch (IOException e) {
			return false;
		}
		
		// copia o arquivo novo sobre o antigo e exclui
		try {
			Files.copy(Paths.get("entrada2.txt"), Paths.get("entrada.txt"), StandardCopyOption.REPLACE_EXISTING);
			Files.deleteIfExists(Paths.get("entrada2.txt"));
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
	
	// -------------------------------------------------------------------------------------------
	
	public static boolean insert(Registro registro, String path) {
		if(registro != null) {
			try {
				
				// leitura dos registros para inclusao no 'ArrayList'
				BufferedReader leitor = new BufferedReader(new FileReader(path));
				List<String> dados = new ArrayList<String>();
				boolean flag = true;

				while (flag) {
					String linha = leitor.readLine();

					if (linha != null) {
						dados.add(linha);
					} else {
						StringBuffer sb = new StringBuffer();

						sb.append(registro.getId() + ";");
						sb.append(registro.getUf() + ";");
						sb.append(registro.getProdLixo() + ";");
						sb.append(registro.getPostosColeta() + ";");
						sb.append(registro.getPorcentagemReciclagem() + ";");
						sb.append(registro.getEconomiaEmValores() + ";");
						sb.append(registro.getQtdeEmpregosGerados());

						dados.add(sb.toString());
						flag = false;
					}

				}

				leitor.close();
				
				// sobrescrita do arquivo
				BufferedWriter escritor = new BufferedWriter(new FileWriter(path));
				
				for (int i = 0; i < dados.size(); i++) {
					escritor.append(dados.get(i) + "\r\n");
				}
				
				escritor.flush();
				escritor.close();
			} catch (FileNotFoundException e) {
				System.out.println();
				System.out.println("--------------------------------------------");
				System.out.println("Arquivo entrada.txt nÃ£o encontrado :( , Crie-o ande de executar essa operaÃ§Ã£o :) ");
		        System.out.println("--------------------------------------------");
				return false;
			} catch (IOException e) {
				return false;
			}
			
			return true;
		}
		return false;
	}
	
	// -------------------------------------------------------------------------------------------
	
	public static int update(Registro r, String path) {
		
		if(r != null) {
			int affectedRecords = 0;
			
			try {
				// leitura dos registros para criacao da 'LinkedList'
				BufferedReader leitor = new BufferedReader(new FileReader(path));
				List<String> dados = new LinkedList<String>();
				boolean flag = true;
				
				while (flag) {
					String linha = leitor.readLine();
					if ((linha != null) ) {
						dados.add(linha);
					} else {
						flag = false;
					}
				}
				
				leitor.close();
				
				// atualizacao
				// variavel 'i' comeca com 1 para pular o cabecalho
				for (int i = 1; i < dados.size(); i++) {
					String[] temp = dados.get(i).split(";");
					int idLista = Integer.parseInt(temp[0]);
					
					if (idLista == r.getId()) {
						String s = String.valueOf(r.getId()) + ";"
							+ String.valueOf(r.getUf()) + ";"
							+ String.valueOf(r.getProdLixo()) + ";"
							+ String.valueOf(r.getPostosColeta()) + ";"
							+ String.valueOf(r.getPorcentagemReciclagem()) + ";"
							+ String.valueOf(r.getEconomiaEmValores()) + ";"
							+ String.valueOf(r.getQtdeEmpregosGerados());
						dados.set(i, s);
						affectedRecords++;
					}
					
				}
				
				// sobrescrita do arquivo
				BufferedWriter escritor = new BufferedWriter(new FileWriter(path));
				
				for (int i = 0; i < dados.size(); i++) {
					escritor.append(dados.get(i) + "\r\n");
				}
				
				escritor.flush();
				escritor.close();
			} catch (FileNotFoundException e) {
				System.out.println();
				System.out.println("--------------------------------------------");
				System.out.println("Arquivo entrada.txt nÃ£o encontrado :( , Crie-o ande de executar essa operaÃ§Ã£o :) ");
		        System.out.println("--------------------------------------------");
				return 0;
			} catch (IOException e) {
				return 0;
			}
			
			return affectedRecords;
		}
		
		return 0;

	}
	
	// -------------------------------------------------------------------------------------------
	
	public static List<Registro> fileToList(String path) {
		
		List<Registro> dados = new ArrayList<>();
		
		// Leitura do arquivo
		try {
			
			BufferedReader leitor = new BufferedReader(new FileReader(path));
			
			String linha = "";
			
			boolean flag = true;
			
			boolean firstLine = true;
			
			while (flag) {
				
				linha = leitor.readLine();
				
				if (linha != null) {
					
					if(!firstLine){
						
						String[] temp = linha.split(";");
						
						Registro registro = new Registro();
						
						registro.setId(Integer.parseInt(temp[0]));
						registro.setUf(temp[1]);
						registro.setProdLixo(Float.parseFloat(temp[2]));
						registro.setPostosColeta(Integer.parseInt(temp[3]));
						registro.setPorcentagemReciclagem(Float.parseFloat(temp[4]));
						registro.setEconomiaEmValores(Float.parseFloat(temp[5]));
						registro.setQtdeEmpregosGerados(Integer.parseInt(temp[6]));

						dados.add(registro);
						
					} else {
				
						firstLine = false;
						
					}

				} else {
					
					flag = false;
					
				}
			}
			
			leitor.close();
			
			return dados;

		} catch (FileNotFoundException e) {
			
			System.out.println();
			System.out.println("--------------------------------------------");
			System.out.println("Arquivo entrada.txt nÃ£o encontrado :( , Crie-o ande de executar essa operaÃ§Ã£o :) ");
	        System.out.println("--------------------------------------------");
	        
			return null;
			
		} catch (IOException e) {
			
			System.out.println();
			System.out.println("--------------------------------------------");
			System.out.println("Arquivo entrada.txt nÃ£o encontrado :( , Crie-o ande de executar essa operaÃ§Ã£o :) ");
	        System.out.println("--------------------------------------------");
	        
			return null;
		}
	}
	
	// -------------------------------------------------------------------------------------------
	
	public static void sortByQuickSort(String path) {
		
		List<Registro> listaRegistros = CRUD.fileToList(path);
		
		if(listaRegistros == null) {
			return;
		}
		
		Registro[] registroArr = new Registro[listaRegistros.size()];
		
		for (Registro registro : listaRegistros) 
			registroArr[listaRegistros.indexOf(registro)] = registro;
		
		
        long tempoInicial = System.currentTimeMillis();
        
		try {
			
			quickSort(registroArr, 0, registroArr.length - 1);

			BufferedWriter escritor = new BufferedWriter(new FileWriter("quickSort.txt"));
			
			escritor.append("ID;Estados;Prod. Lixo a.a. (milhoes ton.);Postos de Coleta;% de Reciclagem;Economia em R$ (milhoes);Qtde de empregos gerados");

			for (int i = 0; i < registroArr.length; i++) {
				
				escritor.append(registroArr[i].toString() + "\r\n");
				
			}
			
			escritor.flush();
			escritor.close();
			
		} catch (IOException e) {
			
	        System.out.println("Ordenação por quick sort falhou :( ");

			e.printStackTrace();
			
			return;
		}
		
        System.out.println("");

        System.out.println("Ordenação executada com sucesso :)");
        
        System.out.println("");

		long tempoFinal = System.currentTimeMillis();
		  
        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");

    }
	
	public static void quickSort(Registro v[], int esquerda, int direita) {
		int esq = esquerda;
		int dir = direita;
		Registro pivo = v[(esq + dir) / 2];
		Registro troca;

		while (esq <= dir) {
			while (v[esq].compareTo(pivo) < 0) {
				esq = esq + 1;
			}
			while (v[dir].compareTo(pivo) > 0) {
				dir = dir - 1;
			}
			if (esq <= dir) {
				troca = v[esq];
				v[esq] = v[dir];
				v[dir] = troca;
				esq = esq + 1;
				dir = dir - 1;
			}
		}
		if (dir > esquerda)
			quickSort(v, esquerda, dir);

		if (esq < direita)
			quickSort(v, esq, direita);

	}

    
	// -------------------------------------------------------------------------------------------
	
	public static void sortBySelectionSort(String path) {
		
		List<Registro> listaRegistros = CRUD.fileToList(path);
		
		if(listaRegistros == null) {
			return;
		}
		
		Registro[] registroArr = new Registro[listaRegistros.size()];
		
		for (Registro registro : listaRegistros) 
			registroArr[listaRegistros.indexOf(registro)] = registro;
		
		
        long tempoInicial = System.currentTimeMillis();
        

		try {
			
			selectionSort(registroArr);

			BufferedWriter escritor = new BufferedWriter(new FileWriter("selectionSort.txt"));
			
			escritor.append("ID;Estados;Prod. Lixo a.a. (milhoes ton.);Postos de Coleta;% de Reciclagem;Economia em R$ (milhoes);Qtde de empregos gerados");

			for (int i = 0; i < registroArr.length; i++) {
				
				escritor.append(registroArr[i].toString() + "\r\n");
				
			}
			
			escritor.flush();
			escritor.close();
			
		} catch (IOException e) {
			
	        System.out.println("Ordenação por selection sort falhou :( ");

			e.printStackTrace();
			
			return;
		}
		
        System.out.println("");

        System.out.println("Ordenação executada com sucesso :)");
        
        System.out.println("");

		long tempoFinal = System.currentTimeMillis();
		  
        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
	}
	
		
	public static void selectionSort(Registro v[]) {
		int length = v.length;
	    for (int i = 0; i < length - 1; i++) {
	      int minPos = i;
	      Registro min = v[minPos];
	      for (int j = i + 1; j < length; j++) {
	        if (v[j].compareTo(min) < 0) {
	          minPos = j;
	          min = v[minPos];
	        }
	      }
	      if (minPos != i) {
	        v[minPos] = v[i];
	        v[i] = min;
	      }
	    }
	  }
	public static String pesquisa(Registro r, String path) {
		
		if (r != null) {
			int affectedRecords = 0;

			try {
				// leitura dos registros para criacao da 'LinkedList'
				BufferedReader leitor = new BufferedReader(new FileReader(path));
				List<String> dados = new LinkedList<String>();
				boolean flag = true;

					while (flag) {
						String linha = leitor.readLine();
					if ((linha != null)) {
						dados.add(linha);
					} else {
						flag = false;
					}
					return linha;
					}
				}catch(IOException e) {
					
				}
			}
		return null;
		}
	}
}
