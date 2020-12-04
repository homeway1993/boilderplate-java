package boilerplate.miscellaneous;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WeekendGetter {

    public static void main(String[] args) {
        List<LocalDateTime> localDateTimeList = new ArrayList<>();
        LocalDateTime localDateTime = LocalDateTime.parse("2021-01-01T00:00:00");

        while (localDateTime.getYear() == 2021) {
            if (DayOfWeek.SATURDAY.equals(localDateTime.getDayOfWeek())) {
                localDateTimeList.add(localDateTime);
            }
            if (DayOfWeek.SUNDAY.equals(localDateTime.getDayOfWeek())) {
                localDateTimeList.add(localDateTime);
            }
            localDateTime = localDateTime.plusDays(1);
        }

        for (LocalDateTime dateTime : localDateTimeList) {
            System.out.println("{\"date\":{\"$date\":\"" + dateTime + ":00.000Z\"},\"name\":\"\",\"holidayCategory\":\"星期六、星期日\",\"description\":\"\"},");
        }
    }
}
