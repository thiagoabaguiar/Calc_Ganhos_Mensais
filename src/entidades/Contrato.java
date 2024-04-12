package entidades;

import java.time.LocalDate;
import util.CalculaAnoBissexto;

public class Contrato {

	private Integer idContrato;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	private Integer qtdHorasPorMes;
	private Double valorPorHora;
	private Double valorTotalContrato;

	public Contrato(Integer idContrato, LocalDate dataInicio, LocalDate dataTermino, Integer qtdHorasPorMes,
			Double valorPorHora) {
		this.idContrato = idContrato;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.qtdHorasPorMes = qtdHorasPorMes;
		this.valorPorHora = valorPorHora;
		// TO DO:
		// implementar método dentro do construtor para já calcular o valor total do
		// contrato (totalValue) assim que
		// o contrato for instanciado - ponto de atenção é calcular os pró-ratas para
		// data-início e data-fim, ou seja:
		// 1º obter o valor de um mês trabalhado OK
		// 2º obter o pró-rata de início OK
		// 3º obter o pró-rata de fim OK
		// 4º obter o valor total do contrato (menos 2 meses)
		// somar os 3 valores = total do contrato
	}

	private Double valorDeUmMesCheio(Integer qtdHorasPorMes, Double valorPorHora) {
		return qtdHorasPorMes * valorPorHora;
	}
	
	private Double valorDeUmDiaTrabalhado() {
		return (qtdHorasPorMes * valorPorHora) / 30; // considerado 30 dias como valor-base
	}

	private Double valorDeUmMesProRataInicioContrato(LocalDate dataInicio) {

		Integer diaInicio = dataInicio.getDayOfMonth();
		Integer mesInicio = dataInicio.getMonthValue();
		Integer anoInicio = dataInicio.getYear();
		Integer qtdDiasTrabalhados = 0;
		
		CalculaAnoBissexto cab = new CalculaAnoBissexto();
		Boolean anoEhBissexto = cab.calculaSeAnoEhBissexto(anoInicio);	
		
		switch (mesInicio) {
		
		case 1:
			qtdDiasTrabalhados = 31 - diaInicio + 1;		
			break;
			
		case 2:	
			if(anoEhBissexto)
				qtdDiasTrabalhados = 29 - diaInicio + 1;				
			else
				qtdDiasTrabalhados = 28 - diaInicio + 1;
			break;	
			
		case 3:			
			qtdDiasTrabalhados = 31 - diaInicio + 1;		
			break;	
			
		case 4:			
			qtdDiasTrabalhados = 30 - diaInicio + 1;		
			break;	
			
		case 5:			
			qtdDiasTrabalhados = 31 - diaInicio + 1;		
			break;	
			
		case 6:			
			qtdDiasTrabalhados = 30 - diaInicio + 1;		
			break;	
			
		case 7:			
			qtdDiasTrabalhados = 31 - diaInicio + 1;		
			break;	
			
		case 8:			
			qtdDiasTrabalhados = 31 - diaInicio + 1;		
			break;	
			
		case 9:			
			qtdDiasTrabalhados = 30 - diaInicio + 1;		
			break;	
			
		case 10:			
			qtdDiasTrabalhados = 31 - diaInicio + 1;		
			break;	
			
		case 11:			
			qtdDiasTrabalhados = 30 - diaInicio + 1;		
			break;
			
		case 12:		
			qtdDiasTrabalhados = 31 - diaInicio + 1;		
			break;				
			
		}	
		
		return qtdDiasTrabalhados * valorDeUmDiaTrabalhado();

	}

	private Double valorDeUmMesProRataTerminoContrato(LocalDate dataTermino) {		
		
		return	dataTermino.getDayOfMonth() * valorDeUmDiaTrabalhado();
		
	}
	
	private Integer calculaQtdDeMesesDeContrato(LocalDate dataInicio, LocalDate dataTermino) {
		
		// TO DO
		// calcular a qtd de meses decorridos de contrato para multiplicar pelo valor mensal (qtdHorasPorMes * valorPorHora)
		// e a isso, somar o pró-rata de início e pró-rata de fim
		
		Integer diaInicio = dataInicio.getDayOfMonth();
		Integer mesInicio = dataInicio.getMonthValue();
		Integer anoInicio = dataInicio.getYear();
		
		Integer diaTermino = dataTermino.getDayOfMonth();
		Integer mesTermino = dataTermino.getMonthValue();
		Integer anoTermino = dataTermino.getYear();
		
		Integer qtdAnos = anoTermino - anoInicio;
		
		return null;
	}

	// método de pró-rata INÍCIO
	// qtyHours * 1 = 1 mês de trabalho OK
	// divide esse valor pela qty de dias corridos daquele mês; esse será o valor
	// "por dia" trabalhado OK
	// descobrir o total de dias trabalhados:
	// 30 (total dias mês) - 7 (início contrato) + 1 (para considerar o dia de
	// início como trabalhado) = 24 dias OK
	// multiplicar o total de dias trabalhados pelo valor do dia trabalhado; isso
	// dará a pró-rata de início OK

	// método de pró-rata FIM
	// qtyHours * 1 = 1 mês de trabalho OK
	// divide esse valor pela qty de dias corridos daquele mês; esse será o valor
	// "por dia" trabalhado OK
	// multiplicar esse valor pela data-fim:
	// 35 (valor do dia trabalhado) * 20 (dia fim do contrato) = 700 é o valor
	// daquele mês OK
	
	// somar isso tudo com o totalValue dos demais meses (exceto o mês de início e o mês
	// de término que são rateados, ou seja,
	// só pegar o total de meses do contrato menos 2)



}
