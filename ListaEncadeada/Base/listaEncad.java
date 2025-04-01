package Base;

public abstract class listaEncad<T> {

    protected no<T> prim, ult;
    protected int tam;

    public listaEncad () {
        this.prim = null;
        this.ult = null;
        this.tam = 0;
    }

    public no<T> getPrim() {
        return prim;
    }

    public no<T> getUlt() {
        return ult;
    }

    public int getTam() {
        return tam;
    }

    public String toString() {
            String str = "[";
            no<T> aux = this.prim;

            while (aux != null) {
                str += aux.getValor() + ", ";
                aux = aux.getProx();
            }
            return str + "]";
    }
    
    // public boolean exclude(T elem) {
    //     no<T> aux = this.getPrim();
    //     no<T> ant = null;

    //     while (aux != null) {
            
    //         if (aux.getValor().equals(elem)) {             //Encontrou o elemento
    //             if (aux == this.getPrim()) {    //Se é o primeiro
    //                 this.prim = aux;
                    
    //                 if (aux == this.getUlt()) { //E o ultimo
    //                     this.ult = aux;
    //                 }
    //             }

    //             else {                          //Caso seja qualquer outro
    //                 ant.setProx(aux.getProx());

    //                 if (aux == this.getUlt()) this.ult = ant; //E o ultimo
    //             }

    //             tam --;                         //Atualizar o tamanho                   
    //             return true;                    //Foi possivel excluir
    //         }

    //         ant = aux;                          //Avançar para o anterior do proximo
    //         aux = aux.getProx();                //Avançar para o proximo no na lista
    //     }

    //     return false;                           //Nao foi possivel excluir
    // }

    
}
