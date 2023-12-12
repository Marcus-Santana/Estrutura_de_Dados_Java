package PilhaFila;

import javax.swing.JTextArea;

public class Fila {
	
	private NoFila inicio;
    private NoFila fim;
    private int tamanho;

    
	public Fila() {
    	
        inicio = null;
        fim = null;
        tamanho = 0;
        
    }

    public boolean vazia() {
    	
        return tamanho == 0;
        
    }

    public void inserir(int info) {
    	
        NoFila novo = new NoFila(info);
        if (vazia()) {
            inicio = novo;
        } else {
            fim.proximo = novo;
        }
        fim = novo;
        tamanho++;
        
    }

    public int remover() {
    	
        if (vazia()) {
            throw new IllegalStateException("A fila está vazia. Não é possível remover.");
        } else {
            int dadoRemovido = inicio.dado;
            inicio = inicio.proximo;
            tamanho--;
            if (inicio == null) {
                fim = null;
            }
            return dadoRemovido;
        }
    }

    public void mostrarElementos(JTextArea textArea) {
    	
        if (vazia()) {
        	textArea.append("A fila está vazia.\n");
        } else {
            NoFila aux = inicio;
            textArea.append("Elementos da fila:\n");
            while (aux != null) {
            	textArea.append(String.valueOf(aux.dado) + "\n");
                aux = aux.proximo;
            }
        }
    }
    
	 public int inicio() {
	    if (vazia()) {
	    	throw new IllegalStateException("A fila está vazia.");
	    } else {
	    	return inicio.dado;
	    }
	 }
 
	 public int fim() {
		if (vazia()) {
			throw new IllegalStateException("A fila está vazia.");
		}else {
		    return fim.dado;
		}
	 }

    public boolean buscarElemento(int elemento) {
    	
        NoFila aux = inicio;
        while (aux != null) {
            if (aux.dado == elemento) {
                return true;
            }
            aux = aux.proximo;
        }
        return false;
        
    }
    

    public int tamanho() {
    	
        return tamanho;
        
    }

    public void esvaziar() {
    	
        inicio = null;
        fim = null;
        tamanho = 0;
        
    }
}

