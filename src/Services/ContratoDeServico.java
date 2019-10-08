
package Services;

import Entities.Contrato;
import Entities.Prestacao;
import java.util.Calendar;
import java.util.Date;


public class ContratoDeServico {
    
    private ServicoDePagamntoOnline servicoDePagamentoOnline;

    public ContratoDeServico(ServicoDePagamntoOnline servicoDePagamentoOnline) {
        this.servicoDePagamentoOnline = servicoDePagamentoOnline;
    }
    
    public void processamentoDeContrato(Contrato contrato, int meses){
        double valorDasParcelasSemJuros = contrato.getValorTotal() / meses;
        for(int i=1; i<=meses; i++){
            Date data = addMeses(contrato.getData(),i);
            double atualizarParcela = valorDasParcelasSemJuros + servicoDePagamentoOnline.parcelas(valorDasParcelasSemJuros, i);
            double parcelaFinal = atualizarParcela + servicoDePagamentoOnline.taxaDePagamento(atualizarParcela);
            contrato.addPrestacao(new Prestacao(data, parcelaFinal));
        }
    }
    
    private Date addMeses(Date data, int n){
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }
    
}
