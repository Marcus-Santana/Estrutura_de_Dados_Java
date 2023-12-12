package PilhaFila;

public class NoPilha {
	
	int dado;
	NoPilha proximo;
	
	public NoPilha(int dado) {
	       this.dado = dado;
	       this.proximo = null;
	   }

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public NoPilha getProximo() {
		return proximo;
	}

	public void setProximo(NoPilha proximo) {
		this.proximo = proximo;
	}	
	
	
	
}