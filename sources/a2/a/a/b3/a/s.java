package a2.a.a.b3.a;

import com.avito.android.str_calendar.booking.CalendarViewModelImpl;
import com.avito.android.str_calendar.utils.DateRange;
import java.util.concurrent.Callable;
public final class s<V> implements Callable<Integer> {
    public final /* synthetic */ DateRange a;
    public final /* synthetic */ CalendarViewModelImpl b;

    public s(DateRange dateRange, CalendarViewModelImpl calendarViewModelImpl) {
        this.a = dateRange;
        this.b = calendarViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Integer call() {
        return Integer.valueOf(this.b.getCalendarDataSource().positionOfDate(this.a.getStart()));
    }
}
