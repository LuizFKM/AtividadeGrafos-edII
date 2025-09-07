/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luizfrancisco.atividadegrafo;

/**
 *
 * @author User
 */
public class Aresta {
    Vertice origem;
    Vertice destino;
    int peso;

    public Aresta(Vertice origem, Vertice destino, int peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
    
    

    public Vertice getOrigem() {
        return origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Aresta{" + "origem=" + origem + ", destino=" + destino + ", peso=" + peso + '}';
    }
  
}
