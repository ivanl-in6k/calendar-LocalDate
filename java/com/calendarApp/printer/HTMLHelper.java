package com.calendarApp.printer;

/**
 * Created by ivan on 12.10.15.
 */
public class HTMLHelper {
    public static final String HTML = "<html>";
    public static final String C_HTML = "</html>";

    public static final String HEAD = "<head>";
    public static final String C_HEAD = "</head>";

    public static final String TITLE = "<title>";
    public static final String C_TITLE = "</title>";

    public static final String BODY = "<body>";
    public static final String C_BODY = "</body>";

    public static final String TABLE = "<table>";
    public static final String C_TABLE = "</table>";

    public static final String TR = "<tr>";
    public static final String C_TR = "</tr>";

    public static final String TD = "<td>";
    public static final String C_TD = "</td>";

    public static final String CSS_GREEN = "greenColor";
    public static final String CSS_BLUE = "blueColor";
    public static final String CSS_RED = "redColor";

    public static String getHead(String title, String ... tags) {
        String head = HEAD + "\n" + TITLE + title + C_TITLE;
        for(String tag : tags) {
            head += tag;
        }
        head += "\n" + C_HEAD + "\n";
        return head;
    }

    public  static String createAndSetTDAttributes(String ... attributes) {
        String td = "<td ";
        for (String attribute : attributes) {
            td += attribute;
        }
        td += ">";
        return td;
    }
}
