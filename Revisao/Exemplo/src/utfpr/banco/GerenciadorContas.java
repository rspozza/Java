package utfpr.banco;

public class GerenciadorContas {
 
    private Conta conta;
    
    public GerenciadorContas(){}
    
    public GerenciadorContas(Conta conta){
        this.conta = conta;
    }
    
    public int getValor(){
        return this.conta.getValor();
    }
    
    public void setValor(int valor){
        this.conta.setValor(valor);
    }
    
}
