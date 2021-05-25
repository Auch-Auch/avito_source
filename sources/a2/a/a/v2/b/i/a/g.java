package a2.a.a.v2.b.i.a;

import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsFiltersCalendarViewModelImpl;
import com.avito.android.str_calendar.utils.DateRange;
import java.util.concurrent.Callable;
public final class g<V> implements Callable<Integer> {
    public final /* synthetic */ DateRange a;
    public final /* synthetic */ HotelsFiltersCalendarViewModelImpl b;

    public g(DateRange dateRange, HotelsFiltersCalendarViewModelImpl hotelsFiltersCalendarViewModelImpl) {
        this.a = dateRange;
        this.b = hotelsFiltersCalendarViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Integer call() {
        return Integer.valueOf(this.b.getCalendarDataSource().positionOfDate(this.a.getStart()));
    }
}
