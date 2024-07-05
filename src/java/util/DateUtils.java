/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author HI
 */
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtils {
    public static long numDaysBetween(Timestamp timestamp1, Timestamp timestamp2) {
        LocalDate moc1 = timestamp1.toLocalDateTime().toLocalDate();
        LocalDate moc2 = timestamp2.toLocalDateTime().toLocalDate();
        return ChronoUnit.DAYS.between(moc1, moc2);
    }
}

