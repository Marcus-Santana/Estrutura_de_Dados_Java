package PilhaFila;

public class NoFila {
	int dado;
	NoFila proximo;
	NoFila anterior;
	
	public NoFila(int dado) {
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public NoFila getProximo() {
		return proximo;
	}

	public void setProximo(NoFila proximo) {
		this.proximo = proximo;
	}

	public NoFila getAnterior() {
		return anterior;
	}

	public void setAnterior(NoFila anterior) {
		this.anterior = anterior;
	}
	
	
}
