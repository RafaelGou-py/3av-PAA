package br.com.projetografos;

import java.util.ArrayList;
import java.util.List;

public class GrafoDirecionado {

    private List<Vertice> vertices;

    public GrafoDirecionado() {
        this.vertices = new ArrayList<Vertice>();
    }

    public void adicionarVertice(char rotulo) {
        Vertice novoVertice = new Vertice(rotulo);
        this.vertices.add(novoVertice);

        System.out.printf("Vertice %c adicionado\n", rotulo);
    }

    public void adicionarAresta(char verticeOrigem, char verticeDestino) {
        Vertice origem = this.getVertice(verticeOrigem);
        Vertice destino = this.getVertice(verticeDestino);
        if(origem.equals(destino)) {
            System.out.println("Não é possível conectar no mesmo vértice\n");
        } else {
            Aresta aresta = new Aresta(origem, destino);
            origem.adicionarAresta(aresta);

            System.out.printf("Aresta do vertice %c ao vertice %c adicionada\n",
                    verticeOrigem, verticeDestino);
        }
    }

    public void removerAresta(char verticeOrigem, char verticeDestino) {
        Vertice origem = this.getVertice(verticeOrigem);
        Vertice destino = this.getVertice(verticeDestino);

        if(this.vertices.contains(origem) && this.vertices.contains(destino)) {
            for(Aresta aresta : origem.getArestas()) {
                if (aresta.getDestino().equals(destino)) {
                    origem.removerAresta(aresta);
                    System.out.printf("Aresta do vertice %c ao vertice %c removida\n",
                            verticeOrigem, verticeDestino);
                    break;
                }
            }
        }
    }

    public Vertice getVertice(char rotulo) {
        for (Vertice vertice : this.vertices) {
            if (vertice.getRotulo() == rotulo) {
                return vertice;
            }
        }
        return null;
    }

    public void exibirGrafo() {
        for (Vertice vertice : this.vertices) {
            System.out.printf("Origem %c --> ", vertice.getRotulo());
            for (Aresta aresta : vertice.getArestas()) {
                System.out.printf("%c --> ", aresta.getDestino().getRotulo());
            }
            System.out.print("NULL");
            System.out.println();
        }
    }
}
