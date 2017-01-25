import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeExample {
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("hh:mm:ss a");
        Date date = df.parse("11:59:45 AM");
        System.out.println("time, after round trip: " + df.format(date));
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, 30);
        date = cal.getTime();
        System.out.println("time+30: " + df.format(date));
    }
}
