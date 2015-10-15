package com.calendarApp;

import com.calendarApp.calendar.Month;
import com.calendarApp.printer.ASCIICalendarPrinter;
import com.calendarApp.printer.AbstractCalendarPrinter;
import com.calendarApp.printer.HTMLCalendarPrinter;
import sun.util.calendar.AbstractCalendar;

import java.io.*;
import java.lang.Throwable;
import java.text.DateFormatSymbols;
import java.util.Locale;
/**
 * Created by ivan on 14.10.15.
 */
public class Main {

    public static void main(String[] args) {
        PrintStream printStreamInFile = null;
        try {
            printStreamInFile = new FileWriter().createPrintStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Month month = new Month(2015, 10);
        AbstractCalendarPrinter printer = null;
//        printer = new HTMLCalendarPrinter(month);
//        printer = new ASCIICalendarPrinter(printStreamInFile, month);
        printer = new HTMLCalendarPrinter(printStreamInFile, month);


        printer.printMonth();

    }

}
