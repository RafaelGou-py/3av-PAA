package Questao1;

import java.util.Arrays;

public class Grafo {
    private final int[][] matrizAdjacencia;
    private final String[] vertices;
    private final boolean[] ciclico;

    public Grafo() {
        this.vertices = new String[]{"A", "B", "C", "D", "E"};
        this.matrizAdjacencia = new int[5][5];
        this.ciclico = new boolean[5];
    }

    public void adicionarAresta(String verticeOrigem, String verticeDestino) {
        int i = getIndex(verticeOrigem);
        int j = getIndex(verticeDestino);

        if (matrizAdjacencia[i][j] == 1) {
            System.out.println("Esses pontos ja estão ligados");
        } else {
            matrizAdjacencia[i][j] = 1;
            matrizAdjacencia[j][i] = 1;
            System.out.println("Aresta adicionada com sucesso");
        }
    }

    public void removerAresta(String verticeOrigem, String verticeDestino) {
        int i = getIndex(verticeOrigem);
        int j = getIndex(verticeDestino);

        if (matrizAdjacencia[i][j] == 0) {
            System.out.println("Não é possível remover essa aresta, porque ela não existe");
        } else {
            matrizAdjacencia[i][j] = 0;
            matrizAdjacencia[j][i] = 0;
            System.out.println("Aresta removida com sucesso");
        }
    }

    public void exibirGrafo() {
        System.out.print("  ");
        for (int i = 0; i < vertices.length; i++) {
            System.out.print(vertices[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < matrizAdjacencia.length; i++) {
            System.out.print(vertices[i] + " ");
            for (int j = 0; j < matrizAdjacencia[i].length; j++) {
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int getIndex(String vertice) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(vertice)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contemCiclo() {
        Arrays.fill(ciclico, false);

        for (int i = 0; i < vertices.length; i++) {
            if (!ciclico[i]) {
                if (deepSearch(i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean deepSearch(int atual, int pai) {
        ciclico[atual] = true;

        for (int i = 0; i < vertices.length; i++) {
            if (matrizAdjacencia[atual][i] == 1) {
                if (!ciclico[i]) {
                    if (deepSearch(i, atual)) {
                        return true;
                    }
                } else if (i != pai) {
                    return true;
                }
            }
        }
        return false;
    }
}

