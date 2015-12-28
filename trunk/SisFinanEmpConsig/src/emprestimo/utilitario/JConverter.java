package emprestimo.utilitario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Carlos Alexandre
 */
public class JConverter {

    public static String converteCharToString(char[] objeto) {
        String usoString = String.valueOf(objeto);
        return usoString;
    }

    public static String converteLongToString(Long objeto) {
        String usoString = Long.toString(objeto);
        return usoString;
    }

    public static Long converteStringtoLong(String objeto) {
        long usoLong = Long.parseLong(objeto);
        return usoLong;
    }

    public static String converteDateToString(Date dataTrab) {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dateToString = formato.format(dataTrab);
        return dateToString;
    }

    public static String converteDateToStringMysql(Date dataTrab) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String dateToString = formato.format(dataTrab);
        return dateToString;
    }

    public static Date converteStringToDate(String dataTrab) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = (Date) formatter.parse(dataTrab);
        return date;
    }
    
    public static String converteCalendarToString(Calendar calendar) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dt_atual = formato.format(calendar.getTime());
        return dt_atual;
    }
    
    public static Calendar converteStringToCalendar(String str) throws ParseException{
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        date = formato.parse(str);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static String format(double x) {
        return String.format("%.2f", x);
    }

    public static String converteMesIntToMesString(int mes) {
        String strMes = null;
        final int i = 1;
        if (mes == 0) {
            strMes = "Janeiro";
        } else if (mes == 1) {
            strMes = "Fevereiro";
        } else if (mes == 2) {
            strMes = "Março";
        } else if (mes == 3) {
            strMes = "Abril";
        } else if (mes == 4) {
            strMes = "Maio";
        } else if (mes == 5) {
            strMes = "Junho";
        } else if (mes == 6) {
            strMes = "Julho";
        } else if (mes == 7) {
            strMes = "Agosto";
        } else if (mes == 8) {
            strMes = "Setembro";
        } else if (mes == 9) {
            strMes = "Outubro";
        } else if (mes == 10) {
            strMes = "Novembro";
        } else if (mes == 11) {
            strMes = "Dezembro";
        }
        return strMes;
    }
}
