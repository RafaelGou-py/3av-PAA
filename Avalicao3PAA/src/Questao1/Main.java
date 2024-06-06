package Questao1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar aresta");
            System.out.println("2. Remover aresta");
            System.out.println("3. Exibir grafo");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();

            if (opcao == 4) {
                break;
            }

            if (opcao == 3) {
                grafo.exibirGrafo();
                if (grafo.contemCiclo()) {
                    System.out.println("É um grafo cíclico");
                } else {
                    System.out.println("Não é um grafo cíclico");
                }
                continue;
            }

            scanner.nextLine();

            System.out.println("Digite o vértice de origem:");
            String verticeOrigem = scanner.nextLine();

            System.out.println("Digite o vértice de destino:");
            String verticeDestino = scanner.nextLine();

            switch (opcao) {
                case 1:
                    grafo.adicionarAresta(verticeOrigem, verticeDestino);
                    break;
                case 2:
                    grafo.removerAresta(verticeOrigem, verticeDestino);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
