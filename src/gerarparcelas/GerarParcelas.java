/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gerarparcelas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class GerarParcelas {

//Aplicação que solicita o valor do empréstimo, total de parcelas, data da compra e cria um vetor
    //para armazenar os valores.
    
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner (System.in);
        
        //Manipular as datas
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        Date data;
        
        double valorEmprestimo = 0d;
      
        System.out.println("Informe o valor do emprestimo: ");
        valorEmprestimo = scan.nextDouble();
        
        System.out.println("Informe o total de parcelas: ");
        int totalParcelas = scan.nextInt();
        
        double [] valorParcelas = new double[totalParcelas]; //cria o vetor com o tamanho informado em parcelas
        
        scan.nextLine(); //captura a quebra de linha
        
        System.out.println("Informe a data da compra: ");
        String data1 = scan.nextLine();        
        data = sdf.parse(data1);  //converte a string recebida para data       
        cal.setTime(data); //calendar passa a ter o valor da variavel data
        
        //gera as parcelas e adiciona ao vetor
        for(int i = 0; i < valorParcelas.length; i++){
            valorParcelas[i] = valorEmprestimo /totalParcelas;
            
        }
        
        System.out.println("Valor de cada parcela: ");
        
        //imprime as parcelas
        for(int i = 0; i < valorParcelas.length; i++){
            cal.add(Calendar.MONTH,1); //soma 1 mes a data da compra
            System.out.println(String.format((i+1) + " - " + "R$ %.2f", valorParcelas[i])
            + " - Vencimento: " + sdf.format(cal.getTime())); // mostra a data formatada
        }
        
        System.out.println("Fim do programa.");
        scan.close();
    }

}
