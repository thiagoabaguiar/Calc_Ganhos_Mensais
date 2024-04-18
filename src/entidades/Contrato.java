package entidades;

import java.time.Duration;
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

	public Double calculaValorPrimeiroMes() {

		LocalDate dataInicio = this.dataInicio;
		Integer diaInicio = dataInicio.getDayOfMonth();
		Integer qtdDiasNoMes = verificaQtosDiasTemOMes(dataInicio);
		Integer totalDiasTrabalhados = qtdDiasNoMes - diaInicio + 1;
		Double percentualDiasTrabalhados = (double) totalDiasTrabalhados / (double) qtdDiasNoMes;
		Double valorMensal = this.valorPorHora * this.qtdHorasPorMes;
		Double valorPrimeiroMes = valorMensal * percentualDiasTrabalhados;
		return valorPrimeiroMes;

	}

	public Double calculaValorUltimoMes() {

		LocalDate dataTermino = this.dataTermino;
		Integer diaTermino = dataTermino.getDayOfMonth();
		Integer qtdDiasNoMes = verificaQtosDiasTemOMes(dataTermino);
		Double percentualDiasTrabalhados = (double) diaTermino / (double) qtdDiasNoMes;
		Double valorMensal = this.valorPorHora * this.qtdHorasPorMes;
		Double valorUltimoMes = valorMensal * percentualDiasTrabalhados;
		return valorUltimoMes;

	}

	public Double calculaValorMesesDoMeio() {

		Integer mesInicio = this.dataInicio.getMonthValue();
		Integer mesTermino = this.dataTermino.getMonthValue();
		Integer anoInicio = this.dataInicio.getYear();
		Integer anoTermino = this.dataTermino.getYear();
		Integer mesSeguinteAoInicio, mesAnteriorAoTermino;
		Double valorMensal = this.valorPorHora * this.qtdHorasPorMes;
		Double valorMesesDoMeio;

		if (mesInicio == 12) {
			mesSeguinteAoInicio = 1;
		} else {
			mesSeguinteAoInicio = mesInicio + 1;
		}

		if (mesTermino == 1) {
			mesAnteriorAoTermino = 12;
		} else {
			mesAnteriorAoTermino = mesTermino - 1;
		}

		Integer qtdMesesDoMeio = (mesAnteriorAoTermino - mesSeguinteAoInicio) + 1;

		if (anoTermino == anoInicio) {
			valorMesesDoMeio = valorMensal * qtdMesesDoMeio;
		} else {
			Integer diferencaDeAnos = anoTermino - anoInicio;
			Integer diferencaDeMeses = diferencaDeAnos * 12;
			qtdMesesDoMeio = diferencaDeMeses + qtdMesesDoMeio;
			valorMesesDoMeio = valorMensal * qtdMesesDoMeio;
		}

		return valorMesesDoMeio;
	}

	public Double somaTudo() {

		Double valorPrimeiroMes = calculaValorPrimeiroMes();
		Double valorUltimoMes = calculaValorUltimoMes();
		Double valorMesesDoMeio = calculaValorMesesDoMeio();

		return valorPrimeiroMes + valorUltimoMes + valorMesesDoMeio;

	}

	private Integer verificaQtosDiasTemOMes(LocalDate dataInicio) {

		Integer mesInicio = dataInicio.getMonthValue();
		Integer anoInicio = dataInicio.getYear();

		CalculaAnoBissexto cab = new CalculaAnoBissexto();
		Boolean anoEhBissexto = cab.calculaSeAnoEhBissexto(anoInicio);

		Integer qtdDiasNoMes = 0;

		switch (mesInicio) {

		case 1:
			qtdDiasNoMes = 31;
			break;

		case 2:
			if (anoEhBissexto)
				qtdDiasNoMes = 29;
			else
				qtdDiasNoMes = 28;
			break;

		case 3:
			qtdDiasNoMes = 31;
			break;

		case 4:
			qtdDiasNoMes = 30;
			break;

		case 5:
			qtdDiasNoMes = 31;
			break;

		case 6:
			qtdDiasNoMes = 30;
			break;

		case 7:
			qtdDiasNoMes = 31;
			break;

		case 8:
			qtdDiasNoMes = 31;
			break;

		case 9:
			qtdDiasNoMes = 30;
			break;

		case 10:
			qtdDiasNoMes = 31;
			break;

		case 11:
			qtdDiasNoMes = 30;
			break;

		case 12:
			qtdDiasNoMes = 31;
			break;

		}

		return qtdDiasNoMes;

	}

	public Double calculaValorTotalDoContrato(LocalDate dataInicio, LocalDate dataTermino) {

		Duration duracao = Duration.between(dataInicio.atStartOfDay(), dataTermino.atStartOfDay().plusDays(1));
		Long duracaoEmDias = duracao.toDays();
		System.out.println(duracaoEmDias);

		Integer diaInicio = dataInicio.getDayOfMonth();
		Integer mesInicio = dataInicio.getMonthValue();
		Integer anoInicio = dataInicio.getYear();

		CalculaAnoBissexto cab = new CalculaAnoBissexto();
		Boolean anoEhBissexto = cab.calculaSeAnoEhBissexto(anoInicio);

		Integer qtdDiasNoMes = 0;

		switch (mesInicio) {

		case 1:
			qtdDiasNoMes = 31;
			break;

		case 2:
			if (anoEhBissexto)
				qtdDiasNoMes = 29;
			else
				qtdDiasNoMes = 28;
			break;

		case 3:
			qtdDiasNoMes = 31;
			break;

		case 4:
			qtdDiasNoMes = 30;
			break;

		case 5:
			qtdDiasNoMes = 31;
			break;

		case 6:
			qtdDiasNoMes = 30;
			break;

		case 7:
			qtdDiasNoMes = 31;
			break;

		case 8:
			qtdDiasNoMes = 31;
			break;

		case 9:
			qtdDiasNoMes = 30;
			break;

		case 10:
			qtdDiasNoMes = 31;
			break;

		case 11:
			qtdDiasNoMes = 30;
			break;

		case 12:
			qtdDiasNoMes = 31;
			break;

		}

		Integer diasDecorridosNoMesDeInicio = qtdDiasNoMes - diaInicio + 1;
		Double valorAReceberProRataNoMesDeInicio = diasDecorridosNoMesDeInicio * valorDeUmDiaTrabalhado();

		System.out.println("Dias trabalhados no mês de início: " + diasDecorridosNoMesDeInicio);
		System.out.println("Valor a receber no mês de início: " + valorAReceberProRataNoMesDeInicio);

		// posso pegar essa quantidade de dias acima, subtrair dela os dias decorridos
		// no mês de início, e os dias restantes no mês de término
		// isso me dará a qtd de dias efetivamente trabalhados OK
		// divido por 30 e arredondo para chegar na qtd de meses
		// multiplico essa qtd pelo valor mensal
		// por fim, pego o valor mensal e faço a pró-rata mês início e mês término, e
		// somo com o total acima

		return null;

	}

	private Double valorDeUmMesCheio(Integer qtdHorasPorMes, Double valorPorHora) {
		return qtdHorasPorMes * valorPorHora;
	}

	private Double valorDeUmDiaTrabalhado() {
		Integer qtdPadraoParaDiasTrabalhadosNoMes = 30;
		return (qtdHorasPorMes * valorPorHora) / qtdPadraoParaDiasTrabalhadosNoMes;
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
			if (anoEhBissexto)
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
		return dataTermino.getDayOfMonth() * valorDeUmDiaTrabalhado();
	}

	public void calculaQtdDeMesesDeContrato() {

		// TO DO
		// calcular a qtd de meses decorridos de contrato para multiplicar pelo valor
		// mensal (qtdHorasPorMes * valorPorHora)
		// e a isso, somar o pró-rata de início e pró-rata de fim

		Duration duracaoContrato = Duration.between(this.dataInicio.atStartOfDay(), this.dataTermino.atStartOfDay());

		System.out.println(duracaoContrato.toDays());

	}

	// somar isso tudo com o totalValue dos demais meses (exceto o mês de início e o
	// mês
	// de término que são rateados, ou seja,
	// só pegar o total de meses do contrato menos 2)

	@Override
	public String toString() {
		return "Contrato [idContrato=" + idContrato + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino
				+ ", qtdHorasPorMes=" + qtdHorasPorMes + ", valorPorHora=" + valorPorHora + ", valorTotalContrato="
				+ valorTotalContrato + "]";
	}

}
