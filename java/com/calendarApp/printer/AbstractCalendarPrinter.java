package com.calendarApp.printer;

import com.calendarApp.calendar.Day;
import com.calendarApp.calendar.Month;
import com.calendarApp.calendar.Week;

import java.io.PrintStream;

/**
 * Created by ivan on 14.10.15.
 */
public abstract class AbstractCalendarPrinter {

    protected abstract String wrapper(String line);

    protected abstract String beforeRow();

    protected abstract String afterRow();

    protected abstract String printHeader();

    protected abstract String afterDocument();

    protected Month month;

    enum DayName
    {
        MON, TUE, WED, THU, FRI, SAT, SUN
    }

    protected PrintStream printStream = System.out;

    AbstractCalendarPrinter(Month month) {
        this.month = month;
    }

    AbstractCalendarPrinter(PrintStream printStream, Month month) {
        this(month);
        this.printStream = printStream;
    }

    public String getMonthName(Month month) {
        return month.getMonthName();
    }

    public void printCalendarHeader() {
        printStream.print(beforeRow());
        for(DayName day : DayName.values()){
            printStream.print(wrapper(day.toString()));
        }
        printStream.println(afterRow());
    }

    public void printMonth() {
        printStream.println(printHeader());
        printStream.println(getMonthName(month));
        printCalendarHeader();
        for(Week week : month.getMonth()) {
            printStream.print(beforeRow());
            printWeek(week, month);
            printStream.print(afterRow());
        }
        printStream.print(afterDocument());
    }

    protected void printWeek(Week week, Month month) {
        for(Day day : week.getWeek()) {
            setColor(day, month);
            printStream.print(wrapper(day.toString()));
        }
        printStream.println();
    }

    protected abstract void setColor(Day day, Month month);
}
