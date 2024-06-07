package learningjava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

public class Dates {
	public static void dates() throws ParseException {
		Locale.setDefault(Locale.US);
		
		// APRENDENDO DATAS EM JAVA
		LocalDate d01 = LocalDate.now();
		LocalDateTime d02 = LocalDateTime.now();
		Instant d03 = Instant.now();
		
		LocalDate d04 = LocalDate.parse("2022-07-20");
		LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
		Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
		Instant d07 = Instant.parse("2022-07-20T01:30:26-03:00");
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
		DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;
		
		LocalDate d08 = LocalDate.parse("20/07/2022", fmt1);
		LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", fmt2);
		
		LocalDate d10 = LocalDate.of(2022, 7, 20);
		LocalDateTime d11 = LocalDateTime.of(2022, 7, 20, 1, 30);
		
		System.out.println("\nd01 = " + d01);
		System.out.println("d02 = " + d02);
		System.out.println("d03 = " + d03);
		
		System.out.println("\nd04 = " + d04);
		System.out.println("d04 = " + d04.format(fmt1));
		System.out.println("d04 = " + fmt1.format(d04));
		
		System.out.println("\nd05 = " + d05);
		System.out.println("d05 = " + d05.format(fmt1));
		System.out.println("d05 = " + d05.format(fmt2));
		System.out.println("d05 = " + d05.format(fmt4));
		
		System.out.println("\nd06 = " + d06);
		System.out.println("d06 = " + fmt3.format(d06));
		System.out.println("d06 = " + fmt5.format(d06));
		
		System.out.println("\nd07 = " + d07);
		System.out.println("d08 = " + d08);
		System.out.println("d09 = " + d09);
		System.out.println("d10 = " + d10);
		System.out.println("d11 = " + d11);
		
		//Convertendo data-hora global para local
		LocalDate d12 = LocalDate.parse("2022-07-20");
		LocalDateTime d13 = LocalDateTime.parse("2022-07-20T01:30:26");
		Instant d14 = Instant.parse("2022-07-20T01:30:26Z");
		
		LocalDate r1 = LocalDate.ofInstant(d14, ZoneId.systemDefault());
		LocalDate r2 = LocalDate.ofInstant(d14, ZoneId.of("Portugal"));
		LocalDateTime r3 = LocalDateTime.ofInstant(d14, ZoneId.systemDefault());
		LocalDateTime r4 = LocalDateTime.ofInstant(d14, ZoneId.of("Portugal"));
		
		System.out.println("r1 = " + r1);
		System.out.println("r2 = " + r2);
		
		System.out.println("d12 dia = " + d12.getDayOfMonth());
		System.out.println("d12 mês = " + d12.getMonthValue());
		System.out.println("d12 ano = " + d12.getYear());
		
		System.out.println("d05 hora = " + d05.getHour());
		System.out.println("d05 minutos = " + d05.getMinute());
		
		
		//Cálculos com data-hora
		LocalDate pastWeekTod12LocalDate = d12.minusDays(7);
		LocalDate nextYearTod12LocalDate = d12.plusYears(1);
		
		Instant pastWeekInstantTod14 = d14.minus(7, ChronoUnit.DAYS);
		Instant nextWeekInstantTod14 = d14.plus(7, ChronoUnit.DAYS);
		
		Duration t1 = Duration.between(pastWeekTod12LocalDate.atTime(0,0), d12.atStartOfDay());
		System.out.println("t1 dias = " + t1.toDays());
		
		
		//Trabalhando com Date
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Date y1 = sdf1.parse("25/06/2018");
		Date y2 = sdf2.parse("25/06/2018 15:42:07");
		Date y3 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		
		System.out.println(sdf2.format(y1));
		System.out.println(sdf2.format(y2));
		
		Date x1 = new Date();
		Date x2 = new Date(System.currentTimeMillis());
		Date x3 = new Date(0L);
		Date x4 = new Date(1000L * 60L * 60L * 5L);
		
	}

}
