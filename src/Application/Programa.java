
package Application;

import Entities.Contrato;
import Entities.Prestacao;
import Services.ContratoDeServico;
import Services.ServicoDePagamento;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Programa {
    
    public static void main(String[] args) throws ParseException{
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("_____Dados do Contrato_____");
        System.out.println();
        
        
        System.out.print("Número: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Data (dd/MM/aaaa): ");
        String data = sc.nextLine();
        System.out.print("Valor do contrato: R$ ");
        double valor = sc.nextDouble();
        System.out.print("Digite o número de parcelas: ");
        int nParcelas = sc.nextInt();
        
        try{
            Date dataDoContrato = sdf.parse(data);

            Contrato contrato = new Contrato(numero, dataDoContrato, valor);
            ContratoDeServico contratoDeServico = new ContratoDeServico(new ServicoDePagamento());

            contratoDeServico.processamentoDeContrato(contrato, nParcelas);

            System.out.println("Parcelas: ");
            for(Prestacao parcela : contrato.getParcelas()){
                System.out.println(parcela);
            }
        }
        
        catch(ParseException erro){
            System.out.println("A data digitada está no formato errado");
        }
        
       sc.close();
    }
    
}
