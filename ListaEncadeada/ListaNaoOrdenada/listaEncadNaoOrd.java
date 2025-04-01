package ListaNaoOrdenada;

import Base.listaEncad;
import Base.no;

public class listaEncadNaoOrd<T> extends listaEncad<T> {

    public listaEncadNaoOrd () {
        super();
    }

    public void adicionar(T elem) {
        no<T> newNo = new no<T>(elem);

        if (this.getPrim() == null) {           //Lista vazia
            this.prim = newNo;
            this.ult = newNo;
        }
        else {                                  //Inserir no fim
            this.getUlt().setProx(newNo);
            this.ult = newNo;
        }
        tam ++;
    }

    public T pesquisar(T elem) {
        no<T> aux = this.getPrim();

        while (aux != null) {

            if (aux.getValor().equals(elem)) return aux.getValor();  //Elemento encontrado

            aux = aux.getProx();
        }

        return null;                           //Elemento nao encontrado
    }

}
