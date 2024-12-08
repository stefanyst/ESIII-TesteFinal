package biblioteca;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Data {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2024-12-06");
        System.out.println(date);
    }
}
