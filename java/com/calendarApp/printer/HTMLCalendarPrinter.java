package com.calendarApp.printer;

import com.calendarApp.calendar.Day;
import com.calendarApp.calendar.Month;

import java.io.PrintStream;

/**
 * Created by ivan on 14.10.15.
 */
public class HTMLCalendarPrinter extends AbstractCalendarPrinter {

    private String cssColor = "" ;


    public HTMLCalendarPrinter(Month month) {
        super(month);
    }
    public HTMLCalendarPrinter(PrintStream printStream, Month month) {
        super(printStream, month);
    }

    @Override
    protected void setColor(Day day, Month month) {
        cssColor = day.isWeekend() ? HTMLHelper.CSS_RED : "";
        cssColor = day.isToday() ? HTMLHelper.CSS_BLUE : cssColor;
        cssColor = day.isInMonth(month.getCurrentMonth()) ? HTMLHelper.CSS_GREEN : cssColor;
    }

    @Override
    protected String wrapper(String line) {
        return HTMLHelper.createAndSetTDAttributes("class=\"" + cssColor + "\"")  + line + HTMLHelper.C_TD;
    }

    @Override
    protected String beforeRow() {
        return HTMLHelper.TR;
    }

    @Override
    protected String afterRow() {
        return HTMLHelper.C_TR;
    }

    @Override
    protected String printHeader() {
        return new String(HTMLHelper.HTML +
                          HTMLHelper.getHead("Calendar 1.0", getCssFilePath()) +
                          HTMLHelper.BODY +
                          HTMLHelper.TABLE);
    }

    @Override
    protected String afterDocument() {
        return new String(HTMLHelper.C_TABLE +
                          HTMLHelper.C_BODY +
                          HTMLHelper.C_HTML);
    }

    private String getCssFilePath() {
        String path = "main.css";
        String css = "<link rel=\"stylesheet\" type=\"text/css\" href=" + path + ">";
        return css;
    }
}
