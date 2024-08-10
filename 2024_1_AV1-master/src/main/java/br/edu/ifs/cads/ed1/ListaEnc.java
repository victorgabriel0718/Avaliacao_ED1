package br.edu.ifs.cads.ed1;

public class ListaEnc<T extends Comparable<T>> extends Lista<T> implements IProva<T> {
    private No<T> cabeca;
    private int tamanho;
    public ListaEnc(){
    this.cabeca = null;
    this.tamanho = 0;
    }

    @Override
    public void incluir(T elemento) throws Exception {
        No<T> novoNo = new No<>(elemento);
        if (cabeca == null){
            cabeca=novoNo;
        }
        else {
            No<T>  atual = cabeca;
            while (atual.getProximo() != null){
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
            tamanho++;

        throw new Exception("Não implementado");
    }


    public T get(int posicao)  throws Exception {
        if (posicao< 0 || posicao >= tamanho){
            throw new Exception("posição ivalida");
        }
        No<T> atual = cabeca;
        for(int i = 0 ; i< posicao; i++){
            atual = atual.getProximo();
        }
        return atual.getDado();
        //throw new Exception("Posição solicitada não existe na lista");
    }


    public int getPosElemento(T elemento)  throws Exception {
        No<T> atual = cabeca;
        int posicao = 0;
        while (atual!=null){
            if(atual.getDado() == elemento){
                return posicao;
            }
            atual = atual.getProximo();
            posicao++;
        }
        throw new Exception("elemento não localizado");
    }

    @Override
    public void incluirInicio(T elemento) throws Exception {
        No<T> novoNo = new No<>(elemento);
        novoNo.setProximo(cabeca);
        cabeca = novoNo;
        tamanho++;
        throw new Exception("Não implementado");
    }

    @Override
    public void incluir(T elemento, int posicao) throws Exception {
        if(posicao == 0 || posicao > tamanho){
            throw new Exception("posição ivalida");
        }
        if(posicao == 0){
            incluirInicio(elemento);
        }
        else {
            No<T> novoNo = new No<>(elemento);
            No<T> atual = cabeca;
            for (int i = 0; i < posicao - 1;i++){
                atual = atual.getProximo();
            }
            novoNo.setProximo(atual.getProximo());
            atual.setProximo(novoNo);
            tamanho++;
        }
        throw new Exception("Não implementado");
    }

    @Override
    public void remover(int posicao) throws Exception {
        if(posicao < 0 || posicao >= tamanho){
            throw new Exception("posição ivalida");
        }
        if (posicao== 0){
            cabeca = cabeca.getProximo();
        }
        else{
            No<T> atual = cabeca;
            for (int i = 0;i< posicao -1;i++ ){
                atual = atual.getProximo();
            }
            atual.setProximo(atual.getProximo().getProximo());
        }
        tamanho--;

        throw new Exception("Não implementado");
    }

    @Override
    public int getTamanho() {
        return Integer.MIN_VALUE;
    }

    public void limpar() {
        cabeca = null;
        tamanho = 0;
    }



    @Override
    public boolean contem(T elemento) throws Exception {
        No<T> atual = cabeca;
        while (atual != null) {
            if (atual.getDado().equals(elemento)) {
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    @Override
    public void importarListas(Lista<T> l1, Lista<T> l2) throws Exception {

    }

    @Override
    public void importarListas(Lista<T> l1, Lista<T> l2, boolean manterOrdenacao) throws Exception {

    }

    @Override
    public boolean estahOrdenada() throws Exception {
        if (tamanho<= 1){
        return true;
        }
        No<T> atual = cabeca;
        while (atual.getProximo() != null){
            if (atual.getDado().compareTo(atual.getProximo().getDado())>0);{
                return true;
            }
        }
        return true;
    }

    @Override
    public boolean estahOrdenada(Lista<T> lista) throws Exception {
        if (lista.getTamanho() <= 1) {
            return true;
        }
        for (int i = 0; i < lista.getTamanho() - 1; i++){
            if (lista.get(i).compareTo(lista.get(i+1)) > 0){
                return false;
            }
        }
        return true;
    }
}