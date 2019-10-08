
package Services;


public class ServicoDePagamento implements ServicoDePagamntoOnline{
    
    private static final double TAXA_PERCENTAGEM = 0.02;
    private static final double JUROS_AO_MES = 0.01;
    
    @Override
    public Double taxaDePagamento(double valor){
        return valor * TAXA_PERCENTAGEM;     
    }
    
    @Override
    public Double parcelas(double valor, int meses){
        return valor * JUROS_AO_MES * meses;  
    
    }
    
}
