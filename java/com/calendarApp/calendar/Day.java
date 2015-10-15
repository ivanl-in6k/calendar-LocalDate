package com.calendarApp.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * Created by ivan on 14.10.15.
 */
public class Day {
    private int dayOfMonth;
    private DayOfWeek dayOfWeek;
    private LocalDate previousMonth;

    Day(int dayOfMonth, DayOfWeek dayOfWeek, LocalDate previousMonth) {
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.previousMonth = previousMonth;
    }

    public boolean isWeekend() {
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public boolean isToday() {
        LocalDate localDate = LocalDate.now();
        return previousMonth.getDayOfWeek() == localDate.getDayOfWeek() && previousMonth.getDayOfMonth() == localDate.getDayOfMonth();
    }

    public boolean isInMonth(LocalDate localdate) {
        return !(previousMonth.getMonth() == localdate.getMonth());
    }

    @Override
    public String toString() {
        return String.valueOf(dayOfMonth);
    }
}
