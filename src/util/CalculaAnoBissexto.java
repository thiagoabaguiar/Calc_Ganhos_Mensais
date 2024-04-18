package util;

import java.util.Scanner;

public class CalculaAnoBissexto {

	private Integer anoInicio = 1900;
	private Integer anoFim = 2900;

	public boolean calculaSeAnoEhBissexto(Integer anoParaSerVerificado) {

		int restoPor4, restoPor400, restoPor100;
		int qtdAnosBissextos = 0, qtdAnosNaoBissextos = 0;

		for (int ano = anoInicio; ano <= anoFim; ano++) {

			restoPor4 = ano % 4;
			restoPor400 = ano % 400;
			restoPor100 = ano % 100;

			if (restoPor4 != 0) {

				qtdAnosNaoBissextos++;

			} else if (restoPor400 == 0) {

				qtdAnosBissextos++;

			} else if (restoPor100 != 0) {

				qtdAnosBissextos++;

			} else {

				qtdAnosNaoBissextos++;

			}

		}

		int[] listaAnosBissextos = new int[qtdAnosBissextos];
		int[] listaAnosNaoBissextos = new int[qtdAnosNaoBissextos];
		int posicaoListaAnosBissextos = 0, posicaoListaAnosNaoBissextos = 0;

		for (int ano = anoInicio; ano <= anoFim; ano++) {

			restoPor4 = ano % 4;
			restoPor400 = ano % 400;
			restoPor100 = ano % 100;

			if (restoPor4 != 0) {

				listaAnosNaoBissextos[posicaoListaAnosNaoBissextos] = ano;
				posicaoListaAnosNaoBissextos++;

			} else if (restoPor400 == 0) {

				listaAnosBissextos[posicaoListaAnosBissextos] = ano;
				posicaoListaAnosBissextos++;

			} else if (restoPor100 != 0) {

				listaAnosBissextos[posicaoListaAnosBissextos] = ano;
				posicaoListaAnosBissextos++;

			} else {

				listaAnosNaoBissextos[posicaoListaAnosNaoBissextos] = ano;
				posicaoListaAnosNaoBissextos++;

			}

		}

		for (int ano : listaAnosBissextos) {

			if (ano == anoParaSerVerificado) {

				return true;

			}

		}

		return false;

	}

}
