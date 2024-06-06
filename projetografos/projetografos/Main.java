package br.com.projetografos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int op;
        Scanner opcao = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);

        GrafoDirecionado gd = new GrafoDirecionado();

        while(true) {
            System.out.println("\nDigite uma opção:");
            System.out.println("1 - Inserir Vértice");
            System.out.println("2 - Inserir Aresta");
            System.out.println("3 - Remover Aresta");
            System.out.println("4 - Exibir Grafo");
            System.out.println("5 - Sair do Programa");

            op = Integer.parseInt(opcao.nextLine());

            if(op == 1) {

                System.out.println("Insira o rótulo do vértice");
                char vertice = entrada.next().charAt(0);

                gd.adicionarVertice(vertice);
            } else if(op == 2) {

                System.out.println("Insira o vértice de origem:");
                char vertice1 = entrada.next().charAt(0);
                System.out.println("Insira o vértice de destino:");
                char vertice2 = entrada.next().charAt(0);

                gd.adicionarAresta(vertice1, vertice2);
            } else if(op == 3) {

                System.out.println("Insira o vértice de origem:");
                char vertice1 = entrada.next().charAt(0);
                System.out.println("Insira o vértice de destino:");
                char vertice2 = entrada.next().charAt(0);

                gd.removerAresta(vertice1, vertice2);
            } else if(op == 4) {

                gd.exibirGrafo();
            } else if (op == 5) {

                System.out.println("Encerrando Programa");
                break;
            }
        }
    }
}
