package Base;

public class no<T> {
    private T valor;
    private no<T> prox;

    public no(T val) {
        this.valor = val;
        this.prox = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public no<T> getProx() {
        return prox;
    }

    public void setProx(no<T> prox) {
        this.prox = prox;
    }

    // Um nó é igual a outro nó se os valores dos nós forem iguais
    public boolean equals(no<T> elem) {
        return this.getValor().equals(elem.getValor());
    }
}
