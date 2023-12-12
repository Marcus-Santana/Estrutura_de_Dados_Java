package PilhaFila;

import javax.swing.JTextArea;

public class Pilha {
	
	private NoPilha topo;
	private int tamanho;
	

	public Pilha() {
		
		topo = null;
		tamanho = 0;
		 
	}
	
	public boolean vazia() {
		
		return topo == null;

	}
	
	public void inserir(int info) {
		
		NoPilha novo = new NoPilha(info);
	
		if (vazia()) {
			topo = novo;
		}else {
			novo.proximo = topo;
			topo = novo;
		}
		tamanho++;
	}
	
	public int remover() {
		
	    if (vazia()) {
	        throw new IllegalStateException("A pilha está vazia. Não é possível remover.");
	    } else {
	        int dadoRemovido = topo.dado;
	        topo = topo.proximo;
	        tamanho--;
	        return dadoRemovido;
	    }
	}
	
	public void mostrarElementos(JTextArea textArea) {
		
	    if (vazia()) {
	    	textArea.append("A pilha está vazia.");
	    } else {
	        NoPilha aux = topo;
	        textArea.append("Elementos da pilha:\n");
	        while (aux != null) {
	        	textArea.append(String.valueOf(aux.dado) + "\n");
	            aux = aux.proximo;
	        }
	    }
	}
	
	public boolean buscarElemento(int elemento) {
		
	    NoPilha aux = topo;
	    while (aux != null) {
	        if (aux.dado == elemento) {
	            return true;
	        }
	        aux = aux.proximo;
	    }
	    return false;
	}
	
	public int topo() {
		
		if (vazia()) {
		       throw new IllegalStateException("A pilha está vazia. Não há topo.");
		} else {
		       return topo.dado;
			}
	}
	
	public int tamanho() {
		
	    return tamanho;
	    
	}
	
	public void esvaziar() {
		
	    while (!vazia()) {
	        remover();
	    }
	}
	
	
	
}
