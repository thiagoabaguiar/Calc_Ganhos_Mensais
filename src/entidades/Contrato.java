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
	}

	public Integer calculaTotalDeMesesContrato() {

		return (((this.dataTermino.getYear() - dataInicio.getYear()) - 1) * 12)
				+ (12 - this.dataInicio.getMonthValue() + 1) + (this.dataTermino.getMonthValue());

	}

	public Double calculaValorDeMesesContrato() {

		return calculaValorDeMesesCheiosContrato() + calculaValorPrimeiroMes() + calculaValorUltimoMes();

	}

	public Integer calculaTotalDeMesesCheiosContrato() {

		return (((this.dataTermino.getYear() - dataInicio.getYear()) - 1) * 12) + (12 - this.dataInicio.getMonthValue())
				+ (this.dataTermino.getMonthValue() - 1);

	}

	public Double calculaValorDeMesesCheiosContrato() {

		return calculaTotalDeMesesCheiosContrato() * (this.valorPorHora * this.qtdHorasPorMes);

	}

	public Double calculaValorPrimeiroMes() {

		Integer diaInicio = dataInicio.getDayOfMonth();
		Integer qtdDiasNoMes = verificaQtosDiasTemOMes(this.dataInicio);
		Integer totalDiasTrabalhados = qtdDiasNoMes - diaInicio + 1;
		Double percentualDiasTrabalhados = (double) totalDiasTrabalhados / (double) qtdDiasNoMes;
		Double valorMensal = this.valorPorHora * this.qtdHorasPorMes;
		Double valorPrimeiroMes = valorMensal * percentualDiasTrabalhados;
		return valorPrimeiroMes;

	}

	public Double calculaValorUltimoMes() {

		Integer diaTermino = dataTermino.getDayOfMonth();
		Integer qtdDiasNoMes = verificaQtosDiasTemOMes(this.dataTermino);
		Double percentualDiasTrabalhados = (double) diaTermino / (double) qtdDiasNoMes;
		Double valorMensal = this.valorPorHora * this.qtdHorasPorMes;
		Double valorUltimoMes = valorMensal * percentualDiasTrabalhados;
		return valorUltimoMes;

	}

	private Integer verificaQtosDiasTemOMes(LocalDate data) {

		Integer mesInicio = data.getMonthValue();
		Integer anoInicio = data.getYear();

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

	@Override
	public String toString() {
		return "Contrato [idContrato=" + idContrato + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino
				+ ", qtdHorasPorMes=" + qtdHorasPorMes + ", valorPorHora=" + valorPorHora + ", valorTotalContrato="
				+ valorTotalContrato + "]";
	}

}
