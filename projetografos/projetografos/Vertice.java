package br.com.projetografos;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private char rotulo;

    private List<Aresta> arestas;

    public Vertice(char rotulo) {
        this.rotulo = rotulo;
        this.arestas = new ArrayList<Aresta>();
    }

    public char getRotulo() {
        return rotulo;
    }

    public void setRotulo(char rotulo) {
        this.rotulo = rotulo;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
    }

    public void adicionarAresta(Aresta aresta) {
        this.arestas.add((aresta));
    }

    public void removerAresta(Aresta aresta) {
        this.arestas.remove(aresta);
    }
}
