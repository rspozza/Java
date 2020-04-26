package utfpr.banco;

public class ContaCorrente implements Conta{

    private int valor = 0;
    
    @Override
    public int getValor() {
        return this.valor;
    }

    @Override
    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
