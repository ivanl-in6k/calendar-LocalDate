package com.calendarApp.printer;

import com.calendarApp.calendar.Day;
import com.calendarApp.calendar.Month;

import java.io.PrintStream;

/**
 * Created by ivan on 14.10.15.
 */
public class ASCIICalendarPrinter extends AbstractCalendarPrinter {
    protected static final String DAY_FORMAT = "%14s";

    private String ansiColor = ASCIIHelper.ANSI_BLACK;

    public ASCIICalendarPrinter(Month month){
        super(month);
    }

    public ASCIICalendarPrinter(PrintStream printStream, Month month) {
        super(printStream, month);
    }

    @Override
    protected String wrapper(String line) {
        return String.format(DAY_FORMAT, ansiColor + line + ASCIIHelper.ANSI_RESET);
    }
    protected void setColor(Day day, Month month) {
        ansiColor = day.isWeekend() ? ASCIIHelper.ANSI_RED : ASCIIHelper.ANSI_BLACK;
        ansiColor = day.isToday() ? ASCIIHelper.ANSI_BLUE : ansiColor;
        ansiColor = day.isInMonth(month.getCurrentMonth()) ? ASCIIHelper.ANSI_GREEN : ansiColor;
    }
    @Override
    protected String beforeRow() {
        return "";
    }

    @Override
    protected String afterRow() {
        return "";
    }

    @Override
    protected String printHeader() {
        return ASCIIHelper.ASCII_HEAD;
    }

    @Override
    protected String afterDocument() {
        return ASCIIHelper.C_ASCII_HEAD;
    }

}
