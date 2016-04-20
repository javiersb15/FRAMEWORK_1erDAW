package Framework.Class;

import Framework.Modules.Menu.Model.Clases.Class_config;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import javax.swing.JOptionPane;

@XStreamAlias("Class_date")
public class Class_date implements Serializable {

    /**
     * ATTRIBUTES
     */
    @XStreamAlias("day")
    private int day;
    @XStreamAlias("month")
    private int month;
    @XStreamAlias("year")
    private int year;
    @XStreamAlias("date")
    private String date;

    
    /**
     * CONSTRUCTOR CALENDAR
     */
    /*public Class_date(Calendar date) {
        this.day = date.get(Calendar.DATE);
        this.month = date.get(Calendar.MONTH) + 1;
        this.year = date.get(Calendar.YEAR);
        //a partir de aqui Daniel dice que trabajar con la clase conf para el formato
        //switch case con los diferentes formatos
        this.date = day + "/" + month + "/" + year;
    }*/
    public Class_date(Calendar fecha) {
        this.day = fecha.get(Calendar.DATE);
        this.month = fecha.get(Calendar.MONTH) + 1;
        this.year = fecha.get(Calendar.YEAR);
    }
    
    public Class_date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    
    /**
     * CONSTRUCTOR FORMAT
     */   
    public Class_date(String date) {
        String[] information = new String[3];

        switch (Class_config.getInstance().getFormat_date()) {
            case "dd/MM/yyyy":
                information = date.split("/");
                this.day = Integer.parseInt(information[0]);
                this.month = Integer.parseInt(information[1]);
                this.year = Integer.parseInt(information[2]);
                this.date = day + "/" + month + "/" + year;
                break;
            case "dd-MM-yyyy":
                information = date.split("-");
                this.day = Integer.parseInt(information[0]);
                this.month = Integer.parseInt(information[1]);
                this.year = Integer.parseInt(information[2]);
                this.date = day + "-" + month + "-" + year;
                break;
            case "yyyy/MM/dd":
                information = date.split("/");
                this.day = Integer.parseInt(information[2]);
                this.month = Integer.parseInt(information[1]);
                this.year = Integer.parseInt(information[0]);
                this.date = year + "/" + month + "/" + day;
                break;
            case "yyyy-MM-dd":
                information = date.split("-");
                this.day = Integer.parseInt(information[2]);
                this.month = Integer.parseInt(information[1]);
                this.year = Integer.parseInt(information[0]);
                this.date = year + "-" + month + "-" + day;
                break;
        }
    }

    /**
     * GETTERS
     */
    public int getday() {
        return this.day;
    }

    public int getmonth() {
        return this.month;
    }

    public int getyear() {
        return this.year;
    }

    public String getdate() {
        return this.date;
    }

    /**
     * SETTERS
     */
    public void setday(int day) {
        this.day = day;
        this.date = day + "/" + this.getmonth() + "/" + this.getyear();
    }

    public void setmonth(int month) {
        this.month = month;
        this.date = this.getday() + "/" + month + "/" + this.getyear();
    }

    public void setyear(int year) {
        this.year = year;
        this.date = this.getday() + "/" + this.getmonth() + "/" + year;
    }

    public void setdate(String date) {
        String[] information = new String[3];
        information = date.split("/");
        this.day = Integer.parseInt(information[0]);
        this.month = Integer.parseInt(information[1]);
        this.year = Integer.parseInt(information[2]);
        this.date = day + "/" + month + "/" + year;
    }

