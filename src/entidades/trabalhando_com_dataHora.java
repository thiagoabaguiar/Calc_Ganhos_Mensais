package entidades;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class trabalhando_com_dataHora {

	public static void main(String[] args) {
		
		LocalDate dataAtual = LocalDate.now();
		System.out.println(dataAtual);

		LocalDateTime dataHoraAtual = LocalDateTime.now();
		System.out.println(dataHoraAtual);

		Instant instanteAtual = Instant.now();
		System.out.println(instanteAtual);

		LocalDate dataAtualTexto = LocalDate.parse("2024-04-10"); // formatos são padronizados ISO 8601
		System.out.println(dataAtualTexto);

		LocalDateTime dataHoraAtualTexto = LocalDateTime.parse("2024-04-10T20:31:22"); // formatos são padronizados ISO 8601
		System.out.println(dataHoraAtualTexto);

		Instant instanteAtualTexto = Instant.parse("2024-04-10T20:35:57Z");
		System.out.println(instanteAtualTexto);

		Instant instanteAtualTextoComFuso = Instant.parse("2024-04-10T20:35:57-01:00");
		System.out.println(instanteAtualTextoComFuso);

		// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html#patterns
		DateTimeFormatter formatter_ddMMyyyy = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataAtualFormatada = LocalDate.parse("10/04/2024", formatter_ddMMyyyy); // para transformar a String recebida no formato dd/MM/yyyy em um Objeto LocalDate padrão ISO 8601
		System.out.println(dataAtualFormatada);
		
		// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html#patterns
		DateTimeFormatter formatter_ddMMyyyy_HHmm = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime dataHoraAtualFormatada = LocalDateTime.parse("10/04/2024 20:50", formatter_ddMMyyyy_HHmm); // para transformar a String recebida no formato dd/MM/yyyy HH:mm em um Objeto LocalDateTime padrão ISO 8601
		System.out.println(dataHoraAtualFormatada);
		
		LocalDate dataAtualSeparada = LocalDate.of(2024, 4, 10); // uma opção quando o front mandar tudo separado (ano, mês, dia);
		System.out.println(dataAtualSeparada);
		
		LocalDateTime dataHoraAtualSeparada = LocalDateTime.of(2024,4,10,20,56); // uma opção quando o front mandar tudo separado (ano, mês, dia, hora, minuto);
		System.out.println(dataHoraAtualSeparada);
				
		LocalDate dataAtualFormatoISO = LocalDate.parse("2022-04-10");
		System.out.println(dataAtualFormatoISO.format(formatter_ddMMyyyy)); // exibe o Objeto ISO 8601 na formatação escolhida
		//OU
		System.out.println(formatter_ddMMyyyy.format(dataAtualFormatoISO)); // chama o método format do DateTimeFormatter passando o Objeto de data parseado
		
		LocalDateTime dataHoraAtualFormatoISO = LocalDateTime.parse("2023-04-10T21:42:37");
		System.out.println(dataHoraAtualFormatoISO.format(formatter_ddMMyyyy_HHmm)); // exibe o Objeto ISO 8601 na formatação escolhida
		// OU
		System.out.println(formatter_ddMMyyyy_HHmm.format(dataHoraAtualFormatoISO)); // chama o método format do DateTimeFormatter passando o Objeto de data/hora parseado

		Instant instanteAtualFormatoISO = Instant.parse("2027-11-28T07:35:17-03:00");
		DateTimeFormatter formatter_ddMMyyyy_HHmm_TimeZone = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		System.out.println(formatter_ddMMyyyy_HHmm_TimeZone.format(instanteAtualFormatoISO));
		
		// *** outra opção para criar o objeto DateTimeFormatter é, ao invés de usar o método ofPattern, é chamar o enum específico da documentação https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
		// *** exemplo:
		DateTimeFormatter formatter_sem_ofPattern = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

		
	}	
}
