package com.calendarApp.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ivan on 14.10.15.
 */
public class Month {
    List<Week> weeks = new ArrayList<>();

    private LocalDate currentMonth;
    private LocalDate previousMonth;

    public LocalDate getCurrentMonth() {
        return currentMonth;
    }

    public Month(int year, int month) {
        currentMonth = LocalDate.of(year, month, 1);
        previousMonth = currentMonth;
    }
    public String getMonthName() {
        return currentMonth.getMonth().name();
    }

    private void setFirstDayOfFirstWeekOfMonth() {
        while(!isDayInWeek(DayOfWeek.MONDAY)) {
            previousMonth = previousMonth.minusDays(1);
        }
    }

    public List<Week> getMonth() {
        setFirstDayOfFirstWeekOfMonth();
        while (isCurrentMonth()){
            weeks.add(new Week(previousMonth));
            previousMonth = previousMonth.plusWeeks(1);
        }
        return weeks;
    }

    private boolean isDayInWeek(DayOfWeek dayOfWeek) {
        return previousMonth.getDayOfWeek() == dayOfWeek;
    }

    private boolean isCurrentMonth() {
        return !(currentMonth.plusMonths(1)).isBefore(previousMonth);
    }
}