package datetime;

import java.time.*;

public class Main {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(1999, Month.JUNE, 10);
        LocalDate date2 = LocalDate.of(2001, Month.JANUARY, 24);
        System.out.println("date1: " + date1);
        System.out.println("date2: " + date2);

        Duration duration = Duration.between((date1.atStartOfDay().toInstant(ZoneOffset.UTC)), (date2.atStartOfDay().toInstant(ZoneOffset.UTC)));
        Double sec = (duration.getSeconds() * Math.pow(10,9)) + duration.getNano();
        System.out.println("diff: " + sec + " ns");

        ZonedDateTime date3 = date1.atStartOfDay(ZoneId.of("Asia/Calcutta"));
        ZonedDateTime date4 = date2.atStartOfDay(date3.getZone());
        System.out.println("\ndate3: " + date3);
        System.out.println("date4: " + date4);

        long zduration = Duration.between(date3, date4).toDays();
        System.out.println("diff: " + zduration + " days");
    }
}
