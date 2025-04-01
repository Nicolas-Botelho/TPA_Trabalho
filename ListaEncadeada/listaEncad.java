import java.util.Comparator;

public class listaEncad<T> {
    private no<T> prim, ult;
    private int tam;
    private boolean ordenada;
    private Comparator<T> comparador;

    // Inserção -   IncludeNotSorted
    // Busca    -   Seek

    public listaEncad (Comparator<T> comparator) {
        this.prim = null;
        this.ult = null;
        this.tam = 0;
        this.ordenada = true;
        this.comparador = comparator;
    }

    public listaEncad () {
        this.prim = null;
        this.ult = null;
        this.tam = 0;
        this.ordenada = false;
        this.comparador = null;
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

    public void include(T elem) {
        if (this.ordenada) includeSorted(elem); //Se for para ordenar, insere ordenado
        else includeNotSorted(elem);            //Se nao for, insere no fim
    }

    private void includeNotSorted(T elem) {
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

    private void includeSorted(T elem) {
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

    public boolean exclude(T elem) {
        no<T> aux = this.getPrim();
        no<T> ant = null;

        while (aux != null) {
            
            if (aux.getValor().equals(elem)) {             //Encontrou o elemento
                if (aux == this.getPrim()) {    //Se é o primeiro
                    this.prim = aux;
                    
                    if (aux == this.getUlt()) { //E o ultimo
                        this.ult = aux;
                    }
                }

                else {                          //Caso seja qualquer outro
                    ant.setProx(aux.getProx());

                    if (aux == this.getUlt()) this.ult = ant; //E o ultimo
                }

                tam --;                         //Atualizar o tamanho                   
                return true;                    //Foi possivel excluir
            }

            ant = aux;                          //Avançar para o anterior do proximo
            aux = aux.getProx();                //Avançar para o proximo no na lista
        }

        return false;                           //Nao foi possivel excluir
    }

    public T seek(T elem) {
        no<T> aux = this.getPrim();

        while (aux != null) {

            if (aux.getValor().equals(elem)) return aux.getValor();  //Elemento encontrado

            aux = aux.getProx();
        }

        return null;                           //Elemento nao encontrado
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
}
