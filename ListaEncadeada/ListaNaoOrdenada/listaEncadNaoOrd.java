package ListaNaoOrdenada;

import Base.listaEncad;
import Base.no;

public class listaEncadNaoOrd<T> extends listaEncad<T> {

    public listaEncadNaoOrd () {
        super();
    }

    //Adiciona no fim da lista
    public void adicionar(T elem) {
        no<T> newNo = new no<T>(elem);

        if (this.getPrim() == null) {   //Inserir em uma lista vazia
            this.prim = newNo;
            this.ult = newNo;
        }
        else {                          //Inserir no fim
            this.getUlt().setProx(newNo);
            this.ult = newNo;
        }
        tam ++;
    }

    //
    public T pesquisar(T elem) {
        no<T> aux = this.getPrim();

        while (aux != null) {

            //Elemento encontrado
            if (aux.getValor().equals(elem)) return aux.getValor();

            //Avança para o próximo elemento da lista
            aux = aux.getProx();
        }

        //Percorreu a lista toda sem encontrar, ou seja, o elemento não está na lista
        return null;
    }

}
