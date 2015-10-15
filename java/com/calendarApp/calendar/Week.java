package com.calendarApp.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ivan on 14.10.15.
 */
public class Week {
    private List<Day> days = new ArrayList<>();

    public Week(LocalDate month) {
        createWeek(month);
    }
    public List<Day> getWeek() {
        return days;
    }

    private List<Day> createWeek(LocalDate month) {
        LocalDate date = month;
        do {
            days.add(new Day(date.getDayOfMonth(), date.getDayOfWeek(), date));
            date = date.plusDays(1);

        } while(date.getDayOfWeek() != DayOfWeek.MONDAY);

        return  days;
    }

}
