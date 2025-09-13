/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.luizfrancisco.atividadegrafo;

/**
 *
 * @author User
 */
public class AtividadeGrafo {

    public static void main(String[] args) {
        Grafo g = new Grafo(true, true);
        Grafo g2 = new Grafo(false, false);
        
        g.addVertice("A");
        g.addVertice("B");
        g.addVertice("C");
        g.addVertice("D");
        
        g.addAresta("A", "B", 5);
        g.addAresta("B", "C", 2);
        g.addAresta("A", "D", 7);
        
        g.removeVertice("B");
        g.removerAresta("A", "B");
        g.removeVertice("B");
        g.removerAresta("B", "C");
        g.removeVertice("B");
        g.mostrarGrafo();
        g.mostrarMatrizAdjacente();
        g.mostrarListaAdjacente();
        
        g2.addVertice("Carlos");
        g2.addVertice("Beto");
        g2.addVertice("Daniel");
        g2.addVertice("Ana");
        g2.addVertice("Eduardo");
        g2.addVertice("Felipe");
        
        g2.addAresta("Carlos", "Daniel", 0);
        g2.addAresta("Carlos", "Eduardo", 0);
        g2.addAresta("Beto", "Ana", 0);
        g2.addAresta("Beto", "Eduardo", 0);
        g2.addAresta("Daniel", "Felipe", 0);
        g2.addAresta("Ana", "Felipe", 0);
        g2.addAresta("Eduardo", "Felipe", 0);
        
        g2.mostrarGrafo();
        
        g2.removerAresta("Carlos", "Daniel");
        g2.mostrarGrafo();
        g2.removeVertice("Eduardo");
        
        g2.removerAresta("Carlos", "Eduardo");
        g2.removerAresta("Beto", "Eduardo");
        g2.removerAresta("Eduardo", "Felipe");
        
        g2.mostrarGrafo();
        g2.mostrarMatrizAdjacente();
        g2.mostrarListaAdjacente();
        
    }
}
