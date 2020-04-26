package utfpr.banco;

public class TestaConta {
    
    public static void main(String[] args) {
        ContaCorrente cc=new ContaCorrente();
        ContaPoupanca cp= new ContaPoupanca();
        GerenciadorContas gc= new GerenciadorContas(cp);
        gc.setValor(10);
        System.out.println("Valor:"+gc.getValor());
                
    }
    
}
