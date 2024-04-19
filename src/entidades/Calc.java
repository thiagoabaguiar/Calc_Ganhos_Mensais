package entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Calc {

	public static void main(String[] args) throws ParseException {

		Scanner scan = new Scanner(System.in);

//		System.out.println("Digite o Depto: ");
//		String workerDept = scan.nextLine();
//
//		System.out.println("Digite o nome do Empregado: ");
//		String workerName = scan.nextLine();
//
//		System.out.println("Digite o cargo do Empregado [JUNIOR, PLENO, SENIOR]: ");
//		String workerLevel = scan.next().toUpperCase();
//
//		System.out.println("Digite o salário base do Empregado: ");
//		Double workerBaseSalary = scan.nextDouble();
//
//		System.out.println("Digite quantos contratos o Empregado terá: ");
//		Integer workerQtyHourContracts = scan.nextInt();
//
//		Worker worker = new Worker(workerName, workerLevel, workerBaseSalary, workerQtyHourContracts, workerDept);
//
//		for (int i = 1; i <= workerQtyHourContracts; i++) {			
//			
//			System.out.println("*** Digite os dados do Contrato #" + i + " ***");
//			
//			System.out.println("Digite a data de término do Contrato [DD/MM/AAAA]: ");
//			String endDate = scan.next();
//			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//			Date endHourContract = formatter.parse(endDate);
//					
//			System.out.println("Digite o valor por hora trabalhada: ");
//			Double valuePerHour = scan.nextDouble();
//			
//			System.out.println("Digite a quantidade total de horas do Contrato: ");
//			Integer qtyHours = scan.nextInt();
//			
//			HourContract newHourContract = new HourContract(i, endHourContract, qtyHours, valuePerHour);
//			
//			worker.addContract(newHourContract);			
//			
//		}

		// receber uma data em formato mm/aaaa, parsear em mm e aaaa, converter para int
		// e passar para a função calcular

//		System.out.println("Digite a data para cálculo de salário [MM/AAAA]: ");
//		String date = scan.next();
//		
//		DateTimeFormatter formatter_MMyyyy = DateTimeFormatter.ofPattern("MM/yyyy");
//		YearMonth yearMonthFormatted = YearMonth.parse(date, formatter_MMyyyy); // para transformar a String recebida no formato MM/yyyy em um Objeto YearMonth padrão ISO 8601. Obs: não é possível usar aqui um Objeto LocalDate, pois efetivamente uma data com apenas mês/ano não é uma data, pois não há dia definido; logo, o Objeto não pode ser desse tipo.
//		System.out.println(yearMonthFormatted);
//		System.out.println(yearMonthFormatted.getMonthValue());
//		System.out.println(yearMonthFormatted.getYear());

		// agora que já consegui pegar o mês/ano, fazer o cálculo dos ganhos
		
		// OBS: o exercício originalmente não tinha o conceito de contrato com data-início, apenas data-fim;
		// nem previa cálculo pró-rata para início depois do começo do mês, nem pró-rata para fim antes do término do mês
		// TO DO: implementar no contrato o atributo de início (dd/mm/aaaa), método para cálculo das pró-ratas, e
		// método para cálculo do valor total e valor mensal do contrato
		// também implementar método para pegar a data atual (system) no momento da criação do contrato e
		// passar essa data como startDate nos argumentos
		
		
		
		
		
		
//		// instanciando os contratos
//		HourContract contrato1 = new HourContract(1, 10, 10d);
//		HourContract contrato2 = new HourContract(2, 20, 20d);
//		HourContract contrato3 = new HourContract(3, 30, 30d);
//		HourContract contrato4 = new HourContract(4, 40, 40d);
//
//		// adicionando contratos no worker worker1.addContract(contrato1);
//		worker1.addContract(contrato2); worker1.addContract(contrato3);
//		worker1.addContract(contrato4); System.out.println(worker1);
//		  
//		// removendo um contrato do worker worker1.removeContract(2);
//		System.out.println(worker1);
		
		LocalDate dataInicioContrato = LocalDate.parse("2020-12-01");
		LocalDate dataTerminoContrato = LocalDate.parse("2026-12-30");
		Contrato contrato = new Contrato(1,dataInicioContrato,dataTerminoContrato,100,200d);
		//contrato.calculaValorTotalDoContrato(dataInicioContrato,dataTerminoContrato);
	
		System.out.println("contrato: " + contrato);
		System.out.println("============================");
		Integer totalDeMesesContrato = contrato.calculaTotalDeMesesContrato();
		System.out.println("Total de Meses do Contrato: " + totalDeMesesContrato);
		
		Integer totalDeMesesCheiosContrato = contrato.calculaTotalDeMesesCheiosContrato();
		System.out.println("Total de Meses Cheios do Contrato: " + totalDeMesesCheiosContrato);
		
		Double valorDeMesesCheiosContrato = contrato.calculaValorDeMesesCheiosContrato();
		System.out.println("Valor de Meses Cheios do Contrato: " + valorDeMesesCheiosContrato);
		
		Double valorDeMesesContrato = contrato.calculaValorDeMesesContrato();
		System.out.println("Valor de Meses do Contrato: " + valorDeMesesContrato);
		
		//System.out.println("mês de início: " + contrato.calculaValorPrimeiroMes());		
		//System.out.println("meses total: " + contrato.calculaQtdMesesDoMeioQdoContratoNaoIniciaETerminaNoMesmoAno());
		//System.out.println("mês de término: " + contrato.calculaValorUltimoMes());
		//System.out.println("TOTAL: " + contrato.somaTudo());	
		
		// PARA 18/04: tem um bug no calculaValorMesesDoMeio quando o ano de término
		// é maior do que o ano de início

		scan.close();

	}

}
