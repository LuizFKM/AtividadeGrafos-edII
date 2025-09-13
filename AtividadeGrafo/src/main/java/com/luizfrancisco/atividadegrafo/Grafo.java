/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luizfrancisco.atividadegrafo;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Grafo {
    ArrayList<Vertice> vertices;
    ArrayList<Aresta> arestas;
    boolean direcionado;
    boolean ponderado;

    public Grafo(boolean direcionado, boolean ponderado) {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
        this.direcionado = direcionado;
        this.ponderado = ponderado;
    }
    
    public void addVertice(String valor){
        if(validarVertice(valor)){
            vertices.add(new Vertice(valor));
        }
    }
    
    public void removeVertice(String valor){
        
        Vertice v = buscarVertice(valor);
        
        if (v == null){
            System.out.println("Vertice nao encontrado");
            return;
        }
        
        ArrayList<Aresta> bloqueio = new ArrayList<>();
        
        for(Aresta a : arestas){
            if (a.getOrigem().equals(v) || a.getDestino().equals(v)){
                bloqueio.add(a);
            }
        }
        
        if(!bloqueio.isEmpty()){
            System.out.println("Nao foi possivel remover o vértiuce, arestas q bloqueiam: ");
            
            for (Aresta a : bloqueio){
                System.out.println(" - " + a);
            }
        }
        
    }
    
    public boolean validarVertice(String valor){
        for(Vertice v: vertices){
            if(v.getValor().equals(valor)){
                System.out.println("O vertice ("+valor+")já existe no grafo");
                return false;
            }
        }
        return true;
    }
    
    private void mostrarVertices(){
        for(Vertice v : vertices){
            System.out.println(" * " + v);
        }
    }
    
    public void addAresta(String verticeInicial, String verticeFinal, int peso){
        Vertice origem = buscarVertice(verticeInicial);
        Vertice destino = buscarVertice(verticeFinal);
        
        if(origem == null || destino == null){
            System.out.println("Vertices não encontrados: " + origem + " - " + destino);
        }
        
        for(Aresta a : arestas){
            if(a.getOrigem().equals(origem) && 
                    a.getDestino().equals(destino)){
                System.out.println("Já existe a aresta: " + a);
                return;
            }
        }
        
        if(!ponderado){
            peso = 0;
        }
        if(direcionado){
            arestas.add(new Aresta(origem, destino, peso));
        }else{
            arestas.add(new Aresta(origem, destino, peso));
            arestas.add(new Aresta(destino, origem, peso));
        }
    }
    
    public void removerAresta(String verticeInicial, String verticeFinal){
        Vertice origem = buscarVertice(verticeInicial);
        Vertice destino = buscarVertice(verticeFinal);
        
        if (origem == null || destino == null){
            System.out.println("Vertices nao encontrados");
            return;
        }
       
        boolean removida = false;
        
        for(int i = arestas.size() -1; i >= 0; i--){
            Aresta a = arestas.get(i);
            
            if(direcionado){
               if(a.getOrigem().equals(origem) && a.getDestino().equals(destino)){
                   arestas.remove(i);
                   removida = true;
                   
               }
            } else {
                if ((a.getOrigem().equals(origem) && a.getDestino().equals(destino)) || (a.getOrigem().equals(destino) && a.getDestino().equals(origem))) {
                    arestas.remove(i);
                    removida = true;
            }
                
           }
        }
        
        if(removida){
            System.out.println("Aresta de " + origem.getValor() + " e " + destino.getValor() + " removidas ");
        }else{
            System.out.println("nenhuma aresta remiovida");
        }
        
    }
    
    
    private Vertice buscarVertice(String valor){
        for(Vertice v : vertices){
            if(v.getValor().equals(valor)){
                return v;
            }
        }
        return null;
    } 
    
    private void mostrarAresta(){
        for(Aresta a : arestas){
            System.out.println(a);
        }
    }
    
    public void mostrarGrafo(){
        System.out.println("Grafo: " + 
                (ponderado ? "Ponderado" : "Não ponderado") + " - " +
                (direcionado ? "Direcionado" : "Não direcionado"));
        System.out.println("Quantidade de vértices do grafo: " +
                vertices.size());
        mostrarVertices();
        System.out.println("Quantidade de arestas do grafo: " +
                arestas.size());
        mostrarAresta();
    }
    
    public void mostrarMatrizAdjacente(){
        int n = vertices.size();
        int [][] matriz = new int[n][n];
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matriz [i] [j] = 0;
            }
        }
        
        for (Aresta a : arestas){
            int i = vertices.indexOf(a.getOrigem());
            int j = vertices.indexOf(a.getDestino());
            
            int valor = ponderado ? a.getPeso() : 1;
            
            matriz[i][j] = valor;
            
        }
        
        System.out.println("\nMatriz de adjacencia:");
        System.out.print(" ");
        for(Vertice v : vertices){
            System.out.print(v + " ");
            
        }
        System.out.println();
        
        for (int i = 0; i < n; i++) {
            System.out.print(vertices.get(i) + " ");
            for (int j = 0; j < n; j++) {
                System.out.print(" " + matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void mostrarListaAdjacente(){
        System.out.println("Lista adjacente");
        
        for (Vertice v : vertices){
            ArrayList<String> adj = new ArrayList<>();
            
            for (Aresta a : arestas){
                if(a.getOrigem() == v){
                    String destino = a.getDestino().getValor();
                    
                    if(ponderado){
                        destino += "(" + a.getPeso() + ")";
                    }
                    adj.add(destino);
                }
            }
            
            System.out.println(v + " -> " + adj);
        }
    }
    
    
}
