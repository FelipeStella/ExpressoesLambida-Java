
package Services;


public interface ServicoDePagamntoOnline {
    
    public Double taxaDePagamento(double valor);
    public Double parcelas(double valor, int meses);
   
    
}
