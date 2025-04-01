package ListaOrdenada;

import java.util.Comparator;

import Base.listaEncad;
import Base.no;

public class listaEncadOrd<T> extends listaEncad<T> {

    protected Comparator<T> comparador;

    public listaEncadOrd (Comparator<T> comparator) {
        super();
        this.comparador = comparator;
    }

    public void adicionar(T elem) {

        no<T> newNo = new no<T>(elem);

        no<T> aux = this.getPrim();
        no<T> ant = null;

        if (this.getPrim() == null) {   //Se a lista estiver vazia
            this.prim = newNo;          //NewNo é o primeiro
            this.ult = newNo;           //E o ultimo
        }

        else {
            while (aux != null && comparador.compare(elem, aux.getValor()) < 0) {
                ant = aux;
                aux = aux.getProx();
            }

            if (aux == this.getPrim()) {        //Se é o primeiro da lista
                newNo.setProx(this.getPrim());  //NewNo fica antes do primeiro antigo
                this.prim = newNo;              //E é o novo primeiro
            }
            else if (aux == null) {             //Se é o ultimo da lista
                this.getUlt().setProx(newNo);   //NewNo fica depois do ultimo antigo
                this.ult = newNo;               //E é o novo ultimo
            }
            else {                              //Se for qualquer outro
                ant.setProx(newNo);             //NewNo fica depois de ant
                newNo.setProx(aux);             //E antes de aux
            }
        }

        this.tam ++;
    }

    public T pesquisar(T elem) {
        no<T> aux = this.getPrim();

        while (aux != null && comparador.compare(elem, aux.getValor()) >= 0) {

            if (aux.getValor().equals(elem)) return aux.getValor();  //Elemento encontrado

            aux = aux.getProx();
        }

        return null;                           //Elemento nao encontrado
    }
}