    /**
     * STRING TO CALENDAR
     */
    public Calendar stringtocalendar() {

        Calendar date = Calendar.getInstance();
        Date date2 = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            date2 = sdf.parse(this.date);
            date.setTime(date2);
        } catch (Exception e) {
            return date;
        }
        return date;
    }

    /**
     * CALENDAR TO STRING
     */
    public String calendartostring(Calendar date) {
        int day = 0, month = 0, year = 0;
        String date3 = null, date4 = "XX/XX/XX/XXXX";

        try {
            day = date.get(Calendar.DATE);
            month = ((date.get(Calendar.MONTH)) + 1);
            year = date.get(Calendar.YEAR);
            date3 = day + "/" + month + "/" + year;
        } catch (Exception e) {
            return date4;
        }
        return date3;
    }

    /**
     * TO CHECK DAY
     */
    public boolean tocheckday() {

        GregorianCalendar calendar = new GregorianCalendar();
        int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (calendar.isLeapYear(this.getyear())) {
            days[2] = 29;
        }
        if ((this.getday() >= 1) && (this.getday() <= days[this.getmonth()])) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * TO CHECK MONTH
     */
    public boolean tocheckmonth() {
        if ((this.getmonth() >= 1) && (this.getmonth() <= 12)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * TO CHECK YEAR
     */
    public boolean tocheckyear() {
        if ((this.getyear() >= 1915) && (this.getyear() <= 2115)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * TO CHECK DATE
     */
    public boolean tocheckdate() {
        boolean check = true;
        if (!this.tocheckday()) {
            check = false;
        }
        if (!this.tocheckmonth()) {
            check = false;
        }
        if (!this.tocheckyear()) {
            check = false;
        }
        return check;
    }

    /**
     * TO COMPARE DATES 1 GREATER THAN 0 SAME AS -1 LOWER THAN
     *
     */
    public int comparedate(Class_date otherdate) {
        int value = 0;

        if (this.getyear() == otherdate.getyear()) {
            if (this.getmonth() == otherdate.getmonth()) {
                if (this.getday() > otherdate.getday()) {
                    value = 1;
                } else if ((this.getday() == otherdate.getday()) && (this.getmonth() == otherdate.getmonth()) && (this.getyear() == otherdate.getyear())) {
                    value = 0;
                } else {
                    value = -1;
                }
            } else if (this.getmonth() < otherdate.getmonth()) {
                value = -1;
            } else {
                value = 1;
            }
        } else if (this.getyear() > otherdate.getyear()) {
            value = 1;
        } else {
            value = -1;
        }
        return value;
    }

    /**
     * SUBSTRACT DATE SYSTEM
     */
    public int substractdatesystem() {
        int contyear1 = 0, contyear2 = 0, cont = 0;

        GregorianCalendar year1 = new GregorianCalendar(this.getyear(), this.getmonth() - 1, this.getday());
        GregorianCalendar year2 = new GregorianCalendar();

        long temps = year2.getTimeInMillis() - year1.getTimeInMillis();
        /**
         * difference in milliseconds
         */

        contyear1 = (int) ((temps) / (1000 * 60 * 60 * 24));
        /**
         * milliseconds to days
         */

        for (int i = year1.get(Calendar.YEAR) + 1; i <= year2.get(Calendar.YEAR); i++) {
            if (year1.isLeapYear(i)) {
                cont++;
                /**
                 * to count number leapYear
                 */
                i = i + 3;
            }
        }
        contyear2 = cont * 366;
        /**
         * number of leapYear
         */
        contyear1 = contyear1 - contyear2;
        /**
         * to substrac of total days
         */
        contyear1 = contyear1 / 365;
        /**
         * year of the other days
         */
        contyear1 = contyear1 + cont;
        /**
         * sum the leapYear
         */

        return contyear1;
    }

    /**
     * SUBSTRACT DATE
     */
    public int substractdate(Class_date date) {
        int contyear1 = 0, contyear2 = 0, cont = 0;

        GregorianCalendar year1 = new GregorianCalendar(this.getyear(), this.getmonth() - 1, this.getday());
        GregorianCalendar year2 = new GregorianCalendar(date.getyear(), date.getmonth() - 1, date.getday());

        if (year1.get(Calendar.YEAR) >= year2.get(Calendar.YEAR)) {
            long temps = year2.getTimeInMillis() - year1.getTimeInMillis();
            /**
             * difference in milliseconds
             */

            contyear1 = (int) ((temps) / (1000 * 60 * 60 * 24));
            /**
             * milliseconds to days
             */

            for (int i = year1.get(Calendar.YEAR) + 1; i <= year2.get(Calendar.YEAR); i++) {
                if (year1.isLeapYear(i)) {
                    cont++;
                    /**
                     * to count number leapYear
                     */
                    i = i + 3;
                }
            }
            contyear2 = cont * 366;
            /**
             * number of leapYear
             */
            contyear1 = contyear2 - contyear1;
            /**
             * to substrac of total days
             */
            contyear1 = contyear1 / 365;
            /**
             * year of the other days
             */
            contyear1 = contyear1 + cont;
            /**
             * sum the leapYear
             */
        } else {
            contyear1 = -1;
        }
        return contyear1;
    }

    /**
     * TO STRING
     */
    public String toString() {
        String cad = " ";

        cad = cad + (this.getday() + "/" + this.getmonth() + "/" + this.getyear());

        return cad;
    }

    /**
     * FORMAT
     */
    public static String format(int format) {
        String s = " ";

        switch (format) {
            case 0:
                s = "dd/MM/yyyy";
                break;
            case 1:
                s = "dd-MM-yyyy";
                break;
            case 2:
                s = "yyyy/MM/dd";
                break;
            case 3:
                s = "yyyy-MM-dd";
                break;
        }
        return s;
    }

    /**
     * TO STRING FORMAT
     */
    public String toStringformat() {
        String date = " ";

        switch (Class_config.getInstance().getFormat_date()) {
            case "dd/MM/yyyy":
                date = String.format("%02d", this.getday()) + "/" + String.format("%02d", this.getmonth()) + "/" + this.getyear();
                break;
            case "dd-MM-yyyy":
                date = String.format("%02d", this.getday()) + "-" + String.format("%02d", this.getmonth()) + "-" + this.getyear();
                break;
            case "yyyy/MM/dd":
                date = this.getyear() + "/" + String.format("%02d", this.getmonth()) + "/" + String.format("%02d", this.getday());
                break;
            case "yyyy-MM-dd":
                date = this.getyear() + "-" + String.format("%02d", this.getmonth()) + "-" + String.format("%02d", this.getday());
                break;
        }
        return date;
    }
    
    public static Class_date Factual() {
        return new Class_date(Calendar.getInstance());
    }
}
